package com.dhenton9000.classic.dao.generated;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Purchaseorder entity. @author eclipse Persistence Tools
 */

public class Purchaseorder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5252607497966603025L;
	private Integer purchaseordernumber;
	private Customer customer;
	private Date orderdate;
	private Date requireddate;
	private Date shippeddate;
	private String status;
	private String comments;
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Purchaseorder() {
	}

	/** full constructor */
	public Purchaseorder(Customer customer, Date orderdate, Date requireddate,
			Date shippeddate, String status, String comments, Set orderdetails) {
		this.customer = customer;
		this.orderdate = orderdate;
		this.requireddate = requireddate;
		this.shippeddate = shippeddate;
		this.status = status;
		this.comments = comments;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Integer getPurchaseordernumber() {
		return this.purchaseordernumber;
	}

	public void setPurchaseordernumber(Integer purchaseordernumber) {
		this.purchaseordernumber = purchaseordernumber;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getRequireddate() {
		return this.requireddate;
	}

	public void setRequireddate(Date requireddate) {
		this.requireddate = requireddate;
	}

	public Date getShippeddate() {
		return this.shippeddate;
	}

	public void setShippeddate(Date shippeddate) {
		this.shippeddate = shippeddate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}