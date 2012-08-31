/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernate.join.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Don
 */
@Entity
@Table(name = "Switch", catalog = "SANDBOX")
public class Switch extends NetworkAsset {
    
    private String manufacturerName;
    private String switchIdentifier;
    private String switchType;

    /**
     * @return the manufacturerName
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * @param manufacturerName the manufacturerName to set
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    /**
     * @return the switchIdentifier
     */
    public String getSwitchIdentifier() {
        return switchIdentifier;
    }

    /**
     * @param switchIdentifier the switchIdentifier to set
     */
    public void setSwitchIdentifier(String switchIdentifier) {
        this.switchIdentifier = switchIdentifier;
    }

    /**
     * @return the switchType
     */
    public String getSwitchType() {
        return switchType;
    }

    /**
     * @param switchType the switchType to set
     */
    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }
    
}
