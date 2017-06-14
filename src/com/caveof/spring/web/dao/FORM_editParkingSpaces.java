package com.caveof.spring.web.dao;

import java.util.ArrayList;
import java.util.List;

public class FORM_editParkingSpaces {

	List<ParkingSpace> parkingSpaces;

	public FORM_editParkingSpaces() {
		
	}

	public FORM_editParkingSpaces(List<ParkingSpace> parkingSpaces) {
		this.parkingSpaces = parkingSpaces;
	}

	public List<ParkingSpace> getParkingSpaces() {
		return parkingSpaces;
	}

	public void setParkingSpaces(List<ParkingSpace> parkingSpaces) {
		this.parkingSpaces = parkingSpaces;
	}

}
