/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.guice.modules;

import com.dhenton9000.guicesample.MailService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import java.util.Date;

/**
 *
 * @author dhenton
 */
public class ProvidesAnnotationModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    public MailService provideMailService() {
        return new MailService("alpha.server "+(new Date()));
    }
}
