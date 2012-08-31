package com.dhenton9000.strutsdemo.controllers.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dhenton9000.strutsdemo.sample.ButtonItem;

public class BeanDemoAction extends Action {
   private static Logger log = LogManager.getLogger(BeanDemoAction.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 
		ButtonItem bI = new ButtonItem();
		bI.setValue("/processTransmission");
		request.setAttribute("actionFromForward", bI);
		
		
		//DemoActionMappings dAction = (DemoActionMappings) mapping;
		//log.debug("d "+dAction.isUsingSystem());
		
		return mapping.findForward("success");
	}
	
	

}
