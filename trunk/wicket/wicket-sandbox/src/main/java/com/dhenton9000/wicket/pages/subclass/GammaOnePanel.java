/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.subclass;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author dhenton
 */
public class GammaOnePanel extends Panel {
    public GammaOnePanel(String id)
    {
        super(id);
         add(new TextField("gammaOne"));
    }
}
