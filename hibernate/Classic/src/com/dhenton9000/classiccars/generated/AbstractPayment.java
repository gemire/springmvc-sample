package com.dhenton9000.classiccars.generated;

import java.util.Date;

/**
 * AbstractPayment entity provides the base persistence definition of the
 * Payment entity. @author eclipse Persistence Tools
 */

public abstract class AbstractPayment implements java.io.Serializable {

	// Fields

	private PaymentId id;
	private Customer customer;
	private Date paymentdate;
	private Double amount;

	// Constructors

	/** default constructor */
	public AbstractPayment() {
	}

	/** minimal constructor */
	public AbstractPayment(PaymentId id, Customer customer) {
		this.id = id;
		this.customer = customer;
	}

	/** full constructor */
	public AbstractPayment(PaymentId id, Customer customer, Date paymentdate,
			Double amount) {
		this.id = id;
		this.customer = customer;
		this.paymentdate = paymentdate;
		this.amount = amount;
	}

	// Property accessors

	public PaymentId getId() {
		return this.id;
	}

	public void setId(PaymentId id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getPaymentdate() {
		return this.paymentdate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}