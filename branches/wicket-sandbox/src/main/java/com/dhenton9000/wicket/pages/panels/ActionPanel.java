/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.panels;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author dhenton
 */
public final class ActionPanel extends Panel {

    public ActionPanel(String id) {
        super(id);
    }

    
    public ActionPanel(String id, IModel<?> model) {
        super(id, model);
    }
    
    
}
