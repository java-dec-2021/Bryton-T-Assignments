package com.bryton.dojos_and_ninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bryton.dojos_and_ninjas.models.Dojo;
import com.bryton.dojos_and_ninjas.models.Ninja;
import com.bryton.dojos_and_ninjas.services.DojoService;
import com.bryton.dojos_and_ninjas.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/ninja/new")
	public String addNinjaToDojo(Model model) {
		List<Dojo> dojos = dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "NewNinja.jsp";
	}
	
	@PostMapping("ninja/create")
	public String addNinjaToDB(Ninja ninja) {
		ninjaService.save(ninja);
		System.out.println(ninja.toString());
		return "redirect:/";
	}
}
