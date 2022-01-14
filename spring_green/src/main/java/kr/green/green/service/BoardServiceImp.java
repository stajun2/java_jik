package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.dao.BoardDAO;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;

	@Override
	public List<BoardVO> getBoardList(String bd_type) {
		return boardDao.selectBoardList(bd_type);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void registerBoard(BoardVO board, MemberVO user) {
		if(board == null || user == null)
			return;
		if(board.getBd_title() == null 
				|| board.getBd_title().trim().length() == 0)
			return;
		if(user.getMe_id()== null || user.getMe_id().trim().length()==0)
			return;
		board.setBd_me_id(user.getMe_id());
		boardDao.insertBoard(board);
	}

	@Override
	public void modifyBoard(BoardVO board, MemberVO user) {
		if(board == null || user == null || board.getBd_num() <= 0 )
			return;
		
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		
		if(dbBoard == null)
			return;
		
		if(!dbBoard.getBd_me_id().equals(user.getMe_id()))
			return;
		
		boardDao.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || bd_num <= 0)
			return;
		BoardVO board = boardDao.selectBoard(bd_num);
		if(board == null)
			return;
		if(user != null && board.getBd_me_id().equals(user.getMe_id()))
			boardDao.deleteBoard(bd_num);
	}
}
