package kr.green.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Cookie cookie = WebUtils.getCookie(request, "loginCookie");
		//자동 로그인을 해야하면
		if(cookie != null) {
			//DB에 cookie에 저장된 값과 일치하는 회원 정보를 가져옴
			//세션 아이디가 일치하는 회원 정보를 가져옴
			MemberVO user = memberService.selectMemberBySessionId(cookie.getValue());
			//회원 정보가 있으면 자동 로그인
			if(user != null) {
				session.setAttribute("user", user);
			}
		}
		
		return true;
	}
}
