package com.dhenton9000.classic.dao.generated;

import java.util.Date;

/**
 * Payment entity. @author eclipse Persistence Tools
 */

public class Payment implements java.io.Serializable {

	// Fields

	private PaymentId id;
	private Date paymentdate;
	private Double amount;

	// Constructors

	/** default constructor */
	public Payment() {
	}

	/** minimal constructor */
	public Payment(PaymentId id) {
		this.id = id;
	}

	/** full constructor */
	public Payment(PaymentId id, Date paymentdate, Double amount) {
		this.id = id;
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