/*
 * Created on Jul 1, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package struts.example.customer.dao;

import java.io.Serializable;

import struts.example.exception.BaseException;
import struts.example.exception.ErrorLevel;

/**
 * @author vnszs
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DAOException extends BaseException
{

	public DAOException(Throwable aThrowable, String userMessageKey, Serializable[] valueReplacementArray, ErrorLevel level)
	{
		 super(aThrowable, userMessageKey, valueReplacementArray, level);
	}
}
