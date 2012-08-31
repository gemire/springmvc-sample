package com.dhenton9000.forms;


 

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class ErrorDemoForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3626878610603976767L;

	private static final Logger log = Logger.getLogger(DemoForm.class);
	private String clownName = null;
	
	
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		 
		ActionErrors errors = new ActionErrors();
		if (clownName == null || clownName.trim().length() == 0)
		{
			errors.add("error.form.emptyClownName",
					new ActionError("error.form.emptyClownName"));
		}
	 
		return errors;
	}



	public void setClownName(String clownName) {
		this.clownName = clownName;
	}



	public String getClownName() {
		return clownName;
	}

	
	
	
	
	 
	
	
}
