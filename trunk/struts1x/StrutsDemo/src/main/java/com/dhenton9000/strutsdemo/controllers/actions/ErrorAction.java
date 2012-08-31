package com.dhenton9000.strutsdemo.controllers.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/**
 * This servlet will always throw an error and should be sent to the error page.
 * 
 * 
 * @author dhh
 *
 */
public class ErrorAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 
		throw new UnsupportedOperationException("error demo");
		
		
		//return mapping.findForward("success");
	}
	
	

}
