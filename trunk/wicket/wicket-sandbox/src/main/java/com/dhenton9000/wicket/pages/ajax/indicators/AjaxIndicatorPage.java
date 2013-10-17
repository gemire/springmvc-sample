/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.ajax.indicators;

import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.service.ISlowService;
import java.util.Date;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;


/**
 * http://stackoverflow.com/questions/11773885/customizing-indicatingajaxlink-in-wicket
 * @author dhenton
 */
public class AjaxIndicatorPage extends TemplatePage{
    
    @SpringBean
    ISlowService service ;
    private IModel<String> resultModel = null;
    
     public AjaxIndicatorPage() {
        super();

        setPageTitle(getClass().getSimpleName());
        
        setup();

    }

    private void setup() {
         final WebMarkupContainer basicIndicatorContainer = new
                 WebMarkupContainer("basicIndicatorContainer");
         basicIndicatorContainer.setOutputMarkupId(true);
         basicIndicatorContainer.setOutputMarkupPlaceholderTag(true);
         add(basicIndicatorContainer);
         resultModel = Model.of("Result");
         
         Label basicIndicatorResult = new Label("basicIndicatorResult",resultModel);
         basicIndicatorContainer.add(basicIndicatorResult);
         IndicatingAjaxLink basicIndicatorButton = 
                 new IndicatingAjaxLink("basicIndicatorButton")
         {
            
         
             @Override
             public void onClick(AjaxRequestTarget target) {
                 String dd = (new Date()).toString();
                 String result = service.slowServiceCall(dd);
                 resultModel.setObject(result);
                  target.add(basicIndicatorContainer);
                  
             }
             
         };
         add(basicIndicatorButton);
         
         
    }
    
    
}
