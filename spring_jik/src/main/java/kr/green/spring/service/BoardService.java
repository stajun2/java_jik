package kr.green.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

public interface BoardService {

	void registerBoard(BoardVO board, List<MultipartFile> files) throws Exception;

	List<BoardVO> getBoardList(String string);

	BoardVO getBoard(Integer bd_num);

	void deleteBoard(Integer bd_num, MemberVO user);

	BoardVO getBoard(Integer bd_num, MemberVO user);

	void updateBoard(BoardVO board, List<MultipartFile> files, Integer[] fileNums);

	List<FileVO> getFileList(Integer bd_num);
	
}
