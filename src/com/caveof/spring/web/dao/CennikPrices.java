package com.caveof.spring.web.dao;

import java.util.ArrayList;
import java.util.List;

public class CennikPrices {

	private List<Cennik> cennikPrices;

	public CennikPrices() {
		
	}

	public CennikPrices(List<Cennik> cennikPrices) {
		this.cennikPrices = cennikPrices;
	}

	public List<Cennik> getCennikPrices() {
		return cennikPrices;
	}

	public void setCennikPrices(List<Cennik> cennikPrices) {
		this.cennikPrices = cennikPrices;
	}
	
	public void addPrice(Cennik price) {
		this.cennikPrices = new ArrayList<Cennik>();
		this.cennikPrices.add(price);
	}
	
	public Cennik getPrice(int id) {
		for(Cennik price : this.cennikPrices) { 
		   if(price.getId() == id) { 
		       return price;
		   }
		}
		return null;
	}
}
