/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.form.complex;

import com.dhenton9000.jpa.entities.Restaurant;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.PropertyModel;
import static com.dhenton9000.wicket.pages.form.complex.CandidateRestaurant.ROLE_TYPE;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author Don
 */
public class RestaurantSelectorPanel extends Panel {

    private final ComplexFormPage page;
    private final ManagerDTO managerDTO;
    private final Button addRestaurantButton;
    private final ListView<CandidateRestaurant> candidateListView;

    public RestaurantSelectorPanel(String id, ComplexFormPage form) {
        super(id);
        this.page = form;
        this.managerDTO = page.getManagerForm().getModelObject();

        ChoiceRenderer renderer = new ChoiceRenderer<Restaurant>("name", "id");

        ListMultipleChoice selectedRestaurants = new ListMultipleChoice("selectedRestaurants",
                managerDTO.getSelectedRestaurants(), managerDTO.getAvailableRestaurants(), renderer);
        selectedRestaurants.setMaxRows(10);
        add(selectedRestaurants);

        addRestaurantButton = new Button("addRestaurant");

        add(addRestaurantButton);

        candidateListView = new ListView<CandidateRestaurant>("candidateRestaurants",
                managerDTO.getCandidateRestaurants()) {

                    @Override
                    protected void populateItem(ListItem item) {
                        CandidateRestaurant mObj = (CandidateRestaurant) item.getModelObject();
                        item.add(new Label("candidateName", mObj.getName()));
                        RadioGroup<ROLE_TYPE> roleTypeGroup = new RadioGroup<ROLE_TYPE>("roleType", new PropertyModel<ROLE_TYPE>(mObj, "roleType"));
                        Radio<ROLE_TYPE> roleTypeAdv = new Radio<ROLE_TYPE>("advancedRoleType", new Model<ROLE_TYPE>(ROLE_TYPE.Advanced));
                        Radio roleTypeBasic = new Radio("basicRoleType", new Model<ROLE_TYPE>(ROLE_TYPE.Basic));
                        roleTypeGroup.add(roleTypeAdv);
                        roleTypeGroup.add(roleTypeBasic);
                        item.add(roleTypeGroup);

                        RowAjaxSubmitLink removeLink
                        = new RowAjaxSubmitLink("removeLink",
                                page.getManagerForm(), new Model<CandidateRestaurant>(mObj));

                        item.add(removeLink);
                    }
                };
        candidateListView.setReuseItems(true);
        add(candidateListView);

    }

    public void refresh(ComplexFormPage.BUTTON_ACTION buttonAction) {

        for (Restaurant r : this.managerDTO.getSelectedRestaurants().getObject()) {
            CandidateRestaurant c = new CandidateRestaurant(r);
            this.managerDTO.getCandidateRestaurants().getObject().add(c);
        }
        this.managerDTO.getSelectedRestaurants().getObject().clear();
        this.managerDTO.getAvailableRestaurants().detach();
        candidateListView.removeAll();

    }

   
    class RowAjaxSubmitLink extends AjaxSubmitLink {

        IModel<CandidateRestaurant> rowModel;

        RowAjaxSubmitLink(String id, Form<?> form, IModel<CandidateRestaurant> rowModel) {
            super(id, form);

            this.rowModel = rowModel;
        }

        @Override
        protected void onError(AjaxRequestTarget target, Form<?> form) {

            target.add(form);
            super.onError(target, form);
        }

        @Override
        protected void onSubmit(AjaxRequestTarget target, Form<?> form) {

            CandidateRestaurant c = this.rowModel.getObject();
            RestaurantSelectorPanel.this.managerDTO.getCandidateRestaurants().getObject().remove(c);
            RestaurantSelectorPanel.this.managerDTO.getAvailableRestaurants().detach();
            candidateListView.removeAll();
            target.add(form);
            super.onSubmit(target, form);
        }

    }

}
