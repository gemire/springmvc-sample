/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.websocket.handlers;

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

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        String mm = message.getPayload();
        LOG.info("got '"+mm+"' in handler");
        TextMessage reply = new TextMessage("Bonzo " + mm);
        session.sendMessage(reply);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOG.debug("connection established " + session.getPrincipal());
    }

}
