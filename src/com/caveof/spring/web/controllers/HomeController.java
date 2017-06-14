package com.caveof.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caveof.spring.web.dao.Cennik;
import com.caveof.spring.web.dao.CennikPrices;
import com.caveof.spring.web.dao.User;
import com.caveof.spring.web.service.CennikService;
import com.caveof.spring.web.service.UsersService;

@Controller
public class HomeController {

	// private static Logger logger = Logger.getLogger(HomeController.class);


	@Autowired
	private CennikService cennikService;
	
	@Autowired
	private UsersService usersService;

	//////////////////////////////////////////////////////////

	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {

		// logger.info("Showing home page...");

		return "home";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		
		List<User> users = usersService.getAllUsers();
		
		model.addAttribute("users", users);
		return "admin";
	}

	
	@RequestMapping("/cennik")
	public String showCennik(Model model) {

		List<Cennik> prices = cennikService.getCennik();
		model.addAttribute("prices", prices);

		return "cennik";
	}

	
	@RequestMapping("/addtocennik")
	public String addToCennik(Model model) {
		
		Cennik price = new Cennik();

		CennikPrices cennikPrices = new CennikPrices();
		cennikPrices.addPrice(price);
		model.addAttribute("cennikPrices", cennikPrices);

		return "addtocennik";
	}
	
	
	@RequestMapping("/editcennik")
	public String editCennik(Model model) {

		List<Cennik> prices = cennikService.getCennik();
		CennikPrices cennikPrices = new CennikPrices(prices);
		model.addAttribute("cennikPrices", cennikPrices);

		return "editcennik";
	}


	@RequestMapping("/updatecennik")
	public String updateCennik(Model model, CennikPrices cennikPrices, BindingResult result) {

		if (result.hasErrors()) {
			return "editcennik";
		}

		for (Cennik price : cennikPrices.getCennikPrices()) {
			if (price.isToRemove() == true) {
				cennikService.delete(price);
			} else {
				cennikService.saveOrUpdate(price);
			}
		}
			
		return "cennikupdated";
	}

	
	@RequestMapping("/kontakt")
	public String showKontakt() {
		return "kontakt";
	}

}
