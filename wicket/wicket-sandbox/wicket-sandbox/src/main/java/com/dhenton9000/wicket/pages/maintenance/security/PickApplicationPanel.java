/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.security;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.wicket.dao.service.IApplicationsService;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author dhenton
 */
public final class PickApplicationPanel extends Panel {

   
    protected SortableApplicationsDataProvider applicationsDataProvider;
    protected AjaxFallbackDefaultDataTable<Applications, String> ajaxFallbackDefaultDataTable;
    private Applications selectedApplication;
    private IApplicationsService service;
    
    public PickApplicationPanel(String id) {
        super(id);
        setup();
    }

    private void setup() {
         
        
        
               List<IColumn<Applications, String>> columns = new ArrayList<IColumn<Applications, String>>();

        columns.add(new AbstractColumn<Applications, String>(new Model<String>("Actions")) {
            @Override
            public void populateItem(Item<ICellPopulator<Applications>> cellItem, String componentId,
                    IModel<Applications> model) {
                cellItem.add(new ActionPanel(componentId, model));
            }
        });
        applicationsDataProvider = new SortableApplicationsDataProvider(getApplicationsService());

        columns.add(new PropertyColumn<Applications, String>(new Model<String>("ID"), "id", "id"));
        columns.add(new PropertyColumn<Applications, String>(new Model<String>("App Name"), "applicationName",
                "applicationName"));
        ajaxFallbackDefaultDataTable = new AjaxFallbackDefaultDataTable<Applications, String>("applicationsTable", columns,
                applicationsDataProvider, 10);
        ajaxFallbackDefaultDataTable.setOutputMarkupId(true);

    }

    /**
     * @return the selectedApplications
     */
    public Applications getSelectedApplication() {
        return selectedApplication;
    }
 public void setSelectedApplication(Applications r) {
          selectedApplication = r;
    }
    /**
     * @return the service
     */
    public IApplicationsService getApplicationsService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(IApplicationsService service) {
        this.service = service;
    }
    
    private class ActionPanel extends Panel {

        ////////////////////////////////////////////////////////
        public ActionPanel(String id, IModel<Applications> model) {
            super(id, model);
            final Applications r = (Applications) this.getDefaultModelObject();
            Link select = new Link("select") {
                @Override
                public void onClick() {
                    getContainingPage().performStateOperation(MaintainApplicationsTwo.STATE.EDIT);
                    setSelectedApplication(r);
                }
            };
            ActionPanel.this.add(select);
            select.add(new Label("linkText", new Model(r.getApplicationName())));

        }
    }
    
       public MaintainApplicationsTwo getContainingPage() {
        return (MaintainApplicationsTwo) getParent();
    }
}
