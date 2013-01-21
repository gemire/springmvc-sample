/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;
import java.util.Iterator;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy;
import org.apache.wicket.markup.repeater.util.ModelIteratorAdapter;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class PickRestaurantPanel extends Panel {

    private Form<Restaurant> pickRestaurantForm;
    private IRestaurantService service;
    private final Logger logger = LoggerFactory.getLogger(PickRestaurantPanel.class);
 //   private IModel pickRestaurantPanelModel = null;

    /**
     * The model is a Restaurant object
     */
    public PickRestaurantPanel(String id, IModel model, IRestaurantService service) {
        super(id, model);
        this.service = service;
   //     this.pickRestaurantPanelModel = model;
        logger.debug("pick restaurant panel "+model.getObject().toString());
        
        pickRestaurantForm = new Form<Restaurant>("pickRestaurantForm");
        add(pickRestaurantForm);

        RefreshingView<Restaurant> refreshingView = new PickRestaurantFormView("pickRestaurantFormView",model);
        refreshingView.setItemReuseStrategy(ReuseIfModelsEqualStrategy.getInstance());
        pickRestaurantForm.add(refreshingView);



    }

    /**
     * @return the pickRestaurantPanelModel
     */
//    public Restaurant getSelectedRestaurantModel() {
//        return pickRestaurantPanelModel;
//    }

    /**
     * @param pickRestaurantPanelModel the pickRestaurantPanelModel to set
     */
    public void setSelectedRestaurant(RestaurantReloadableEntityModel selectedRestaurantModel) {
   //     this.pickRestaurantPanelModel = pickRestaurantPanelModel;
       // this.setDefaultModel(selectedRestaurantModel);
        logger.debug("sent in set "+selectedRestaurantModel.getObject());
        Object z = selectedRestaurantModel.getObject();
        this.setDefaultModelObject(z);
        getContainingPage().setSelectedRestaurantModel(selectedRestaurantModel);
        logger.debug("Panel is now "+ this.getDefaultModel().getObject().toString());
    }

    /**
     * @return the containingPage
     */
    public MaintainRestaurants getContainingPage() {
        return (MaintainRestaurants) getParent();
    }

    //////////////////////////////
    class PickRestaurantFormView extends RefreshingView<Restaurant> {

        
        public PickRestaurantFormView(String id, IModel<?> model) {
            super(id, model);
        }

        @Override
        protected Iterator<IModel<Restaurant>> getItemModels() {
 
            Iterator<Restaurant> rIter =  service.getAllRestaurants().iterator();
           
            return new ModelIteratorAdapter<Restaurant>(rIter) {
                @Override
                protected IModel<Restaurant> model(Restaurant object) {
                    //return new CompoundPropertyModel<Restaurant>(
                    //        new RestaurantReloadableEntityModel(object,service));
                    return  new RestaurantReloadableEntityModel(object,service);
                }
            };



        }

        @Override
        protected void populateItem(Item<Restaurant> item) {


            
            item.add(new PickActionPanel("pickAction", item.getModel()));

        }
    }

    ////////////////////////////////
    private class PickActionPanel extends Panel {

        ////////////////////////////////////////////////////////
        public PickActionPanel(String id, IModel<Restaurant> model) {
            super(id, model);
            final RestaurantReloadableEntityModel pickActionPanelModel = 
                    (RestaurantReloadableEntityModel) this.getDefaultModel();
           
            Link select = new Link("select") {
                @Override
                public void onClick() {
                    
//                    final RestaurantReloadableEntityModel pickActionPanelModel = 
//                    (RestaurantReloadableEntityModel) this.getDefaultModel();
//                    
                    setSelectedRestaurant(pickActionPanelModel);
                    getContainingPage().performStateOperation(MaintainRestaurants.STATE.EDIT);
                   
                     logger.debug(" clicked on "
                             + pickActionPanelModel.getObject());
                     // logger.debug(" panelmodel "
                      //       + pickRestaurantPanelModel.getObject());
                     
                    
                }
            };
            PickActionPanel.this.add(select);
            Restaurant rItem = ((Restaurant) pickActionPanelModel.getObject());
            select.add(new Label("linkText", new Model(rItem.getName() )));

        }
    }
}
