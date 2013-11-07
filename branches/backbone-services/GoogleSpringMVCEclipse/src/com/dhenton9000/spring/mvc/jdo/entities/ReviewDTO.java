package com.dhenton9000.spring.mvc.jdo.entities;

import java.util.Date;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class ReviewDTO {

	private int starRating;
	private String reviewListing;
	private RestaurantDTO restaurant;
	private Date stampDate = new Date();
	private Long id = null;

	public ReviewDTO(Review rv) {
		this.setStampDate(rv.getStampDate());
		this.setStarRating(rv.getStarRating());
		this.setReviewListing(rv.getReviewListing());
		 
		this.setId(rv.getId().getId());
	}

	public ReviewDTO() {
	}

	public Review makeReview() {
		Review r = new Review();
		r.setStampDate(this.getStampDate());
		r.setStarRating(this.getStarRating());
		r.setReviewListing(this.getReviewListing());
		if (this.getId() != null)
		{
			Key k = KeyFactory.createKey("Review", this.getId().longValue());
			r.setId(k);
		}

		return r;
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

	public RestaurantDTO getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDTO restaurant) {
		this.restaurant = restaurant;
	}

	public Date getStampDate() {
		return stampDate;
	}

	public void setStampDate(Date stampDate) {
		this.stampDate = stampDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
