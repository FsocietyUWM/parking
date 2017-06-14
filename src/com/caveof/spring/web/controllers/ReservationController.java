package com.caveof.spring.web.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caveof.spring.web.dao.Cennik;
import com.caveof.spring.web.dao.CennikPrices;
import com.caveof.spring.web.dao.FORM_editParkingSpaces;
import com.caveof.spring.web.dao.ParkingSpace;
import com.caveof.spring.web.dao.Reservation;
import com.caveof.spring.web.dao.ReservationDetails;
import com.caveof.spring.web.dao.User;
import com.caveof.spring.web.dao.Vehicle;
import com.caveof.spring.web.service.CennikService;
import com.caveof.spring.web.service.ReservationsService;
import com.caveof.spring.web.service.UsersService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationsService reservationsService;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private CennikService cennikService;

	//////////////////////////////////////////////////////////
	
	@RequestMapping("/myreservations")
	public String showMyReservations(Model model, Principal principal) {
		
		String username = principal.getName();
		User authUser = usersService.getUser(username);
		List<Reservation> reservations = reservationsService.getReservations(authUser.getUsername());
		
		List<ReservationDetails> myReservations = new ArrayList<ReservationDetails>();
		for(Reservation reservation : reservations)
		{
			ReservationDetails reservationDetails = new ReservationDetails();
			reservationDetails.setReservation(reservation);
			
			List<Vehicle> vehicles = reservationsService.getVehicles(reservation.getReservationID());
			reservationDetails.setVehicles(vehicles);
			
			myReservations.add(reservationDetails);
		}
		
		model.addAttribute("myReservations", myReservations);
		
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
		
		List<Cennik> prices = cennikService.getCennik();
		reservationDetails.setCennikPrices(prices);
		
		int iloscWolnychMiejsc = reservationsService.getNumberOfAvailableParkingSpaces();

		model.addAttribute("reservationDetails", reservationDetails);
		model.addAttribute("iloscWolnychMiejsc", iloscWolnychMiejsc);

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
		
		double naleznosc = 0;
		
		long diffInMillies = reservation.getExpirationDate().getTime() - reservation.getStartDate().getTime();
		long dlugoscRezerwacjiWDniach = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1;
		
		for(Vehicle vehicle : vehicles) {
			if (!vehicle.getRegistrationNumber().isEmpty())
			{
				String vehicleType = vehicle.getVehicleType();
				Cennik cennik = cennikService.getCennikByVehicleType(vehicleType);
				
				naleznosc += cennik.getFirstDayPrice();
				naleznosc += (dlugoscRezerwacjiWDniach - 1) * cennik.getNextDayPrice();
			}
		}
		
		reservation.setCharge(naleznosc);
		reservationsService.saveOrUpdate(reservation);
		
		return "reservationcreated";
	}
	
	@RequestMapping("/parkingspaces")
	public String showParkingSpaces(Model model) {
		
		List<ParkingSpace> parkingSpaces = reservationsService.getParkingSpaces();
		List<Vehicle> allVehicles = reservationsService.getVehicles();
		
		int iloscWszyskichMiejsc = reservationsService.getNumberOfAllParkingSpaces();
		int iloscWolnychMiejsc = reservationsService.getNumberOfAvailableParkingSpaces();
		int iloscZajetychMiejsc = reservationsService.getNumberOfTakenParkingSpaces();
		
		model.addAttribute("parkingSpaces", parkingSpaces);
		model.addAttribute("iloscWszyskichMiejsc", iloscWszyskichMiejsc);
		model.addAttribute("iloscWolnychMiejsc", iloscWolnychMiejsc);
		model.addAttribute("iloscZajetychMiejsc", iloscZajetychMiejsc);
		model.addAttribute("allVehicles", allVehicles);

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
		
		return "parkingupdated";
	}
	
	@RequestMapping("/editparkingspaces")
	public String editParkingSpaces(Model model) {

		List<ParkingSpace> parkingSpaces = reservationsService.getAvailableParkingSpaces();
		FORM_editParkingSpaces formParkingSpaces = new FORM_editParkingSpaces(parkingSpaces);
		
		model.addAttribute("formParkingSpaces", formParkingSpaces);

		return "editparkingspaces";
	}
	
	@RequestMapping("/updateparkingspaces")
	public String updateCennik(Model model, FORM_editParkingSpaces formParkingSpaces, BindingResult result) {

		if (result.hasErrors()) {
			return "editparkingspaces";
		}

		for (ParkingSpace parkingSpace : formParkingSpaces.getParkingSpaces()) {
			if (parkingSpace.isToRemove() == true) {
				reservationsService.delete(parkingSpace);
			} else {
				reservationsService.saveOrUpdate(parkingSpace);
			}
		}
			
		return "parkingupdated";
	}
}
