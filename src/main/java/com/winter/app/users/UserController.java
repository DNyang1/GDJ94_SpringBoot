package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

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

	@GetMapping("mypage")
	public void detail(UserDTO dto) throws Exception {

	}

	@GetMapping("login")
	public void login() throws Exception {
	}

	@PostMapping("login")
	public String login(UserDTO dto, HttpSession session) throws Exception {
		UserDTO user = service.login(dto);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:/";
		} else {
			return "redirect:/users/login";
		}
	}

}
