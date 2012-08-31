package struts.example;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import struts.example.customer.CustomerDetailObject;

public class CustomerDetailAssembler
{
	private CustomerDetailAssembler() { }

	public static final CustomerDetailObject createCustomerDetail(CustomerForm form)
	{
		CustomerDetailObject customer = new CustomerDetailObject();
		try
		{
			BeanUtils.copyProperties(customer, form);
			BeanUtils.copyProperties(customer.getAddress(), form.getAddress());
		}
		catch (InvocationTargetException ite)
		{
			ite.printStackTrace();	//do nothing for now
		}
		catch (IllegalAccessException iae)
		{
			iae.printStackTrace();	//do nothing for now
		}
		return customer;		
	}

}