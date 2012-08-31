package com.dhenton9000.strutsdemo.controllers.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class DemoFormAction extends DispatchAction {

	public ActionForward step1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//return mapping.findForward("global.step1");
		return mapping.findForward("global.step1.tiles");
	}
	 
	
	public ActionForward step2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//return mapping.findForward("step2");
		return mapping.findForward("global.step2.tiles");
	}
	
	
	
	public ActionForward step3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//return mapping.findForward("step3");
		return mapping.findForward("global.step3.tiles");
	}

}
