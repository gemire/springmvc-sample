package struts.example.customer.list;

import java.io.Serializable;

/**
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerSummaryObject implements Serializable 
{
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String emailAddress;
    	
	/**
	 * @return
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}

	/**
	 * @return
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @return
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param string
	 */
	public void setEmailAddress(String string)
	{
		emailAddress = string;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string)
	{
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string)
	{
		lastName = string;
	}

	/**
	 * @return
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param string
	 */
	public void setId(int i)
	{
		id = i;
	}

}