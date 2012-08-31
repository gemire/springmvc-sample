/*
 * Created on Jul 1, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package struts.example.customer.list;

import java.io.Serializable;

import struts.example.exception.ErrorLevel;
import struts.example.exception.LightweightBaseException;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerListServiceException extends LightweightBaseException
{
	
	public CustomerListServiceException(String userMessageKey, Serializable[] aValueReplacementArray, String aUniqueID, ErrorLevel anErrorLevel)
	{
		super(userMessageKey, aValueReplacementArray, aUniqueID, anErrorLevel);
	}

}