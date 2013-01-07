/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.restaurant.maintenance;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;
import java.util.Iterator;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy;
import org.apache.wicket.markup.repeater.util.ModelIteratorAdapter;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author dhenton
 */
public final class PickRestaurantPanel extends Panel {

    private Form<Restaurant> pickRestaurantForm;
    private IRestaurantDao service;
    private Restaurant selectedRestaurant = null;

    /**
     * The model is a Restaurant object
     */
    public PickRestaurantPanel(String id, IModel model,IRestaurantDao service) {
        super(id,model);
        this.service = service;
        pickRestaurantForm = new Form<Restaurant>("pickRestaurantForm");
        add(pickRestaurantForm);
        pickRestaurantForm.add(new FeedbackPanel("feedbackForPickRestaurant"));
        RefreshingView<Restaurant> refreshingView = new PickRestaurantFormView("pickRestaurantFormView");
        refreshingView.setItemReuseStrategy(ReuseIfModelsEqualStrategy.getInstance());
        pickRestaurantForm.add(refreshingView);


    }

    /**
     * @return the selectedRestaurant
     */
    public Restaurant getSelectedRestaurant() {
        return selectedRestaurant;
    }

    /**
     * @param selectedRestaurant the selectedRestaurant to set
     */
    public void setSelectedRestaurant(Restaurant selectedRestaurant) {
        this.selectedRestaurant = selectedRestaurant;
        this.setDefaultModelObject(selectedRestaurant);
    }

    //////////////////////////////
    class PickRestaurantFormView extends RefreshingView<Restaurant> {

        public PickRestaurantFormView(String id) {
            super(id);
        }

        public PickRestaurantFormView(String id, IModel<?> model) {
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
            item.add(new PickActionPanel("pickAction", restaurant));

        }
    }

    ////////////////////////////////
    private class PickActionPanel extends Panel {

        ////////////////////////////////////////////////////////
        public PickActionPanel(String id, IModel<Restaurant> model) {
            super(id, model);
            final Restaurant r = (Restaurant) this.getDefaultModelObject();
            Link select = new Link("select") {
                @Override
                public void onClick() {
                    setSelectedRestaurant(r);
                }
            };
            PickActionPanel.this.add(select);
            select.add(new Label("linkText", new Model(r.getName())));

        }
    }
}
