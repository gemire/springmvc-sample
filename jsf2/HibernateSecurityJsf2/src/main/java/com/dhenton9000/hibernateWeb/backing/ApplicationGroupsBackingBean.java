/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernateWeb.backing;

import com.dhenton9000.hibernatesecurity.ApplicationGroups;
import com.dhenton9000.hibernatesecurity.Applications;
import com.dhenton9000.hibernatesecurity.Groups;
import com.dhenton9000.hibernatesecurity.Utils;
import com.dhenton9000.hibernatesecurity.dao.DataAccessLayerException;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author dyh
 */
public class ApplicationGroupsBackingBean extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = -6891686668597709112L;
    private static Logger log = LogManager.getLogger(ApplicationGroupsBackingBean.class);
 
    private int selectedApplication = 0;
    private SelectItem[] applicationItems = null;
    private DataModel currentAvailableGroups = null;
    private DataModel currentGroups = null;

    /**
     * Creates a new instance of ApplicationGroupsBackingBean
     */
    public ApplicationGroupsBackingBean() {

        
        if (applicationItems == null) {
             
            try {
                List list = this.getSecurityService() .findAll(Applications.class);
                applicationItems = new SelectItem[list.size() + 1];
                applicationItems[0] = new SelectItem("0", "--Select Application--");
                for (int j = 0; j < list.size(); j++) {
                    Applications a = (Applications) list.get(j);
                    applicationItems[j + 1] = new SelectItem(a.getId() + "", a.getApplicationName());
                }

                setSelectedApplication(0);
            } catch (DataAccessLayerException ex) {

                log.error("constructor problem " + Utils.createErrorMessage(ex));
                addFacesErrorMessage(ex);

            }
        }

    }

    public DataModel getAvailableGroups() {

        return currentAvailableGroups;
    }

    private void recalcAvailableGroups() {
 
        List groupData = null;
        if (selectedApplication == 0) {
            return;
        }

        try {
            groupData = this.getSecurityService() .getAvailableGroupsForApplication(selectedApplication);
        } catch (DataAccessLayerException ex) {

            log.error("getAvailableGroups() " + Utils.createErrorMessage(ex));
            addFacesErrorMessage(ex);

        }
        currentAvailableGroups = new ListDataModel(groupData);

    }

    public void recalcGroups() {

        List groupData = null;
        if (selectedApplication == 0) {
            return;
        }
        try {
            groupData = this.getSecurityService() .getGroupsForApplication(selectedApplication);
        } catch (DataAccessLayerException ex) {

            log.error("getGroups() " + Utils.createErrorMessage(ex));
            addFacesErrorMessage(ex);

        }
        currentGroups = new ListDataModel(groupData);

    }

    public DataModel getGroups() {

        return currentGroups;

    }

    public void applicationChanged(ValueChangeEvent valueChangeEvent) {

        String t = valueChangeEvent.getNewValue().toString();
        this.selectedApplication = Integer.parseInt(t);
        recalcGroups();
        recalcAvailableGroups();
    }

    /**
     * @return the selectedApplication
     */
    public int getSelectedApplication() {
        return selectedApplication;
    }

    /**
     * @return the applicationItems
     */
    public SelectItem[] getApplicationItems() {

        return applicationItems;
    }

    /**
     * @param applicationItems the applicationItems to set
     */
    public void setApplicationItems(SelectItem[] applicationItems) {
        this.applicationItems = applicationItems;
    }

    /**
     * @param selectedApplication the selectedApplication to set
     */
    public void setSelectedApplication(int selectedApplication) {
        this.selectedApplication = selectedApplication;
    }

    public void doDeleteAction(ActionEvent e) {
        log.debug("action event called " + e.getComponent().toString());
        Groups g = null;
        DataModel gModel = getGroups();

        if (gModel == null) {
            return;
        }

        g = (Groups) gModel.getRowData();
        Applications aa = null;
        if (this.getSelectedApplication() == 0) {
            return;
        }

        g = (Groups) gModel.getRowData();
        try {
            aa = (Applications) this.getSecurityService() .find(Applications.class, new Integer(this.getSelectedApplication()));
            int gId = g.getId();
            int aId = aa.getId();
            this.getSecurityService() .deleteApplicationGroup(aId, gId);
            recalcAvailableGroups();
            recalcGroups();
        } catch (DataAccessLayerException ex) {

            log.error("dodeleteaction() " + Utils.createErrorMessage(ex));
            addFacesErrorMessage(ex);
            return;

        }

    }

    public void doAssign() {
        DataModel gModel = getAvailableGroups();
        Groups g = null;
        Applications aa = null;
        if (this.getSelectedApplication() == 0) {
            return;
        }
        if (gModel != null) {

            g = (Groups) gModel.getRowData();
            ApplicationGroups aG = new ApplicationGroups();
            try {
                aa = (Applications) this.getSecurityService() .find(Applications.class, new Integer(this.getSelectedApplication()));
                aG.setApplications(aa);
                aG.setGroups(g);
                this.getSecurityService() .saveOrUpdate(aG);
                recalcAvailableGroups();
                recalcGroups();
            } catch (DataAccessLayerException ex) {

                log.error("doAssign() " + Utils.createErrorMessage(ex));
                addFacesErrorMessage(ex);
                return;

            }

        }

    }
}
