/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.hibernateWeb.backing;

import java.io.Serializable;

import com.dhenton9000.hibernatesecurity.Utils;
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
}
