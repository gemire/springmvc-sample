package struts.example.customer;

import java.io.Serializable;

/**
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerDetailObject implements Serializable 
{

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String emailAddress;

	private String preferredCarrier;
    
	private boolean receiveEmail;
    
	private Address address;
	
	/**
	 * @return
	 */
	public Address getAddress()
	{
		return address;
	}

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
	public int getId()
	{
		return id;
	}

	/**
	 * @return
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @return
	 */
	public String getPreferredCarrier()
	{
		return preferredCarrier;
	}

	/**
	 * @return
	 */
	public boolean getReceiveEmail()
	{
		return receiveEmail;
	}

	/**
	 * @param address
	 */
	public void setAddress(Address address)
	{
		this.address = address;
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
	 * @param i
	 */
	public void setId(int i)
	{
		id = i;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string)
	{
		lastName = string;
	}

	/**
	 * @param string
	 */
	public void setPreferredCarrier(String string)
	{
		preferredCarrier = string;
	}

	/**
	 * @param b
	 */
	public void setReceiveEmail(boolean b)
	{
		receiveEmail = b;
	}

	public String toString()
	{
		return "[CustomerDetailObject = firstName=" + firstName +
				", Last Name=" + lastName + ", Email=" + emailAddress + "]";
	}
}