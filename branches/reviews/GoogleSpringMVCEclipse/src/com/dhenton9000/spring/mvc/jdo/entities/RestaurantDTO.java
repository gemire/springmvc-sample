package com.dhenton9000.spring.mvc.jdo.entities;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RestaurantDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String zipCode;
	private String city;
	private String state;
	private Integer version;
	private Long id;
	private ArrayList<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();

	public RestaurantDTO() {

	}

	public RestaurantDTO(Restaurant r) {
		
		this.setCity(r.getCity());
		this.setName(r.getName());
		this.setZipCode(r.getZipCode());
		this.setState(r.getState());
		if (r.getVersion() != null)
			this.setVersion(new Integer(r.getVersion().intValue()));
		if (r.getId() != null)
			this.setId(new Long(r.getId().getId()));
		if (r.getReviews() != null) {
			for (Review rv : r.getReviews()) {
				this.getReviewDTOs().add(new ReviewDTO(rv));
			}
		}

	}

	public Restaurant makeRestaurant() {
		Restaurant r = new Restaurant();
		r.setCity(this.getCity());
		r.setName(this.getName());
		r.setZipCode(this.getZipCode());
		r.setState(this.getState());
		if (this.getVersion() != null)
			r.setVersion(new Integer(this.getVersion().intValue()));
		if (this.getId() != null) {
			Key k = KeyFactory
					.createKey("Restaurant", this.getId().longValue());
			r.setId(k);
		}
		if (this.getReviewDTOs() != null)
		{
			for (ReviewDTO rd: getReviewDTOs())
			{
				r.addReview(rd.getStarRating(), rd.getReviewListing());
			}
		}
		
		return r;
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
		if ((this.getId() == null) ? (other.getId() != null) : !this.getId()
				.equals(other.getId())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 71 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
		return hash;
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

	@Override
	public String toString() {

		return getName() + "|" + getZipCode() + "| {" + getId() + "}";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addReviewDTO(int rating, String message) {
		ReviewDTO r = new ReviewDTO();
		r.setReviewListing(message);
		r.setStarRating(rating);
		getReviewDTOs().add(r);

	}

	public ArrayList<ReviewDTO> getReviewDTOs() {
		return reviewDTOs;
	}

}
