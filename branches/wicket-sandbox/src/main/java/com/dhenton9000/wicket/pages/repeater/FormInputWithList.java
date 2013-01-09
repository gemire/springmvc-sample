/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.repeater;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;
import com.dhenton9000.wicket.pages.TemplatePage;
import java.util.Iterator;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy;
import org.apache.wicket.markup.repeater.util.ModelIteratorAdapter;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class FormInputWithList extends TemplatePage {

    private final Logger logger = LoggerFactory.getLogger(FormInputWithList.class);
    private Form<Restaurant> form;
  
    @SpringBean
    private IRestaurantDao service;

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
        add(form);

        RefreshingView<Restaurant> refreshingView = new RestaurantFormView("restaurantFormView");
        refreshingView.setItemReuseStrategy(ReuseIfModelsEqualStrategy.getInstance());
        form.add(new Label("sampleHeaderFromBundle", new StringResourceModel("sample.Header", this, null)));
        form.add(refreshingView);

    }

    /**
     * @return the service
     */
    public IRestaurantDao getService() {
        return service;
    }

    //////////////////////////////
    class RestaurantFormView extends RefreshingView<Restaurant> {

        public RestaurantFormView(String id) {
            super(id);
        }

        public RestaurantFormView(String id, IModel<?> model) {
            super(id, model);
        }

        @Override
        protected Iterator<IModel<Restaurant>> getItemModels() {
            Iterator<Restaurant> rIter =
                    service.getAllRestaurants().iterator();


            return new ModelIteratorAdapter<Restaurant>(rIter) {
                @Override
                protected IModel<Restaurant> model(Restaurant object) {
                    return new CompoundPropertyModel<Restaurant>(
                            new RestaurantReloadableEntityModel(object));
                }
            };



        }

        @Override
        protected void populateItem(Item<Restaurant> item) {


            IModel<Restaurant> restaurant = item.getModel();
            item.add(new Label("id"));
            item.add(new TextField<String>("name"));
            item.add(new TextField<String>("city"));
            item.add(new TextField<String>("state"));
            item.add(new TextField<String>("zipCode"));


        }
    }
}
