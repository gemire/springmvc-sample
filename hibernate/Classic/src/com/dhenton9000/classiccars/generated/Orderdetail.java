package com.dhenton9000.classiccars.generated;

/**
 * Orderdetail entity. @author eclipse Persistence Tools
 */
public class Orderdetail extends AbstractOrderdetail implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** minimal constructor */
	public Orderdetail(OrderdetailId id, Purchaseorder purchaseorder,
			Product product) {
		super(id, purchaseorder, product);
	}

	/** full constructor */
	public Orderdetail(OrderdetailId id, Purchaseorder purchaseorder,
			Product product, Integer quantityordered, Double priceeach,
			Short orderlinenumber) {
		super(id, purchaseorder, product, quantityordered, priceeach,
				orderlinenumber);
	}

}
