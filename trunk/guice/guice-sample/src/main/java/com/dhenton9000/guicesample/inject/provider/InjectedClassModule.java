/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.inject.provider;

import com.google.inject.AbstractModule;

/**
 * This module sets up a factory of InjectedClass, which can be used to 
 * bind a class (not an interface) to a given source, that is the 
 * InjectedClassFactory, which must implement the google Provider interface
 * 
 * @author dhenton
 */
public class InjectedClassModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(InjectedClass.class).toProvider(InjectedClassFactory.class);
    }
    
}
