/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.security.maintenance;

 
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.TemplatePage;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dhenton
 */
public final class MaintainApplications extends TemplatePage {

    @Inject
    private IApplicationsDao applicationsService;
    
    
    public MaintainApplications() {
        super();
        this.setPageTitle(this.getClass().getSimpleName());
        setup();  
        
    }
    
    public MaintainApplications(PageParameters params) {
		setup();       
        
    }

    private void setup() {
        List<IColumn<Applications, String>> columns = new ArrayList<IColumn<Applications, String>>();
//'wicket_child6:wicket_extend7
//		columns.add(new AbstractColumn<Applications, String>(new Model<String>("Actions"))
//		{
//			@Override
//			public void populateItem(Item<ICellPopulator<Applications>> cellItem, String componentId,
//				IModel<Applications> model)
//			{
//				cellItem.add(new ActionPanel(componentId, model));
//			}
//		});

                columns.add(new PropertyColumn<Applications, String>(new Model<String>("ID"), "id"));
                columns.add(new PropertyColumn<Applications, String>(new Model<String>("App Name"), "applicationName",
                        "applicationName"));
                add(new AjaxFallbackDefaultDataTable<Applications, String>("applicationsTable", columns,
                        new SortableApplicationsDataProvider(applicationsService), 8));
         
    }
}
