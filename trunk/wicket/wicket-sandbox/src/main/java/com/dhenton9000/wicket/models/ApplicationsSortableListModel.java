/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

import com.dhenton9000.wicket.models.ApplicationsReloadableEntityModel;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.models.SortableListModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dhenton
 */
public class ApplicationsSortableListModel extends SortableListModel {

    private ApplicationsReloadableEntityModel applicationsModel;
    
    @Override
    protected List load(String orderByProperty, Boolean orderByAsc) {
        
        Applications t =  (Applications) applicationsModel.getObject();
        return new ArrayList(t.getGroupsSet());
    }
    
    
     
    
    

    /**
     * @return the applicationsModel
     */
    public ApplicationsReloadableEntityModel getApplicationsModel() {
        return applicationsModel;
    }

    /**
     * @param applicationsModel the applicationsModel to set
     */
    public void setApplicationsModel(ApplicationsReloadableEntityModel applicationsModel) {
        this.applicationsModel = applicationsModel;
    }
    
}
