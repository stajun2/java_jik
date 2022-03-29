package kr.green.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handle404(NoHandlerFoundException e) {
		ModelAndView mv = new ModelAndView();
		//예외 처리 하고 싶은 코드 작업
		log.error("페이지를 찾을 수 없습니다.");
		mv.setViewName("/exception/custom404");
		return mv;
	}
	
}
