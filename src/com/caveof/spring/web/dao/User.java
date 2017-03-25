package com.caveof.spring.web.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	@NotBlank(message="Pole 'nazwa uzytkownika' nie moze byc puste.")
	@Size(min=4, max=12, message="Nazwa uzytkownika musi byc dluga na conajmniej 4 znaki i nie wieksza niz 12 znakow.")
	@Pattern(regexp="^\\w{4,}$", message="Nazwa uzytkownika moze zawierac tylko i wylacznie znaki alfanumeryczne.")
	private String username;
	
	@NotBlank(message="Pole 'haslo' nie moze byc puste.")
	@Size(min=8, max=20, message="Haslo musi byc dlugie na conajmniej 8 znakow i nie wieksze niz 20 znakow.")
	@Pattern(regexp="^\\S+$", message="Haslo nie moze zawierac bialych znakow.")
	private String password;
	
	@NotBlank(message="Pole 'email' nie moze byc puste.")
	@Email(message="Wyglada na to, ze email jest nie wlasciwy.")
	private String email;
	
	private boolean enabled = false;
	private String authority;

	public User() {
		
	}
	
	public User(String username, String password, String email, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
