package kr.green.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.vo.MemberVO;
//@Controller가 있어야 URL을 분석하여 처리
@Controller
public class HomeController {
	
	//URL을 확인하는 곳, 필수
	//value는 localhost:8080/패키지명을 제외한 부분
	//method는 전달 방식, GET,POST, 생략하면 둘다
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		//화면 파일명 확장자는 여기서 선택하는게 아님
		//확장자는 servlet-context.xml에서 설정
		//단, views 폴더에는 jsp만 가능
		//html을 화면으로 쓰려면 src/main/resources 폴더에 넣어야함
		mv.setViewName("home2");
		//화면으로 데이터를 보낼때 addObject를 사용
		//addObject("화면에서 사용할 이름", 데이터);
		mv.addObject("serverTime", "데이터" );
		
		return mv;
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView testGet(ModelAndView mv, Integer num, String name) {
		mv.setViewName("home2");
		//mv.addObject("serverTime", "데이터" );
		System.out.println("/test : num = " + num + ", name = " + name);
		return mv;
	}
	@RequestMapping(value = "/test/form", method = RequestMethod.GET)
	public ModelAndView testFormGet(ModelAndView mv, Integer num, String name) {
		mv.setViewName("home2");
		System.out.println("/test/form:get : num = " + num + ", name = " + name);
		return mv;
	}
	@RequestMapping(value = "/test/form", method = RequestMethod.POST)
	public ModelAndView testFormPost(ModelAndView mv, Integer num, String name) {
		mv.setViewName("home2");
		System.out.println("/test/form:post : num = " + num + ", name = " + name);
		return mv;
	}
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public ModelAndView test2Get(ModelAndView mv, Integer num1, Integer num2) {
		System.out.println("/test2 : num1 = " + num1 +", num2 = " + num2);
		Integer res = null;
		if(num1 != null && num2 != null) {
			res = num1 + num2;
		}
		mv.addObject("result", res);
		mv.addObject("num1", num1);
		mv.addObject("num2", num2);
		mv.setViewName("test2");
		return mv;
	}
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public ModelAndView test3Get(ModelAndView mv, MemberVO member) {
		System.out.println("/test3 :" + member);
		mv.setViewName("test3");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		System.out.println("/login:get :");
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		System.out.println("/login:post :" + member);
		mv.setViewName("login");
		return mv;
	}
}




