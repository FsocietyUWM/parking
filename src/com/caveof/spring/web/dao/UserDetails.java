package com.caveof.spring.web.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users_details")
public class UserDetails {
	
	@Id
	private String username;
	
	private String name;
	private String surname;
	private String phoneNumber;
	private String birthDate;
	private String address;
	private String postalCode;
	private String city;

	public UserDetails() {

	}
	
	public UserDetails(String name, String surname, String phoneNumber, String birthDate, String address, String postalCode, String city) {
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserDetails [username=" + username + ", name=" + name + ", surname=" + surname + ", phoneNumber="
				+ phoneNumber + ", birthDate=" + birthDate + ", address=" + address + ", postalCode=" + postalCode
				+ ", city=" + city + "]";
	}
}
