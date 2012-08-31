package struts.example.customer;

import java.io.Serializable;

import struts.example.exception.ErrorLevel;
import struts.example.exception.LightweightBaseException;

public class CustomerServiceException extends LightweightBaseException
{
	/**
	 * @param userMessage
	 * @param anUniqueID
	 * @param anErrorLevel
	 */
	public CustomerServiceException(String userMessageKey, Serializable[] valueReplacementArray, String anUniqueID, ErrorLevel anErrorLevel)
	{
		super(userMessageKey, valueReplacementArray, anUniqueID, anErrorLevel);
	}
	
}