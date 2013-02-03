/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.security;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.dao.IGroupsDao;
import com.dhenton9000.wicket.dao.service.IApplicationsService;
import com.dhenton9000.wicket.models.ApplicationsReloadableEntityModel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class MaintainApplicationsTwo extends WebPage {

    private final Logger logger = LoggerFactory.getLogger(MaintainApplicationsTwo.class);
    private ApplicationsReloadableEntityModel selectedApplication = null;
    @SpringBean
    private IApplicationsService service;
    @SpringBean
    private IGroupsDao groupsService;

    public MaintainApplicationsTwo() {
        super();
        setup();
    }

    private void setup() {
    }

    /**
     * @return the state
     */
    public STATE getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(STATE state) {
        this.state = state;
    }

    /**
     * @return the selectedApplication
     */
    public Applications getSelectedApplication() {
        return (Applications) selectedApplication.getEntity();
    }

    public enum STATE {

        INITIAL, ADD, EDIT, DELETE
    }
    private STATE state = STATE.INITIAL;
    
    
     public void performStateOperation(STATE t) {
        logger.debug("operation called with " + t);

        switch (t) {

            case ADD:
                setState(STATE.ADD);
                selectedApplication = new ApplicationsReloadableEntityModel(new Applications(),service);
                break;
            case DELETE:
                if (getSelectedApplication() != null) {
                    service.delete((Applications) getSelectedApplication());
                    setState(STATE.INITIAL);
                    selectedApplication = new ApplicationsReloadableEntityModel(new Applications(),service);
                }
                break;
            case EDIT:
                setState(STATE.EDIT);
                break;
            case INITIAL:
                setState(STATE.INITIAL);
                selectedApplication = new ApplicationsReloadableEntityModel(new Applications(),service);
                 
                break;
        }



    }
    
     public String getSelectedApplicationsDisplay() {
        String t = getSelectedApplication().getApplicationName();
        if (t == null) {
            t = "";
        }
        return t + " [" + getState() + "]";
    }
    
    
    
    
}
