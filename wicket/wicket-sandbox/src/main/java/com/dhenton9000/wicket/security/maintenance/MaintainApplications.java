/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.security.maintenance;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.TemplatePage;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.dhenton9000.wicket.pages.form.sample.SuccessPage;
import com.dhenton9000.wicket.security.SandboxSession;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Fragment;
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
    
    private   final Logger logger =   LoggerFactory.getLogger(MaintainApplications.class);
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

        columns.add(new PropertyColumn<Applications, String>(new Model<String>("ID"), "id"));
        columns.add(new PropertyColumn<Applications, String>(new Model<String>("App Name"), "applicationName",
                "applicationName"));
        final AjaxFallbackDefaultDataTable<Applications, String> ajaxFallbackDefaultDataTable =
                new AjaxFallbackDefaultDataTable<Applications, String>("applicationsTable", columns,
                new SortableApplicationsDataProvider(applicationsService), 10);
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
                    new PropertyModel<String>(selectedApplication, "applicationName"));

            final Label tId = new Label("applicationId",
                    new PropertyModel<String>(selectedApplication, "id"));

            add(tApplicationName);
            add(tId);

        }

        /*
         AjaxButton lSearchButton = new AjaxButton("searchButton") {
         private static final long serialVersionUID = 1L;

         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
         SubscriberFilter filter = new SubscriberFilter();
         target.add(table);
         if (!(tn.getValue() == null) && !tn.getValue().isEmpty()) {
         filter.setTn(tn.getValue());
         }
         // giving the new filter to the dataProvider
         subscriberDataProvider.setFilterState(filter);
         }

         @Override
         protected void onError(AjaxRequestTarget target, Form<?> form) {
         // TODO Implement onError(..)
         throw new UnsupportedOperationException("Not yet implemented.");
         }

         };
         lSearchButton.setOutputMarkupId(true);
         this.setDefaultButton(lSearchButton);
         add(lSearchButton);
        
        
         */
        @Override
        protected void onSubmit() {
           
             
            applicationsService.merge(selectedApplication);
           
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
                    Applications selected =
                            (Applications) getParent().getDefaultModelObject();

                    //selectedApplicationId = selected.getId();
                    selectedApplication.setApplicationName(selected.getApplicationName());
                    selectedApplication.setId(selected.getId());

                }
            });
        }
    }
}
