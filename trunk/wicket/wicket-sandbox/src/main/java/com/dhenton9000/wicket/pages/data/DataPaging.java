/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.data;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.data.providers.RestaurantDataProvider;
import com.dhenton9000.wicket.data.providers.RestaurantsDataView;
import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author dhenton
 */
public class DataPaging extends TemplatePage {

    @SpringBean
    private IRestaurantService service;
    private Restaurant selected = null;

    public DataPaging() {
        super();
        setPageTitle(getClass().getSimpleName());
        setup();
    }

    private void setup() {
        RestaurantDataProvider dataView = new RestaurantDataProvider(service);

        RestaurantsDataView rDview = new RestaurantsDataView("repeating", dataView);
        rDview.setItemsPerPage(10);
        this.add(rDview);
        
        PagingNavigator pNav = new PagingNavigator("nav",rDview);
        this.add(pNav);
        
    }
    
    
    
 
    
    
    
}//

