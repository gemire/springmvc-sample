/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities;

import com.dhenton9000.jpa.domain.Identifiable;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name = "RESTAURANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT u FROM Restaurant u"),
    @NamedQuery(name = "Restaurant.findByid", query = "SELECT u FROM Restaurant u WHERE u.id = :id"),
    @NamedQuery(name = "Restaurant.findByName", query = "SELECT u FROM Restaurant u WHERE u.name = :name")})
public class Restaurant implements Identifiable<Integer>, Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer version;
    private String versionString;
    private String zipCode;
    private String city;
    private String state;
    private final Logger logger = LoggerFactory.getLogger(Restaurant.class);

    public Restaurant() {
    }

    public Restaurant(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Restaurant other = (Restaurant) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    @Transient
    @XmlTransient
    public Integer getPrimaryKey() {
        return this.getId();
    }

    @Override
    public void setPrimaryKey(Integer id) {
        this.setId(id);
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isPrimaryKeySet() {
        return id != null;
    }

    /**
     * @return the version
     */
    @Column(name = "VERSION")
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return the zipCode
     */
    @Column(name = "ZIP_CODE", length = 250)
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the city
     */
    @Column(name = "CITY", length = 250)
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    @Column(name = "STATE", length = 250)
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return getName() + " {" + getPrimaryKey() + "}";
    }

    /**
     * @return the versionString
     */
    @XmlTransient
    @Transient
    public String getVersionString() {
        return versionString;
    }

    /**
     * @param versionString the versionString to set
     */
    public void setVersionString(String versionString) {
        this.versionString = versionString;
    }

    /**
     * move the integer value to the string value
     */
    public void scatter() {
        String var = "";
        if (this.getVersion() != null) {
            logger.debug("scattering "+this.getVersion());
            var = this.getVersion().toString();
        }
        this.setVersionString(var);
    }

    /**
     * move the string value to the integer value
     */
    public void gather() {
        String var = this.getVersionString();
        Integer i = null;
        if (var != null) {
            try {
                i = Integer.parseInt(var);
            } catch (Exception err) {
            }
        }
        this.setVersion(i);
    }
}
