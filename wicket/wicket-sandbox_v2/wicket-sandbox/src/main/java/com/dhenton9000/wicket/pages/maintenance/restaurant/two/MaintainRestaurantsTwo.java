/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.maintenance.restaurant.two;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.models.RestaurantReloadableEntityModel;
import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public final class MaintainRestaurantsTwo extends TemplatePage {

    private final Logger logger = LoggerFactory.getLogger(MaintainRestaurantsTwo.class);
    @SpringBean
    private IRestaurantService service;
    private RestaurantReloadableEntityModel selectedRestaurantModel;
    private SelectRestaurantPanel pickPanel = null;
    private EditorPanel editorPanel = null;
    private AddButtonPanel addPanel = null;

    public enum STATE {

        INITIAL, ADD, EDIT, DELETE
    }
    private STATE state = STATE.INITIAL;

    public MaintainRestaurantsTwo() {
        super();
        this.setPageTitle(this.getClass().getSimpleName());
        setup();
    }

    private void setup() {
        pickPanel = new SelectRestaurantPanel("pickPanel", service);
        add(pickPanel);
        PropertyModel mLabel = new PropertyModel(MaintainRestaurantsTwo.this, "selectedRestaurantDisplay");
        add(new Label("selectedRestaurant", mLabel));
        selectedRestaurantModel = createEmptyRestaurantModel();
        editorPanel = new EditorPanel("editorPanel", new PropertyModel(MaintainRestaurantsTwo.this, "selectedRestaurantModel.object"));
        add(editorPanel);
        addPanel = new AddButtonPanel("addPanel");
        add(addPanel);
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
     * @return the service
     */
    public IRestaurantService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(IRestaurantService service) {
        this.service = service;
    }

    /**
     * @return the selectedRestaurantModel
     */
    public RestaurantReloadableEntityModel getSelectedRestaurantModel() {
        return selectedRestaurantModel;
    }

    /**
     * @param selectedRestaurantModel the selectedRestaurantModel to set
     */
    public void setSelectedRestaurantModel(RestaurantReloadableEntityModel selectedRestaurantModel) {
        this.selectedRestaurantModel = selectedRestaurantModel;
    }

    public String getSelectedRestaurantDisplay() {
        if (getSelectedRestaurantModel() == null) {
            return "";
        }

        Restaurant rr = (Restaurant) getSelectedRestaurantModel().getObject();
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

    /////////////////////
    @Override
    public void onEvent(IEvent<?> event) {

        logger.debug("In maintain event got " + event.getPayload().getClass().getName());
        RestaurantEvent rEvent = (RestaurantEvent) event.getPayload();
        RestaurantReloadableEntityModel r = rEvent.getRestaurantModel();
        Restaurant res = rEvent.getRestaurant();
        logger.debug("In maintain event got " + rEvent.getRequest());

        RestaurantEvent.REQUEST request = rEvent.getRequest();
        switch (request) {
            case ADD_REQUEST:
                setSelectedRestaurantModel(createEmptyRestaurantModel());
                setState(STATE.ADD);
                break;
            case EDIT_REQUEST:
                RestaurantReloadableEntityModel rModel = copyRestaurantModel(r);
                ((Restaurant) rModel.getObject()).scatter();
                setSelectedRestaurantModel(rModel);
                setState(STATE.EDIT);
                break;
            case CANCEL_REQUEST:
                logger.debug("cancel request ");
                setSelectedRestaurantModel(createEmptyRestaurantModel());
                setState(STATE.INITIAL);
                break;
            case DELETE_REQUEST:
                Restaurant dR = service.get(res);
                logger.debug("delete found " + dR);
                service.delete(dR);
                setSelectedRestaurantModel(createEmptyRestaurantModel());
                setState(STATE.INITIAL);
                break;
            case SAVE_REQUEST:
                logger.debug("save request " + res);
                res.gather();
                if (res.isPrimaryKeySet()) {
                    service.merge(res);
                } else {
                    service.save(res);
                }
                setSelectedRestaurantModel(createEmptyRestaurantModel());
                setState(STATE.INITIAL);

                break;
        };

    }

    private RestaurantReloadableEntityModel copyRestaurantModel(RestaurantReloadableEntityModel r) {
        Restaurant cR = (Restaurant) r.getObject();
        Restaurant newCopy = copyRestaurant(cR);
        RestaurantReloadableEntityModel model = new RestaurantReloadableEntityModel(newCopy, service);
        return model;
    }

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

    private RestaurantReloadableEntityModel createEmptyRestaurantModel() {
        return new RestaurantReloadableEntityModel(new Restaurant(), service);
    }
}
