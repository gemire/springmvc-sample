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
    private RestaurantReloadableEntityModel selectedRestaurant = null;
    @SpringBean
    private IRestaurantService service;
    private PickRestaurantPanel pickPanel = null;
    private RestaurantFormPanel restaurantFormPanel = null;

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

    public enum STATE {

        INITIAL, ADD, EDIT, DELETE
    }
    private STATE state = STATE.INITIAL;

   

    public void performStateOperation(STATE t) {
        logger.debug("operation called with " + t);

        switch (t) {

            case ADD:
                setState(STATE.ADD);
                selectedRestaurant = new RestaurantReloadableEntityModel(new Restaurant(),service);
                break;
            case DELETE:
                if (selectedRestaurant != null) {
                    service.delete((Restaurant) selectedRestaurant.getEntity());
                    setState(STATE.INITIAL);
                    selectedRestaurant = new RestaurantReloadableEntityModel(new Restaurant(),service);
                }
                break;
            case EDIT:
                setState(STATE.EDIT);
                break;
            case INITIAL:
                setState(STATE.INITIAL);
                selectedRestaurant = new RestaurantReloadableEntityModel(new Restaurant(),service);
                 
                //restaurantFormPanel.resetMainForm();
                break;
        }



    }

    public String getSelectedRestaurantDisplay() {
        String t = getSelectedRestaurant().getName();
        if (t == null) {
            t = "";
        }
        return t + " [" + getState() + "]";
    }

    private void setup() {
        setPageTitle(getClass().getSimpleName());
        selectedRestaurant = new RestaurantReloadableEntityModel(new Restaurant(),service);
        selectedRestaurant.setService(service);
        PropertyModel mLabel = new PropertyModel(MaintainRestaurants.this, "selectedRestaurantDisplay");
        add(new Label("selectedRestaurant", mLabel));
        PropertyModel selectedRestaurantModel =
                new PropertyModel(MaintainRestaurants.this, "selectedRestaurant");
        pickPanel = new PickRestaurantPanel("pickPanel", selectedRestaurantModel, service);
        add(pickPanel);
        CompoundPropertyModel formModel = new CompoundPropertyModel(
                selectedRestaurantModel);
        restaurantFormPanel = new RestaurantFormPanel("restaurantFormPanel", formModel, service);
        add(restaurantFormPanel);
        add(new AddDeleteRestaurantPanel("addDeletePanel"));

        
    }

    /**
     * @return the service
     */
    public IRestaurantService getService() {
        return service;
    }

    /**
     * @return the selectedRestaurant
     */
    public Restaurant getSelectedRestaurant() {
        return (Restaurant) selectedRestaurant.getEntity();
    }

    /**
     * @param selectedRestaurant the selectedRestaurant to set
     */
    public void setSelectedRestaurant(Restaurant selectedRestaurant) {
        this.selectedRestaurant = new RestaurantReloadableEntityModel(selectedRestaurant,service);
    }
}