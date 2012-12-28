/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.security.maintenance;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.google.inject.Inject;
import java.util.Iterator;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

/**
 *
 * @author dhenton
 */
public class SortableApplicationsDataProvider extends SortableDataProvider<Applications, String> {

    
    private IApplicationsDao applicationsService;

    /**
     * constructor
     */
   
    SortableApplicationsDataProvider(IApplicationsDao applicationsService) {
        
        setSort("applicationName", SortOrder.ASCENDING);
        
        this.applicationsService = applicationsService;
    }

    @Override
    public Iterator<Applications> iterator(long first, long count) {

        return applicationsService.getAllApplicationswithLimits(first,count).iterator();

    }

    /**
     * @see org.apache.wicket.markup.repeater.data.IDataProvider#size()
     */
    @Override
    public long size() {
        return applicationsService.getAllApplications().size();
    }

    /**
     * @see
     * org.apache.wicket.markup.repeater.data.IDataProvider#model(java.lang.Object)
     */
    @Override
    public IModel<Applications> model(Applications object) {
        return new DetachableApplicationsModel(object, applicationsService);
    }
}
