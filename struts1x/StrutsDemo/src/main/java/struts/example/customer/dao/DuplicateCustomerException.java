package struts.example.customer.dao;

import struts.example.exception.ErrorLevel;
import struts.example.exception.LightweightBaseException;

/**
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class DuplicateCustomerException extends LightweightBaseException 
{

	/**
	 * @param userMessage
	 * @param anUniqueID
	 * @param anErrorLevel
	 */
	public DuplicateCustomerException(String userMessageKey, String email, String anUniqueID, ErrorLevel anErrorLevel)
	{
		super(userMessageKey, null, anUniqueID, anErrorLevel);
		String[] vArray = { email };
		setValueReplacementArray(vArray);
	}
	
}
