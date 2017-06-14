package com.caveof.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.caveof.spring.web.dao.Cennik;
import com.caveof.spring.web.dao.ParkingSpace;
import com.caveof.spring.web.dao.Reservation;
import com.caveof.spring.web.dao.ReservationsDao;
import com.caveof.spring.web.dao.Vehicle;

@Service("reservationsService")
public class ReservationsService {

	private ReservationsDao reservationsDao;

	@Autowired
	public void setReservationsDao(ReservationsDao reservationsDao) {
		this.reservationsDao = reservationsDao;
	}
	
	//////////////////////////////////////////////////////////

	
	public List<Reservation> getReservations() {
		return reservationsDao.getReservations();
	}
	
	public List<Vehicle> getVehicles() {
		return reservationsDao.getVehicles();
	}
	
	public List<Vehicle> getVehicles(String username) {
		return reservationsDao.getVehicles(username);
	}
	
	public List<Vehicle> getVehicles(int reservationID) {
		return reservationsDao.getVehicles(reservationID);
	}
	

	public List<Reservation> getReservations(String username) {

		if (username == null) {
			return null;
		}

		List<Reservation> reservations = reservationsDao.getReservations(username);
		if (reservations.size() == 0) {
			return null;
		}

		return reservations;
	}
	
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void saveOrUpdate(Reservation reservation) {
		reservationsDao.saveOrUpdate(reservation);
	}
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void saveVehicle(Vehicle vehicle) {
		reservationsDao.saveVehicle(vehicle);
	}
	

	public void delete(int id) {
		reservationsDao.delete(id);
	}


	public boolean hasReservation(String username) {

		if (username == null) {
			return false;
		}

		List<Reservation> reservations = reservationsDao.getReservations(username);
		if (reservations.size() == 0) {
			return false;
		}

		return true;
	}
	
	public List<ParkingSpace> getParkingSpaces() {
		return reservationsDao.getParkingSpaces();
	}
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void saveParkingSpace(ParkingSpace parkingSpace) {
		reservationsDao.saveParkingSpace(parkingSpace);
	}
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void updateParkingSpace(ParkingSpace parkingSpace) {
		reservationsDao.updateParkingSpace(parkingSpace);
	}
	
	public List<ParkingSpace> getAvailableParkingSpaces() {
		return reservationsDao.getAvailableParkingSpaces();
	}
	
	public ParkingSpace getAvailableParkingSpace() {
		return reservationsDao.getAvailableParkingSpace();
	}
	
	public int getNumberOfAllParkingSpaces() {
		return reservationsDao.getNumberOfAllParkingSpaces();
	}
	
	public int getNumberOfAvailableParkingSpaces() {
		return reservationsDao.getNumberOfAvailableParkingSpaces();
	}
	
	public int getNumberOfTakenParkingSpaces() {
		return reservationsDao.getNumberOfTakenParkingSpaces();
	}
	
	public void delete(ParkingSpace parkingSpace) {
		reservationsDao.delete(parkingSpace);
	}
	
	public void saveOrUpdate(ParkingSpace parkingSpace) {
		reservationsDao.saveOrUpdate(parkingSpace);
	}
	
}
