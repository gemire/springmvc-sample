/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernate.join.inheritance;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Don
 */
@Entity
@Table(name = "NetworkAsset", catalog = "SANDBOX")
@Inheritance(strategy = InheritanceType.JOINED)
public class NetworkAsset implements Serializable {

    private String ipAddress;
    private String assetDescription;
    @Id
    @Column(name = "db_id", unique = true, nullable = false)
    @GeneratedValue
    private int dbId;

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the assetDescription
     */
    public String getAssetDescription() {
        return assetDescription;
    }

    /**
     * @param assetDescription the assetDescription to set
     */
    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    /**
     * @return the dbId
     */
    public int getDbId() {
        return dbId;
    }

    /**
     * @param dbId the dbId to set
     */
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NetworkAsset other = (NetworkAsset) obj;
        if ((this.ipAddress == null) ? (other.ipAddress != null) : !this.ipAddress.equals(other.ipAddress)) {
            return false;
        }
        if (this.dbId != other.dbId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.ipAddress != null ? this.ipAddress.hashCode() : 0);
        hash = 83 * hash + this.dbId;
        return hash;
    }

    public NetworkAsset(String ipAddress, String assetDescription) {
        this.ipAddress = ipAddress;
        this.assetDescription = assetDescription;
       
    }

    public NetworkAsset() {
    }
    
    
    
    
}
