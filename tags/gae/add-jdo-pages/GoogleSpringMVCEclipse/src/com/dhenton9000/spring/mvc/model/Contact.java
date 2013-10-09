package com.dhenton9000.spring.mvc.model;

import java.io.Serializable;

public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3687573109684994526L;
	private String firstname;
	private String lastname;
	private String email;
	private String telephone;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	} 
	
	
	
	
}
