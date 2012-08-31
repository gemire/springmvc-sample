package com.dhenton9000.classiccars.generated;

/**
 * AbstractOrderdetailId entity provides the base persistence definition of the
 * OrderdetailId entity. @author eclipse Persistence Tools
 */

public abstract class AbstractOrderdetailId implements java.io.Serializable {

	// Fields

	private Integer purchaseordernumber;
	private String productcode;

	// Constructors

	/** default constructor */
	public AbstractOrderdetailId() {
	}

	/** full constructor */
	public AbstractOrderdetailId(Integer purchaseordernumber, String productcode) {
		this.purchaseordernumber = purchaseordernumber;
		this.productcode = productcode;
	}

	// Property accessors

	public Integer getPurchaseordernumber() {
		return this.purchaseordernumber;
	}

	public void setPurchaseordernumber(Integer purchaseordernumber) {
		this.purchaseordernumber = purchaseordernumber;
	}

	public String getProductcode() {
		return this.productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractOrderdetailId))
			return false;
		AbstractOrderdetailId castOther = (AbstractOrderdetailId) other;

		return ((this.getPurchaseordernumber() == castOther
				.getPurchaseordernumber()) || (this.getPurchaseordernumber() != null
				&& castOther.getPurchaseordernumber() != null && this
				.getPurchaseordernumber().equals(
						castOther.getPurchaseordernumber())))
				&& ((this.getProductcode() == castOther.getProductcode()) || (this
						.getProductcode() != null
						&& castOther.getProductcode() != null && this
						.getProductcode().equals(castOther.getProductcode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getPurchaseordernumber() == null ? 0 : this
						.getPurchaseordernumber().hashCode());
		result = 37
				* result
				+ (getProductcode() == null ? 0 : this.getProductcode()
						.hashCode());
		return result;
	}

}