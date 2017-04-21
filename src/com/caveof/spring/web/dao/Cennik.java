package com.caveof.spring.web.dao;


public class Cennik {

	private String vehicleType;
	private double oneDay;
	private double oneDayMoreThanWeek;
	private double oneDayMoreThanMonth;

	
	public Cennik() {
		
	}
	
	public Cennik(String vehicleType, double oneDay, double oneDayMoreThanWeek, double oneDayMoreThanMonth) {
		this.vehicleType = vehicleType;
		this.oneDay = oneDay;
		this.oneDayMoreThanWeek = oneDayMoreThanWeek;
		this.oneDayMoreThanMonth = oneDayMoreThanMonth;
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

	@Override
	public String toString() {
		return "Cennik [vehicleType=" + vehicleType + ", v=" + oneDay + ", oneDayMoreThanWeek=" + oneDayMoreThanWeek + ", oneDayMoreThanMonth=" + oneDayMoreThanMonth + "]";
	}

}
