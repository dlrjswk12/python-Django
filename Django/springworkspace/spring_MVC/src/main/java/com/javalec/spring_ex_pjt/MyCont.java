package com.javalec.spring_ex_pjt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class MyCont {

	@RequestMapping("/view")
	public String view(Model haha) {
		
		
		haha.addAttribute("id","아아아아아");
		
		
		
		return "/board/view";
	}
	
// /board + /view = /board/view	
	
	
}
