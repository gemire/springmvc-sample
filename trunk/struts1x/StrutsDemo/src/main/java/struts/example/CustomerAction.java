package struts.example;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.example.customer.CustomerDetailObject;
import struts.example.customer.HourOfOperation;
import struts.example.customer.delegate.CustomerDelegate;

/**
 * CustomerAction handles all form submission requests for CustomerForm.
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class CustomerAction extends Action 
{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	ActionForward nextPage = mapping.findForward("gotoSearchPage");
		CustomerForm custForm = (CustomerForm) form;
        
        if (custForm.getCancel().isSelected()) 
        {
            System.out.println("Cancel Operation Performed");
        }
        else if (custForm.getSave().isSelected())
        {
        	//Print Hour of Operation
        	Iterator iter = custForm.getHourOfOperationList().iterator();
        	while (iter.hasNext())
        	{
        		HourOfOperation hop = (HourOfOperation) iter.next();
        		System.out.println(hop);
        	}
			CustomerDelegate delegate = new CustomerDelegate();
			CustomerDetailObject obj = 
					CustomerDetailAssembler.createCustomerDetail(custForm);
			if (custForm.getId() == 0)
			{
				delegate.createCustomer(obj);
			}
			else
			{
				delegate.updateCustomer(obj);
			}
        }
        return nextPage;
    }

}