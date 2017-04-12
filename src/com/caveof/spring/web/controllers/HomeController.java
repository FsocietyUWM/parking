package com.caveof.spring.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caveof.spring.web.dao.Offer;

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
