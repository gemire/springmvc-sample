package struts.example.search;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;

/**
 * CustomerSearchForm is the object representation of the html form for entering
 * customer search parameters.
 * 
 * @author Srikanth Shenoy
 * @version $Revision: $ $Date: $
 */
public class CustomerSearchForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String lastName = "";
	/** used to report the x, y location of the image button pretty useless here **/
	private ImageButtonBean searchButton;

	public CustomerSearchForm() {
		init();
	}
	
	
	protected void init()
	{
		lastName = "";
		searchButton = new ImageButtonBean();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String string) {
		lastName = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors at = new ActionErrors();
		if (lastName == null || lastName.trim().length() == 0)
		{
			
			ActionError eA = new ActionError("blank.lastname");
			at.add("lastname.problem", eA);
			return at;
		}
		
		return super.validate(mapping, request);
	}

	public void setSearchButton(ImageButtonBean searchButton) {
		this.searchButton = searchButton;
	}

	public ImageButtonBean getSearchButton() {
		return searchButton;
	}

	
	
	
}
