/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.ajax.indicators;

import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.service.ISlowService;
import java.util.Date;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.IAjaxIndicatorAware;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.ContextRelativeResource;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * http://stackoverflow.com/questions/11773885/customizing-indicatingajaxlink-in-wicket
 *
 * @author dhenton
 */
public class AjaxIndicatorPage extends TemplatePage {

    @SpringBean
    ISlowService service;
    private IModel<String> basicResultModel = null;
    private IModel<String> customResultModel = null;
    private final WebMarkupContainer customIndicatorContainer;

    public AjaxIndicatorPage() {
        super();
        customIndicatorContainer = new WebMarkupContainer("customIndicatorContainer");
        setPageTitle(getClass().getSimpleName());

        setupBasic();
        setupCustom();

    }

    private void setupBasic() {
        final WebMarkupContainer basicIndicatorContainer = new WebMarkupContainer("basicIndicatorContainer");
        basicIndicatorContainer.setOutputMarkupId(true);
        basicIndicatorContainer.setOutputMarkupPlaceholderTag(true);
        add(basicIndicatorContainer);
        basicResultModel = Model.of("Result");

        Label basicIndicatorResult = new Label("basicIndicatorResult", basicResultModel);
        basicIndicatorContainer.add(basicIndicatorResult);
        IndicatingAjaxLink basicIndicatorButton =
                new IndicatingAjaxLink("basicIndicatorButton") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                String dd = (new Date()).toString()+" basic ";
                String result = service.slowServiceCall(dd);
                basicResultModel.setObject(result);
                target.add(basicIndicatorContainer);

            }
        };
        add(basicIndicatorButton);
    }

    private void setupCustom() {

        customIndicatorContainer.setOutputMarkupId(true);
        customIndicatorContainer.add(new Image("customBusyImage",
                new ContextRelativeResource("/images/shared/loader.gif")));
        customIndicatorContainer.setOutputMarkupPlaceholderTag(true);
        add(customIndicatorContainer);
        customResultModel = Model.of("Custom Result");

        Label customIndicatorResult = new Label("customIndicatorResult", customResultModel);
        customIndicatorContainer.add(customIndicatorResult);
        AjaxLink customIndicatorButton =
                new MyAjaxLink("customIndicatorButton") ;
        add(customIndicatorButton);
    }

    public class MyAjaxLink extends AjaxLink implements IAjaxIndicatorAware {

        public MyAjaxLink(String id) {
            super(id);
        }

        @Override
        public void onClick(AjaxRequestTarget target) {
            String dd = (new Date()).toString() + " custom ";
            String result = service.slowServiceCall(dd);
            customResultModel.setObject(result);
            target.add(customIndicatorContainer);

        }

        @Override
        public String getAjaxIndicatorMarkupId() {
            return "ajaxIndicatorAwareIndicator";
        }
    }
}
