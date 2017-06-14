package com.caveof.spring.web.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="vehicles")
public class Vehicle {

	@Id
	private String registrationNumber;
	
	private String vehicleType;
	private String manufacturer;
	private String model;
	
	@ManyToOne
	@JoinColumn(name="reservationID")
	private Reservation reservation;
	
	@OneToOne
	@JoinColumn(name="parkingSpaceID")
	private ParkingSpace parkingSpace;
	
	public Vehicle() {
	}
	
	public Vehicle(String registrationNumber, String vehicleType, String manufacturer, String model, Reservation reservation, ParkingSpace parkingSpace) {
		this.registrationNumber = registrationNumber;
		this.vehicleType = vehicleType;
		this.manufacturer = manufacturer;
		this.model = model;
		this.reservation = reservation;
		this.parkingSpace = parkingSpace;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	@Override
	public String toString() {
		return "Vehicle [registrationNumber=" + registrationNumber + ", vehicleType=" + vehicleType + ", manufacturer="
				+ manufacturer + ", model=" + model + ", reservation=" + reservation + ", parkingSpace=" + parkingSpace
				+ "]";
	}

}
