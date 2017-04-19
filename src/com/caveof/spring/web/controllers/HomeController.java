package com.caveof.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caveof.spring.web.dao.Cennik;
import com.caveof.spring.web.dao.User;
import com.caveof.spring.web.service.CennikService;
import com.caveof.spring.web.service.OffersService;

@Controller
public class HomeController {
	
	private OffersService offersService;
	private CennikService cennikService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
	
	@Autowired
	public void setCennikService(CennikService cennikService) {
		this.cennikService = cennikService;
	}

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/cennik")
	public String showCennik(Model model) {
		
		List<Cennik> prices = cennikService.getCurrentCennik();
		model.addAttribute("prices", prices);
		
		return "cennik";
	}
	
	@RequestMapping("/editcennik")
	public String editCennik(Model model) {
		
		List<Cennik> prices = cennikService.getCurrentCennik();
		model.addAttribute("prices", prices);
		
		return "editcennik";
	}
	
	@RequestMapping("/kontakt")
	public String showKontakt() {
		return "kontakt";
	}

}
