package com.dhenton9000.classiccars.generated;

import java.util.Set;

/**
 * Customer entity. @author eclipse Persistence Tools
 */
public class Customer extends AbstractCustomer implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String customername, String contactlastname,
			String contactfirstname, String phone, String addressline1,
			String addressline2, String city, String state, String postalcode,
			String country, Integer salesrepemployeenumber, Double creditlimit,
			Set payments, Set purchaseorders) {
		super(customername, contactlastname, contactfirstname, phone,
				addressline1, addressline2, city, state, postalcode, country,
				salesrepemployeenumber, creditlimit, payments, purchaseorders);
	}

}
