/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.security;

 
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 *
 * @author dhenton
 */
public class SandboxSession extends WebSession {
    
    private SecureUser user = null;
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
        return (getUser() != null);
    }

    /**
     * @return the user
     */
    public SecureUser getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(SecureUser user) {
        this.user = user;
    }

    

   
}
