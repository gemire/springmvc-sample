/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample;

/**
 *
 * @author Don
 */
public class MailService {

    private String mailServerName = null;
    public MailService(String serverName) {
        this.mailServerName = serverName;
        
    }
    public MailService()
    {
        
    }
    
    public String getMailServerName() { return mailServerName; }
    
    
}
