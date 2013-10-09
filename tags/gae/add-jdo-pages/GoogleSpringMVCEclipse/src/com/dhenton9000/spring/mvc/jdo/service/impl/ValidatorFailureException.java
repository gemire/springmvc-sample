package com.dhenton9000.spring.mvc.jdo.service.impl;

import java.util.HashMap;

public class ValidatorFailureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3753675717119918862L;
	
	private HashMap<String,String> errors = null;

	public HashMap<String,String> getErrors() {
		return errors;
	}


	public ValidatorFailureException(String arg0,HashMap<String,String> e) {
		super(arg0);
		errors = e;
	}



	 
	

}
