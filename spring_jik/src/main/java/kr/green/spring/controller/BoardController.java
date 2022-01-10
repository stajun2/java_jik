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
		mv.setViewName("redirect:/board/list");
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
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,Integer bd_num, HttpServletRequest request) {
		//게시글 번호 확인
		//System.out.println("게시글 번호 : " + bd_num);
		//로그인한 유저 정보를 확인
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//System.out.println(user);
		//서비스에게 게시글 번호와 로그인한 유저 정보를 주면서 게시글 삭제하라고 시킴
		//boardSercie.게시글삭제(게시글 번호, 로그인한 유저정보);
		boardService.deleteBoard(bd_num, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView boardModify(ModelAndView mv, Integer bd_num
			,HttpServletRequest request) {
		//게시글을 검색해서 화면에 전달 => 서비스에게 일을 시킴
		//게시글 번호를 확인
		//System.out.println("게시글 번호 : " + bd_num);
		//서비스에게 번호와 로그인 회원 정보를 알려주면서 
		//번호와 작성자가 일치하는 게시글을 가져오라고 시킴
		//컨트롤러는 서비스가 보내준 게시글 정보를 가지고 정상 접근인지 아닌지 확인
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//게시글 = 서비스.게시글가져오기(번호, 로그인 정보);
		BoardVO board = boardService.getBoard(bd_num, user);
		
		//게시글이 없으면
			//1. 번호가 잘못된 경우
			//2. 본인이 작성자가 아닌 경우
		if(board == null) {
			mv.setViewName("redirect:/board/list");
		}else {
			mv.addObject("board", board);
			mv.setViewName("/board/modify");
		}
		
		//서비스에게 번호를 알려주면서 게시글을 가져오라고 시킴
		//서비스가 보내준 게시글의 작성자와 로그인한 회원 아이디가 일치하는지 확인
		//컨트롤러가 서비스가 보내준 게시글 정보를 가지고 추가 확인
		return mv;
	}
}
