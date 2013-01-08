/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.restaurant.maintenance;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class MaintainRestaurants extends TemplatePage {

    private final Logger logger = LoggerFactory.getLogger(MaintainRestaurants.class);
    private Restaurant selectedRestaurant = new Restaurant();
    private IRestaurantDao service;
    private PickRestaurantPanel pickPanel = null;
    private RestaurantFormPanel restaurantFormPanel = null;

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

    public MaintainRestaurants() {
        super();
        setup();
    }

    public MaintainRestaurants(PageParameters params) {
        setup();
    }

    public void performStateOperation(STATE t) {
        logger.debug("operation called with " + t);

        switch (t) {
            case ADD:

                break;
            case DELETE:
                if (selectedRestaurant != null) {
                    service.delete(selectedRestaurant);
                }
                break;
        }
        setState(t);
        selectedRestaurant = new Restaurant();

    }

    private void setup() {
        setPageTitle(getClass().getSimpleName());

        PropertyModel mLabel = new PropertyModel(MaintainRestaurants.this, "selectedRestaurant.name");
        add(new Label("selectedRestaurant", mLabel));
        PropertyModel selectedRestaurantModel =
                new PropertyModel(MaintainRestaurants.this, "selectedRestaurant");
        pickPanel = new PickRestaurantPanel("pickPanel", selectedRestaurantModel, service);
        add(pickPanel);
        CompoundPropertyModel formModel = new CompoundPropertyModel(
                selectedRestaurantModel);
        restaurantFormPanel = new RestaurantFormPanel("restaurantFormPanel", formModel, service);
        add(restaurantFormPanel);
        Model pageModel =
                new Model(MaintainRestaurants.this);
        add(new AddDeleteRestaurantPanel("addDeletePanel", pageModel, service));

    }

    /**
     * @return the service
     */
    public IRestaurantDao getService() {
        return service;
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
    }
}