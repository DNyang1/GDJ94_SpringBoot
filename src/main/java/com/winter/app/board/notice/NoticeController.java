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

import com.winter.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@Value("${category.board.notice}")
	private String category;
	
	@ModelAttribute("category")
    public String getCategory() {
		return this.category;
	}
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {
	    List<NoticeDTO> ar = noticeService.list(pager);
	    model.addAttribute("list", ar);
	    model.addAttribute("pager", pager);
	    return "board/list";
	}

	@GetMapping("add")
	public String add() throws Exception {
	    return "board/add";
	}


	@PostMapping("add")
	public String add(NoticeDTO dto) throws Exception {
		noticeService.add(dto);
	    return "redirect:/notice/list";
	}
	
	@GetMapping("detail")
	public String detail(NoticeDTO dto, Model model) throws Exception {
	    model.addAttribute("detail", noticeService.detail(dto));
	    return "board/detail";
	}
}
