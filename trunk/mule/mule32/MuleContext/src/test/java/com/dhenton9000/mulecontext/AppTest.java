package com.dhenton9000.mulecontext;

import javax.naming.NamingException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.mule.config.spring.jndi.DefaultSpringJndiContext;
import org.mule.config.spring.jndi.SpringInitialContextFactory;

/**
 * Unit test for simple App.
 * 
 * 
 *
 * 
 */
public class AppTest extends TestCase {

    private ApplicationContext context = null;
    private Logger log = LogManager.getLogger(AppTest.class);
    private DefaultSpringJndiContext jContext = null;
    

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    @Override
    public void setUp() {
        this.context = new ClassPathXmlApplicationContext("spring-jndi.xml");
       jContext  = (DefaultSpringJndiContext) context.getBean("jndi");
        
    }

    @Override
    public void tearDown() {
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testLoadingFile() throws Exception {

        
      String t = (String)  jContext.lookup("string/sampleString");
      assertEquals("Fred",t);

    }
}
