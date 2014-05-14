package com.dhenton9000.spring.mvc.jdo.entities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author dhenton
 */

public class Restaurant implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private List<Review> reviewDTOs;
        private String id ;
	private Integer version;
	private String zipCode;
	private String city;	
	private String state;	
	
	private final transient Logger logger = LoggerFactory
			.getLogger(Restaurant.class);

	

	public Restaurant() {

	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	

	/**
	 * @return the version
	 */

	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
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
	 * @param zipCode
	 *            the zipCode to set
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
	 * @param city
	 *            the city to set
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
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	
	public void clear() {
		setName(null);
		setCity(null);
		setVersion(null);
		setZipCode(null);
		setState(null);
		 

	}

 

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the reviewDTOs
     */
    public List<Review> getReviewDTOs() {
        return reviewDTOs;
    }

    /**
     * @param reviewDTOs the reviewDTOs to set
     */
    public void setReviewDTOs(List<Review> reviewDTOs) {
        this.reviewDTOs = reviewDTOs;
    }
	

 
}
