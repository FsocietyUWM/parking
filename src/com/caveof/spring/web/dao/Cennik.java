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
	private double oneDay;
	private double oneDayMoreThanWeek;
	private double oneDayMoreThanMonth;
	private boolean toRemove = false;

	
	public Cennik() {
		
	}
	
	public Cennik(String vehicleType, double oneDay, double oneDayMoreThanWeek, double oneDayMoreThanMonth, boolean toRemove) {
		this.vehicleType = vehicleType;
		this.oneDay = oneDay;
		this.oneDayMoreThanWeek = oneDayMoreThanWeek;
		this.oneDayMoreThanMonth = oneDayMoreThanMonth;
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

	public double getOneDay() {
		return oneDay;
	}

	public void setOneDay(double oneDay) {
		this.oneDay = oneDay;
	}

	public double getOneDayMoreThanWeek() {
		return oneDayMoreThanWeek;
	}

	public void setOneDayMoreThanWeek(double oneDayMoreThanWeek) {
		this.oneDayMoreThanWeek = oneDayMoreThanWeek;
	}

	public double getOneDayMoreThanMonth() {
		return oneDayMoreThanMonth;
	}

	public void setOneDayMoreThanMonth(double oneDayMoreThanMonth) {
		this.oneDayMoreThanMonth = oneDayMoreThanMonth;
	}
	
	public boolean isToRemove() {
		return toRemove;
	}

	public void setToRemove(boolean toRemove) {
		this.toRemove = toRemove;
	}

	@Override
	public String toString() {
		return "Cennik [id=" + id + ", vehicleType=" + vehicleType + ", oneDay=" + oneDay + ", oneDayMoreThanWeek="
				+ oneDayMoreThanWeek + ", oneDayMoreThanMonth=" + oneDayMoreThanMonth + ", toRemove=" + toRemove + "]";
	}

}
