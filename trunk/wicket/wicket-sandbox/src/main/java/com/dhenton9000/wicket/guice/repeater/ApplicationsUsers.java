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
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dhenton
 */
public final class ApplicationsUsers extends TemplatePage {

    @Inject
    private IApplicationsDao service;
    private List<Applications> applications;
    private ApplicationsDropDownChoice dropDownApplicationListItem = null;
    private Applications selectedApplication;
    private String titleStart = this.getClass().getSimpleName();

    public ApplicationsUsers() {
        super();
        setup(new PageParameters());
    }

    public ApplicationsUsers(PageParameters params) {
        super();

        setup(params);


    }

    private void setup(PageParameters params) {
        setPageTitle(titleStart);
        dropDownApplicationListItem =
                new ApplicationsUsers.ApplicationsDropDownChoice("applicationsSelect");

        add(dropDownApplicationListItem);
    }

    /**
     * @return the applications
     */
    public List<Applications> getApplications() {
        if (applications == null) {
            applications = service.getAllApplications();
            if (applications.size() > 0) {
                setSelectedApplication(applications.get(0));
            }
        }
        return applications;
    }

    /**
     * @return the selectedApplication
     */
    public Applications getSelectedApplication() {
        return selectedApplication;
    }

    /**
     * @param selectedApplication the selectedApplication to set
     */
    public void setSelectedApplication(Applications selectedApplication) {
        this.selectedApplication = selectedApplication;
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
            super(id, getApplications(), new ApplicationsUsers.ApplicationsChoiceRenderer());
            setChoices(getApplications());
            setModel(new PropertyModel<Applications>(ApplicationsUsers.this, "selectedApplication"));
 

        }

        /**
         * @see
         * org.apache.wicket.markup.html.form.DropDownChoice#onSelectionChanged(java.lang.Object)
         */
        @Override
        public void onSelectionChanged(Applications newSelection) {
            setPageTitle(titleStart+"--"+getSelectedApplication().getId());
            this.setResponsePage(ApplicationsUsers.this);
           // setModel(new PropertyModel<Applications>(ApplicationsUsers.this, "applications"));

        }

        /**
         * @see
         * org.apache.wicket.markup.html.form.DropDownChoice#wantOnSelectionChangedNotifications()
         */
        @Override
        protected boolean wantOnSelectionChangedNotifications() {
            // we want roundtrips when a the user selects another dropDownApplicationListItem
            return true;
        }
    }

    private final class ApplicationsChoiceRenderer extends ChoiceRenderer<Applications> {

        /**
         * Constructor.
         */
        public ApplicationsChoiceRenderer() {
        }

        @Override
        public String getIdValue(Applications a,int b)
        {
            return a.getId()+"";
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
}
