/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.csvfeed;


/**
 * This is a generic column that will return a
 * label that can be injected by Spring
 *
 * @author Don
 */
public class ConstantColumn extends FeedColumn {

    private String label = null;

    @Override
    public String getValue(Object item) {
        return getLabel();
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

 
}
