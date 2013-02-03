/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.security;

import java.io.Serializable;

/**
 *
 * @author dhenton
 */
public class SecureUser implements Serializable {
    
    private String fullName = null;
    private String sandboxUsername = null;
    private String sandboxPassword = null;
    private boolean admin = false;

     

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the sandboxUsername
     */
    public String getSandboxUsername() {
        return sandboxUsername;
    }

    /**
     * @param sandboxUsername the sandboxUsername to set
     */
    public void setSandboxUsername(String sandboxUsername) {
        this.sandboxUsername = sandboxUsername;
    }

    /**
     * @return the sandboxPassword
     */
    public String getSandboxPassword() {
        return sandboxPassword;
    }

    /**
     * @param sandboxPassword the sandboxPassword to set
     */
    public void setSandboxPassword(String sandboxPassword) {
        this.sandboxPassword = sandboxPassword;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}
