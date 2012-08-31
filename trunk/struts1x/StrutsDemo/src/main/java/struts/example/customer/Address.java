/*
 * Created on Jun 29, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package struts.example.customer;

import java.io.Serializable;

/**
 * Address represents the Customer's Address.
 * It is Serializable since the CustomerForm could be potentially
 * placed in HttpSession. 
 * JSPs can use nested properties to display the objects
 * That way the ActionForms need not be flat anymore 
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class Address implements Serializable 
{
	
	private String address1;
	
	private String address2;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	/**
	 * @return
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @return
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param string
	 */
	public void setAddress1(String string) {
		address1 = string;
	}

	/**
	 * @param string
	 */
	public void setAddress2(String string) {
		address2 = string;
	}

	/**
	 * @param string
	 */
	public void setCity(String string) {
		city = string;
	}

	/**
	 * @param string
	 */
	public void setState(String string) {
		state = string;
	}

	/**
	 * @param string
	 */
	public void setZip(String string) {
		zip = string;
	}

}
