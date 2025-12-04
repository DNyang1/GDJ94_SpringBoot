package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardFileDTO;
import com.winter.app.util.Pager;

import jakarta.validation.Valid;

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
	public String add(@ModelAttribute("dto") NoticeDTO dto) throws Exception {
		return "board/add";
	}

	@PostMapping("add")
	public String add(@ModelAttribute("dto") @Valid NoticeDTO dto, BindingResult bindingResult, MultipartFile[] attach) throws Exception {
		if(bindingResult.hasErrors()) 
			return "board/add";
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
		model.addAttribute("dto", dto);
		model.addAttribute("sub", "Update");
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

	@GetMapping("fileDown")
	public String fileDown(BoardFileDTO fileDTO, Model model) throws Exception {
		fileDTO = service.fileDetail(fileDTO);
		model.addAttribute("file", fileDTO);
		return "fileDownView";
	}

}
