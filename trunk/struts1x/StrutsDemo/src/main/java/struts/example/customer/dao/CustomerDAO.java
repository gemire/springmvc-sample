package struts.example.customer.dao;

import struts.example.customer.CustomerDetailObject;
import struts.example.customer.list.CustomerSummaryObject;

/**
 * 
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public interface CustomerDAO 
{

	public CustomerDetailObject fetchDetail(String emailAddress) throws DAOException;
	
	public CustomerSummaryObject[] find(String lastName) throws DAOException;
		
	public int create(CustomerDetailObject customer) throws DAOException, DuplicateCustomerException;
	
	public void update(CustomerDetailObject customer) throws DAOException, DuplicateCustomerException;
	
	public void delete(int id) throws DAOException;

}