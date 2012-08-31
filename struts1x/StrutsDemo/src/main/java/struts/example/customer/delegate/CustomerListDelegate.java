package struts.example.customer.delegate;

import struts.example.customer.list.CustomerListService;
import struts.example.customer.list.CustomerListServiceException;
import struts.example.customer.list.CustomerSummaryObject;

/**
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerListDelegate 
{

	public CustomerListDelegate() 
	{
	}

	public CustomerSummaryObject[] findCustomers(String lastName) throws CustomerListServiceException
	{
		//Generally a EJB lookup on ServiceLocator goes here.
		//For simplicity, Customer List Service is just a POJO in our case
		
		CustomerListService custListService = new CustomerListService();
		return custListService.findCustomers(lastName);
	}
}