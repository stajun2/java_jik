package kr.green.green.service;

import java.util.List;

import kr.green.green.vo.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList(String string);

}
