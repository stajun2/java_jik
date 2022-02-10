package kr.green.green.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value= "/")
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");
	    return mv;
	}
	@RequestMapping(value= "/signup", method=RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv){
	    mv.setViewName("/member/signup");
	    return mv;
	}
	@RequestMapping(value= "/signup", method=RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user){
		boolean isSignup = memberService.signup(user);
		if(isSignup) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signup");
		}
	    return mv;
	}
	@RequestMapping(value= "/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv){
	    mv.setViewName("/member/login");
	    return mv;
	}
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO user){
		
		MemberVO loginUser = memberService.login(user);
		
		if(loginUser == null)
			mv.setViewName("redirect:/login");
		else {
			loginUser.setMe_auto_login(user.getMe_auto_login());
			mv.addObject("user",loginUser);
			mv.setViewName("redirect:/");
		}
    return mv;
	}
	@RequestMapping(value= "/logout")
	public ModelAndView logout(ModelAndView mv, HttpSession session){
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		session.removeAttribute("user");
		user.setMe_session_limit(new Date());
		user.setMe_session_id("none");
		memberService.insertAutoLogin(user);
    mv.setViewName("redirect:/");
    return mv;
	}
	@ResponseBody
	@RequestMapping(value= "/idcheck")
	public String idcheck(String me_id){
		return memberService.idCheck(me_id);
	}
	@RequestMapping(value= "/mypage")
	public ModelAndView mypage(ModelAndView mv, MemberVO inputUser
			, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		user = memberService.updateMember(inputUser,user);
		if(user != null)
			request.getSession().setAttribute("user", user);
    mv.setViewName("/member/mypage");
    return mv;
	}
	@RequestMapping(value= "/member/find")
	public ModelAndView memberFind(ModelAndView mv){
		mv.setViewName("/member/find");
    return mv;
	}
	@ResponseBody
	@RequestMapping(value= "/member/find/id")
	public String memberFindId(@RequestBody MemberVO member){
		return memberService.selectMemberByEmail(member);
	}
	@ResponseBody
	@RequestMapping(value= "/member/find/pw")
	public String memberFindPw(@RequestBody MemberVO member){
		return memberService.sendPassword(member);
	}
}
