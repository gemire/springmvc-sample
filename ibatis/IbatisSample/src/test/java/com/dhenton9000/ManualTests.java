package com.dhenton9000;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 
import com.dhenton9000.classiccars.vo.Office;
import com.dhenton9000.ibatis.dao.TransactedIClassicCarsDAO;


import junit.framework.TestCase;

/**
 * Unit test for Transaction demonstration.
 */
public class ManualTests extends TestCase {
	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"manualContext.xml");
	private static Logger log = LogManager.getLogger(ManualTests.class);
	private TransactedIClassicCarsDAO dao = (TransactedIClassicCarsDAO) ctx.getBean("transactionAwareClassicCarsDAO");
	
	 
	
   public void testTransactedManualInsert()
   {
	   dao.insertOfficeTransacted(new Office());
   }
	
}