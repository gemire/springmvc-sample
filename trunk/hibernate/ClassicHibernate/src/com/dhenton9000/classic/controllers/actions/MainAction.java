package com.dhenton9000.classic.controllers.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MainAction extends Action {

 
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 
		String parm = request.getParameter("operation");
		if (parm == null)
		{
			throw new ServletException("must define operation parameter for MainAction it should be a defined forward");
		}
		
		
		return mapping.findForward(parm);
	}
	 
}
