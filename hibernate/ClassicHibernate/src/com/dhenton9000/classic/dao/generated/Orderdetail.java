package com.dhenton9000.classic.dao.generated;

/**
 * Orderdetail entity. @author eclipse Persistence Tools
 */

public class Orderdetail implements java.io.Serializable {

	// Fields

	private OrderdetailId id;
	private Integer quantityordered;
	private Double priceeach;
	private Short orderlinenumber;

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** minimal constructor */
	public Orderdetail(OrderdetailId id) {
		this.id = id;
	}

	/** full constructor */
	public Orderdetail(OrderdetailId id, Integer quantityordered,
			Double priceeach, Short orderlinenumber) {
		this.id = id;
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