package com.dhenton9000.classiccars.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCustomer entity provides the base persistence definition of the
 * Customer entity. @author eclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private Integer customernumber;
	private String customername;
	private String contactlastname;
	private String contactfirstname;
	private String phone;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String postalcode;
	private String country;
	private Integer salesrepemployeenumber;
	private Double creditlimit;
	private Employee salesrep;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String customername, String contactlastname,
			String contactfirstname, String phone, String addressline1,
			String addressline2, String city, String state, String postalcode,
			String country, Integer salesrepemployeenumber, Double creditlimit) {
		this.customername = customername;
		this.contactlastname = contactlastname;
		this.contactfirstname = contactfirstname;
		this.phone = phone;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.postalcode = postalcode;
		this.country = country;
		this.salesrepemployeenumber = salesrepemployeenumber;
		this.creditlimit = creditlimit;
		
	}

	// Property accessors

	public Integer getCustomernumber() {
		return this.customernumber;
	}

	public void setCustomernumber(Integer customernumber) {
		this.customernumber = customernumber;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getContactlastname() {
		return this.contactlastname;
	}

	public void setContactlastname(String contactlastname) {
		this.contactlastname = contactlastname;
	}

	public String getContactfirstname() {
		return this.contactfirstname;
	}

	public void setContactfirstname(String contactfirstname) {
		this.contactfirstname = contactfirstname;
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getSalesrepemployeenumber() {
		return this.salesrepemployeenumber;
	}

	public void setSalesrepemployeenumber(Integer salesrepemployeenumber) {
		this.salesrepemployeenumber = salesrepemployeenumber;
	}

	public Double getCreditlimit() {
		return this.creditlimit;
	}

	public void setCreditlimit(Double creditlimit) {
		this.creditlimit = creditlimit;
	}

	public void setSalesrep(Employee salesrep) {
		this.salesrep = salesrep;
	}

	public Employee getSalesrep() {
		return salesrep;
	}

	

}