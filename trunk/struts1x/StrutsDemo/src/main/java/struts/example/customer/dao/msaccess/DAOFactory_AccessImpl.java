package struts.example.customer.dao.msaccess;

import struts.example.customer.dao.CustomerDAO;
import struts.example.customer.dao.DAOFactory;

/**
 * This is a implementation of Factory Method
 * 
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class DAOFactory_AccessImpl extends DAOFactory 
{

	public CustomerDAO getCustomerDAO() 
	{
		return new CustomerDAO_AccessImpl();
	}

}
