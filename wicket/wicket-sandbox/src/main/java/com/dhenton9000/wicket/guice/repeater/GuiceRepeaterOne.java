/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.guice.repeater;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.TemplatePage;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.google.inject.Inject;
import java.util.List;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author dhenton
 */
public final class GuiceRepeaterOne extends TemplatePage {

    @Inject
    private IApplicationsDao service;
    public GuiceRepeaterOne() {


        this.setPageTitle("Simple Repeater Demo");
        addLocationsModule();
    }

    private void addLocationsModule() {
        ListView<Applications> applications = new ListView<Applications>("applications", createModelForLocations()) {
            @Override
            protected void populateItem(ListItem<Applications> item) {
                item.add(new Label("id", new PropertyModel<Applications>(item.getModel(), "id")));
                item.add(new Label("applicationName", new PropertyModel<Applications>(item.getModel(), "applicationName")));
            }
        };

        add(applications);
    }

    private LoadableDetachableModel<List<Applications>> createModelForLocations() {

        return new LoadableDetachableModel<List<Applications>>() {     
            @Override
            protected List<Applications> load() {     
                return service.getAllApplications();
            }
        };
    }
}
