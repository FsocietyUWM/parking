package com.caveof.spring.web.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="reservations")
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reservationID;
	
	@Column(name = "startDate", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@Column(name = "expirationDate", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate;
	
	private int numberOfVehicles;
	private double charge;
	private boolean doesPaid;
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	public Reservation() {
	}
	
	public Reservation(User user, Date startDate, Date expirationDate, int numberOfVehicles, double charge, boolean doesPaid) {
		this.user = user;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.numberOfVehicles = numberOfVehicles;
		this.charge = charge;
		this.doesPaid = doesPaid;
	}
	
	public Reservation(int reservationID, User user, Date startDate, Date expirationDate, int numberOfVehicles, double charge, boolean doesPaid) {
		this.reservationID = reservationID;
		this.user = user;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.numberOfVehicles = numberOfVehicles;
		this.charge = charge;
		this.doesPaid = doesPaid;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getNumberOfVehicles() {
		return numberOfVehicles;
	}

	public void setNumberOfVehicles(int numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public boolean isDoesPaid() {
		return doesPaid;
	}

	public void setDoesPaid(boolean doesPaid) {
		this.doesPaid = doesPaid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", startDate=" + startDate + ", expirationDate="
				+ expirationDate + ", numberOfVehicles=" + numberOfVehicles + ", charge=" + charge + ", doesPaid="
				+ doesPaid + ", user=" + user + "]";
	}

}
