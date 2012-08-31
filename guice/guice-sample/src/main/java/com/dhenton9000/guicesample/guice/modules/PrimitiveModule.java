/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.guice.modules;

import com.dhenton9000.guicesample.PrimitiveItem;
import com.google.inject.AbstractModule;
import static com.google.inject.name.Names.*;


/**
 * This module is part of a demo of using primitives
 * @author dhenton
 */
public class PrimitiveModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bindConstant().annotatedWith(named("personsGreeting")).to("Hello moron!");
        this.bindConstant().annotatedWith(named("personsName")).to("Bozo");
        this.bind(PrimitiveItem.class);
        
    }
    
}
