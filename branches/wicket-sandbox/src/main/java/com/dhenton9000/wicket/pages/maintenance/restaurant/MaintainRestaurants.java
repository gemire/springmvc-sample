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
    private ValidatingRestaurantFormPanel restaurantFormPanel = null;
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
        return (RestaurantReloadableEntityModel) getDefaultModel();
    }

    void setSelectedRestaurantModel(RestaurantReloadableEntityModel selectedRestaurantModel) {
        setDefaultModel(selectedRestaurantModel);
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
                setSelectedRestaurantModel(new RestaurantReloadableEntityModel(new Restaurant(), service));
                break;
            case DELETE:
                if (getSelectedRestaurantModel() != null) {
                    Restaurant r = (Restaurant) getSelectedRestaurantModel().getObject();
                    logger.debug("in switch delete " + r);
                    service.delete(r);
                    setState(STATE.INITIAL);
                    setSelectedRestaurantModel(new RestaurantReloadableEntityModel(new Restaurant(), service));
                     
                }
                break;
            case EDIT:
                Restaurant r = (Restaurant) getSelectedRestaurantModel().getObject();
                logger.debug("in switch edit " + r);
               setState(STATE.EDIT);
                break;
            case INITIAL:
                setState(STATE.INITIAL);
                setSelectedRestaurantModel(new RestaurantReloadableEntityModel(new Restaurant(), service));

                //restaurantFormPanel.resetMainForm();
                break;
        }

    }

    public String getSelectedRestaurantDisplay() {
        Restaurant rr = (Restaurant) getDefaultModel().getObject();
        if (rr == null) {
            return "";
        }
        String t = rr.getName();
        String j = "";
        if (rr.getPrimaryKey() == null) {
            j = "";
        } else {
            j = rr.getPrimaryKey().toString();
        }
        if (t == null) {
            t = "";
            j = "";
        }
        return t + " [" + getState() + "] " + j;
    }

    private void setup() {
        setPageTitle(getClass().getSimpleName());
        selectedRestaurantModel = new RestaurantReloadableEntityModel(new Restaurant(), service);
        PropertyModel propModel = new PropertyModel(MaintainRestaurants.this, "selectedRestaurantModel.object");
        setDefaultModel(selectedRestaurantModel);
        logger.debug("maintain " + getDefaultModel().getObject().toString());
        PropertyModel mLabel = new PropertyModel(MaintainRestaurants.this, "selectedRestaurantDisplay");
        add(new Label("selectedRestaurant", mLabel));

        pickPanel = new PickRestaurantPanel("pickPanel", getDefaultModel(), service);
        add(pickPanel);
        restaurantFormPanel = new ValidatingRestaurantFormPanel("restaurantFormPanel",
                propModel, service);
        add(restaurantFormPanel);

        add(new AddDeleteRestaurantPanel("addDeletePanel"));


    }

    /**
     * @return the service
     */
    public IRestaurantService getService() {
        return service;
    }
}