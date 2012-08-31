package com.dhenton9000.form;

import org.apache.struts.action.ActionForm;

public class VoteForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381216411555421321L;
	String slogan;
	String party;
	
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}

	 
	
}