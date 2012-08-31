package struts.example.search;

import org.apache.struts.action.ActionMapping;

import struts.example.customer.list.CustomerSummaryObject;

public class CustomerSearchMapping extends ActionMapping{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4147790284023411765L;
	private CustomerSummaryObject[] customers = null;
	public void setCustomers(CustomerSummaryObject[] customers) {
		this.customers = customers;
	}
	public CustomerSummaryObject[] getCustomers() {
		return customers;
	}
	
	

}
