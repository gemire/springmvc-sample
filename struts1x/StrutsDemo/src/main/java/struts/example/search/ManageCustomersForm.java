/*
 * Created on Jul 2, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package struts.example.search;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;

/**
 * @author vnszs
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ManageCustomersForm extends ActionForm 
{

	private String[] idSelections;
	
	private ImageButtonBean newButton;
	
	private ImageButtonBean deleteButton;
	
	public ManageCustomersForm() 
	{
		init();
	}

	protected void init()
	{
		idSelections = new String[] { "" };
		newButton = new ImageButtonBean();
		deleteButton = new ImageButtonBean();
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		init();
	}


	/**
	 * @return
	 */
	public ImageButtonBean getDeleteButton()
	{
		return deleteButton;
	}

	/**
	 * @return
	 */
	public String[] getIdSelections()
	{
		return idSelections;
	}

	/**
	 * @return
	 */
	public ImageButtonBean getNewButton()
	{
		return newButton;
	}

	/**
	 * @param strings
	 */
	public void setIdSelections(String[] strings)
	{
		idSelections = strings;
	}

}
