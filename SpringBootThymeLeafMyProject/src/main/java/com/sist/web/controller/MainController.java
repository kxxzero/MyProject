package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String main_page(Model model) {
		
		model.addAttribute("main_html", "main/home"); // 확장자를 붙이면 안 됨
		return "main";
	}
}