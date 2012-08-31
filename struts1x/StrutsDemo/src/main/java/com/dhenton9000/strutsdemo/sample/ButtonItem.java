package com.dhenton9000.strutsdemo.sample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.tiles.beans.SimpleMenuItem;



public class ButtonItem extends SimpleMenuItem
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -372811606505078132L;

	private static Log LOG = LogFactory.getLog(ButtonItem.class.getName());

	private String showIfEqualProperty = "";
	private String showIfEqualValue = "";
	private boolean startNewLine = false;
	private boolean showIfErrors = true;
	private String role = "";
	private boolean alternatePreviousEnabled = false;

	public String getShowIfEqualProperty()
	{
		return showIfEqualProperty;
	}

	public String getShowIfEqualValue()
	{
		return showIfEqualValue;
	}

	public void setShowIfEqualProperty(String string)
	{
		showIfEqualProperty = string;
	}

	public void setShowIfEqualValue(String string)
	{
		showIfEqualValue = string;
	}

	public boolean isStartNewLine()
	{
		return startNewLine;
	}

	public void setStartNewLine(boolean b)
	{
		startNewLine = b;
	}

	public boolean isShowIfErrors()
	{
		return showIfErrors;
	}

	public void setShowIfErrors(boolean b)
	{
		showIfErrors = b;
	}

	public String getRole()
	{
		return role;
	}

	public void setRoles(String string)
	{
		role = string;
	}

	
	/**
	 * @return boolean
	 */
	public boolean isAlternatePreviousEnabled() {
		return alternatePreviousEnabled;
	}

	/**
	 * @param boolean b
	 */
	public void setAlternatePreviousEnabled(boolean b) {
		alternatePreviousEnabled = b;
	}

}
