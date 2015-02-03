/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.hibernateWeb.backing;

import java.io.Serializable;

import com.dhenton9000.hibernatesecurity.Utils;
import com.dhenton9000.hibernatesecurity.service.ISecurityService;
import com.dhenton9000.hibernatesecurity.service.SecurityService;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dyh
 */
public class BaseBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1972674874545844619L;
        private SecurityService securityService = new SecurityService();
	protected void addFacesErrorMessage(Exception ex) {
        String t = Utils.createErrorMessage(ex);
        addFacesMessage(t);
    }

    protected void addFacesMessage(String t) {
        FacesMessage mm = new FacesMessage();
        mm.setSeverity(FacesMessage.SEVERITY_ERROR);
        mm.setDetail(t);
        mm.setSummary(t);
        FacesContext.getCurrentInstance().addMessage(null, mm);
    }
    
    protected ISecurityService getSecurityService()
    {
        return securityService;
    }
}
