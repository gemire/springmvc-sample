/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springwebservice;

/*
 * @(#)ClientDemoTest.java   2010-03-18
 *
 * All rights reserved.
 *
 */
import com.dhenton9000.football.generated.AllDefenders;
import com.dhenton9000.football.generated.AllDefendersResponse;
import com.dhenton9000.football.generated.ArrayOfString;
import com.dhenton9000.xml.utils.XMLUtils;
import junit.framework.Assert;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.ws.client.support.interceptor.WebServiceValidationException;

public class ClientDemoTestCase {

    private static final String stringSample =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
            + "<AllDefenders xmlns=\"http://footballpool.dataaccess.eu\">"
            + "<sCountryName>Germany</sCountryName></AllDefenders>";
    private static final String failSample =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
            + "<AllBozos xmlns=\"http://footballpool.dataaccess.eu\">"
            + "<sCountryBozo>Germany</sCountryBozo></AllBozos>";
    private static ClassPathXmlApplicationContext ctx = null;
    private static Logger log = LogManager.getLogger(ClientDemoTestCase.class);
    //private static WebServiceTemplate wtCastor = null;
    private static WebServiceTemplate wtJaxb = null;

    //~--- methods --------------------------------------------------------------
    /**
     * Method description TODO
     *
     *
     * @throws Exception
     */
    @BeforeClass
    public static void beforeClass()
            throws Exception {
        ctx = new ClassPathXmlApplicationContext("ws-spring.xml");
        wtJaxb = (WebServiceTemplate) ctx.getBean("webServiceTemplate");

    }

    /**
     * Calls the web service using xml payload and
     * checks that the returned result is a document
     * the returned document does not include soap headers
     * it is only the payload
     *
     */
    @Test
    public void testSendSourceAndReceiveToResult() {
        StreamSource source = new StreamSource(new StringReader(stringSample));
        StringWriter ww = new StringWriter();
        StreamResult result = new StreamResult(ww);

        wtJaxb.sendSourceAndReceiveToResult(source, result);

        try {
            XMLUtils.stringToDoc(ww.toString());
        } catch (Exception err) {
            Assert.fail("threw error " + err.getMessage());
        }

        log.debug("\n--------\n" + ww.toString() + "\n-------------\n");
    }

    /**
     * Calls the web service using full round trip marshalling
     * @throws Exception
     */
    @Test
    public void testFullMarshalling()
            throws Exception {
        AllDefenders aDef = new AllDefenders();
        aDef.setSCountryName("Germany");
        AllDefendersResponse aRep = (AllDefendersResponse) wtJaxb.marshalSendAndReceive(aDef);
        Assert.assertNotNull(aRep);
        ArrayOfString aString = aRep.getAllDefendersResult();
        Assert.assertTrue(aString.getString().size() > 2);
    }

    /**
     * Takes a jaxb object and makes the payload xml from it
     * tests marshalling/unmarshalling by itself
     * @throws Exception
     */
    @Test
    public void testMakingXMLFromClass()
            throws Exception {
        AllDefenders aDef = new AllDefenders();

        aDef.setSCountryName("Germany");

        StringWriter ww = new StringWriter();
        StreamResult result = new StreamResult(ww);

        wtJaxb.getMarshaller().marshal(aDef, result);
        Assert.assertEquals(stringSample, ww.toString());
        log.debug(ww.toString());
    }

    
    //@Test(expected=WebServiceValidationException)
    // apparently expected doesn't work for this kind of exception in netbeans
    /**
     * the validator will throw a WebServiceValidationException
     */
    public void failValidation() {
        StreamSource source = new StreamSource(new StringReader(failSample));
        StringWriter ww = new StringWriter();
        StreamResult result = new StreamResult(ww);
        boolean gotValidationError = false;
        try {
            wtJaxb.sendSourceAndReceiveToResult(source, result);
        } catch (WebServiceValidationException err) {
            gotValidationError = true;
        }

       Assert.assertTrue(gotValidationError);


    }
}
