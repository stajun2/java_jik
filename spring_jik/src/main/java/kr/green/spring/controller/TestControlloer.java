package kr.green.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestControlloer {
	@RequestMapping("/sample/test1")
	public ModelAndView adminMemberList(ModelAndView mv, 
			HttpServletResponse response, Integer test) throws IOException {
		if(test != null) {
			response.setContentType("text/html; charset=utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
      out.println("<script>alert('알림');</script> ");
      out.flush();
		}
		mv.setViewName("/main/home");
		
		return mv;
	}
	@RequestMapping("/sample/test2")
	public ModelAndView sampleTest2(ModelAndView mv) {
		
		mv.setViewName("/main/test2");
		
		return mv;
	}
}
