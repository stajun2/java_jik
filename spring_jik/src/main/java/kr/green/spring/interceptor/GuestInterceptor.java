package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GuestInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//세션에 있는 회원정보를 가져옴. 세션에 user로 저장했기에 user를 가져옴
		Object user = request.getSession().getAttribute("user");
		//세션에 회원정보가 있으면 => 로그인을 했으면
		if(user != null) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
		return true;
	}
}
