/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.data;

import com.dhenton9000.wicket.components.basic.PageSizeSelectorRepeatingView;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.data.providers.RestaurantDataProvider;
import com.dhenton9000.wicket.data.providers.RestaurantsDataView;
import com.dhenton9000.wicket.pages.TemplatePage;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author dhenton
 */
public class DataPaging extends TemplatePage {

    @SpringBean
    private IRestaurantService service;

    public DataPaging() {
        super();
        setPageTitle(getClass().getSimpleName());
        setup();
    }

    private void setup() {
        RestaurantDataProvider dataView = new RestaurantDataProvider(service);
   
        final RestaurantsDataView rDview = new RestaurantsDataView("repeating", dataView);
        final PagingNavigator pNav = new PagingNavigator("nav", rDview);
        rDview.setItemsPerPage(10);
        final WebMarkupContainer wContainer = new WebMarkupContainer("tableContainer");
        wContainer.add(rDview);
        wContainer.setOutputMarkupId(true);
        this.add(wContainer);
        List<Integer> sizeItems = new ArrayList<Integer>();
        sizeItems.add(5);
        sizeItems.add(10);
        sizeItems.add(20);
        rDview.setOutputMarkupId(true);
        pNav.setOutputMarkupId(true);
        PageSizeSelectorRepeatingView pageSelectorView =
                new PageSizeSelectorRepeatingView("pageSizeSelector", sizeItems) {
            @Override
            protected DataView getPagedComponent() {
                return rDview;
              }

            @Override
            protected void addComponents(AjaxRequestTarget target) {
                 target.add(wContainer);
                 target.add(pNav);
            }
        };
        {
        };

        this.add(pNav);
        this.add(pageSelectorView);
        

    }
}//

