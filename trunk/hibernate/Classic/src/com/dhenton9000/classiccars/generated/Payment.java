package com.dhenton9000.classiccars.generated;

import java.util.Date;

/**
 * Payment entity. @author eclipse Persistence Tools
 */
public class Payment extends AbstractPayment implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Payment() {
	}

	/** minimal constructor */
	public Payment(PaymentId id, Customer customer) {
		super(id, customer);
	}

	/** full constructor */
	public Payment(PaymentId id, Customer customer, Date paymentdate,
			Double amount) {
		super(id, customer, paymentdate, amount);
	}

}
