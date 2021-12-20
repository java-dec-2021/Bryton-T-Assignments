package com.bryton.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class AppController {
	//@RequestMapping("/")
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/welcome", method=RequestMethod.POST)
	public String welcome(@RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="program") String program,
			@RequestParam(value="comment", defaultValue="") String comment,
			Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("program", program);
		model.addAttribute("comment", comment);
		
		return "welcome.jsp";
	}

}
