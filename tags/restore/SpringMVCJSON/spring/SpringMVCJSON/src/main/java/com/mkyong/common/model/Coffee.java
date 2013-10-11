package com.mkyong.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coffee")
public class Coffee {

	String brand;
	int quantity;


	public String getBrand() {
		return brand;
	}

	
	@XmlElement
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	@XmlElement
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Coffee(String name, int quanlity) {
		this.brand = name;
		this.quantity = quanlity;
	}

	public Coffee() {
		super();
	}

	
	
}