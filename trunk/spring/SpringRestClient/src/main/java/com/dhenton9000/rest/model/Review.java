/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.rest.model;



import java.io.Serializable;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Review implements Serializable  {

    private static final long serialVersionUID = 1L;
     

    private Key id;

    private int starRating;

    private String reviewListing;

    private Restaurant restaurant;

	private Date stampDate = new Date();

    private final transient Logger logger = LoggerFactory.getLogger(Review.class);
   
    
    public Review(Key k)
    {
    	id = k;
    }
    
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
	public Key getId() {
		return id;
	}
	public void setId(Key id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((reviewListing == null) ? 0 : reviewListing.hashCode());
		result = prime * result + starRating;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reviewListing == null) {
			if (other.reviewListing != null)
				return false;
		} else if (!reviewListing.equals(other.reviewListing))
			return false;
		if (starRating != other.starRating)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", starRating=" + starRating
				+ ", reviewListing=" + reviewListing + "]";
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Date getStampDate() {
		return stampDate;
	}

	public void setStampDate(Date stampDate) {
		this.stampDate = stampDate;
	}
    
   
    
    
}