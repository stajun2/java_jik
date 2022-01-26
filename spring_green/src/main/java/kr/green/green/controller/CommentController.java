package kr.green.green.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		List<CommentVO> list = new ArrayList<CommentVO>();
		CommentVO c = new CommentVO();
		list.add(c);
		map.put("list", list);
		return map;
	}
}







