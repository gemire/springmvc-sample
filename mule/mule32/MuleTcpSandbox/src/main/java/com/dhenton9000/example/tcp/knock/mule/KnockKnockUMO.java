/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp.knock.mule;


import com.dhenton9000.example.tcp.knock.KnockKnockProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Don
 */
public class KnockKnockUMO {
         private static final Logger logger = LoggerFactory.getLogger(KnockKnockUMO.class);
         private KnockKnockProtocol p = new KnockKnockProtocol();
    public String echoString(String t)
    {
        logger.debug("@@@ Echo UMO "+t);
        return t;
    }
}
