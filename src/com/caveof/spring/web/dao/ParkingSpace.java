package com.caveof.spring.web.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="parking_spaces")
public class ParkingSpace {
	
	@Id
	private String spaceNumber;
	
	private boolean available = true;

	public ParkingSpace() {

	}
	
	public ParkingSpace(String spaceNumber, boolean available) {
		this.spaceNumber = spaceNumber;
		this.available = available;
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

	@Override
	public String toString() {
		return "ParkingSpace [spaceNumber=" + spaceNumber + ", available=" + available + "]";
	}

}
