package com.dhenton9000;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dhenton9000.classiccars.vo.Office;
import com.dhenton9000.ibatis.dao.IClassicCarsDAO;

import junit.framework.TestCase;

/**
 * Unit test for Transaction demonstration.
 */
public class TransactionTests extends TestCase {
	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"transactionContext.xml");
	private static Logger log = LogManager.getLogger(TransactionTests.class);
	private IClassicCarsDAO dao = (IClassicCarsDAO) ctx.getBean("classicCarsDAO");
	
	public void testTransaction()
	{
		 log.debug("1 @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		 try {
			dao.transactionTestInsertOffice(null);
		} catch (Exception e) {
		 
		}
		 log.debug("2 @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		 
	}
	
	public void testGetOffice()
	{
		 log.debug("3 @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		 try {
			Office j = dao.getOfficeByCode("2");
			assertEquals("Boston",j.getCity());
		} catch (Exception e) {
		 
		}
		 log.debug("4 @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	}
	
}