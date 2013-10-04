package com.dhenton9000.spring.mvc.jdo.entities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.NumberFormat;

import com.google.appengine.api.datastore.Key;

/**
 * @author dhenton
 */

@PersistenceCapable()
 public class Restaurant implements Serializable  {

    private static final long serialVersionUID = 1L;
    @PrimaryKey  
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)  
   // @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")  
    private Key id;
    @Persistent
    @NotEmpty(message="Restaurant Name cannot be blank")
    private String name;
    @Persistent
    @NumberFormat(pattern="####")
    private Integer version;
    @Persistent
    @NotEmpty(message="Zipcode cannot be blank")
    private String zipCode;
    @Persistent    
    @NotEmpty(message="City cannot be blank")
    private String city;
    @Persistent
    @NotEmpty(message="State cannot be blank")
    private String state;
    
    
    private Long idAsLong = null;
    
    private final transient Logger logger = LoggerFactory.getLogger(Restaurant.class);

    public Restaurant(Key k) {
    	id = k;
    }
 
    public Restaurant()
    {
    	
    }
    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
        setIdAsLong(null);
    }

    
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

 

    /**
     * @return the version
     */
   
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
    	String id = "null";
    	
    	if (getId() != null)
    	{
    		id = getId().getAppId();
    	}
        return getName() + "|" + getZipCode()+"| {" + id + "}";
    }

	public void clear() {
		setName(null);
		setCity(null);
		setVersion(null);
		setZipCode(null);
		setId(null);
		setState(null);
		
	}

	public Long getIdAsLong() {
		return idAsLong;
	}

	public void setIdAsLong(Long idAsLong) {
		this.idAsLong = idAsLong;
	}

 

    
 
}
