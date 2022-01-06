package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
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
	        session.setAttribute("user", user);
	    }
	}
}
