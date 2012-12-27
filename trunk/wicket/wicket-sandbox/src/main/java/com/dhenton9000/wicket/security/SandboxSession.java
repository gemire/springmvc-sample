/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.security;

 
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 *
 * @author dhenton
 */
public class SandboxSession extends WebSession {
    
    private SecureUser secureUser = null;
    public SandboxSession(Request request)
    {
        super(request);
    }
    
    public static SandboxSession get()
    {
        return (SandboxSession) Session.get();
    }
    
    public boolean isAuthenticated()
    {
        return (getSecureUser() != null);
    }

    /**
     * @return the secureUser
     */
    public SecureUser getSecureUser() {
        return secureUser;
    }

    /**
     * @param secureUser the secureUser to set
     */
    public void setSecureUser(SecureUser secureUser) {
        this.secureUser = secureUser;
    }

   
}
