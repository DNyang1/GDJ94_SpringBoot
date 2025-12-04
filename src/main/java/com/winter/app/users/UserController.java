package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.val;

@Controller
@RequestMapping("/users/*")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("register")
	public String register(@ModelAttribute("dto") UserDTO dto) throws Exception {
		return "users/register";
	}

	@PostMapping("register")
	public String register(@ModelAttribute("dto") @Valid UserDTO dto, BindingResult bindingResult,MultipartFile profile) throws Exception {
		if(bindingResult.hasErrors()) 
			return "users/register";
	    if (!dto.getPassword().equals(dto.getPasswordCheck())) {
	        bindingResult.rejectValue("passwordCheck", "password.notEqual", "비밀번호가 일치하지 않습니다.");
	        return "users/register";
	    }	
		service.register(dto, profile);
		return "index";
	}

	@GetMapping("mypage")
	public String mypage(HttpSession session, Model model) throws Exception {
	    UserDTO loginUser = (UserDTO) session.getAttribute("user");
	    if (loginUser == null) return "redirect:/users/login";
	    UserDTO dto = service.detail(loginUser);
	    model.addAttribute("user", dto);
	    return "users/mypage";
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
	
	@GetMapping("update")
	public String update(UserDTO dto, Model model) throws Exception {
	    dto = service.detail(dto);
	    model.addAttribute("dto", dto);
	    return "users/update";
	}
	
	@PostMapping("update")
	public String update(@ModelAttribute("dto") UserDTO dto, MultipartFile profile) throws Exception {
	    service.update(dto, profile);
	    return "redirect:/users/mypage?username=" + dto.getUsername();
	}

}
