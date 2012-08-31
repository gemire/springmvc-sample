/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * This is used by PrimitiveModule. In that module, primitives for the
 * values of the attributes are injected and wired in
 * This illustrates using the frowned upon Named annotation
 * @author dhenton
 */
public class PrimitiveItem {

    @Inject
    @Named("personsName")
    private String name = null;
    private String greeting = null;

    public PrimitiveItem() {
    }

    @Inject
    public PrimitiveItem(@Named("personsGreeting") String g, String n) {
        greeting = g;
        name = n;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the greeting
     */
    public String getGreeting() {
        return greeting;
    }

    /**
     * @param greeting the greeting to set
     */
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getMessage() {
        return getName() + ", " + getGreeting();
    }
}
