package com.dhenton9000.classic.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.classic.dao.generated.Customer;
import com.dhenton9000.classic.dao.generated.Employee;
import com.dhenton9000.classic.dao.generated.Office;
import com.dhenton9000.classic.generic.dao.GenericHibernateDAO;


import junit.framework.TestCase;

public class DAOTests extends TestCase {
	private static Logger log = LogManager.getLogger(DAOTests.class);
	private ClassicCarsDAO dao = ClassicCarsDAO.getInstance();
	
	
	public void testFindById() 
	{
		Customer c = (Customer) dao.findById(new Integer(168), Customer.class);
		assertNotNull(c);
		log.debug(c.getCity());
		assertEquals("New Haven",c.getCity());
	}
	
	public void testFindByExample() 
	{
		
		Office offTest = new Office();
		offTest.setCountry("USA");
		List offices = (List) dao.findByExample(offTest);
		assertNotNull(offices);
		Office o = (Office) offices.get(0);
		assertEquals("USA",o.getCountry());
		assertEquals(3,offices.size());
		 
	}
	
	
	public void testFindByProperty() 
	{
		
		 
		List offices = (List) dao.findByProperty("country", "USA", Office.class);
		assertNotNull(offices);
		Office o = (Office) offices.get(0);
		assertEquals("USA",o.getCountry());
		assertEquals(3,offices.size());
		 
	}
	
	
	public void testMergeAndDelete() 
	{
		Employee o = new Employee();
		String name = "zimbo";
		o.setLastname(name);
		Object o2  =  dao.merge(o);
		
		assertFalse(o==o2);
		assertTrue(o.equals(o2));
		
		Employee e = (Employee) o2;
		Employee e2 = (Employee) dao.findById(e.getEmployeenumber(), e.getClass());
		assertTrue(e2.equals(e));
		
		Integer evar = e.getEmployeenumber();
		o = new Employee();
		o.setLastname(name);
		assertEquals(name,e2.getLastname());
		assertEquals(evar.intValue(),e2.getEmployeenumber().intValue());
		List empList = dao.findByExample(o);
		
		Employee e3 = (Employee) empList.get(0);
		assertEquals(evar.intValue(),e3.getEmployeenumber().intValue());
	 
		
		dao.deleteByExample(o);

		
	}
	
}
