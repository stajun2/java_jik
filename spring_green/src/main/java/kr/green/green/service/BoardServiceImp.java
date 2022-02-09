package kr.green.green.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.green.dao.BoardDAO;
import kr.green.green.pagination.Criteria;
import kr.green.green.utils.UploadFileUtils;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.LikesVO;
import kr.green.green.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\JAVA_JIK\\upload";
	//String uploadPath = "D:\\JAVA_JIK\\upload";

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		return boardDao.selectBoardList(cri);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void registerBoard(BoardVO board, MemberVO user , List<MultipartFile> files) {
		if(board == null || user == null)
			return;
		if(board.getBd_title() == null 
				|| board.getBd_title().trim().length() == 0)
			return;
		if(user.getMe_id()== null || user.getMe_id().trim().length()==0)
			return;
		if(!board.isAccessAuthority(user.getMe_authority()))
			return;
		board.setBd_me_id(user.getMe_id());
		boardDao.insertBoard(board);
		
		uploadFile(files, board.getBd_num());
	}

	@Override
	public void modifyBoard(BoardVO board, MemberVO user , 
			List<MultipartFile> files2, Integer[] fileNums) {
		if(board == null || user == null || board.getBd_num() <= 0 )
			return;
		
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		
		if(dbBoard == null)
			return;
		
		if(!dbBoard.getBd_me_id().equals(user.getMe_id()))
			return;
		
		boardDao.updateBoard(board);
		
		//첨부파일을 삭제(수정화면에서 x버튼 눌러서 취소환 첨부파일들)
		//게시글의 첨부파일들을 가져옴
		List<FileVO> fileList = boardDao.selectFileList(board.getBd_num());
		List<FileVO> remainFileList = new ArrayList<FileVO>();
		//가져온 첨부파일들 중에서 fileNums에 일치하는 번호가 있으면 remailFileList에 추가
		//유지해야할 첨부파일이 있는 경우
		if(fileNums != null && fileNums.length != 0) {
			for(FileVO tmp : fileList) {
				for(Integer tmpNum : fileNums) {
					if(tmp.getFi_num() == tmpNum) {
						remainFileList.add(tmp);
					}
				}
			}
			//게시글의 전체 첨부파일중 유지해야할 첨부파일을 제외한 첨부파일 만듬
			fileList.removeAll(remainFileList);
		}
		//실제 서버에서 삭제 후 DB에서 삭제처리
		deleteFile(fileList);
		
		//새로 추가한 첨부파일을 업로드
		uploadFile(files2, board.getBd_num());
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || bd_num <= 0)
			return;
		BoardVO board = boardDao.selectBoard(bd_num);
		if(board == null)
			return;
		if(user != null && board.getBd_me_id().equals(user.getMe_id())) {
			boardDao.deleteBoard(bd_num);
			//첨부파일 삭제하기 위해서 해당 게시글과 일치하는 첨부파일들을 가져옴
			List<FileVO> fileList = boardDao.selectFileList(bd_num);
			deleteFile(fileList);
		}
	}

	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		return boardDao.selectFileList(bd_num);
	}
	
	private void uploadFile(List<MultipartFile> files, int bd_num) {
		if(files == null || files.size() == 0)
			return;
		for(MultipartFile tmpFile : files) {
			if(tmpFile != null && tmpFile.getOriginalFilename().length() != 0) {
				try {
					String path = 
						UploadFileUtils.uploadFile(
							uploadPath, 
							tmpFile.getOriginalFilename(), 
							tmpFile.getBytes());
					FileVO file 
						= new FileVO(tmpFile.getOriginalFilename(),path,bd_num);
					boardDao.insertFile(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	private void deleteFile(List<FileVO> fileList) {
		if(fileList != null && fileList.size()!= 0) {
			for(FileVO tmp : fileList) {
				String fileName = tmp.getFi_name().replace("/",File.separator);
				File file = new File(uploadPath + fileName);
				boardDao.deleteFile(tmp);
				if(file.exists()) {
					file.delete();
				}
			}
		}
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.selectBoardCount(cri);
	}

	@Override
	public void updateViews(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return;
		boardDao.updateViews(bd_num);
	}

	@Override
	public String likes(LikesVO likes, MemberVO user) {
		if(likes == null || user == null)
			return "";
		if(likes.getLi_me_id() == null || 
				!likes.getLi_me_id().equals(user.getMe_id()))
			return "";
		
		
		//처음??=>DB에 없는 경우(아이디와 게시글 번호가 일치하는 추천/비추천이 없는 경우)
		LikesVO dbLikes = boardDao.selectLikes(likes);
		//처음 추천/비추천한 경우 => DB에 추가
		if(dbLikes == null) {
			//DB에 추가
			boardDao.insertLikes(likes);
			//추천 상태를 리턴
			return ""+likes.getLi_state();
		}
		//처음이 아닌 경우 => DB에 수정
		else {
			//DB에 수정
			//취소
			if(dbLikes.getLi_state() == likes.getLi_state()) {
				dbLikes.setLi_state(0);
			}
			//기존에 눌렀던 추천/비추천과 반대되는 경우, 취소했다가 다시 누른 경우
			else {
				dbLikes.setLi_state(likes.getLi_state());
			}
			boardDao.updateLikes(dbLikes);
		}
			
		return ""+dbLikes.getLi_state();
	}

	@Override
	public String views(LikesVO likes, MemberVO user) {
		if(likes == null || user == null)
			return "0";
		likes.setLi_me_id(user.getMe_id());
		LikesVO dbLikes = boardDao.selectLikes(likes);
		if(dbLikes == null)
			return "0";
		return "" + dbLikes.getLi_state();
	}
}
