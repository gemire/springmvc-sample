/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.websocket.handlers;

import java.security.Principal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 *
 * @author dhenton
 */
public class EchoHandler extends TextWebSocketHandler {

    private static Logger LOG = LogManager.getLogger(EchoHandler.class);
    private String userName = "<not set>";
    private int counter = 0;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
       
        Principal principal = session.getPrincipal();
         
        if (principal != null) {
            userName = principal.getName();
        } else {
            LOG.warn("principal  null");
        }
        counter ++;
        String mm = message.getPayload();
        LOG.info("got '" + mm + "' in handler from user " + userName);
        TextMessage reply = new TextMessage("User " + userName + " take this --> " + mm+" ("+counter+")");
        session.sendMessage(reply);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOG.debug("connection established " + session.getPrincipal());
    }

}
