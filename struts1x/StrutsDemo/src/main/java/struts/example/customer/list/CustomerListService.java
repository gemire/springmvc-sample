package struts.example.customer.list;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import struts.example.customer.dao.CustomerDAO;
import struts.example.customer.dao.DAOException;
import struts.example.customer.dao.DAOFactory;
import struts.example.exception.ErrorLevel;

/**
 * CustomerListService provides the Service of Listing Customers.
 * It is also an example of Session Facade pattern.
 * In real projects, CustomerListService is implemented as Stateful Session EJB.
 * 
 * But this is kept seperate from the CustomerControllerService
 * The reason is that this Service uses ValueListHandler  (Another Core J2EE Pattern) 
 * to access the DAO and is of more stateful nature.
 * Seperating will prevent mingling of this stateful session faceade with 
 * otherwise stateless nature of CustomerControllerService
 * 
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerListService 
{

	public CustomerSummaryObject[] findCustomers(String lastName) throws CustomerListServiceException
	{
		CustomerSummaryObject[] customers = null;
		try
		{
			DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MS_ACCESS);
			CustomerDAO dao = daoFactory.getCustomerDAO();
			customers = dao.find(lastName);
		}
		catch (DAOException de)
		{
			if (! de.isLogged())
			{
				Log log = LogFactory.getLog("CustomerListService");
				de.log(log);
			}
			throw new CustomerListServiceException(de.getUserMessageKey(), 
									de.getValueReplacementArray(),
									de.getUniqueID(), 
									ErrorLevel.ERROR);
		}
		
		return customers;
	}

}