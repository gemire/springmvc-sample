package com.dhenton9000.hibernatetest.dataaccess;

import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dhenton9000.hibernatetest.generated.BankAccount;
import com.dhenton9000.hibernatetest.generated.BillingDetails;

public class DataAccessTest {

	private static Logger log = LogManager.getLogger(DataAccessTest.class);
	private static TestDAO instance = null;

	@BeforeClass
	public static void setUpClass() throws Exception {
		instance = TestDAO.getInstance();
	}

	/** * Method description TODO * * * @throws Exception */
	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	/** * Method description TODO * */
	@Before
	public void setUp() {
	}

	/** * Method description TODO * */
	@After
	public void tearDown() {
	}
	
	@Test
	public void testAddThing() throws Exception
	{
		
		BankAccount b = new BankAccount("John Smith", "123ASAA","US BANK222","Swift111");
		b.setBillingDetailsId(2);
		instance.saveOrUpdate(b);
		 
		
		BillingDetails bd = instance.getBillingDetails(2);
		 assertEquals("John Smith",bd.getName());
		
	}
	
	
	
	
}
