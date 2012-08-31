package com.dhenton9000;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dhenton9000.classiccars.parms.CountryStateParameter;
import com.dhenton9000.classiccars.vo.Customer;
import com.dhenton9000.classiccars.vo.Office;
import com.dhenton9000.classiccars.vo.OfficeWithEmployees;
import com.dhenton9000.ibatis.dao.ClassicCarsDAO;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class NonTransactionTests extends TestCase {
	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private static Logger log = LogManager.getLogger(NonTransactionTests.class);
	private ClassicCarsDAO dao = (ClassicCarsDAO) ctx.getBean("classicCarsDAO");

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public NonTransactionTests(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(NonTransactionTests.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testAllOffices() {
		log.debug("test");
		List<Office> offices = dao.getAllOffices();

		assertEquals(7, offices.size());
		Office a = offices.get(0);

	}

	public void testOfficeWithEmployees() {
		OfficeWithEmployees oF = dao.getOfficeByCodeWithEmployees("2");
		assertEquals(2, oF.getEmployees().size());

	}

	public void testCustomerByCountryState() {
		CountryStateParameter parms = new CountryStateParameter();
		parms.setCountry("USA");
		parms.setState("MA");
		List<Customer> customerList = dao.getCustomerByCountryState(parms);
		assertEquals(9, customerList.size());
		Customer c = customerList.get(3);
		assertEquals("Patterson", c.getSalesrep().getLastname());

	}
	
	
	public void testAddOffice()
	{
		Office newOffice = new Office();
		String oCode = "25";
		String add1  = "1001 N Main";
		newOffice.setOfficecode(oCode);
		newOffice.setAddressline1(add1);

		// add the office
		dao.addOffice(newOffice);

		
		//check that it got in
		Office v = dao.getOfficeByCode(oCode);
		assertEquals(add1,v.getAddressline1());
		
		// delete it
		dao.deleteOffice(oCode);
		v = dao.getOfficeByCode(oCode);
		assertNull(v);
		
		
	}
	
	
	
	

}
