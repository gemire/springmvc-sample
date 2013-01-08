/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.security.maintenance;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.javabeat.net/2011/04/displaying-data-using-datatable-in-apache-wicket/
 *
 * @author dhenton
 */
public class SortableApplicationsDataProvider extends SortableDataProvider<Applications, String> {

    private final Logger logger = LoggerFactory.getLogger(SortableApplicationsDataProvider.class);
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

        //logger.debug("sort is " + getSort().getProperty() + " " + getSort().isAscending());
        List<Applications> data = applicationsService.getAllApplications();
        Collections.sort(data, new Comparator<Applications>() {
            @Override
            public int compare(Applications o1, Applications o2) {
                int dir = getSort().isAscending() ? 1 : -1;
                if ("applicationName".equals(getSort().getProperty())) {
                    return dir * (o1.getApplicationName().
                            toUpperCase().
                            compareTo(o2.
                            getApplicationName().toUpperCase()));
                } else {
                    return dir * (o1.getId().compareTo(o2.getId()));
                }
            }
        });


        return data.subList((int) first,
                (int) Math.min(first + count, data.size())).iterator();

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
