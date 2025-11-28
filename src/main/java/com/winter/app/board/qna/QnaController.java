package com.winter.app.board.qna;

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
@RequestMapping("/qna/*")
public class QnaController {

    @Autowired
    private QnaService service;

	@Value("${category.board.qna}")
	private String category;
    
	@ModelAttribute("category")
    public String getCategory() {
		return this.category;
	}

    @GetMapping("list")
    public String list(Pager pager, Model model) throws Exception {
        List<QnaDTO> ar = service.list(pager);
        model.addAttribute("list", ar);
        model.addAttribute("pager", pager);
        return "board/list";
    }

    @GetMapping("add")
    public String add() throws Exception {
        return "board/add";
    }

    @PostMapping("add")
    public String add(QnaDTO dto) throws Exception {
        service.add(dto);
        return "redirect:/qna/list";
    }

    @GetMapping("detail")
    public String detail(QnaDTO dto, Model model) throws Exception {
        model.addAttribute("dto", service.detail(dto));
        return "board/detail";
    }
    
    @GetMapping("reply")
    public String reply(QnaDTO dto, Model model) throws Exception {
    	model.addAttribute("dto", service.detail(dto));
		
		return "board/add";
	}
    
    @PostMapping("reply")
    public String reply(QnaDTO dto) throws Exception{
        service.reply(dto);
        return "redirect:/qna/list";
	}
}
