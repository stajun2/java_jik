package kr.green.spring.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

//게시글 url을 담당하는 컨트롤러. /board/xxx을 담당
@Controller
@RequestMapping(value="/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list")
	//@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
		cri.setPerPageNum(5);
		//등록된 게시글 중 현재 페이지와 일치하는 게시글을 가져옴
		List<BoardVO> list = boardService.getBoardList(cri);
		
		//페이지메이커를 만들어서 화면에 전달해야함
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		
		mv.addObject("pm",pm);
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv
			,Integer bd_ori_num, String bd_type) {
		mv.addObject("bd_type", bd_type);
		mv.addObject("bd_ori_num", bd_ori_num);
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, 
			HttpServletRequest request, List<MultipartFile> files2) throws Exception {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		board.setBd_me_id(user.getMe_id());
		List<String> authorityAdmin = new ArrayList<String>();
		authorityAdmin.add("관리자");
		authorityAdmin.add("슈퍼 관리자");
		//공지사항을 작성하는데 권한이 회원이 경우
		if( board.getBd_type().equals("공지") &&
				authorityAdmin.indexOf(user.getMe_authority()) < 0) {
			mv.addObject("type","공지");
			mv.setViewName("redirect:/board/list");
		}else {
			boardService.registerBoard(board, files2);
			mv.addObject("type", board.getBd_type());
			mv.setViewName("redirect:/board/list");
		}
		return mv;
	}
	@RequestMapping(value="/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
		mv.setViewName("/board/detail");
		//게시글 번호 확인
		//System.out.println("게시글 번호 : " + bd_num);
		//게시글 = boardService.게시글가져오기(게시글번호);
		BoardVO board = boardService.getBoard(bd_num);
		List<FileVO> files = boardService.getFileList(bd_num);
		boardService.updateViews(bd_num);
		//가져온 게시글 확인
		//System.out.println(board);
		//화면에게 게시글을 전달
		mv.addObject("board", board);
		mv.addObject("files", files);
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
			//첨부파일을 가져옴
			List<FileVO> fileList = boardService.getFileList(bd_num);
			mv.addObject("fileList",fileList);
			mv.addObject("board", board);
			mv.setViewName("/board/modify");
		}
		
		//서비스에게 번호를 알려주면서 게시글을 가져오라고 시킴
		//서비스가 보내준 게시글의 작성자와 로그인한 회원 아이디가 일치하는지 확인
		//컨트롤러가 서비스가 보내준 게시글 정보를 가지고 추가 확인
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv,BoardVO board, 
			List<MultipartFile> files2, Integer [] fileNums) {
		//기존 첨부파일 번호인 fileNums 확인
		//화면에서 수정한 게시글 정보가 넘어오는지 확인
		//System.out.println("게시글 : " + board);
		//서비스에게 게시글 정보를 주면서 업데이트하라고 시킴
		//서비스.게시글업데이트(게시글정보)
		boardService.updateBoard(board, files2, fileNums);
		//게시글 번호를 넘겨줌
		mv.addObject("bd_num", board.getBd_num());
		mv.setViewName("redirect:/board/detail");
		
		return mv;
	}
	@ResponseBody
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		String uploadPath = "D:\\JAVA_JIK\\upload";
		InputStream in = null;
    ResponseEntity<byte[]> entity = null;
    try{
        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
        HttpHeaders headers = new HttpHeaders();
        in = new FileInputStream(uploadPath+fileName);

        fileName = fileName.substring(fileName.indexOf("_")+1);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.add("Content-Disposition",  "attachment; filename=\"" 
			+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
    }catch(Exception e) {
        e.printStackTrace();
        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
    }finally {
        in.close();
    }
    return entity;
	}
}
