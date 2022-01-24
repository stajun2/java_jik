package kr.green.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.spring.service.CommentService;
import kr.green.spring.vo.CommentVO;
import kr.green.spring.vo.MemberVO;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value ="/comment/insert")
	public String commentInsert(@RequestBody CommentVO comment, 
			HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(commentService.insertComment(comment, user)) {
			return "true";
		}
	  return "false";
	}
	@RequestMapping(value ="/comment/list")
	public List<CommentVO> commentList(Integer co_bd_num){
		System.out.println(co_bd_num);
		return commentService.selectCommentList(co_bd_num);
	}
}



