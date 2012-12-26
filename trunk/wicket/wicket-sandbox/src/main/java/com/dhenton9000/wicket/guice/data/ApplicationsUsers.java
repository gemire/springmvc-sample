/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.guice.data;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.wicket.TemplatePage;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.PropertyPopulator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
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
    private Component dropDownApplicationListItem = null;
    private Applications selectedApplication;
    private String titleStart = this.getClass().getSimpleName();
    private WebMarkupContainer userTable;
    private UsersForApplications userDataProvider;
    private List<Users> selectedUsers = null;

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
        getApplications();
        dropDownApplicationListItem =
                new ApplicationsDropDownChoice("applicationsSelect").add(new AjaxFormComponentUpdatingBehavior("change") {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {

                target.add(userTable);
            }
        });

        add(dropDownApplicationListItem);
        addUsersModule();


    }

    /**
     * @return the applications
     */
    public List<Applications> getApplications() {
        if (applications == null) {
            applications = service.getAllApplications();
            if (applications.size() > 0) {
                
                setSelectedApplication(applications.get(0));
                selectedUsers = service.findUsersForApplications(selectedApplication);
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
     * @return the selectedUsers
     */
    public List<Users> getSelectedUsers() {
        if (selectedUsers == null)
        {
            selectedUsers = service.findUsersForApplications(selectedApplication);
        }
        return selectedUsers;
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

        
    }

    private final class ApplicationsChoiceRenderer extends ChoiceRenderer<Applications> {

        /**
         * Constructor.
         */
        public ApplicationsChoiceRenderer() {
        }

        @Override
        public String getIdValue(Applications a, int b) {
            return a.getId() + "";
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

    //// user stuff //////////////////////////////////////////////////////
    private void addUsersModule() {
        userTable = new WebMarkupContainer("userTable");
        
        //setMarkup to allow for refresh
        add(userTable.setOutputMarkupId(true));

        List<ICellPopulator<Users>> columns = new ArrayList<ICellPopulator<Users>>();

        columns.add(new PropertyPopulator<Users>("userid"));
        columns.add(new PropertyPopulator<Users>("username"));
        userDataProvider = new UsersForApplications();
        userTable.add(new DataGridView<Users>("users", columns, userDataProvider));

    }

    private class UsersForApplications implements IDataProvider<Users> {

        public UsersForApplications() {
        }

        @Override
        public Iterator iterator(long first, long count) {
            return getSelectedUsers().iterator();
        }

        @Override
        public long size() {
            return getSelectedUsers().size();
        }

        @Override
        public IModel model(final Users object) {
            return new LoadableDetachableModel<Users>() {
                @Override
                protected Users load() {
                    return object;
                }
            };
        }

        @Override
        public void detach() {
            selectedUsers = null;
        }
    }
}
