package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//세션에 있는 회원정보를 가져옴. 세션에 user로 저장했기에 user를 가져옴
		Object user = request.getSession().getAttribute("user");
		//세션에 회원정보가 없으면 => 로그인을 안했으면
		if(user == null) {
			//http://localhost:8080/프로젝트명/board/register에서
			// /board/register를 가져오는 코드
			String str = request.getServletPath();
			request.getSession().setAttribute("prevUrl", str);
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		
		return true;
	}
}
