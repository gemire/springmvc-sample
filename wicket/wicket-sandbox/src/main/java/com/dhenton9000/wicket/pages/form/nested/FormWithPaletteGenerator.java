/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * http://www.mkyong.com/wicket/wicket-palette-example/
 * 
 */
package com.dhenton9000.wicket.pages.form.nested;

import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.service.IRestaurantService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.model.util.ListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class FormWithPaletteGenerator implements Serializable {

    private List<Restaurant> selectedRestaurants;
    private List<Restaurant> allRestaurants;
    private IChoiceRenderer<Restaurant> renderer;
    private IRestaurantService service;
    private Form<Void> roleForm;
    private final Logger logger = LoggerFactory.getLogger(FormWithPaletteGenerator.class);

    public FormWithPaletteGenerator(final IRestaurantService service) {
        this.service = service;

        renderer = new ChoiceRenderer<Restaurant>("name", "id");
        selectedRestaurants = new ArrayList<Restaurant>();
        allRestaurants = service.getAllRestaurants();

        Palette<Restaurant> rolePalette = new Palette<Restaurant>(
                "rolePalette",
                new ListModel<Restaurant>(selectedRestaurants),
                new CollectionModel<Restaurant>(allRestaurants),
                renderer,
                10,
                false);
        roleForm = new Form<Void>("roleForm") {
            @Override
            protected void onSubmit() {

                info("inner: " + selectedRestaurants);

            }
        };

        roleForm.add(rolePalette);
        AjaxSubmitLink roleSubmitLink = new AjaxSubmitLink("roleSubmit", roleForm) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                logger.info("got a hit on the selector " + selectedRestaurants);
                super.onSubmit(target, form);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
                super.onError(target, form);
            }
        };

        roleForm.add(roleSubmitLink);

    }

    /**
     * @return the selectedRestaurants
     */
    public List<Restaurant> getSelectedRestaurants() {
        return selectedRestaurants;
    }

    /**
     * @return the roleForm
     */
    public Form<Void> getRoleForm() {
        return roleForm;
    }
}