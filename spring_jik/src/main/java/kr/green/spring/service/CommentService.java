package kr.green.spring.service;

import java.util.List;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.CommentVO;
import kr.green.spring.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	List<CommentVO> selectCommentList(Integer co_bd_num, Criteria cri);

	int selectTotalCount(Integer co_bd_num);

}
