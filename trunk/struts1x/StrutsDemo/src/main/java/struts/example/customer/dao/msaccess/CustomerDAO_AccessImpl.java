package struts.example.customer.dao.msaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import struts.example.customer.Address;
import struts.example.customer.CustomerDetailObject;
import struts.example.customer.dao.CustomerDAO;
import struts.example.customer.dao.DAOException;
import struts.example.customer.dao.DuplicateCustomerException;
import struts.example.customer.list.CustomerSummaryObject;
import struts.example.exception.ErrorLevel;

/**
 * CustomerDAO encapsulates data access and manipulation
 * It represents the Data Access Object (DAO) Pattern.
 * A DAO abstract the mechanisms of accessing and manipulating 
 * a persistence store such as database 
 * 
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerDAO_AccessImpl implements CustomerDAO
{

	protected static String DB_FIELDS = "EMAIL, FIRSTNAME, LASTNAME, PREFERRED_CARRIER, CAN_RECV_MAIL, ADDRESS1, ADDRESS2, CITY, STATE, ZIPCODE";
	
	protected static String SELECT_SQL = "SELECT ID, " + DB_FIELDS + " FROM CUSTOMER WHERE EMAIL = ?";
	
	protected static String SEARCH_SQL = "SELECT ID, " + DB_FIELDS + " FROM CUSTOMER WHERE LASTNAME = ? ORDER BY ID";
	
	protected static String INSERT_SQL = "INSERT INTO CUSTOMER ( " + DB_FIELDS + " ) " + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )" ;
	
	protected static String UPDATE_SQL = "UPDATE CUSTOMER SET EMAIL = ?, FIRSTNAME = ?, LASTNAME = ?, PREFERRED_CARRIER = ?, " +
											" CAN_RECV_MAIL = ?, ADDRESS1 = ?, ADDRESS2 = ?, CITY = ?, STATE = ?, ZIPCODE = ?" +
											" WHERE ID = ?";
	
	protected static String DELETE_SQL = "DELETE FROM CUSTOMER WHERE EMAIL = ?";

	protected static String DELETE_ID_SQL = "DELETE FROM CUSTOMER WHERE ID = ?";
	
	public CustomerDAO_AccessImpl()
	{
		
	}
	
	public CustomerDetailObject fetchDetail(String emailAddress) throws DAOException
	{
		PreparedStatement pStmt = null;
		Connection con = getConnection();
		CustomerDetailObject customer = null;
		try
		{
			pStmt = con.prepareStatement(SELECT_SQL);
			pStmt.setString(1, emailAddress);
			
			ResultSet rs = pStmt.executeQuery();
			if (rs.next())
			{
				customer = extractCustomerDetailObjectFromResultSet(rs);
			}
		}
		catch (SQLException se) 
		{
			String[] valueReplacementArray = { emailAddress };
			throw new DAOException(se, "error.database.fetch.customerdetail", 
									valueReplacementArray, ErrorLevel.ERROR);
		}
		finally
		{
			try { con.close(); } catch(SQLException sq) { }
		}
		
		return customer;
	}
	
	public CustomerSummaryObject[] find(String lastName) throws DAOException
	{
		PreparedStatement pStmt = null;
		Connection con = getConnection();
		CustomerSummaryObject customer = null;
		List list = new ArrayList();
		
		try
		{
			pStmt = con.prepareStatement(SEARCH_SQL);
			pStmt.setString(1, lastName);
			
			ResultSet rs = pStmt.executeQuery();
			while (rs.next())
			{
				customer = extractCustomerSummaryObjectFromResultSet(rs);
				list.add(customer);
			}
		}
		catch (SQLException se) 
		{
			String[] valueReplacementArray = { lastName };
			throw new DAOException(se, "error.database.fetch.customersummary", 
									valueReplacementArray, ErrorLevel.ERROR);
		}
		finally
		{
			try { con.close(); } catch(SQLException sq) { }
		}
		
		CustomerSummaryObject[] customers = null;
		if (list.size() > 0)
		{
			customers = (CustomerSummaryObject[]) list.toArray(new CustomerSummaryObject[list.size()]);
		}
		
		return customers;
	}
	
	public int create(CustomerDetailObject customer) throws DAOException, DuplicateCustomerException
	{
		int insertedRows = 0;
		PreparedStatement pStmt = null;
		Connection con = getConnection();
		try
		{
			CustomerDetailObject det = fetchDetail(customer.getEmailAddress());
			if (det != null)
			{
				throw new DuplicateCustomerException("error.database.customer.duplicate", 
													customer.getEmailAddress(), 
													null, ErrorLevel.WARNING);			
			}
			
			pStmt = con.prepareStatement(INSERT_SQL);
			pStmt.setString(1, customer.getEmailAddress());
			pStmt.setString(2, customer.getFirstName());
			pStmt.setString(3, customer.getLastName());
			pStmt.setString(4, customer.getPreferredCarrier());
			pStmt.setBoolean(5, customer.getReceiveEmail());
			pStmt.setString(6, customer.getAddress().getAddress1());
			pStmt.setString(7, customer.getAddress().getAddress2());
			pStmt.setString(8, customer.getAddress().getCity());
			pStmt.setString(9, customer.getAddress().getState());
			pStmt.setString(10, customer.getAddress().getZip());
			
			insertedRows = pStmt.executeUpdate();
		}
		catch (SQLException se) 
		{
			String[] valueReplacementArray = { customer.getEmailAddress() };
			throw new DAOException(se, "error.database.customer.save", 
									valueReplacementArray, ErrorLevel.ERROR);			
		}
		finally
		{
			try { con.close(); } catch(SQLException sq) { }
		}
		
		return insertedRows;
	}
	
	public void update(CustomerDetailObject customer) throws DAOException, DuplicateCustomerException
	{
		int updatedRows = 0;
		PreparedStatement pStmt = null;
		Connection con = getConnection();
		try
		{
			CustomerDetailObject det = fetchDetail(customer.getEmailAddress());
			if (det != null && det.getId() != customer.getId())
			{
				throw new DuplicateCustomerException("error.database.customer.duplicate", 
													customer.getEmailAddress(), 
													null, ErrorLevel.WARNING);			
			}

			pStmt = con.prepareStatement(UPDATE_SQL);
			pStmt.setString(1, customer.getEmailAddress());
			pStmt.setString(2, customer.getFirstName());
			pStmt.setString(3, customer.getLastName());
			pStmt.setString(4, customer.getPreferredCarrier());
			pStmt.setBoolean(5, customer.getReceiveEmail());
			pStmt.setString(6, customer.getAddress().getAddress1());
			pStmt.setString(7, customer.getAddress().getAddress2());
			pStmt.setString(8, customer.getAddress().getCity());
			pStmt.setString(9, customer.getAddress().getState());
			pStmt.setString(10, customer.getAddress().getZip());
			pStmt.setInt(11, customer.getId());
			
			updatedRows = pStmt.executeUpdate();
		}
		catch (SQLException se) 
		{
			String[] valueReplacementArray = { customer.getEmailAddress() };
			throw new DAOException(se, "error.database.customer.save", 
									valueReplacementArray, ErrorLevel.ERROR);									
		}
		finally
		{
			try { con.close(); } catch(SQLException sq) { }
		}		
	}
	
	public void delete(int id) throws DAOException
	{
		int updatedRows = 0;
		PreparedStatement pStmt = null;
		Connection con = getConnection();
		try
		{
			pStmt = con.prepareStatement(DELETE_ID_SQL);
			pStmt.setInt(1, id);
			updatedRows = pStmt.executeUpdate();
		}
		catch (SQLException se) 
		{
			String[] valueReplacementArray = { new Integer(id).toString() };
			throw new DAOException(se, "error.database.customer.delete", 
									valueReplacementArray, ErrorLevel.ERROR);									
		}
		finally
		{
			try { con.close(); } catch(SQLException sq) { }
		}
	}

	protected CustomerDetailObject extractCustomerDetailObjectFromResultSet(ResultSet rs) throws SQLException
	{
		CustomerDetailObject customer = new CustomerDetailObject();
		customer.setId(rs.getInt("ID"));
		customer.setEmailAddress(rs.getString("EMAIL"));
		customer.setFirstName(rs.getString("FIRSTNAME"));	
		customer.setLastName(rs.getString("LASTNAME"));
		customer.setPreferredCarrier(rs.getString("PREFERRED_CARRIER"));
		customer.setReceiveEmail(rs.getBoolean("CAN_RECV_MAIL"));
		
		Address address = new Address();
		address.setAddress1(rs.getString("ADDRESS1"));
		address.setAddress2(rs.getString("ADDRESS2"));
		address.setCity(rs.getString("CITY"));
		address.setState(rs.getString("STATE"));
		address.setZip(rs.getString("ZIPCODE"));
		
		customer.setAddress(address);
		return customer;
	}

	protected CustomerSummaryObject extractCustomerSummaryObjectFromResultSet(ResultSet rs) throws SQLException
	{
		CustomerSummaryObject customer = new CustomerSummaryObject();
		customer.setId(rs.getInt("ID"));
		customer.setEmailAddress(rs.getString("EMAIL"));
		customer.setFirstName(rs.getString("FIRSTNAME"));	
		customer.setLastName(rs.getString("LASTNAME"));
		
		return customer;
	}
	
	protected Connection getConnection() throws DAOException
	{
		Connection dbConnection = null;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Use this for detailed debugging: 
			//DriverManager.setLogStream(java.lang.System.out);
			dbConnection = DriverManager.getConnection("jdbc:odbc:STRUTS_TRAINING");
		}
		catch(ClassNotFoundException cfe)
		{
			throw new DAOException(cfe, "error.database.config", null, ErrorLevel.FATAL);									
		}
		catch (SQLException se)
		{
			throw new DAOException(se, "error.database.config", null, ErrorLevel.FATAL);
		}
		return dbConnection;
	}

	public static void main(String[] args)
	{
		try
		{
			CustomerDAO_AccessImpl dao = new CustomerDAO_AccessImpl();
			CustomerDetailObject cust = dao.fetchDetail("joe.moe@yahoo.com");
			System.out.println(cust);
		}
		catch (DAOException e)
		{
			Log log = LogFactory.getLog("CustomerDAO");
			e.log(log);
		}
	}
}