package kr.green.green.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(String string);

	BoardVO getBoard(Integer bd_num);

	void registerBoard(BoardVO board, MemberVO user, List<MultipartFile> files);

	void modifyBoard(BoardVO board, MemberVO user);

	void deleteBoard(Integer bd_num, MemberVO user);

	List<FileVO> getFileList(Integer bd_num);

}
