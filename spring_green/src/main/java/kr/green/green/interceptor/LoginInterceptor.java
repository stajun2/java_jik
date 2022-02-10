package kr.green.green.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter  {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
    HttpServletRequest request, 
    HttpServletResponse response, 
    Object handler, 
    ModelAndView modelAndView)
    throws Exception {
    ModelMap modelMap = modelAndView.getModelMap();
    MemberVO user = (MemberVO)modelMap.get("user");
    if(user != null) {
    	HttpSession session = request.getSession();
    	if(user.getMe_auto_login() != null) {
    		//세션 아이디를 이용한 쿠키를 생성
    		Cookie cookie = new Cookie("loginCookie", session.getId());
    		//생성된 쿠키의 유지시간을 7일로
    		int day = 7;
      	int session_limit_second = 60 * 60 * 24 * day;//일을 초로 계산
      	cookie.setMaxAge(session_limit_second);
      	cookie.setPath("/");
    		//response에 쿠키를 넣어 보내줌
      	response.addCookie(cookie);
    		//DB에 세션 아이디와 세션 만료 시간을 전달함
      	user.setMe_session_id(session.getId());
      	//System.currentTimeMillis() : 현재 시간을 밀리세컨드로 환산
      	Date me_session_limit = 
    			new Date(System.currentTimeMillis() + session_limit_second * 1000);
      	user.setMe_session_limit(me_session_limit);
      	memberService.insertAutoLogin(user);
    	}
    	session.setAttribute("user", user);
    }
	}
}
