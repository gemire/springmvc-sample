package com.dhenton9000.spring.mvc.jdo.entities;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewDTO {

	private int starRating;
	private String reviewListing;
	private Date stampDate = new Date();
	private Long id = null;
	private Long parentRestaurantId = null;

	public ReviewDTO(Review rv) {
		this.setStampDate(rv.getStampDate());
		this.setStarRating(rv.getStarRating());
		this.setReviewListing(rv.getReviewListing());
		this.setParentRestaurantId(rv.getParentRestaurantId());
		this.setId(rv.getId().getId());
	}

	public ReviewDTO() {
	}

	public Review makeReview() {
		Review r = new Review();
		r.setStampDate(this.getStampDate());
		r.setParentRestaurantId(this.getParentRestaurantId());
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

	public Long getParentRestaurantId() {
		return parentRestaurantId;
	}

	public void setParentRestaurantId(Long parentRestaurantId) {
		this.parentRestaurantId = parentRestaurantId;
	}



}
