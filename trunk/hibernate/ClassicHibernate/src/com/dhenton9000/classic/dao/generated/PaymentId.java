package com.dhenton9000.classic.dao.generated;

/**
 * PaymentId entity. @author eclipse Persistence Tools
 */

public class PaymentId implements java.io.Serializable {

	// Fields

	private Customer customer;
	private String checknumber;

	// Constructors

	/** default constructor */
	public PaymentId() {
	}

	/** full constructor */
	public PaymentId(Customer customer, String checknumber) {
		this.customer = customer;
		this.checknumber = checknumber;
	}

	// Property accessors

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getChecknumber() {
		return this.checknumber;
	}

	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PaymentId))
			return false;
		PaymentId castOther = (PaymentId) other;

		return ((this.getCustomer() == castOther.getCustomer()) || (this
				.getCustomer() != null
				&& castOther.getCustomer() != null && this.getCustomer()
				.equals(castOther.getCustomer())))
				&& ((this.getChecknumber() == castOther.getChecknumber()) || (this
						.getChecknumber() != null
						&& castOther.getChecknumber() != null && this
						.getChecknumber().equals(castOther.getChecknumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCustomer() == null ? 0 : this.getCustomer().hashCode());
		result = 37
				* result
				+ (getChecknumber() == null ? 0 : this.getChecknumber()
						.hashCode());
		return result;
	}

}