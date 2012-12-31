/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.security.maintenance;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.wicket.TemplatePage;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.dhenton9000.wicket.dao.IGroupsDao;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class MaintainApplications extends TemplatePage {

    @Inject
    private IApplicationsDao applicationsService;
    @Inject
    private IGroupsDao groupsService;
    private final Logger logger = LoggerFactory.getLogger(MaintainApplications.class);
    private List<Groups> allGroups = new ArrayList<Groups>();
    private List<Groups> selectedGroups = new ArrayList<Groups>();
      /**
     * this doesn't need a detach as it was loaded from the ajax table which
     * already has a detachable model
     */
    private Applications selectedApplication = new Applications();
    private IModel selectedGroupsModel =  new SelectedGroupsModel(selectedApplication,"groupsSet");

    public MaintainApplications() {
        super();
        this.setPageTitle(this.getClass().getSimpleName());
        setup();

    }

    public MaintainApplications(PageParameters params) {
        setup();

    }

    private void setup() {



        Label selectedAppIdLabel = new Label("selectedAppId", new PropertyModel(this, "displaySelectedAppId"));
        add(selectedAppIdLabel);
        List<IColumn<Applications, String>> columns = new ArrayList<IColumn<Applications, String>>();

        columns.add(new AbstractColumn<Applications, String>(new Model<String>("Actions")) {
            @Override
            public void populateItem(Item<ICellPopulator<Applications>> cellItem, String componentId,
                    IModel<Applications> model) {
                cellItem.add(new ActionPanel(componentId, model));
            }
        });

        columns.add(new PropertyColumn<Applications, String>(new Model<String>("ID"), "id", "id"));
        columns.add(new PropertyColumn<Applications, String>(new Model<String>("App Name"), "applicationName",
                "applicationName"));
        final AjaxFallbackDefaultDataTable<Applications, String> ajaxFallbackDefaultDataTable =
                new AjaxFallbackDefaultDataTable<Applications, String>("applicationsTable", columns,
                new SortableApplicationsDataProvider(getApplicationsService()), 10);
        ajaxFallbackDefaultDataTable.setOutputMarkupId(true);
        add(ajaxFallbackDefaultDataTable);

        //////// add a container to contain the editing system.
        final WebMarkupContainer editGroup = new AppEditGroup("editGroup");
        EditForm editForm = new EditForm("editForm");

        editGroup.add(editForm);
        editGroup.add(new FeedbackPanel("feedback"));
        add(editGroup);


    }

    /**
     * @return the displaySelectedAppId
     */
    public String getDisplaySelectedAppId() {
        String info = "selected : ";
        if (selectedApplication.getId() == null) {
            info += "";
        } else {
            info += selectedApplication.getApplicationName() + " ("
                    + selectedApplication.getPrimaryKey() + ")";
        }

        return info;
    }

    /**
     * @return the applicationsService
     */
    public IApplicationsDao getApplicationsService() {
        return applicationsService;
    }

    /**
     * @return the groupsService
     */
    public IGroupsDao getGroupsService() {
        return groupsService;
    }

    /**
     * @return the allGroups
     */
    public List<Groups> getAllGroups() {
        if (allGroups.isEmpty())
        {
            allGroups = getGroupsService().getAllGroups();
        }
        return allGroups;
    }

    
   

    class AppEditGroup extends WebMarkupContainer {

        public AppEditGroup(String id) {
            super(id);

        }

        public AppEditGroup(String id, IModel<Applications> model) {
            super(id, model);


        }

        @Override
        public boolean isVisible() {

            if (selectedApplication != null
                    && selectedApplication.getId() != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    class EditForm extends Form<Applications> {

        public EditForm(String id) {
            super(id);
            setup();
        }

        public EditForm(String id, IModel<Applications> model) {
            super(id, model);
            setup();
        }

        private void setup() {
            final TextField<String> tApplicationName = new TextField<String>("applicationName",
                    new PropertyModel<String>(MaintainApplications.this, "selectedApplication.applicationName"));

            final Label tId = new Label("applicationId",
                    new PropertyModel<String>(MaintainApplications.this, "selectedApplication.id"));

            GroupsDropDownChoice groupsChoice;
            groupsChoice = new GroupsDropDownChoice("applicationGroups");
            add(tApplicationName);
            add(tId);
            add(groupsChoice);

        }

        @Override
        protected void onSubmit() {

              getApplicationsService().merge(selectedApplication);

        }
    }
 

    class SelectedGroupsModel extends PropertyModel
    {

        public SelectedGroupsModel(Object modelObject, String expression) {
            super(modelObject, expression);
        }
        @Override
        public Object getObject() {
           
            logger.debug("111111 selectedGroups " );
            if (super.getObject() != null) {
                 Set s =(Set) super.getObject();
                logger.debug("111111 selectedGroups ");
                return new ArrayList(s);
                
            }
            return new ArrayList();
        }
    }
    
    class GroupsDropDownChoice extends ListMultipleChoice<Groups> {

        // there needs to be a model that represents the selections
        // and a model that represents the choices for which the
        // selections are a subset
        
        public GroupsDropDownChoice(String id) {
            super(id,  new PropertyModel(MaintainApplications.this,"selectedGroups"),
            new PropertyModel(MaintainApplications.this, 
            "allGroups"), new GroupsDropDownRenderer());
            //  super(id, getApplications(), new ApplicationsUsers.ApplicationsChoiceRenderer());
            // setChoices(getApplications());
            // setModel(new PropertyModel<Applications>(ApplicationsUsers.this, "selectedApplication"));



        }
    }

    class GroupsDropDownRenderer extends ChoiceRenderer<Groups> {

        public GroupsDropDownRenderer() {
        }

        @Override
        public Object getDisplayValue(Groups object) {
            return object.getGroupName();
        }

        @Override
        public String getIdValue(Groups object, int index) {
            return object.getId().toString();
        }
    }

    class ActionPanel extends Panel {

        /**
         * @param id component id
         * @param model model for contact
         */
        public ActionPanel(String id, IModel<Applications> model) {
            super(id, model);
            add(new Link("select") {
                @Override
                public void onClick() {
                    selectedApplication =
                            (Applications) getParent().getDefaultModelObject();
                    logger.debug(selectedApplication.getGroupsSet()+"");
                    selectedGroups = new ArrayList(selectedApplication.getGroupsSet());

                }
            });
        }
    }
}
