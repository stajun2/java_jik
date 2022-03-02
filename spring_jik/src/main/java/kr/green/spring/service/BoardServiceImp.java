package kr.green.spring.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.LikesVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;
	//업로드할 폴더 경로. 환경에 따라 바꿔줘야함.
	//집
	String uploadPath = "D:\\JAVA_JIK\\upload";
	//학원
	//String uploadPath = "D:\\JAVA_JIK\\upload";

	@Override
	public void registerBoard(BoardVO board, List<MultipartFile> files) throws Exception {
		if(board == null 
			|| board.getBd_title() == null
			|| board.getBd_contents() == null
			|| board.getBd_me_id() ==null)
			return;
		
		boardDao.insertBoard(board);
		uploadFile(files, board.getBd_num());
	}

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		//게시글 번호가 없거나 0이하이면 null을 반환
		//존재할수 없는 게시글을 가져오라고 시킴 
		if(bd_num == null || bd_num <= 0)
			return null;
		//다오에게 일을 시킴
		//게시글하나 = boardDao.게시글검색(게시글번호)
		//BoardVO board = boardDao.getBoard(bd_num);
		//return board;
		return boardDao.getBoard(bd_num);
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		//유효하지 않은 게시글 번호이면 삭제할 필요 없음
		//번호가 null이거나 음수, 0인 경우
		if(bd_num == null || bd_num <= 0)
			return;
		
		//게시글번호와 일치하는 게시글을 가져옴
		BoardVO board = boardDao.getBoard(bd_num);
		
		//가져온 게시글이 null이면 삭제할 필요 없음
		if(board == null)
			return;
		
		//게시글 작성자와 로그인한 회원 아이디가 같은지 확인하여 다르면 삭제할 필요 없음
		//board.getBd_me_id()와 user.getMe_id()가 다르면
		if(!board.getBd_me_id().equals(user.getMe_id()))
			return;
		//게시글을 삭제
		//게시글의 bd_del을 Y로 수정
		//다오에게 수정된 게시글을 업데이트하라고 시킴
		//boardDao.게시글삭제(게시글 번호);
		List<String> authorityAdmin = new ArrayList<String>();
		authorityAdmin.add("관리자");
		authorityAdmin.add("슈퍼 관리자");
		if( board.getBd_type().equals("공지") &&
				authorityAdmin.indexOf(user.getMe_authority()) < 0) {
			return;
		}
		boardDao.deleteBoard(bd_num);
		
		/*
		board.setBd_del("Y");
		board.setBd_del_date(new Date());
		boardDao.updateBoard(board);
		*/
		List<FileVO> fileList = boardDao.selectFileList(bd_num);
		deleteFile(fileList);
		//deleteFile(boardDao.selectFileList(bd_num));
	}

	@Override
	public BoardVO getBoard(Integer bd_num, MemberVO user) {
		//게시글 번호가 유효한지 체크 => 번호가 없거나 0이하이면 작업할 필요 없음
		if(bd_num == null || bd_num <= 0)
			return null;
		//다오에게 게시글을 가져오라고 시킴
		//게시글 = 다오.게시글가져옴(게시글 번호)
		BoardVO board = boardDao.getBoard(bd_num);
		//가져온 게시글이 있으면 작성자와 user와 비교하여 같은 아이디인지 체크
		if(board == null || !board.getBd_me_id().equals(user.getMe_id()))
			return null;
		return board;
	}

	@Override
	public void updateBoard(BoardVO board , List<MultipartFile> files, Integer[] fileNums) {
		//다오에게 게시글 번호와 일치하는 게시글을 가져오라고 시킴
		//게시글 = 다오.게시글가져오기(게시글번호)
		BoardVO dbBoard = boardDao.getBoard(board.getBd_num());
		
		//가져온 게시글의 제목과 내용을 board의 제목과 내용으로 덮어쓰기를 함
		dbBoard.setBd_title(board.getBd_title());
		dbBoard.setBd_contents(board.getBd_contents());
		
		//가져온 게시글의 수정일을 현재 시간으로 업데이트
		dbBoard.setBd_up_date(new Date());
		
		//다오에게 수정된 게시글 정보를 주면서 업데이트 하라고 시킴
		boardDao.updateBoard(dbBoard);
		
		//해당 게시글번호와 일치하는 첨부파일 전체를 가져옴
		List<FileVO> fileList = boardDao.selectFileList(board.getBd_num());
		
		//가져온 첨부파일전체에서 fileNums에 없는 번호들의 첨부파일들을 서버에서 삭제
		if(fileList != null && fileList.size() != 0 
				&& fileNums != null && fileNums.length != 0) {
			List<FileVO> delList = new ArrayList<FileVO>();
			for(FileVO tmpFileVo : fileList) {
				for(Integer tmp: fileNums) {
					if(tmpFileVo.getFi_num() == tmp) {
						delList.add(tmpFileVo);
					}
				}
			}
			fileList.removeAll(delList);
		}
		//위의 조건문을 거치고 난 뒤 fileList는 삭제할 첨부파일들
		//DB에서도 삭제
		deleteFile(fileList);
		
		//새로 추가된 첨부파일 있으면 서버에 업로드
		//새로 추가된 첨부파일을 DB에 추가
		uploadFile(files, board.getBd_num());
	}

	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		return boardDao.selectFileList(bd_num);
	}
	private void uploadFile(List<MultipartFile>files, Integer bd_num) {
		if(files == null)
			return;
		for(MultipartFile tmpFile : files) {
			if(tmpFile != null && tmpFile.getOriginalFilename().length() !=0) {
				uploadFile(tmpFile, bd_num);
			}
		}
	}
	private void deleteFile(List<FileVO> fileList) {
		if(fileList != null && fileList.size() != 0) {
			for(FileVO tmpFileVo : fileList) {
				File f = 
					new File(uploadPath+tmpFileVo.getFi_name().replace("/", File.separator));
				if(f.exists()) {
					f.delete();
				}
				boardDao.deleteFile(tmpFileVo.getFi_num());
			}
		}
	}
	private String uploadFile(MultipartFile file, Integer bd_num) {
		try {
			String path = UploadFileUtils.uploadFile(
				uploadPath, file.getOriginalFilename(), file.getBytes());
			FileVO fileVo = 
				new FileVO(file.getOriginalFilename(), path, bd_num);
			boardDao.insertFile(fileVo);
			return path;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.selectCountBoard(cri);
	}

	@Override
	public void updateViews(Integer bd_num) {
		boardDao.updateViews(bd_num);
	}

	@Override
	public String likes(LikesVO likes, MemberVO user) {
		if(likes == null || user == null)
			return "fail";
		//DB에서 해당 유저가 해당 게시글을 추천/비추천했는지 확인하기 위해 DB에서 가져옴
		LikesVO dbLikes = boardDao.selectLikes(likes);
		//해당 게시글에 추천/비추천을 한적이 없을 때
		if(dbLikes == null) {
			boardDao.insertLikes(likes);
			//해당 게시글에 추천, 비추천 수를 계산
			boardDao.updateBoardLikes(likes);
			return ""+likes.getLi_state();
		}
		//취소하는 경우 => li_state = 0
		if(dbLikes.getLi_state() == likes.getLi_state()) {
			likes.setLi_state(0);
			boardDao.updateLikes(likes);
			boardDao.updateBoardLikes(likes);
			return "0";
		}
		//추천=>비추천 또는 비추천=>추천, 취소=>추천, 취소=>비추천으로 바뀌는 경우 
		boardDao.updateLikes(likes);
		boardDao.updateBoardLikes(likes);
		return ""+likes.getLi_state();
	}

	@Override
	public String viewLikes(LikesVO likes, MemberVO user) {
		if(likes == null || user == null) {
			return "0";
		}
		LikesVO dbLikes = boardDao.selectLikes(likes);
		if(dbLikes == null)
			return "0";
		return "" + dbLikes.getLi_state();
	}

	@Override
	public String semmernoteImg(MultipartFile img) {
		if(img != null && img.getOriginalFilename().length() != 0) {
			return uploadFile(img, null);
		}
		return "";
	}
}
