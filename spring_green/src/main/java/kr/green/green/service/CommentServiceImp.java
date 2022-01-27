package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.dao.CommentDAO;
import kr.green.green.pagination.Criteria;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	CommentDAO commentDao;

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null)
			return false;
		if(!comment.getCo_me_id().equals(user.getMe_id()))
			return false;
		
		commentDao.insertComment(comment);
		
		return true;
	}

	@Override
	public List<CommentVO> selectCommentList(Integer bd_num, Criteria cri) {
		if(bd_num == null || bd_num <= 0)
			return null;
		return commentDao.selectCommentList(bd_num, cri);
	}

	@Override
	public int selectCommentCount(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return 0;
		return commentDao.selectCommentCount(bd_num);
	}

	@Override
	public boolean deleteComment(Integer co_num, MemberVO user) {
		if(co_num ==null || co_num <=0 || user == null)
			return false;
		CommentVO comment = commentDao.selectComment(co_num);
		
		if(comment == null || !comment.getCo_me_id().equals(comment.getCo_me_id()))
			return false;
		
		commentDao.deleteComment(co_num);
		
		return true;
	}
}
