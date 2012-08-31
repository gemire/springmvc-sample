package com.dhenton9000.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dhenton9000.beans.InjectedBean;
import com.dhenton9000.form.BeanDemoForm;

public class BeanDemoAction extends Action {
	private static Logger log = LogManager.getLogger(BeanDemoAction.class);
	private InjectedBean injectedBean = null;

	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		
		BeanDemoForm bForm = (BeanDemoForm) form;
		bForm.setMessage("Hello from Struts and Spring");
	
		
		
		
		
		return mapping.findForward("beandemoresults");
	}

	public InjectedBean getInjectedBean() {
		return injectedBean;
	}

	public void setInjectedBean(InjectedBean injectedBean) {
		this.injectedBean = injectedBean;
	}

}