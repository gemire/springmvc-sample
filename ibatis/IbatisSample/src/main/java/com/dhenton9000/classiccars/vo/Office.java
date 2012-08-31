package com.dhenton9000.classiccars.vo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractOffice entity provides the base persistence definition of the Office
 * entity. @author eclipse Persistence Tools
 */

public class Office implements java.io.Serializable {

	// Fields

	private String officecode;
	private String city;
	private String phone;
	private String addressline1;
	private String addressline2 = null;
	private String state;
	private String country;
	private String postalcode;
	private String territory;
	

	// Constructors

	/** default constructor */
	public Office() {
	}

	/** full constructor */
	public Office(String city, String phone, String addressline1,
			String addressline2, String state, String country,
			String postalcode, String territory) {
		this.city = city;
		this.phone = phone;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.state = state;
		this.country = country;
		this.postalcode = postalcode;
		this.territory = territory;

	}

	

	 

	// Property accessors

	public String getOfficecode() {
		return this.officecode;
	}

	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getTerritory() {
		return this.territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}



}