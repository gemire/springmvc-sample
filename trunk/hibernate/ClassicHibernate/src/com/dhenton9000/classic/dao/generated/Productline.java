package com.dhenton9000.classic.dao.generated;

/**
 * Productline entity. @author eclipse Persistence Tools
 */

public class Productline implements java.io.Serializable {

	// Fields

	private String productline;
	private String textdescription;
	private String htmldescription;
	private String image;

	// Constructors

	/** default constructor */
	public Productline() {
	}

	/** full constructor */
	public Productline(String textdescription, String htmldescription,
			String image) {
		this.textdescription = textdescription;
		this.htmldescription = htmldescription;
		this.image = image;
	}

	// Property accessors

	public String getProductline() {
		return this.productline;
	}

	public void setProductline(String productline) {
		this.productline = productline;
	}

	public String getTextdescription() {
		return this.textdescription;
	}

	public void setTextdescription(String textdescription) {
		this.textdescription = textdescription;
	}

	public String getHtmldescription() {
		return this.htmldescription;
	}

	public void setHtmldescription(String htmldescription) {
		this.htmldescription = htmldescription;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}