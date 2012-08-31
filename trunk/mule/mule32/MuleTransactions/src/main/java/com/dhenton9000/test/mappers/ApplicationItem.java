/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.test.mappers;

/**
 *
 * @author dhenton
 */
public class ApplicationItem {
    private int id = 0;
    private String applicationName = null;

    public ApplicationItem()
    {
        
    }
    @Override
    public String toString() {
        return "Application{" + "id=" + id + ", applicationName=" + applicationName + '}';
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ApplicationItem other = (ApplicationItem) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.applicationName == null) ? (other.applicationName != null) : !this.applicationName.equals(other.applicationName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + (this.applicationName != null ? this.applicationName.hashCode() : 0);
        return hash;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the applicationName
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * @param applicationName the applicationName to set
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
    
}
