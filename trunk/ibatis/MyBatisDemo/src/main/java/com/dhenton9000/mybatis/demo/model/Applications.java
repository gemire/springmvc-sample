/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mybatis.demo.model;

/**
 *
 * @author dhenton
 */

public class Applications   {

        private Integer id;
        private String applicationName;
      

    public Applications() {
    }

    public Applications(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Applications other = (Applications) obj;
        if ((this.applicationName == null) ? (other.applicationName != null) : !this.applicationName.equals(other.applicationName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.applicationName != null ? this.applicationName.hashCode() : 0);
        return hash;
    }

 
    @Override
    public String toString() {
        return "com.dhenton9000.jpa.generated.Applications[ id=" + id + " ]";
    }

   

  
}

