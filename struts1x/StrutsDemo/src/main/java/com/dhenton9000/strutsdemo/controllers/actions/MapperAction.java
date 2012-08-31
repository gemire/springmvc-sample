package com.dhenton9000.strutsdemo.controllers.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MapperAction extends Action {
public static Logger log = LogManager.getLogger(MapperAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 
		DemoActionMappings dAction = (DemoActionMappings) mapping;
	
		if (dAction.isFirstTime() == true)
		{
			dAction.setSharedInformation("info from action code -- "+dAction.getSharedInformation());
			dAction.setFirstTime(false);
		}
		
		return mapping.findForward("success");
	}
	
	

}
