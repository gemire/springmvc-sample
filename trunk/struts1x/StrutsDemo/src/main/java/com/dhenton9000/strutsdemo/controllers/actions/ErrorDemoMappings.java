package com.dhenton9000.strutsdemo.controllers.actions;

import org.apache.struts.action.ActionMapping;

public class ErrorDemoMappings extends ActionMapping {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6784403181680419799L;
	private String clownName = null;
	public void setClownName(String clownName) {
		this.clownName = clownName;
	}
	public String getClownName() {
		return clownName;
	}
	

}
