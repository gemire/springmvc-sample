/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.data.sort;

import com.dhenton9000.wicket.components.basic.PageSizeSelector;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.data.providers.RestaurantDataProvider;
import com.dhenton9000.wicket.data.providers.RestaurantsDataView;
import com.dhenton9000.wicket.pages.TemplatePage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class DataFilteringPage extends TemplatePage {

    @SpringBean
    private IRestaurantService service;
    private RestaurantsDataView rDview;
    private PagingNavigator pNav;
    private WebMarkupContainer wContainer;
    private PageSizeSelector pageSelectorView;
    private static final Logger LOG = LoggerFactory.getLogger(DataFilteringPage.class);
    private FilterObj filterText = new FilterObj();
    private PropertyModel filterPropModel;
    private Form<FilterObj> filterForm;

    public DataFilteringPage() {
        super();
        setPageTitle(getClass().getSimpleName());

        setup();
    }

    private void setup() {

        final CompoundPropertyModel<FilterObj> cmpdFilterModel = new CompoundPropertyModel<FilterObj>(filterText);
        filterPropModel = new PropertyModel(filterText, "filterTextField");
        RestaurantDataProvider dataView = new RestaurantDataProvider(service, filterPropModel);

        rDview = new RestaurantsDataView("repeating", dataView);
        pNav = new PagingNavigator("nav", rDview);
        rDview.setItemsPerPage(10);
        wContainer = new WebMarkupContainer("tableContainer");
        wContainer.add(rDview);
        wContainer.add(pNav);
        wContainer.setOutputMarkupId(true);
        this.add(wContainer);
        List<Integer> sizeItems = new ArrayList<Integer>();
        sizeItems.add(5);
        sizeItems.add(10);
        sizeItems.add(20);
        rDview.setOutputMarkupId(true);
        pNav.setOutputMarkupId(true);
        pageSelectorView = new PageSizeSelector("pageSizeSelector", sizeItems);


        wContainer.add(pageSelectorView);
        TextField<String> filterTextField = new TextField<String>("filterTextField");
        filterForm = new Form<FilterObj>("filterForm", cmpdFilterModel);
        filterForm.add(filterTextField);
        filterForm.setOutputMarkupId(true);
        filterForm.add(new AjaxButton("submit-filter", filterForm) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                target.add(wContainer);

            }
        });
        filterForm.add(new AjaxButton("clear-filter", filterForm) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                filterText.setFilterTextField(null);
                target.add(form);
                target.add(wContainer);

            }
        });





        this.add(filterForm);

    }

    @Override
    public void onEvent(IEvent<?> event) {

        Object payload = event.getPayload();
        if (payload instanceof PageSizeSelector.SizeSelectionEvent) {
            PageSizeSelector.SizeSelectionEvent o = (PageSizeSelector.SizeSelectionEvent) event.getPayload();
            rDview.setItemsPerPage(o.sizeValue);
            o.ajaxTarget.add(wContainer);
        } else {
            // LOG.info("got an event of " + payload.getClass().getName());
        }

    }

    public class FilterObj implements Serializable {

        public FilterObj() {
        }
        private String filterTextField = null;

        /**
         * @return the filterTextField
         */
        public String getFilterTextField() {
            return filterTextField;
        }

        /**
         * @param filterTextField the filterTextField to set
         */
        public void setFilterTextField(String filterTextField) {
            this.filterTextField = filterTextField;
        }
    }
}//

