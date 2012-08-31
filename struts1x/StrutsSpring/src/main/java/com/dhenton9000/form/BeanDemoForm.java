package com.dhenton9000.form;

import org.apache.struts.action.ActionForm;

public class BeanDemoForm extends ActionForm{
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}