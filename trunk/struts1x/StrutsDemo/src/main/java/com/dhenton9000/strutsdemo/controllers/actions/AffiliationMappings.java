package com.dhenton9000.strutsdemo.controllers.actions;

import java.util.ArrayList;

import org.apache.struts.action.ActionMapping;

public class AffiliationMappings extends ActionMapping {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6784406181680419799L;
	private ArrayList affiliations = new ArrayList();
	private String candidateName = null;
	
	
	
	public void setAffiliations(ArrayList affiliations) {
		this.affiliations = affiliations;
	}
	public ArrayList getAffiliations() {
		return affiliations;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCandidateName() {
		return candidateName;
	}
	
	
	 

}
