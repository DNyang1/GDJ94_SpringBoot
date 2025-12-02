package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	@Value("${category.board.notice}")
	private String category;
	
	@ModelAttribute("category")
    public String getCategory() {
		return this.category;
	}
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {
	    List<NoticeDTO> ar = service.list(pager);
	    model.addAttribute("list", ar);
	    model.addAttribute("pager", pager);
	    return "board/list";
	}

	@GetMapping("add")
	public String add() throws Exception {
	    return "board/add";
	}


	@PostMapping("add")
	public String add(NoticeDTO dto, MultipartFile[] attach) throws Exception {
		service.add(dto, attach);
	    return "redirect:/notice/list";
	}
	
	@GetMapping("detail")
	public String detail(NoticeDTO dto, Model model) throws Exception {
	    model.addAttribute("dto", service.detail(dto));
	    return "board/detail";
	}

	@GetMapping("update")
	public String update(NoticeDTO dto, Model model) throws Exception {
		dto = service.detail(dto);
		model.addAttribute("dto",dto);
		model.addAttribute("sub","Update");
		return "board/add";
	}
	@PostMapping("update")
	public String update(NoticeDTO dto) throws Exception {
	    service.update(dto);
	    return "redirect:/notice/detail?boardNum=" + dto.getBoardNum();
	}

	@PostMapping("delete")
	public String delete(NoticeDTO dto) throws Exception {
	    service.delete(dto);
	    return "redirect:/notice/list";
	}
	
}
