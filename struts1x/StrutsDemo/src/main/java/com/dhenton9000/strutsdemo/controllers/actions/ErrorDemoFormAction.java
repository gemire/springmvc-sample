package com.dhenton9000.strutsdemo.controllers.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dhenton9000.forms.ErrorDemoForm;
import com.dhenton9000.strutsdemo.ClownException;

public class ErrorDemoFormAction extends Action {
	private static Logger log = LogManager.getLogger(ErrorDemoFormAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Object[] messageArgs = {"Moron","<i>get a job!!!</i>"};
		String messageKey = "error.bozo.error";
		
		ErrorDemoForm eForm = (ErrorDemoForm) form;
		String clownName = eForm.getClownName();
		
		
		
		ErrorDemoMappings eMappings = (ErrorDemoMappings) mapping;
		eMappings.setClownName(clownName);
		
		log.debug("clown name is "+clownName);
		clownName = clownName.trim().toUpperCase();
		if ("BOZO".equalsIgnoreCase(clownName))
		{
			 ClownException c =  new ClownException();
			 
			c.setMessageArgs(messageArgs);
			
			c.setMessageKey(messageKey);
			throw c;
		}
 
		return mapping.findForward("success");
	}

}
