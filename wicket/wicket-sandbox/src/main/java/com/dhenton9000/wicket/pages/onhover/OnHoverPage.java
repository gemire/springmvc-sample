/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.onhover;

import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.pages.lightbox.LightboxPage;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.util.string.Strings;

/**
 *
 * @author dhenton
 */
public final class OnHoverPage extends TemplatePage {
private static final JavaScriptResourceReference JQUERY_JS =
            new JavaScriptResourceReference(LightboxPage.class, "js/jquery-1.6.2.min.js");
    
 private static final CssResourceReference ONHOVER_CSS =
            new CssResourceReference(OnHoverPage.class, "css/onhover.css"); 
 
  private static final JavaScriptResourceReference INIT_ONHOVER =
            new JavaScriptResourceReference(OnHoverPage.class, "js/onhover.js");
    public static final String HOVER_MESSAGE = "Warning! You've have violated Our TOS!!";
 
    // http://css.dzone.com/news/css-message-boxes-different-me
    // http://stackoverflow.com/questions/12249391/display-wicket-panel-content-as-tooltip-on-mouse-hover-of-a-page-component
    public OnHoverPage() {
        super();
        setPageTitle(getClass().getSimpleName());
        String tooltipMsg = Strings.toMultilineMarkup(HOVER_MESSAGE).toString(); 
        Label itemLabel = new Label("hoverLabel","Hover Over Me");
 
        itemLabel.add(AttributeModifier.append("toolTipText", tooltipMsg));
        itemLabel.setOutputMarkupId(true);
        itemLabel.setMarkupId("hoverItem");
        add(itemLabel);
        
        
    }
    
    
     @Override
    public void renderHead(IHeaderResponse response) {
        // the order is important as jquery must exist before pixDisplay
        response.render(JavaScriptReferenceHeaderItem.forReference(JQUERY_JS));
        response.render(JavaScriptReferenceHeaderItem.forReference(INIT_ONHOVER));
        response.render(CssReferenceHeaderItem.forReference(ONHOVER_CSS));
        
    }
    
    
    
}
