package com.caveof.spring.web.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="parking_spaces")
public class ParkingSpace {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Autoincrement
	private int parkingSpaceID;
	
	private String spaceNumber;
	private boolean available = true;
	private boolean toRemove = false;

	public ParkingSpace() {

	}
	
	public ParkingSpace(String spaceNumber, boolean available, boolean toRemove) {
		this.spaceNumber = spaceNumber;
		this.available = available;
		this.toRemove = toRemove;
	}

	public int getParkingSpaceID() {
		return parkingSpaceID;
	}

	public void setParkingSpaceID(int parkingSpaceID) {
		this.parkingSpaceID = parkingSpaceID;
	}

	public String getSpaceNumber() {
		return spaceNumber;
	}

	public void setSpaceNumber(String spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isToRemove() {
		return toRemove;
	}

	public void setToRemove(boolean toRemove) {
		this.toRemove = toRemove;
	}

	@Override
	public String toString() {
		return "ParkingSpace [parkingSpaceID=" + parkingSpaceID + ", spaceNumber=" + spaceNumber + ", available="
				+ available + ", toRemove=" + toRemove + "]";
	}

}
