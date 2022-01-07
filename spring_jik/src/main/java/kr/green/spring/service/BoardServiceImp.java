package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;

	@Override
	public void registerBoard(BoardVO board) {
		if(board == null 
			|| board.getBd_title() == null
			|| board.getBd_contents() == null
			|| board.getBd_me_id() ==null)
			return;
		boardDao.insertBoard(board);
	}

	@Override
	public List<BoardVO> getBoardList(String type) {
		return boardDao.getBoardList(type);
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
}
