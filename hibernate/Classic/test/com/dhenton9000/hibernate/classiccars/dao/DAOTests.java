package com.dhenton9000.hibernate.classiccars.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.dhenton9000.classiccars.dao.ExtPurchaseorderDAO;
import com.dhenton9000.classiccars.generated.Customer;
import com.dhenton9000.classiccars.generated.CustomerDAO;
import com.dhenton9000.classiccars.generated.Orderdetail;
import com.dhenton9000.classiccars.generated.Purchaseorder;
import com.dhenton9000.classiccars.generated.PurchaseorderDAO;
//import com.dhenton9000.classiccars.dao.ClassicCarsDAO;


public class DAOTests {

	private ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private static Log log = LogFactory.getLog(DAOTests.class);

	
	
	@Test
	  public void testCustomerSave() {

			CustomerDAO d = CustomerDAO.getFromApplicationContext(ctx);
			Customer c = new Customer();
			c.setCity("Memphis");
			c.setCustomername("John Schmoe");
			d.save(c);
			Assert.assertEquals(497, c.getCustomernumber());
			d.delete(c);
		//	c = d.findById(497);
		//	Assert.assertNull(c);

		}

	@Test
	public void testFindByCountry() {

		CustomerDAO d = CustomerDAO.getFromApplicationContext(ctx);
		List listresults = d.findByCity("Madrid");
		Assert.assertEquals(5, listresults.size());

	}
	
	@Test
	public void testGetInvoices()
	{
		ExtPurchaseorderDAO eD = ExtPurchaseorderDAO.getFromApplicationContext(ctx);
		List inv = eD.getPurchaseOrdersForCustomer(103);
		Assert.assertEquals(7,inv.size());
		Purchaseorder p = (Purchaseorder) inv.get(3);
		Set det = p.getOrderdetails();
		Orderdetail[] order_det = new Orderdetail[det.size()];
		det.toArray(order_det);
		Assert.assertNotNull(order_det[0]);
		Assert.assertEquals(4,order_det.length);
		
	}

	  	
	
	
/*
  
  public void testCustomerSave() {

		CustomerDAO d = CustomerDAO.getFromApplicationContext(ctx);
		Customer c = new Customer();
		c.setCity("Memphis");
		c.setCustomername("John Schmoe");
		d.save(c);
		Assert.assertEquals(497, c.getCustomernumber());
		d.delete(c);
		c = d.findById(497);
		Assert.assertNull(c);

	}
  
  
	@Test
	public void testCustomerMerge() {

		CustomerDAO d = CustomerDAO.getFromApplicationContext(ctx);
		Customer c = new Customer();
		c.setCity("Memphis");
		c.setCustomername("John Schmoe");
		Customer k = (Customer) d.merge(c);

		Assert.assertEquals(497, k.getCustomernumber());
		c = d.findById(497);
		d.delete(c);

		c = d.findById(497);
		Assert.assertNull(c);

	}
  
  
	@Test
	public void testInvoiceForCustomersUsingHSQL() {
		ClassicCarsDAO d = ClassicCarsDAO.getFromApplicationContext(ctx);
		List invList = d.getCustomerInvoices(103);
		Assert.assertEquals(7, invList.size());
		Object[] arr = (Object[]) invList.get(4);
		String t = (String) arr[9];
		Assert.assertEquals("1996 Moto Guzzi 1100i", t);

	}

	
	@Test(expected=org.hibernate.LazyInitializationException.class)
	public void getInvoicesViaGraph() {
		PurchaseorderDAO pDAO = PurchaseorderDAO.getFromApplicationContext(ctx);
		List poList = pDAO.findByCustomernumber(103);
		Assert.assertEquals(3, poList.size());
		Iterator iter = poList.iterator();

		while (iter.hasNext()) {
			Purchaseorder p = (Purchaseorder) iter.next();
			Set det = p.getOrderdetails();
			// this produces a lazyinitialization exception
			// if lazy=false is added to the set relation in purchaseorder.hbm.xml 
			// this error goes away
			
			Iterator dIter = det.iterator();
			while (dIter.hasNext()) {
				Orderdetail ordDet = (Orderdetail) dIter.next();
			}

		}

	}
	
	
	@Test
	public void testClassicCarsDAOGetInvoices() {
		ClassicCarsDAO d = ClassicCarsDAO.getFromApplicationContext(ctx);
		List invList = d.getInvoices(103);
		Assert.assertEquals(3,invList.size());
		Purchaseorder p = (Purchaseorder) invList.get(1);
		Set s = p.getOrderdetails();
		Assert.assertEquals(2,s.size());
		Orderdetail ordDet = (Orderdetail) s.toArray()[1];
		Assert.assertNotNull(ordDet.getProduct().getProductdescription());
		Assert.assertNotNull(ordDet.getProduct().getProductname());
		
		
		
		
	}
	*/
	
	

}
