/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.form.listview;

import com.dhenton9000.wicket.dao.service.IRestaurantService;
import com.dhenton9000.wicket.pages.TemplatePage;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IFormSubmitter;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Don
 */
public class FormListView extends TemplatePage {

    @SpringBean
    private IRestaurantService service;
    private final Logger logger = LoggerFactory.getLogger(FormListView.class);

    private final ListDO listDO = new ListDO(service);
    private final Form<ListDO> listForm;
    private ListView<SelectedRestaurant> candidateListView;

    public FormListView() {
        super();
        setPageTitle(getClass().getSimpleName());
        listForm = new Form("listForm", new Model<ListDO>(listDO)) {

            @Override
            protected void detachModel() {
                super.detachModel(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void detachModels() {
                super.detachModels(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void process(IFormSubmitter submittingComponent) {
                super.process(submittingComponent);  
                 logger.debug("in process");
            }

          
            @Override
            protected void onSubmit() {
                 logger.debug("in submit");
                // move the marked items to the selected list
                
                    logger.debug("after submit selected is size "+                 
                         listDO.getSelectedRestaurants().size());
                 // they will be removed in the load method of the loadabledetachable model
            }

            @Override
            protected void onError() {
                
            }

        };

        add(listForm);
        Button button = new Button("submit");

        listForm.add(button);
        listForm.add(createCandidateRestaurantView());

    }

    private ListView<SelectedRestaurant> createCandidateRestaurantView() {

        candidateListView = new ListView<SelectedRestaurant>("candidateRestaurants",
                listDO.getAvailableRestaurantsModel()) {
                    @Override
                    protected void populateItem(ListItem item) {
                        SelectedRestaurant mObj = (SelectedRestaurant) item.getModelObject();
                        item.add(new Label("candidateName", mObj.getName()));
                        CheckBox candidateSelectBox = 
                          new CheckBox("candidateSelectBox",
                          new PropertyModel<Boolean>(mObj,"selected") );
                        item.add(candidateSelectBox);
                      //  logger.debug("in populate Item");

                    }
                };
        candidateListView.setReuseItems(false);
        add(candidateListView);

        return candidateListView;
    }
}
