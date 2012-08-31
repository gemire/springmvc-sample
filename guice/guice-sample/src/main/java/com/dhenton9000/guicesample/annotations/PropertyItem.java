/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.annotations;

import java.lang.annotation.Annotation;

/**
 *
 * @author dhenton
 */
public class PropertyItem implements PropertyAnnotation {

    public static final int MUST_USE_ANNOTATION_SEED = 127;
    private final String value;

    public PropertyItem(String value) {
        if (value == null) {
            throw new NullPointerException("name");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    public Class<? extends Annotation> annotationType() {
        return PropertyAnnotation.class;
    }

    //these overrides are crtical for providing the functionality 
    // for guice
    @Override
    public int hashCode() {
        // This is specified in java.lang.Annotation.
        // Nothing else seems to work
        return MUST_USE_ANNOTATION_SEED * "value".hashCode() ^ value.hashCode();

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PropertyItem)) {
            return false;
        }

        return value.equals(((PropertyItem) o).value());
    }

    @Override
    public String toString() {
        return PropertyItem.class.getName() + "(value=" + value + ")";
    }
}
