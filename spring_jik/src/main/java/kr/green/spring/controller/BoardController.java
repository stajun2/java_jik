package kr.green.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

//게시글 url을 담당하는 컨트롤러. /board/xxx을 담당
@Controller
@RequestMapping(value="/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list")
	//@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv) {
		//등록된 모든 게시글을 보는 작업
		List<BoardVO> list 
		= boardService.getBoardList("일반");
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		board.setBd_me_id(user.getMe_id());
		board.setBd_type("일반");
		System.out.println(board);
		boardService.registerBoard(board);
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value="/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
		mv.setViewName("/board/detail");
		//게시글 번호 확인
		//System.out.println("게시글 번호 : " + bd_num);
		//게시글 = boardService.게시글가져오기(게시글번호);
		BoardVO board = boardService.getBoard(bd_num);
		//가져온 게시글 확인
		//System.out.println(board);
		//화면에게 게시글을 전달
		mv.addObject("board", board);
		return mv;
	}
}
