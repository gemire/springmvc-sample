package com.dhenton9000.classiccars.generated;

import java.util.Date;
import java.util.Set;

/**
 * Purchaseorder entity. @author eclipse Persistence Tools
 */
public class Purchaseorder extends AbstractPurchaseorder implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Purchaseorder() {
	}

	/** full constructor */
	public Purchaseorder(Customer customer, Date orderdate, Date requireddate,
			Date shippeddate, String status, String comments, Set orderdetails) {
		super(customer, orderdate, requireddate, shippeddate, status, comments,
				orderdetails);
	}

}
