package com.bryton.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String hello(@RequestParam(value="name", required = false, defaultValue = "Human") String name,
			@RequestParam(value = "last_name", required = false) String lastName,
			@RequestParam(value = "times", required = false) String times,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("lastName", lastName);
		model.addAttribute("times", times);
		return "index.jsp";
	}
}
