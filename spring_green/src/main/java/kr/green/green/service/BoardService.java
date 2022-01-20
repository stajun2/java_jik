package kr.green.green.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(String string, Criteria cri);

	BoardVO getBoard(Integer bd_num);

	void registerBoard(BoardVO board, MemberVO user, List<MultipartFile> files);

	void modifyBoard(BoardVO board, MemberVO user, List<MultipartFile> files2, Integer[] fileNums);

	void deleteBoard(Integer bd_num, MemberVO user);

	List<FileVO> getFileList(Integer bd_num);

	int getTotalCount(String type, Criteria cri);

}
