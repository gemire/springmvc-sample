/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.events.observer;


/**
 * The contract for a class that wants to send messages out to one 
 * or more MessageEventListeners
 * 
 * @author dhenton
 */
public interface MessageEventPublisher {
    
   
    public void setMediator(EventMediator m);
    
}
