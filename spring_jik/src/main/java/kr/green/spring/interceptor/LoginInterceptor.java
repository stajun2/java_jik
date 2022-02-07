package kr.green.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		//mv.addObject()로 전달한 정보중에 user라는 정보가 있는지 확인해서
		//user 정보를 가져오는 코드
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");
	    
	    if(user != null) {
    		//세션에 user 정보를 추가
        HttpSession session = request.getSession();
        //자동 로그인을 체크했으면
        if(user.getMe_auto_login() != null) {
        	//서버에서 쿠키 생성(이름 : loginCookie, 값 : 세션아이디)
        	Cookie cookie = new Cookie("loginCookie", session.getId());
        	//쿠키 기본 경로 설정
        	cookie.setPath("/");
        	//쿠키 유지시간 설정
        	int day = 7;
        	int session_limit_second = 60 * 60 * 24 * day;//일을 초로 계산
        	cookie.setMaxAge(session_limit_second);
        	//서버에서 생성된 쿠키를 클라이언트로 보내기 위해 쿠키를 response에 추가
        	response.addCookie(cookie);
        	//DB 회원 정보에 쿠키에 저장된 session_id와 session 유지 시간을 업데이트
        	//1000ms + 1s => 1000ms + 1000ms =>2000ms
        	//day(7)일 후의 날짜
        	Date session_limit = new Date(System.currentTimeMillis() 
        			+ 1000 * session_limit_second);
        	user.setMe_session_id(session.getId());
        	user.setMe_session_limit(session_limit);
        	memberService.updateAutoLogin(user);
        }
        session.setAttribute("user", user);
	    }
	}
}
