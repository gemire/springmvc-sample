package com.dhenton9000.classiccars.generated;

import java.util.Set;

/**
 * Product entity. @author eclipse Persistence Tools
 */
public class Product extends AbstractProduct implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String productname, String productline, String productscale,
			String productvendor, String productdescription,
			Integer quantityinstock, Double buyprice, Double msrp,
			Set orderdetails) {
		super(productname, productline, productscale, productvendor,
				productdescription, quantityinstock, buyprice, msrp,
				orderdetails);
	}

}
