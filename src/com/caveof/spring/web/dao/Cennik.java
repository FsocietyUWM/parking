package com.caveof.spring.web.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pricelist")
public class Cennik {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Autoincrement
	private int id;
	
	private String vehicleType;
	private double firstDayPrice;
	private double nextDayPrice;
	private boolean toRemove = false;

	
	public Cennik() {
		
	}
	
	public Cennik(String vehicleType, double firstDayPrice, double nextDayPrice, boolean toRemove) {
		this.vehicleType = vehicleType;
		this.firstDayPrice = firstDayPrice;
		this.nextDayPrice = nextDayPrice;
		this.toRemove = toRemove;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public double getFirstDayPrice() {
		return firstDayPrice;
	}

	public void setFirstDayPrice(double firstDayPrice) {
		this.firstDayPrice = firstDayPrice;
	}

	public double getNextDayPrice() {
		return nextDayPrice;
	}

	public void setNextDayPrice(double nextDayPrice) {
		this.nextDayPrice = nextDayPrice;
	}

	public boolean isToRemove() {
		return toRemove;
	}

	public void setToRemove(boolean toRemove) {
		this.toRemove = toRemove;
	}

	@Override
	public String toString() {
		return "Cennik [id=" + id + ", vehicleType=" + vehicleType + ", firstDayPrice=" + firstDayPrice + ", nextDayPrice="
				+ nextDayPrice + ", toRemove=" + toRemove + "]";
	}

}
