package com.dhenton9000.spring.mvc.jdo.entities;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Review implements Serializable  {

    private static final long serialVersionUID = 1L;
    private String id;
    private int starRating;
  
    private String reviewListing;
  
    private Restaurant restaurant;
   
	private Date stampDate = new Date();
  
    private Long parentRestaurantId = null;

    private final transient Logger logger = LoggerFactory.getLogger(Review.class);
   
  
    
    public Review()
    {
    	
    }
    public Review(int s , String m)
    {
    	starRating = s;
    	reviewListing = m;
    }
   
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public String getReviewListing() {
		return reviewListing;
	}
	public void setReviewListing(String reviewListing) {
		this.reviewListing = reviewListing;
	}




	public Date getStampDate() {
		return stampDate;
	}

	public void setStampDate(Date stampDate) {
		this.stampDate = stampDate;
	}

	public Long getParentRestaurantId() {
		return parentRestaurantId;
	}

	public void setParentRestaurantId(Long parentRestaurantId) {
		this.parentRestaurantId = parentRestaurantId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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


    
   
    
    
}
