/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.providers;

import com.dhenton9000.guicesample.MailService;
import com.google.inject.Inject;

/**
 *
 * @author Don
 */
public class ProvidesAnnotationSample {

    private MailService service;

    @Inject
    public ProvidesAnnotationSample(MailService s) {
        service = s;
    }

    public String reportService() {
        return service.getMailServerName();
    }
}