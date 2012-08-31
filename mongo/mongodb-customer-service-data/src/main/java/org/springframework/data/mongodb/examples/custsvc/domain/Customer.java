package org.springframework.data.mongodb.examples.custsvc.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.persistence.document.RelatedDocument;

@Entity
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	@RelatedDocument
	private SurveyInfo surveyInfo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public SurveyInfo getSurveyInfo() {
		return surveyInfo;
	}

	public void setSurveyInfo(SurveyInfo surveyInfo) {
		this.surveyInfo = surveyInfo;
	}

}
