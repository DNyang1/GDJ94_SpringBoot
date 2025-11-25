package com.winter.app.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/")
	public String index() throws Exception {
		log.info("인덱스컨트롤라 인덱스컨트롤라 인덱스컨트롤라 인덱스컨트롤라 인덱스컨트롤라 인덱스컨트롤라 ");
		return "index";
	}
}
