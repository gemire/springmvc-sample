package com.dhenton9000.strutsdemo.controllers.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorActionForm;

 

public class DynaDemoAction extends Action {

	private static final Logger log = Logger.getLogger(DynaDemoAction.class);
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DynaValidatorActionForm dForm = (DynaValidatorActionForm) form;
		 
		String affiliationKey = "affiliation";
		String[] tArray = (String[]) dForm.getMap().get(affiliationKey);
		String z = "";
		if (tArray != null && tArray.length > 0)
		{
			 for (int i=0;i< tArray.length;i++)
			 {
				 z = z + tArray[i]+"|";
			 }
			z = z.trim();
			z = z.substring(0,z.length()-1);
			
			
		}
		dForm.getMap().put(affiliationKey, z);		
		
		
		request.setAttribute("formBean", dForm);
		
		
		return mapping.findForward("success");
	}
}
