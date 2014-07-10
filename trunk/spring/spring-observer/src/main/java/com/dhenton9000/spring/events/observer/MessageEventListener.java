/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.events.observer;

import com.dhenton9000.spring.events.MessageEvent;

/**
 * The contract for a class to receive messages from a MessageEventPublisher
 * via the EventMediator
 * 
 * @author dhenton
 */
public interface MessageEventListener {
    public void receiveMessage(MessageEvent m);
}
