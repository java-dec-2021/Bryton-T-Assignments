package com.bryton.displaydate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		java.util.Date date = new java.util.Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		String dateInfo = "";
		int year = calendar.get(Calendar.YEAR);
		int day = calendar.get(calendar.DAY_OF_MONTH);
		String month = new SimpleDateFormat("MMM").format(date);
		String dayOfWeek = new SimpleDateFormat("EEEE").format(date);
		dateInfo = dayOfWeek + ", the " + day + " of " + month + ", " + year;
		
		model.addAttribute("date", dateInfo);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm: aa");
		java.util.Date date = new java.util.Date();
		String time = dateFormat.format(date);
		model.addAttribute("time", time);
		return "time.jsp";
	}
	
}
