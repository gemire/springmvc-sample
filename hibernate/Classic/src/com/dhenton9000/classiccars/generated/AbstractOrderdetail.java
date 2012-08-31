package com.dhenton9000.classiccars.generated;

/**
 * AbstractOrderdetail entity provides the base persistence definition of the
 * Orderdetail entity. @author eclipse Persistence Tools
 */

public abstract class AbstractOrderdetail implements java.io.Serializable {

	// Fields

	private OrderdetailId id;
	private Purchaseorder purchaseorder;
	private Product product;
	private Integer quantityordered;
	private Double priceeach;
	private Short orderlinenumber;

	// Constructors

	/** default constructor */
	public AbstractOrderdetail() {
	}

	/** minimal constructor */
	public AbstractOrderdetail(OrderdetailId id, Purchaseorder purchaseorder,
			Product product) {
		this.id = id;
		this.purchaseorder = purchaseorder;
		this.product = product;
	}

	/** full constructor */
	public AbstractOrderdetail(OrderdetailId id, Purchaseorder purchaseorder,
			Product product, Integer quantityordered, Double priceeach,
			Short orderlinenumber) {
		this.id = id;
		this.purchaseorder = purchaseorder;
		this.product = product;
		this.quantityordered = quantityordered;
		this.priceeach = priceeach;
		this.orderlinenumber = orderlinenumber;
	}

	// Property accessors

	public OrderdetailId getId() {
		return this.id;
	}

	public void setId(OrderdetailId id) {
		this.id = id;
	}

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

	public Integer getQuantityordered() {
		return this.quantityordered;
	}

	public void setQuantityordered(Integer quantityordered) {
		this.quantityordered = quantityordered;
	}

	public Double getPriceeach() {
		return this.priceeach;
	}

	public void setPriceeach(Double priceeach) {
		this.priceeach = priceeach;
	}

	public Short getOrderlinenumber() {
		return this.orderlinenumber;
	}

	public void setOrderlinenumber(Short orderlinenumber) {
		this.orderlinenumber = orderlinenumber;
	}

}