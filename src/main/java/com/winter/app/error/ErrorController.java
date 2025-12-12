package com.winter.app.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외 처리 컨트롤러
@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(exception = NullPointerException.class)
	public String exc1(Model model) {
		return "error/error_page";
	}
	@ExceptionHandler(exception = Exception.class)
	public String exc2(Model model) {
		return "error/error_page";
	}
	@ExceptionHandler(exception = Throwable.class)
	public String exc3(Model model) {
		return "error/error_page";
	}
	

}
