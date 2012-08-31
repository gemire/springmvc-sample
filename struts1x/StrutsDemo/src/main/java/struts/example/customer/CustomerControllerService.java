package struts.example.customer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import struts.example.customer.dao.CustomerDAO;
import struts.example.customer.dao.DAOException;
import struts.example.customer.dao.DAOFactory;
import struts.example.customer.dao.DuplicateCustomerException;
import struts.example.exception.ErrorLevel;

/**
 * In real projects, CustomerControllerService object is often implemented as Session EJB.
 * It represents a Business Service and is Session Facade pattern (Core J2EE Patterns) 
 * 
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerControllerService 
{

	public CustomerDetailObject getCustomerDetail(String emailAddress) throws CustomerServiceException
	{
		CustomerDetailObject customer = null;
		try
		{
			DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MS_ACCESS);
			CustomerDAO dao = daoFactory.getCustomerDAO();
			customer = dao.fetchDetail(emailAddress);
		}
		catch (DAOException de)
		{
			if (! de.isLogged())
			{
				Log log = LogFactory.getLog("CustomerFetchService");
				de.log(log);
			}
			throw new CustomerServiceException(de.getUserMessageKey(), 
									de.getValueReplacementArray(),
									de.getUniqueID(), 
									ErrorLevel.ERROR);
		}
		
		return customer;
	}
	
	public void createCustomer(CustomerDetailObject customer) throws CustomerServiceException, DuplicateCustomerException
	{
		try
		{
			customer.getAddress().setAddress1("N/A");
			customer.getAddress().setAddress2("N/A");
			DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MS_ACCESS);
			CustomerDAO dao = daoFactory.getCustomerDAO();
			dao.create(customer);
		}
		catch (DAOException de)
		{
			if (! de.isLogged())
			{
				Log log = LogFactory.getLog("CustomerInsertService");
				de.log(log);
			}
			throw new CustomerServiceException(de.getUserMessageKey(), 
									de.getValueReplacementArray(),
									de.getUniqueID(), 
									ErrorLevel.ERROR);
		}
	}

	public void updateCustomer(CustomerDetailObject customer) throws CustomerServiceException, DuplicateCustomerException
	{
		try
		{
			customer.getAddress().setAddress1("N/A");
			customer.getAddress().setAddress2("N/A");
			DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MS_ACCESS);
			CustomerDAO dao = daoFactory.getCustomerDAO();
			dao.update(customer);
		}
		catch (DAOException de)
		{
			if (! de.isLogged())
			{
				Log log = LogFactory.getLog("CustomerUpdateService");
				de.log(log);
			}
			throw new CustomerServiceException(de.getUserMessageKey(), 
									de.getValueReplacementArray(),
									de.getUniqueID(), 
									ErrorLevel.ERROR);
		}
	}
	
	public void deleteCustomer(int id) throws CustomerServiceException
	{
		try
		{
			DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MS_ACCESS);
			CustomerDAO dao = daoFactory.getCustomerDAO();
			dao.delete(id);
		}
		catch (DAOException de)
		{
			if (! de.isLogged())
			{
				Log log = LogFactory.getLog("CustomerDeleteService");
				de.log(log);
			}
			throw new CustomerServiceException(de.getUserMessageKey(), 
									de.getValueReplacementArray(),
									de.getUniqueID(), 
									ErrorLevel.ERROR);
		}
	}
	
}