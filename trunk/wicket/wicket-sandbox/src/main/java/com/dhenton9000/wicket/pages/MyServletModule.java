/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

/**
 *
 * @author dhenton
 */
public class MyServletModule extends ServletModule {
     protected void configureServlets() {
        install(new JpaPersistModule("WicketJPA_PU"));
        filter("/*").through(PersistFilter.class);
    }
}
 