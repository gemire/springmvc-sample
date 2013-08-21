/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.data.providers;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.pages.data.DataPaging;
import com.dhenton9000.wicket.pages.data.RestaurantsDataViewActionPanel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class RestaurantsDataView extends DataView<Restaurant> {

    Logger logger = LoggerFactory.getLogger(RestaurantsDataView.class);

    public RestaurantsDataView(String id, IDataProvider<Restaurant> dataProvider) {
        super(id, dataProvider);
    }

    public RestaurantsDataView(String id, IDataProvider<Restaurant> dataProvider, long itemsPerPage) {
        super(id, dataProvider, itemsPerPage);
    }

    @Override
    protected void populateItem(final Item<Restaurant> item) {
        Restaurant r = item.getModelObject();

        item.add(new Label("zipcode", new Model(r.getZipCode())));
        item.add(new Label("state", new Model(r.getState())));
        item.add(new Label("city", new Model(r.getCity())));
        item.add(new RestaurantsDataViewActionPanel ("actions", item.getModel()));

        item.add(AttributeModifier.replace("class", new AbstractReadOnlyModel<String>() {
            private static final long serialVersionUID = 1L;

            @Override
            public String getObject() {
                return (item.getIndex() % 2 == 1) ? "even" : "odd";
            }
        }));

    }

    
}
