package kr.green.spring.service;

import kr.green.spring.vo.CommentVO;
import kr.green.spring.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

}
