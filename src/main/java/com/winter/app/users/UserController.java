package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/users/*")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("register")
	public String register() throws Exception {
		return "users/register";
	}
	@PostMapping("register")
	public String register(UserDTO dto, MultipartFile profile) throws Exception {
		service.register(dto, profile);
		return "index";
	}
	
}
