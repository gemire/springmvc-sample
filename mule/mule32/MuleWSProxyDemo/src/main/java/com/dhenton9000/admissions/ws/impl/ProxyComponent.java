/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.admissions.ws.impl;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

/**
 *
 * @author dhenton
 */
public class ProxyComponent implements Callable {
    private static final Logger logger = LoggerFactory.getLogger(ProxyComponent.class);

    @Override
    public Object onCall(MuleEventContext mec) throws Exception {
       
        MuleMessage m = mec.getMessage();
        
        Object p = m.getPayload();
        logger.debug("payload is of class "+p.getClass().getName());
        return m;
        
        
    }
    
}
