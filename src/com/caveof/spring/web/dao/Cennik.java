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
	private double pricePerDay;
	private double pricePerMonth;
	private boolean toRemove = false;

	
	public Cennik() {
		
	}
	
	public Cennik(String vehicleType, double pricePerDay, double pricePerMonth, boolean toRemove) {
		this.vehicleType = vehicleType;
		this.pricePerDay = pricePerDay;
		this.pricePerMonth = pricePerMonth;
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
	
	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

	public boolean isToRemove() {
		return toRemove;
	}

	public void setToRemove(boolean toRemove) {
		this.toRemove = toRemove;
	}

	@Override
	public String toString() {
		return "Cennik [id=" + id + ", vehicleType=" + vehicleType + ", pricePerDay=" + pricePerDay + ", pricePerMonth="
				+ pricePerMonth + ", toRemove=" + toRemove + "]";
	}

}
