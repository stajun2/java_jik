package kr.green.green.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.green.pagination.Criteria;
import kr.green.green.pagination.PageMaker;
import kr.green.green.service.CommentService;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping("/comment/insert")
	public boolean commentInsert(
			@RequestBody CommentVO comment,
			HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		return commentService.insertComment(comment, user);
	}
	@RequestMapping("/comment/list")
	public Map<String, Object> commentList(Integer page, Integer bd_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		//페이지메이커 : 총 컨텐츠 갯수(DB)
		//            한 페이지네이션에서 보여지는 페이지 숫자 최대 갯수(개발자가 설정)
		//            현재 페이지정보(현재 페이지, 한페이지에서 보여지는 컨텐츠의 최대 갯수)
		int totalCount = commentService.selectCommentCount(bd_num); //DB에서 가져올 예정
		int displayPageNum = 5;
		Criteria cri = new Criteria(page, 5);
		
		List<CommentVO> list = commentService.selectCommentList(bd_num, cri);
		PageMaker pm = new PageMaker(totalCount, displayPageNum, cri);
		
		map.put("pm", pm);
		map.put("list", list);
		return map;
	}
	
	@RequestMapping("/comment/delete")
	public boolean commentDelete(Integer co_num, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		return commentService.deleteComment(co_num, user);
	}
	
	@RequestMapping("/comment/modify")
	public boolean commentModify(@RequestBody CommentVO comment,
			HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		return commentService.modifyComment(comment,user);
	}
}







