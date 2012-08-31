package com.dhenton9000.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.dhenton9000.form.VoteForm;


public class VoteAction extends Action{
	  private static Logger log = LogManager.getLogger(VoteAction.class);
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		VoteForm vForm = (VoteForm) form;
		String party = vForm.getParty(); 
		vForm.setSlogan(party+"!!!!!!");
		return mapping.findForward(party);
	}
	
}