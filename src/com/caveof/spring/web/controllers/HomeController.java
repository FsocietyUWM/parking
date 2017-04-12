package com.caveof.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/cennik")
	public String showCennik() {
		return "cennik";
	}
	
	@RequestMapping("/kontakt")
	public String showKontakt() {
		return "kontakt";
	}

}
