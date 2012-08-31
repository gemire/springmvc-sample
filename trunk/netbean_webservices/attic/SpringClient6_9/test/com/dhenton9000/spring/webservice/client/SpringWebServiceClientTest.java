/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.webservice.client;

import com.dhenton9000.utils.XMLUtils;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 *
 * @author dyh
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({})
public class SpringWebServiceClientTest {

    private static Logger log = LogManager.getLogger(SpringWebServiceClientTest.class);
    private static WebServiceTemplate wTemplate = null;
    private static ClassPathXmlApplicationContext ctx = null;

    @BeforeClass
    public static void setUpClass() throws Exception {

        ctx = new ClassPathXmlApplicationContext("ws-spring.xml");
        wTemplate = (WebServiceTemplate) ctx.getBean("webServiceTemplate");


    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetSomething() throws Exception {
        log.debug("begin test");

         String stringSample = "<wsdl:InventoryRequest xmlns:wsdl=\"http://dhenton9000.com/QuantityService/wsdl\"><wsdl:StyleData><wsdl:style>fred</wsdl:style><wsdl:color>ted</wsdl:color></wsdl:StyleData></wsdl:InventoryRequest>";



        StreamSource source = new StreamSource(new StringReader(stringSample));
        StringWriter ww = new StringWriter();
        StreamResult result = new StreamResult(ww);

        wTemplate.sendSourceAndReceiveToResult(source, result);

        try {
            XMLUtils.stringToDoc(ww.toString());
        } catch (Exception err) {
            Assert.fail("threw error " + err.getMessage());
        }
        String info = ww.toString();
        log.debug("\n--------\n" + info + "\n-------------\n");
        Assert.assertTrue(info.indexOf("true") > -1);


        log.debug("end test");
    }
}
