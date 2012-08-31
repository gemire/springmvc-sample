package com.dhenton9000.classic.dao.generated;

import java.util.HashSet;
import java.util.Set;

/**
 * Office entity. @author eclipse Persistence Tools
 */

public class Office implements java.io.Serializable {

	// Fields

	private String officecode;
	private String city;
	private String phone;
	private String addressline1;
	private String addressline2;
	private String state;
	private String country;
	private String postalcode;
	private String territory;
	private Set employees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Office() {
	}

	/** full constructor */
	public Office(String city, String phone, String addressline1,
			String addressline2, String state, String country,
			String postalcode, String territory, Set employees) {
		this.city = city;
		this.phone = phone;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.state = state;
		this.country = country;
		this.postalcode = postalcode;
		this.territory = territory;
		this.employees = employees;
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

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressline1 == null) ? 0 : addressline1.hashCode());
		result = prime * result
				+ ((addressline2 == null) ? 0 : addressline2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((postalcode == null) ? 0 : postalcode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((territory == null) ? 0 : territory.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Office other = (Office) obj;
		if (addressline1 == null) {
			if (other.addressline1 != null)
				return false;
		} else if (!addressline1.equals(other.addressline1))
			return false;
		if (addressline2 == null) {
			if (other.addressline2 != null)
				return false;
		} else if (!addressline2.equals(other.addressline2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postalcode == null) {
			if (other.postalcode != null)
				return false;
		} else if (!postalcode.equals(other.postalcode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (territory == null) {
			if (other.territory != null)
				return false;
		} else if (!territory.equals(other.territory))
			return false;
		return true;
	}

}