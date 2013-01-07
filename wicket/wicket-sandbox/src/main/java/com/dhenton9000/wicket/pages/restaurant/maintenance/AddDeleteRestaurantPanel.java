/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.restaurant.maintenance;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.service.IRestaurantService;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author dhenton
 */
public final class AddDeleteRestaurantPanel extends Panel {
    private Form<Restaurant> addDeleteRestaurantForm;
    private final IRestaurantService service;
    private Restaurant selectedRestaurant = null;
    private MaintainRestaurants containingPage = null;
    /**
     * The model is the containing Page , MaintainRestaurants
     * @param id
     * @param model
     * @param service 
     */
    public AddDeleteRestaurantPanel(String id, IModel model,final IRestaurantService service) {
        super(id,model);
        this.service = service;
        this.containingPage =  (MaintainRestaurants) model.getObject();
        
         Form<Restaurant> addDeleteRestaurantForm = new Form<Restaurant>("addDeleteForm", model) {
            @Override
            protected void onSubmit() {
                 
            }
        };
        Button addButton = new Button("addButton",new Model("Add"))
        {

            @Override
            public void onSubmit() {
                getContainingPage().performStateOperation(MaintainRestaurants.STATE.ADD);
            }
            
            
            @Override
            public boolean isVisible()
            {
                boolean isVisible = true;
                
//                switch (getContainingPage().getState())
//                {
//                    case ADD:
//                        break;
//                    case EDIT:
//                        break;
//                    case INITIAL:
//                        isVisible = true;
//                        break;
//                    case DELETE:
//                        break;
//                }
                
                
                return isVisible;
            }
            
        };
        
         Button cancelButton = new Button("cancelButton",new Model("Cancel"))
        {

            @Override
            public void onSubmit() {
                getContainingPage().performStateOperation(MaintainRestaurants.STATE.INITIAL);
            }
            
            
              @Override
            public boolean isVisible()
            {
                boolean isVisible = true;
                
//                switch (getContainingPage().getState())
//                {
//                    case ADD:
//                        break;
//                    case EDIT:
//                        break;
//                    case INITIAL:
//                        isVisible = false;
//                        break;
//                    case DELETE:
//                        break;
//                }
                
                
                return isVisible;
            }
            
        };
        Button deleteButton = new Button("deleteButton",new Model("Delete"))
        {

            @Override
            public void onSubmit() {
              getContainingPage().performStateOperation(MaintainRestaurants.STATE.DELETE);  
            }

            @Override
            protected String getOnClickScript() {
                return "return confirm('Remove Restaurant?');";
            }
            
              @Override
            public boolean isVisible()
            {
                boolean isVisible = true;
//                
//                switch (getContainingPage().getState())
//                {
//                    case ADD:
//                        break;
//                    case EDIT:
//                         isVisible = true;
//                        break;
//                    case INITIAL:
//                       
//                        break;
//                    case DELETE:
//                        break;
//                }
//                
                
                return isVisible;
            }
            
            
        };
        
        addDeleteRestaurantForm.add(addButton);
        addDeleteRestaurantForm.add(deleteButton);
        addDeleteRestaurantForm.add(cancelButton);
        add(addDeleteRestaurantForm);
        
        
        
        
        
    }
    
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

    /**
     * @return the containingPage
     */
    public MaintainRestaurants getContainingPage() {
        return containingPage;
    }

}
