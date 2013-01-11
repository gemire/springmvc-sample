/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;
import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class MaintainRestaurants extends TemplatePage {

    private final Logger logger = LoggerFactory.getLogger(MaintainRestaurants.class);
   // private RestaurantReloadableEntityModel selectedRestaurantModel = null;
    @SpringBean
    private IRestaurantService service;
    private PickRestaurantPanel pickPanel = null;
    private RestaurantFormPanel restaurantFormPanel = null;
    private RestaurantReloadableEntityModel selectedRestaurantModel;

     public MaintainRestaurants() {
        super();
        setup();
    }

    
    
    
    /**
     * @return the state
     */
    public STATE getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(STATE state) {
        this.state = state;
    }

    /**
     * @return the selectedRestaurantModel
     */
    public RestaurantReloadableEntityModel getSelectedRestaurantModel() {
        return selectedRestaurantModel;
    }

     
//
//    /**
//     * @param selectedRestaurantPropertyModel the selectedRestaurantPropertyModel to set
//     */
//    public void setSelectedRestaurantModel(RestaurantReloadableEntityModel selectedRestaurantModel) {
//        this.selectedRestaurantModel = selectedRestaurantModel;
//    }

    public enum STATE {

        INITIAL, ADD, EDIT, DELETE
    }
    private STATE state = STATE.INITIAL;

   

    public void performStateOperation(STATE t) {
        logger.debug("operation called with " + t);

        switch (t) {

            case ADD:
                setState(STATE.ADD);
               // selectedRestaurantPropertyModel = new RestaurantReloadableEntityModel(new Restaurant(),service);
                selectedRestaurantModel.setObject(new Restaurant());
                break;
            case DELETE:
                if (getSelectedRestaurantModel() != null) {
                    service.delete((Restaurant) getSelectedRestaurantModel().getObject());
                    setState(STATE.INITIAL);
                  //  selectedRestaurantPropertyModel = new RestaurantReloadableEntityModel(new Restaurant(),service);
                     getSelectedRestaurantModel().setObject(new Restaurant());
                }
                break;
            case EDIT:
                setState(STATE.EDIT);
                break;
            case INITIAL:
                setState(STATE.INITIAL);
               // selectedRestaurantPropertyModel = new RestaurantReloadableEntityModel(new Restaurant(),service);
                  getSelectedRestaurantModel().setObject(new Restaurant());
                   
                //restaurantFormPanel.resetMainForm();
                break;
        }

    }

    public String getSelectedRestaurantDisplay() {
        Restaurant rr = (Restaurant) getDefaultModel().getObject();
        String t = rr.getName();
        if (t == null) {
            t = "";
        }
        return t + " [" + getState() + "]";
    }

    private void setup() {
        setPageTitle(getClass().getSimpleName());
        selectedRestaurantModel = new RestaurantReloadableEntityModel(new Restaurant(),service);
        
        setDefaultModel(selectedRestaurantModel);
        logger.debug("maintain "+getDefaultModel().getObject().toString());
        PropertyModel mLabel = new PropertyModel(MaintainRestaurants.this, "selectedRestaurantDisplay");
        add(new Label("selectedRestaurant", mLabel));
      
        pickPanel = new PickRestaurantPanel("pickPanel", getDefaultModel(), service);
        add(pickPanel);
        //CompoundPropertyModel formModel = new CompoundPropertyModel(
        //        getDefaultModel());
        restaurantFormPanel = new RestaurantFormPanel("restaurantFormPanel", getDefaultModel(), service);
        add(restaurantFormPanel);
        add(new AddDeleteRestaurantPanel("addDeletePanel",getDefaultModel()));

        
    }

    /**
     * @return the service
     */
    public IRestaurantService getService() {
        return service;
    }
}