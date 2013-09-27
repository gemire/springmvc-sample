/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.subclass;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.pages.TemplatePage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author dhenton
 */
public class PageSwapDemo extends TemplatePage {

    private static final String SUBMIT_FORM = "submitForm";
    private static final String SWAPPABLE_AREA = "swappableArea";
    private static final String FEEDBACK_PANEL = "feedbackPanel";
    private static final String SUBMIT_FORM_LINK = "submitFormLink";
    private static final String GAMMA_SELECT_BOX = "gammaSelectBox";

    /**
     * @return the selectedGroup
     */
    public GAMMA_GROUPS getSelectedGroup() {
        return selectedGroup;
    }

    /**
     * @param selectedGroup the selectedGroup to set
     */
    public void setSelectedGroup(GAMMA_GROUPS selectedGroup) {
        this.selectedGroup = selectedGroup;
    }
    private enum GAMMA_GROUPS { G1,G2,G3 };
    private static final String[] GAMMA_LABELS = {"Gamma 1","Gamma 2","Gamma 3"};
    private  GAMMA_GROUPS selectedGroup = null;

    public PageSwapDemo() {
        super();

        setPageTitle(getClass().getSimpleName());
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        setDefaultModel(buildNewSwapModel());

        final Form<PageSwapModel> form = new Form<PageSwapModel>(SUBMIT_FORM, getSwapModel()) {
            private static final long serialVersionUID = 1L;

            protected void onSubmit() {
            }
        };
        form.setOutputMarkupPlaceholderTag(true);
        add(form);

        final WebMarkupContainer swappableFieldContainer = new WebMarkupContainer(SWAPPABLE_AREA);
        swappableFieldContainer.setOutputMarkupId(true);
        form.add(swappableFieldContainer);

        final FeedbackPanel feedbackPanel = new FeedbackPanel(FEEDBACK_PANEL);
        feedbackPanel.setOutputMarkupId(true);
        feedbackPanel.setOutputMarkupPlaceholderTag(true);
        form.add(feedbackPanel);
        form.add(new SubmitLink(SUBMIT_FORM_LINK, form));

        final TextField<String> textFieldAlpha = new TextField<String>("alpha");
        final TextField<String> textFieldBeta = new TextField<String>("beta");

        final DropDownChoice gammaSelectBox = 
                new DropDownChoice<GAMMA_GROUPS>(GAMMA_SELECT_BOX, new PropertyModel(PageSwapDemo.this,"selectedGroup"), getGammaChoices(), getRenderer())
                {

                    @Override
                    protected GAMMA_GROUPS convertChoiceIdToChoice(String id) {
                        return GAMMA_GROUPS.valueOf(id);
                    }
                
                }
                ;

         
        form.add(textFieldAlpha);
        form.add(textFieldBeta);
        form.add(gammaSelectBox);
    }

    private List<GAMMA_GROUPS> getGammaChoices() {
        ArrayList<GAMMA_GROUPS> g = new ArrayList<GAMMA_GROUPS>();
        for (GAMMA_GROUPS gg : GAMMA_GROUPS.values())
        {
            g.add(gg);
            
        }
        return g;
    }

    private IChoiceRenderer getRenderer() {
        ChoiceRenderer<GAMMA_GROUPS> r = new ChoiceRenderer<GAMMA_GROUPS>() {

            @Override
            public Object getDisplayValue(GAMMA_GROUPS object) {
                int z = object.ordinal();
                return "Panel " + GAMMA_LABELS[z];
            }

            @Override
            public String getIdValue(GAMMA_GROUPS object, int index) {
                return object.toString();
            }
           
        };

        return r;
    }

    
 
    
    
    
    protected IModel<PageSwapModel> getSwapModel() {
        return (IModel<PageSwapModel>) getDefaultModel();
    }

    /**
     * Build the default model of the panel.
     */
    protected IModel<PageSwapModel> buildNewSwapModel() {
        PageSwapModel swapModel = new PageSwapModel();
//        LoadableDetachableModel m = new LoadableDetachableModel() {
//            @Override
//            protected Object load() {
                return new CompoundPropertyModel<PageSwapModel>(swapModel);
//            }
//        };
//       return m;
    }

    public class PageSwapModel implements Serializable {

        public PageSwapModel() {
        }
        private String alpha = "alpha";
        private String beta = "";
        private String gammaOne = "";
        private String gammaTwo = "";
        private String delta = "";

        /**
         * @return the alpha
         */
        public String getAlpha() {
            return alpha;
        }

        /**
         * @param alpha the alpha to set
         */
        public void setAlpha(String alpha) {
            this.alpha = alpha;
        }

        /**
         * @return the beta
         */
        public String getBeta() {
            return beta;
        }

        /**
         * @param beta the beta to set
         */
        public void setBeta(String beta) {
            this.beta = beta;
        }

        /**
         * @return the gammaOne
         */
        public String getGammaOne() {
            return gammaOne;
        }

        /**
         * @param gammaOne the gammaOne to set
         */
        public void setGammaOne(String gammaOne) {
            this.gammaOne = gammaOne;
        }

        /**
         * @return the gammaTwo
         */
        public String getGammaTwo() {
            return gammaTwo;
        }

        /**
         * @param gammaTwo the gammaTwo to set
         */
        public void setGammaTwo(String gammaTwo) {
            this.gammaTwo = gammaTwo;
        }

        /**
         * @return the delta
         */
        public String getDelta() {
            return delta;
        }

        /**
         * @param delta the delta to set
         */
        public void setDelta(String delta) {
            this.delta = delta;
        }
    }
}
