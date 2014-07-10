/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.events.observer;

import com.dhenton9000.spring.events.MessageEvent;

/**
 * the mediator that is the go-between for publishers and listeners
 * 
 * @author dhenton
 */
public interface EventMediator {
     public void sendMessage(MessageEvent ev);
}
