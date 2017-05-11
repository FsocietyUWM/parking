package com.caveof.spring.web.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caveof.spring.web.dao.Cennik;
import com.caveof.spring.web.dao.CennikPrices;
import com.caveof.spring.web.dao.Offer;
import com.caveof.spring.web.dao.ParkingSpace;
import com.caveof.spring.web.dao.Reservation;
import com.caveof.spring.web.dao.ReservationDetails;
import com.caveof.spring.web.dao.User;
import com.caveof.spring.web.dao.UserDetails;
import com.caveof.spring.web.dao.Vehicle;
import com.caveof.spring.web.service.CennikService;
import com.caveof.spring.web.service.OffersService;
import com.caveof.spring.web.service.ReservationsService;
import com.caveof.spring.web.service.UsersService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationsService reservationsService;
	
	@Autowired
	private UsersService usersService;

	//////////////////////////////////////////////////////////
	
	@RequestMapping("/myreservations")
	public String showMyReservations(Model model, Principal principal) {
		
		String username = principal.getName();
		User authUser = usersService.getUser(username);
		
		List<Reservation> reservations = reservationsService.getReservations(authUser.getUsername());
		model.addAttribute("reservations", reservations);

		return "myreservations";
	}
	
	@RequestMapping("/newreservation")
	public String newReservation(Model model) {
	
		ReservationDetails reservationDetails = new ReservationDetails();
		reservationDetails.setReservation(new Reservation());
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(new Vehicle());
		vehicles.add(new Vehicle());
		vehicles.add(new Vehicle());
		reservationDetails.setVehicles(vehicles);

		model.addAttribute("reservationDetails", reservationDetails);

		return "newreservation";
	}
	
	@Transactional
	@RequestMapping("/createreservation")
	public String createReservation(Principal principal, Model model, ReservationDetails reservationDetails, BindingResult result) {

		/*
		if (result.hasErrors()) {
			return "newreservation";
		}
		*/
		
		String username = principal.getName();
		User authUser = usersService.getUser(username);
		
		Reservation reservation = reservationDetails.getReservation();
		reservation.setUser(authUser);
		reservationsService.saveOrUpdate(reservation);
		
		List<Vehicle> vehicles = reservationDetails.getVehicles();
		
		for(Vehicle vehicle : vehicles) {
			if (!vehicle.getRegistrationNumber().isEmpty())
			{
				vehicle.setReservation(reservation);
				
				ParkingSpace parkingSpace = reservationsService.getAvailableParkingSpace();
				parkingSpace.setAvailable(false);
				reservationsService.updateParkingSpace(parkingSpace);
				
				vehicle.setParkingSpace(parkingSpace);
				
				reservationsService.saveVehicle(vehicle);
			}
		}
		
		return "reservationcreated";
	}
	
	@RequestMapping("/parkingspaces")
	public String showParkingSpaces(Model model) {
		
		List<ParkingSpace> parkingSpaces = reservationsService.getParkingSpaces();
		model.addAttribute("parkingSpaces", parkingSpaces);

		return "parkingspaces";
	}
	
	@RequestMapping("/newparkingspace")
	public String newParkingSpace(Model model) {
	
		ParkingSpace parkingSpace = new ParkingSpace();

		model.addAttribute("parkingSpace", parkingSpace);

		return "newparkingspace";
	}
	
	@RequestMapping("/createparkingspace")
	public String createParkingSpace(Model model, ParkingSpace parkingSpace, BindingResult result) {

		/*
		if (result.hasErrors()) {
			return "newreservation";
		}
		*/
		
		reservationsService.saveParkingSpace(parkingSpace);
		
		return "parkingspacecreated";
	}
	

	/*
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
	*/
}
