package struts.example.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 

import struts.example.customer.delegate.CustomerListDelegate;
import struts.example.customer.list.CustomerSummaryObject;

/**
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerSearchAction extends Action 
{
	private static Logger log = LogManager.getLogger(CustomerSearchAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ActionForward forward = null;
		CustomerSearchForm searchForm = (CustomerSearchForm) form;
		if (searchForm.getSearchButton().isSelected())
		{
			String info = "Customer Name: "+searchForm.getLastName();
			CustomerListDelegate delegate = new CustomerListDelegate();
			
			
			CustomerSearchMapping customerMapping = (CustomerSearchMapping) mapping;
			
			CustomerSummaryObject[] customers = delegate.findCustomers(searchForm.getLastName());
			if (customers != null)
			{
				info = info + " found count "+customers.length;
				customerMapping.setCustomers(customers);
			}
			else
			{
				customerMapping.setCustomers(null);
			}
			log.debug(info);
			
			
			forward = mapping.findForward("success");
		}
		
		return forward;
	}

}