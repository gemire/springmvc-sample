/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.chat.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * to listen on this event will require sprint 4.0.6
 * https://jira.spring.io/browse/SPR-11825 7/10/2014
 * 
 * @author dhenton
 */

public class SessionDisconnectListener implements ApplicationListener<SessionDisconnectEvent> {
     private static Logger log = LoggerFactory.getLogger(InboundChannelInterceptor.class);
    @Override
    public void onApplicationEvent(SessionDisconnectEvent disConnectEvent) {
         log.debug("got disconnect "+disConnectEvent.getSessionId()+" "+disConnectEvent.getCloseStatus());
         
    }
    
}
