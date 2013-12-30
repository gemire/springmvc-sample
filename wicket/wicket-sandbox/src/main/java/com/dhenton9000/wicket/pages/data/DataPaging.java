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
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class DataPaging extends TemplatePage implements PageSizeSelectorRepeatingView.IProvider {

    @SpringBean
    private IRestaurantService service;
    private RestaurantsDataView rDview;
    private PagingNavigator pNav;
    private WebMarkupContainer wContainer;
    private PageSizeSelectorRepeatingView pageSelectorView;
    private static final Logger LOG = LoggerFactory.getLogger(DataPaging.class);

    public DataPaging() {
        super();
        setPageTitle(getClass().getSimpleName());
        setup();
    }

    private void setup() {
        RestaurantDataProvider dataView = new RestaurantDataProvider(service);

        rDview = new RestaurantsDataView("repeating", dataView);
        pNav = new PagingNavigator("nav", rDview);
        rDview.setItemsPerPage(10);
        wContainer = new WebMarkupContainer("tableContainer");
        wContainer.add(rDview);
        wContainer.setOutputMarkupId(true);
        this.add(wContainer);
        List<Integer> sizeItems = new ArrayList<Integer>();
        sizeItems.add(5);
        sizeItems.add(10);
        sizeItems.add(20);
        rDview.setOutputMarkupId(true);
        pNav.setOutputMarkupId(true);
        pageSelectorView
                = new PageSizeSelectorRepeatingView("pageSizeSelector", sizeItems, this);

        this.add(pNav);
        this.add(pageSelectorView);

    }



    @Override
    public void processSizeChange(AjaxRequestTarget target, int size) {
        rDview.setItemsPerPage(size);
        target.add(wContainer);
        target.add(pNav);
    }

}//

