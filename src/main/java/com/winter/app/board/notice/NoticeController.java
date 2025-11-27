package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.winter.app.board.qna.QnaDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public void list(Pager pager, Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.list(pager);
	    model.addAttribute("list", ar);
	    model.addAttribute("pager", pager);
	}
	@GetMapping("add")
	public String add() throws Exception {
	    return "notice/add";
	}

	@PostMapping("add")
	public String add(NoticeDTO dto) throws Exception {
		noticeService.add(dto);
	    return "redirect:/notice/list";
	}
	
	@GetMapping("detail")
	public void detail(NoticeDTO dto, Model model) throws Exception {
		model.addAttribute("detail",noticeService.detail(dto));		
	}
}
