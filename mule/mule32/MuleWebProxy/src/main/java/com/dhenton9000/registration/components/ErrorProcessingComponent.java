/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.components;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.apache.log4j.*;
/**
 *
 * @author dhenton
 */
public class ErrorProcessingComponent implements Callable{
   private static final Logger log = LogManager.getLogger(ErrorProcessingComponent.class);

    @Override
    public Object onCall(MuleEventContext mec) throws Exception {
         
        log.error("#################\n");
        log.error("payload "+mec.getMessage().getPayloadAsString());
        log.error("payload class "+mec.getMessage().getPayload());
        
        log.error("#################\n");
        return null;
    }
    
}
