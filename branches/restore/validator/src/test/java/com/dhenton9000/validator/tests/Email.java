package com.dhenton9000.validator.tests;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

public class Email {
	@NotEmpty
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "{bad.email.format}")
	private String from;
	@NotEmpty
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "bad.email.format")
	private String to;
	@NotEmpty
	private String subject;
	@NotEmpty
	private String body;
	@NotNull
	@Valid
	// will recursively validate this object
	private PersonalInfo personalInformation;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setPersonalInformation(PersonalInfo personalInformation) {
		this.personalInformation = personalInformation;
	}

	public PersonalInfo getPersonalInformation() {
		return personalInformation;
	}
}
