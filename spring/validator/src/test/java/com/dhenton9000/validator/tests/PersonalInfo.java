package com.dhenton9000.validator.tests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

public class PersonalInfo {

	@Range(min = 25, max = 45)
	private int age;

	@NotNull
	@Pattern(regexp = "^(?:m|M|male|Male|f|F|female|Female)$")
	private String gender;

	@NotNull
 	@Pattern(regexp="^\\(\\d{3}\\)[\\s]\\d{3}[-,\\s]\\d{4}$")
	private String phone;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
