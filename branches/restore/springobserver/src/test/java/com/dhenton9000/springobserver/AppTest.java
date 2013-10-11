package com.dhenton9000.springobserver;


import com.dhenton9000.springobserver.residents.TownResident;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 * 
 * http://www.theserverside.com/news/1364408/Spring-Loaded-Observer-Pattern
 *
 * 
 */
public class AppTest extends TestCase {

    private ApplicationContext context = null;
    private Logger log = LogManager.getLogger(AppTest.class);

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
        this.context = new ClassPathXmlApplicationContext("spring-config.xml");
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

    public void testLoadingFile() {
        log.debug("bite me");
        assertTrue(true);
    }
    
    
    public void testWiring()
    {
        TownCrier crier = (TownCrier) context.getBean("townCrier");
        final String sampleMessage = "bite me";
        crier.setMessage(sampleMessage);
        TownResident res = (TownResident) crier.getTownResidents().get(0);
        assertEquals("Hello, I am Elmo, and I got the message '"+sampleMessage+"'",res.getResponse());
        
    }
}
