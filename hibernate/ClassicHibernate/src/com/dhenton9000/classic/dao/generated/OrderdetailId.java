package com.dhenton9000.classic.dao.generated;

/**
 * OrderdetailId entity. @author eclipse Persistence Tools
 */

public class OrderdetailId implements java.io.Serializable {

	// Fields

	private Purchaseorder purchaseorder;
	private Product product;

	// Constructors

	/** default constructor */
	public OrderdetailId() {
	}

	/** full constructor */
	public OrderdetailId(Purchaseorder purchaseorder, Product product) {
		this.purchaseorder = purchaseorder;
		this.product = product;
	}

	// Property accessors

	public Purchaseorder getPurchaseorder() {
		return this.purchaseorder;
	}

	public void setPurchaseorder(Purchaseorder purchaseorder) {
		this.purchaseorder = purchaseorder;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderdetailId))
			return false;
		OrderdetailId castOther = (OrderdetailId) other;

		return ((this.getPurchaseorder() == castOther.getPurchaseorder()) || (this
				.getPurchaseorder() != null
				&& castOther.getPurchaseorder() != null && this
				.getPurchaseorder().equals(castOther.getPurchaseorder())))
				&& ((this.getProduct() == castOther.getProduct()) || (this
						.getProduct() != null
						&& castOther.getProduct() != null && this.getProduct()
						.equals(castOther.getProduct())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getPurchaseorder() == null ? 0 : this.getPurchaseorder()
						.hashCode());
		result = 37 * result
				+ (getProduct() == null ? 0 : this.getProduct().hashCode());
		return result;
	}

}