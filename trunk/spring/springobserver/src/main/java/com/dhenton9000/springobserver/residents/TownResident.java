/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springobserver.residents;

import com.dhenton9000.springobserver.Observer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 *
 * @author dhenton
 */
public class TownResident implements Observer  {
    
    private Logger log = LogManager.getLogger(TownResident.class);
    
    private String message = null;
    private String name = null;
    
    public void update(String messageText) {
        
        //log.debug("Hello, I am "+getName()+", and I got the message '"+getMessage());
        setMessage(messageText);
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getResponse()
    {
        
        String response = "Hello, I am "+getName()+", and I got the message '"+getMessage()+"'";
        log.debug(response);
        return response;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
