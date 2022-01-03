package kr.green.spring.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//@Controller가 있어야 URL을 분석하여 처리
@Controller
public class HomeController {
	
	//URL을 확인하는 곳, 필수
	//value는 localhost:8080/패키지명을 제외한 부분
	//method는 전달 방식, GET,POST, 생략하면 둘다
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
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
	
}
