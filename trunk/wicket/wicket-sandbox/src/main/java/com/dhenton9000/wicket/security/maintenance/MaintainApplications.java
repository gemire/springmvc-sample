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
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
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
    private List<Groups> allGroups = new ArrayList<Groups>();
    private List<Groups> selectedGroups = new ArrayList<Groups>();
    private EditForm editForm;

    private enum STATE {

        INITIAL, ADD, EDIT, DELETE
    };
    private final Logger logger = LoggerFactory.getLogger(MaintainApplications.class);
    private STATE currentState = STATE.INITIAL;
    /**
     * this doesn't need a detach as it was loaded from the ajax table which
     * already has a detachable model
     */
    private Applications selectedApplication = new Applications();

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
        
        editForm = new EditForm("editForm", new PropertyModel(MaintainApplications.this,"selectedApplication"));
        
        editGroup.add(editForm);
        editGroup.add(new FeedbackPanel("feedback"));
        add(editGroup);
        /////// add a container for the add button
        AddButtonForm addButtonForm = new AddButtonForm("addButtonForm");
        final WebMarkupContainer addGroup = new AppAddGroup("addGroup");
        addGroup.add(addButtonForm);
        add(addGroup);

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

        return info + " [" + currentState.toString() + "]";
    }

    /**
     * @return the applicationsService
     */
    public IApplicationsDao getApplicationsService() {
        return applicationsService;
    }

    /**
     * reset the various state items based on the submitted state
     * @param newState 
     */
    public void resetSelectedApplication(STATE newState) {
        logger.debug("reset called with state "+newState.toString());
        currentState = newState;
        switch (newState) {
            case ADD:
            case INITIAL:
                selectedApplication = new Applications();
                selectedGroups = new ArrayList<Groups>();
                
                break;
            default:
                break;
          }
         String info = "After reset app is now "+selectedApplication.getApplicationName()
                            + " with group size of "+selectedGroups.size();
                    logger.debug("action panel on click\n"+info+"\n");
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
        if (allGroups.isEmpty()) {
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
            boolean visible = false;


            switch (currentState) {
                case INITIAL:
                    visible = false;
                    break;
                default:
                    visible = true;
            }


            return visible;
        }
    }

    class AppAddGroup extends WebMarkupContainer {

        public AppAddGroup(String id) {
            super(id);

        }

        public AppAddGroup(String id, IModel<Applications> model) {
            super(id, model);


        }

        @Override
        public boolean isVisible() {
            boolean visible = true;


            switch (currentState) {
                case INITIAL:
                    visible = true;
                    break;
                default:
                    visible = false;
            }


            return visible;
        }
    }

    class EditForm extends Form<Applications> {

        public EditForm(String id) {
            super(id);
            setup();
        }

        // info("Cancel was pressed!");
        public String getCurrentStateLabel() {
            String label = "Edit Application";
            switch (currentState) {
                case INITIAL:
                    break;
                case ADD:
                    label = "Add Application";
                default:

            }
            return label;
        }

        public EditForm(String id, IModel<Applications> model) {
            super(id, model);
            setup();
        }

        private void setup() {
            final TextField<String> tApplicationName = new TextField<String>("applicationName",
                    new PropertyModel<String>(this.getModel(), "applicationName"));

            final Label tId = new Label("applicationId",
                    new PropertyModel<String>(this.getModel(), "id"));
            
             final Label tDes = new Label("actionDescription",
                    new PropertyModel<String>(this, "currentStateLabel"));

            GroupsDropDownChoice groupsChoice;
            groupsChoice = new GroupsDropDownChoice("applicationGroups");
            add(tApplicationName);
            add(tId);
            add(tDes);
            add(groupsChoice);
            // this is the default save submission button with 
            add(new Button("saveEditButton", new PropertyModel<String>(this,
                    "currentStateLabel")));

            Button cancel = new Button("cancelEditButton") {
                public void onSubmit() {

                    resetSelectedApplication(STATE.INITIAL);
                }
            };
            cancel.setDefaultFormProcessing(true);
            add(cancel);

        }

        @Override
        protected void onSubmit() {
            Set newGroups = new HashSet(selectedGroups);
            selectedApplication.setGroupsSet(newGroups);
            getApplicationsService().merge(selectedApplication);

        }
    }

    class GroupsDropDownChoice extends ListMultipleChoice<Groups> {

        // there needs to be a model that represents the selections
        // and a model that represents the choices for which the
        // selections are a subset
        public GroupsDropDownChoice(String id) {
            super(id, new PropertyModel(MaintainApplications.this, "selectedGroups"),
                    new PropertyModel(MaintainApplications.this,
                    "allGroups"), new GroupsDropDownRenderer());



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
         * @param model model for selected application
         */
        public ActionPanel(String id, IModel<Applications> model) {
            super(id, model);
            add(new Link("select") {
                @Override
                public void onClick() {
                    selectedApplication =
                            (Applications) getParent().getDefaultModelObject();
                    //logger.debug(selectedApplication.getGroupsSet() + "");
                    selectedGroups = new ArrayList(selectedApplication.getGroupsSet());
                    String info = "The selected app is now "+selectedApplication.getApplicationName()
                            + " with group size of "+selectedGroups.size();
                    logger.debug("action panel on click\n"+info+"\n");
                    resetSelectedApplication(STATE.EDIT);
                    
                }
            });
        }
    }

    class AddButtonForm extends Form<Applications> {

        public AddButtonForm(String id) {
            super(id);


        }

        public AddButtonForm(String id, IModel<Applications> model) {
            super(id, model);


        }

       

        @Override
        protected void onSubmit() {
            resetSelectedApplication(STATE.ADD);

        }
    }
}


/*
 * 
 form.add(new AjaxButton("ajax-button", new PropertyModel<String>(this,
            "counter", form)) {

        @Override
        protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
            counter++;
            target.addComponent(this);

        }
    });
 * 
 */