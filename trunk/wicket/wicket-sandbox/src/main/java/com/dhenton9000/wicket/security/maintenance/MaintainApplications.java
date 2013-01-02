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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
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
    private EditForm editForm;
    private List<Groups> allGroups = new ArrayList<Groups>();
    private List<Groups> selectedGroups = new ArrayList<Groups>();
    //   private EditForm editForm;
    protected SortableApplicationsDataProvider applicationsDataProvider;
    protected AjaxFallbackDefaultDataTable<Applications, String> ajaxFallbackDefaultDataTable;
    private WebMarkupContainer mainRefreshGroup;

    /**
     * @return the groupsService
     */
    public IGroupsDao getGroupsService() {
        return groupsService;
    }

    private enum STATE {

        INITIAL, ADD, EDIT, DELETE
    };

    /**
     * @return the applicationsService
     */
    public IApplicationsDao getApplicationsService() {
        return applicationsService;
    }
    private final Logger logger = LoggerFactory.getLogger(MaintainApplications.class);
    private STATE currentState = STATE.INITIAL;
    /**
     * this doesn't need a detach as it was loaded from the ajax table which
     * already has a detachable model
     */
    private Applications selectedApplication = new Applications();

    public MaintainApplications() {
        super();
        setup();

    }

    public MaintainApplications(PageParameters params) {
        setup();

    }

    private void setup() {

        this.setPageTitle(this.getClass().getSimpleName());
        mainRefreshGroup = new WebMarkupContainer("mainRefreshGroup");
        mainRefreshGroup.setOutputMarkupId(true);


        Label selectedAppIdLabel = new Label("selectedAppId", new PropertyModel(this, "displaySelectedAppId"));
        mainRefreshGroup.add(selectedAppIdLabel);


        //do the edit form
        editForm = new EditForm("editForm", new PropertyModel(MaintainApplications.this, "selectedApplication"));

        mainRefreshGroup.add(editForm);
        mainRefreshGroup.add(new FeedbackPanel("feedback"));




        // do the data table 
        List<IColumn<Applications, String>> columns = new ArrayList<IColumn<Applications, String>>();

        columns.add(new AbstractColumn<Applications, String>(new Model<String>("Actions")) {
            @Override
            public void populateItem(Item<ICellPopulator<Applications>> cellItem, String componentId,
                    IModel<Applications> model) {
                cellItem.add(new MaintainApplications.ActionPanel(componentId, model));
            }
        });
        applicationsDataProvider = new SortableApplicationsDataProvider(getApplicationsService());

        columns.add(new PropertyColumn<Applications, String>(new Model<String>("ID"), "id", "id"));
        columns.add(new PropertyColumn<Applications, String>(new Model<String>("App Name"), "applicationName",
                "applicationName"));
        ajaxFallbackDefaultDataTable = new AjaxFallbackDefaultDataTable<Applications, String>("applicationsTable", columns,
                applicationsDataProvider, 10);
        ajaxFallbackDefaultDataTable.setOutputMarkupId(true);
        mainRefreshGroup.add(ajaxFallbackDefaultDataTable);

        add(mainRefreshGroup);
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

    public void resetSelectedApplication(STATE newState) {
        logger.debug("reset called with state " + newState.toString());
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
        String info = "After reset app is now " + selectedApplication.getApplicationName()
                + " with group size of " + selectedGroups.size();
        logger.debug("action panel on click\n" + info + "\n");
    }

    //////////////////////////////////////
    class ActionPanel extends Panel {

        /**
         * @param id component id
         * @param model model for selected application
         */
        public ActionPanel(String id, IModel<Applications> model) {
            super(id, model);
            setOutputMarkupId(true);
            AjaxLink select =
                    new AjaxLink("select") {
                        @Override
                        public void onClick(AjaxRequestTarget target) {
                            selectedApplication =
                                    (Applications) getParent().getDefaultModelObject();
                            //logger.debug(selectedApplication.getGroupsSet() + "");
                            selectedGroups = new ArrayList(selectedApplication.getGroupsSet());
                            String info = "The selected app is now " + selectedApplication.getApplicationName()
                                    + " with group size of " + selectedGroups.size();
                            logger.debug("action panel on click\n" + info + "\n");
                            resetSelectedApplication(STATE.EDIT);
                            target.add(mainRefreshGroup);
                            target.add(editForm);

                        }
                    };
            select.setOutputMarkupId(true);
            AjaxLink delete =
                    new AjaxLink("delete") {
                        @Override
                        public void onClick(AjaxRequestTarget target) {
                            selectedApplication =
                                    (Applications) getParent().getDefaultModelObject();
                            logger.debug("delete requested " + selectedApplication.getApplicationName());
                            try {
                                Integer k = selectedApplication.getId();
                                Applications n = new Applications();
                                n.setPrimaryKey(k);
                                //selectedApplication = null;
                                //selectedGroups = null;
                                resetSelectedApplication(STATE.INITIAL);
                                getApplicationsService().delete(n);
                                ajaxFallbackDefaultDataTable.modelChanged();
                                target.add(ajaxFallbackDefaultDataTable);
                                target.add(mainRefreshGroup);


                            } catch (Exception err) {
                                logger.error("ERROR in delete " + err.getClass().getName() + err.getMessage());
                            }
                        }

                        @Override
                        public boolean isVisible() {
                            boolean visible = false;


                            switch (currentState) {
                                case INITIAL:
                                    visible = true;
                                    break;
                                default:
                                    visible = false;
                            }


                            return visible;
                        }
                    };

            delete.add(new AttributeModifier("onclick", model) {
                @Override
                protected String newValue(final String currentValue, final String replacementValue) {
                    return "return confirm('Remove Application?')";
                }
            });
            delete.setOutputMarkupId(true);
            add(select);
            add(delete);


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
    //////////////////////////////////////

    class EditForm extends Form<Applications> {

        public EditForm(String id) {
            super(id);
            setup();
        }

        @Override
        public boolean isVisible() {
            boolean visible = false;


            switch (currentState) {
                case EDIT:
                case ADD:
                    visible = true;
                    break;
                default:
                    visible = false;
            }


            return visible;
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
            this.setOutputMarkupId(true);
            final TextField<String> tApplicationName = new TextField<String>("applicationName",
                    new PropertyModel<String>(this.getModel(), "applicationName"));

            final Label tId = new Label("applicationId",
                    new PropertyModel<String>(this.getModel(), "id"));

            final Label tDes = new Label("actionDescription",
                    new PropertyModel<String>(this, "currentStateLabel"));

            MaintainApplications.GroupsDropDownChoice groupsChoice;
            groupsChoice = new MaintainApplications.GroupsDropDownChoice("applicationGroups");
            tApplicationName.setOutputMarkupId(true);
            tId.setOutputMarkupId(true);
            tDes.setOutputMarkupId(true);
            groupsChoice.setOutputMarkupId(true);
            add(tApplicationName);
            add(tId);
            add(tDes);
            add(groupsChoice);



            AjaxButton saveEditButton = new AjaxButton("saveEditButton", new PropertyModel<String>(this,
                    "currentStateLabel"), this) {
                @Override
                protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                    super.onSubmit(target, form);
                    target.add(mainRefreshGroup);
                    target.add(ajaxFallbackDefaultDataTable);


                }
            };
            // this is the default save submission button with 
            add(saveEditButton);

            AjaxButton cancelButton = new AjaxButton("cancelEditButton", new Model("Cancel"), this) {
                @Override
                protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                    resetSelectedApplication(STATE.INITIAL);
                    target.add(mainRefreshGroup);
                    target.add(ajaxFallbackDefaultDataTable);
                    target.add(editForm);

                }
            };
            saveEditButton.setOutputMarkupId(true);
            cancelButton.setOutputMarkupId(true);
            cancelButton.setDefaultFormProcessing(true);
            add(cancelButton);
        }

        @Override
        protected void onSubmit() {
            Set newGroups = new HashSet(selectedGroups);
            selectedApplication.setGroupsSet(newGroups);
            switch (currentState) {
                case EDIT:
                    getApplicationsService().merge(selectedApplication);
                    break;
                case ADD:
                    getApplicationsService().save(selectedApplication);
                    break;
                default:
                    break;

            }
            resetSelectedApplication(STATE.INITIAL);
        }
    }

    class GroupsDropDownChoice extends ListMultipleChoice<Groups> {

        // there needs to be a model that represents the selections
        // and a model that represents the choices for which the
        // selections are a subset
        public GroupsDropDownChoice(String id) {
            super(id, new PropertyModel(MaintainApplications.this, "selectedGroups"),
                    new PropertyModel(MaintainApplications.this,
                    "allGroups"), new MaintainApplications.GroupsDropDownRenderer());



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
}