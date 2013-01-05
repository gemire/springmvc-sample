/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.guice.repeater;

 
import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.pages.panels.ActionPanel;
import java.util.Iterator;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class FormInputWithList extends TemplatePage {
    private final Logger logger = LoggerFactory.getLogger(FormInputWithList.class);
    private Form<Restaurant> form;
    
    public FormInputWithList() {
        super();
        setup();
    }
    
    public FormInputWithList(PageParameters params) {
        setup();
    }

    private void setup() {
        setPageTitle(getClass().getSimpleName());
        add(new FeedbackPanel("feedback"));
        form = new Form<Restaurant>("form");
        
    }
    
    
    
    
    
    
    
    //////////////////////////////
    class WineFormView extends RefreshingView<Restaurant>
    {

        public WineFormView(String id) {
            super(id);
        }

        public WineFormView(String id, IModel<?> model) {
            super(id, model);
        }

        @Override
        protected Iterator<IModel<Restaurant>> getItemModels() {
             return null;
        }

        @Override
        protected void populateItem(Item<Restaurant> item) {
             
            
            IModel<Restaurant> wine = item.getModel();
				item.add(new ActionPanel("actions", wine));
				item.add(new TextField<Long>("id"));
				item.add(new TextField<String>("firstName"));
				item.add(new TextField<String>("lastName"));
				item.add(new TextField<String>("homePhone"));
				item.add(new TextField<String>("cellPhone"));
            
            
        }
        
    }
    
}
