package kr.green.spring.service;

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
}
