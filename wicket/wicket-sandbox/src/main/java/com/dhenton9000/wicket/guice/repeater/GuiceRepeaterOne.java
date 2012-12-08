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
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.markup.html.form.DropDownChoice;

/**
 *
 * @author dhenton
 */
public final class GuiceRepeaterOne extends TemplatePage {

    @Inject
    private IApplicationsDao service;
    private List<Applications> applications;

    public GuiceRepeaterOne() {


        this.setPageTitle("Simple Repeater Demo");
        addApplicationsListViewModule();
        add(new ApplicationsDropDownChoice("applicationsSelect"));

    }

    private void addApplicationsListViewModule() {

        ListView<Applications> applicationsListView = new ListView<Applications>("applications", createModelForLocations()) {
            @Override
            protected void populateItem(ListItem<Applications> item) {
                item.add(new Label("id", new PropertyModel<Applications>(item.getModel(), "id")));
                item.add(new Label("applicationName", new PropertyModel<Applications>(item.getModel(), "applicationName")));
            }
        };

        add(applicationsListView);

    }

    private LoadableDetachableModel<List<Applications>> createModelForLocations() {

        return new LoadableDetachableModel<List<Applications>>() {
            @Override
            protected List<Applications> load() {
               
                return getApplications();
            }
        };
    }

    /**
     * @return the applications
     */
    public List<Applications> getApplications() {
        if (applications == null) {
            applications = service.getAllApplications();
        }
        return applications;
    }

    private final class ApplicationsChoiceRenderer extends ChoiceRenderer<Applications> {

        /**
         * Constructor.
         */
        public ApplicationsChoiceRenderer() {
        }

        /**
         * @see
         * org.apache.wicket.markup.html.form.IChoiceRenderer#getDisplayValue(Object)
         */
        @Override
        public Object getDisplayValue(Applications app) {
            return app.getApplicationName();
        }
    }

    /**
     * Dropdown with Applications.
     */
    private final class ApplicationsDropDownChoice extends DropDownChoice<Applications> {

        /**
         * Construct.
         *
         * @param id component id
         */
        public ApplicationsDropDownChoice(String id) {
            super(id, getApplications(), new ApplicationsChoiceRenderer());

           
            setModel(new PropertyModel<Applications>(GuiceRepeaterOne.this, "applications"));
        }

        /**
         * @see
         * org.apache.wicket.markup.html.form.DropDownChoice#onSelectionChanged(java.lang.Object)
         */
        @Override
        public void onSelectionChanged(Applications newSelection) {
        }

        /**
         * @see
         * org.apache.wicket.markup.html.form.DropDownChoice#wantOnSelectionChangedNotifications()
         */
        @Override
        protected boolean wantOnSelectionChangedNotifications() {
            // we want roundtrips when a the user selects another item
            return false;
        }
    }
}
