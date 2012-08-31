package struts.example.customer.delegate;

import java.io.Serializable;

/**
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerSearchCriteria implements Serializable 
{

	private String lastName;
	
	public CustomerSearchCriteria(String theLastName)
	{
		this.lastName = theLastName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
}