/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant.two;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;
import com.dhenton9000.wicket.pages.events.SimpleEventPage;
import java.util.Iterator;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy;
import org.apache.wicket.markup.repeater.util.ModelIteratorAdapter;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class SelectRestaurantPanel extends Panel {

    private Form<Restaurant> pickRestaurantForm;
    private IRestaurantService service;
    private final Logger logger = LoggerFactory.getLogger(SelectRestaurantPanel.class);
    //   private IModel pickRestaurantPanelModel = null;

    /**
     * The model is a Restaurant object
     */
    public SelectRestaurantPanel(String id, IRestaurantService service) {
        super(id);
        this.service = service;
        //     this.pickRestaurantPanelModel = model;
        // logger.debug("pick restaurant panel "+model.getObject().toString());

        pickRestaurantForm = new Form<Restaurant>("pickRestaurantForm");
        add(pickRestaurantForm);

        RefreshingView<Restaurant> refreshingView = new SelectRestaurantPanel.PickRestaurantFormView("pickRestaurantFormView");
        refreshingView.setItemReuseStrategy(ReuseIfModelsEqualStrategy.getInstance());
        pickRestaurantForm.add(refreshingView);



    }

    /**
     * @return the pickRestaurantPanelModel
     */
//    public Restaurant getSelectedRestaurantModel() {
//        return pickRestaurantPanelModel;
//    }
    

    private Restaurant copyRestaurant(Restaurant cR) {
        Restaurant newCopy = new Restaurant();
        newCopy.setCity(cR.getCity());
        newCopy.setId(cR.getId());
        newCopy.setName(cR.getName());
        newCopy.setState(cR.getState());
        newCopy.setVersion(cR.getVersion());
        newCopy.setZipCode(cR.getZipCode());

        return newCopy;
    }

    //////////////////////////////
    class PickRestaurantFormView extends RefreshingView<Restaurant> {

        public PickRestaurantFormView(String id) {
            super(id);
        }

        @Override
        protected Iterator<IModel<Restaurant>> getItemModels() {

            Iterator<Restaurant> rIter = service.getAllRestaurants().iterator();

            return new ModelIteratorAdapter<Restaurant>(rIter) {
                @Override
                protected IModel<Restaurant> model(Restaurant object) {
                    //return new CompoundPropertyModel<Restaurant>(
                    //        new RestaurantReloadableEntityModel(object,service));
                    return new RestaurantReloadableEntityModel(object, service);
                }
            };



        }

        @Override
        protected void populateItem(Item<Restaurant> item) {



            item.add(new SelectRestaurantPanel.PickActionPanel("pickAction", item.getModel()));

        }
    }

    ////////////////////////////////
    private class PickActionPanel extends Panel {

        ////////////////////////////////////////////////////////
        public PickActionPanel(String id, IModel<Restaurant> model) {
            super(id, model);
            final RestaurantReloadableEntityModel pickActionPanelModel =
                    (RestaurantReloadableEntityModel) this.getDefaultModel();

            Link select;
            select = new Link("select") {
           @Override
           public void onClick() {
               logger.debug(" clicked on "
                       + pickActionPanelModel.getObject());
               // logger.debug(" panelmodel "
               //       + pickRestaurantPanelModel.getObject());
               RestaurantEvent eV = 
                       new RestaurantEvent(RestaurantEvent.REQUEST.EDIT_REQUEST,pickActionPanelModel);
               send(getPage(), Broadcast.DEPTH, eV);

           }
       };
            SelectRestaurantPanel.PickActionPanel.this.add(select);
            Restaurant rItem = ((Restaurant) pickActionPanelModel.getObject());
            select.add(new Label("linkText", new Model(rItem.getName())));

        }
    }
}
