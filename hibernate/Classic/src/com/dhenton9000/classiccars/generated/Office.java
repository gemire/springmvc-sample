package com.dhenton9000.classiccars.generated;

import java.util.Set;

/**
 * Office entity. @author eclipse Persistence Tools
 */
public class Office extends AbstractOffice implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Office() {
	}

	/** full constructor */
	public Office(String city, String phone, String addressline1,
			String addressline2, String state, String country,
			String postalcode, String territory, Set employees) {
		super(city, phone, addressline1, addressline2, state, country,
				postalcode, territory, employees);
	}

}
