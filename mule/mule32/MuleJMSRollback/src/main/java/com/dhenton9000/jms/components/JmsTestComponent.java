/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dhenton
 */
package com.dhenton9000.jms.components;

import org.apache.log4j.LogManager;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.apache.log4j.*;

public class JmsTestComponent implements Callable {
    private static Logger log = LogManager.getLogger(JmsTestComponent.class);
	@Override
	public Object onCall(MuleEventContext arg0) throws Exception {
            
            String payload = arg0.getMessage().getPayloadAsString();
            if (payload == null)
                payload = "NULL";
            
            payload = payload.trim().toUpperCase();
            if (payload.indexOf("BOZO") > -1)
            {
                throw new RuntimeException("you cannot be a BOZO");
            }
            
            
		log.info("got message "+payload);
		return null;
	}

}
