package struts.example.customer.delegate;

import struts.example.customer.*;
import struts.example.customer.dao.DuplicateCustomerException;

/**
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerDelegate 
{

	public CustomerDetailObject getCustomerDetail(String emailAddress) throws CustomerServiceException
	{
		CustomerControllerService custService = new CustomerControllerService();
		return custService.getCustomerDetail(emailAddress);
	}
	
	public void createCustomer(CustomerDetailObject customer) throws CustomerServiceException, DuplicateCustomerException
	{
		CustomerControllerService custService = new CustomerControllerService();
		custService.createCustomer(customer);
	}

	public void updateCustomer(CustomerDetailObject customer) throws CustomerServiceException, DuplicateCustomerException
	{
		CustomerControllerService custService = new CustomerControllerService();
		custService.updateCustomer(customer);
	}
	
	public void deleteCustomer(int id) throws CustomerServiceException
	{
		CustomerControllerService custService = new CustomerControllerService();
		custService.deleteCustomer(id);
	}
}