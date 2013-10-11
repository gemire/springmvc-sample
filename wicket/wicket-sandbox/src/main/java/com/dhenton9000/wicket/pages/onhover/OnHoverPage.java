/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.onhover;

import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.pages.lightbox.LightboxPage;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.util.string.Strings;
import static com.dhenton9000.wicket.resources.ResourceMarker.JQUERY_JS;

/**
 *
 * @author dhenton
 */
public final class OnHoverPage extends TemplatePage {

  
    private static final CssResourceReference ONHOVER_CSS =
            new CssResourceReference(OnHoverPage.class, "css/onhover.css");
    private static final JavaScriptResourceReference INIT_ONHOVER =
            new JavaScriptResourceReference(OnHoverPage.class, "js/onhover.js");
    public static final String HOVER_MESSAGE = "Warning! You've have violated Our TOS!!";
    private String hoverText = "";

    // http://css.dzone.com/news/css-message-boxes-different-me
    // http://stackoverflow.com/questions/12249391/display-wicket-panel-content-as-tooltip-on-mouse-hover-of-a-page-component
    public OnHoverPage() {
        super();
        setPageTitle(getClass().getSimpleName());
        // String tooltipMsg = Strings.toMultilineMarkup(HOVER_MESSAGE).toString();
        Label itemLabel = new Label("hoverLabel", new PropertyModel<String>(this, "hoverLabel"));

        itemLabel.add(AttributeModifier.append("toolTipText", new PropertyModel<String>(this, "toolTipMessage")));
        itemLabel.setOutputMarkupId(true);
        itemLabel.setMarkupId("hoverItem");
        add(itemLabel);

        final TextField<String> hoverTextField = new TextField<String>("hoverText",
                new PropertyModel<String>(this, "hoverText"));



        Form<?> form = new Form<Void>("hoverForm") {
            @Override
            protected void onSubmit() {
            }
        };
        form.add(hoverTextField);

        add(form);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
         
        response.render(JavaScriptReferenceHeaderItem.forReference(JQUERY_JS));
        response.render(JavaScriptReferenceHeaderItem.forReference(INIT_ONHOVER));
        response.render(CssReferenceHeaderItem.forReference(ONHOVER_CSS));

    }

    /**
     * @return the hoverText
     */
    public String getHoverText() {
        return hoverText;
    }

    public String getHoverLabel() {
        if (StringUtils.isBlank(hoverText)) {
            return ("Enter Hover Text");
        } else {
            return "Rollover this to see the onhover text '" + hoverText + "'";
        }

    }

    /**
     * @param hoverText the hoverText to set
     */
    public void setHoverText(String hoverText) {
        this.hoverText = hoverText;
    }

    /**
     * @return the toolTipMessage
     */
    public String getToolTipMessage() {
        if (StringUtils.isBlank(getHoverText()))
        {
            return "";
        }
        String textValue = getHoverText()+"\n"+getHoverText()+"\n"+getHoverText();
        return Strings.toMultilineMarkup(textValue).toString();
    }
}
