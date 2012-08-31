/*
 * @(#)ClientDemoTest.java   2010-03-18
 *
 * Copyright (c) 2009-present, dhenton9000 Companies Inc.
 * All rights reserved.
 *
 * This is demo code using sample-ws-spring.xml for a now defunct
 * web service
 *
 * 
 */



package com.dhenton9000.spring.webservice.client;


//import com.dhenton9000.utils.dhenton9000XMLUtils;
//import com.dhenton9000.webtest.AllDefenders;
//import com.dhenton9000.webtest.AllDefendersResponse;
//import com.dhenton9000.webtest.ArrayOfString;

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


/**
 *
 * @author dyh
 */
public class ClientDemoTest {
    /*
  private static final String stringSample =
    "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
    "<AllDefenders xmlns=\"http://euro2008.dataaccess.eu\">" +
    "<sCountryName>Germany</sCountryName></AllDefenders>";
  private static ClassPathXmlApplicationContext ctx = null;
  private static Logger                         log = LogManager.getLogger(ClientDemoTest.class);
  private static WebServiceTemplate             wtCastor = null;
  private static WebServiceTemplate             wtJaxb = null;

  //~--- methods --------------------------------------------------------------



  @BeforeClass
  public static void beforeClass()
  throws Exception {
    ctx = new ClassPathXmlApplicationContext("ws-spring.xml");
    wtJaxb = (WebServiceTemplate) ctx.getBean("webServiceTemplate");
    wtCastor = (WebServiceTemplate) ctx.getBean("castorWebServiceTemplate");
  }



   * Calls the web service using xml payload and
   * checks that the returned result is a document
   * the returned document does not include soap headers
   * it is only the payload
   *

  @Test
  public void testSendSourceAndReceiveToResult() {
    StreamSource source = new StreamSource(new StringReader(stringSample));
    StringWriter ww = new StringWriter();
    StreamResult result = new StreamResult(ww);

    wtJaxb.sendSourceAndReceiveToResult(source, result);

    try {
      XMLUtils.stringToDoc(ww.toString());
    } catch ( Exception err ) {
      Assert.fail("threw error " + err.getMessage());
    }

    log.debug("\n--------\n" + ww.toString() + "\n-------------\n");
  }



   * Calls the web service using full round trip marshalling
   * @throws Exception

  @Test
  public void testFullMarshalling()
  throws Exception {
    AllDefenders aDef = new AllDefenders();

    aDef.setSCountryName("Germany");

    AllDefendersResponse aRep = (AllDefendersResponse) wtJaxb.marshalSendAndReceive(aDef);

    Assert.assertNotNull(aRep);

    ArrayOfString aString = aRep.getAllDefendersResult();

    Assert.assertEquals(7, aString.getString().size());
  }



   * Calls the web service using full round trip marshalling
   * @throws Exception

  @Test
  public void testFullMarshallingForCastor()
  throws Exception {
    AllDefenders aDef = new AllDefenders();

    aDef.setSCountryName("Germany");

    AllDefendersResponse aRep = (AllDefendersResponse) wtCastor.marshalSendAndReceive(aDef);

    Assert.assertNotNull(aRep);

    ArrayOfString aString = aRep.getAllDefendersResult();

    Assert.assertEquals(7, aString.getString().size());
  }



   * Takes a jaxb object and makes the payload xml from it
   * @throws Exception

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
     *
     */
}
