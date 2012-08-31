/*
 * @(#)QuantityServiceImpl.java   2010-03-18
 *
 *
 */



package com.dhenton9000.spring.webservice;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 *
 * @author dyh
 */
public class QuantityServiceImpl
    extends AbstractDomPayloadEndpoint {

  public static String SCHEMA_NAME_SPACE = "http://dhenton9000.com/QuantityService/wsdl";

  private static Logger log = LogManager.getLogger(QuantityServiceImpl.class);

  //~--- fields ---------------------------------------------------------------

  private String schemaNameSpace = SCHEMA_NAME_SPACE;
  private String schemaPrefix = "qty";



  //~--- methods --------------------------------------------------------------

  @Override
  protected Element invokeInternal(
      Element elmnt,
      Document dcmnt
  )
  throws Exception {
    log.debug("got to this");

    if (dcmnt != null && dcmnt.getDocumentElement() != null)
        log.debug("document inbound -->"+dcmnt.getDocumentElement().getTagName());
    else
        log.debug("inbound doc is null");
    if (elmnt != null)
        log.debug("Element inbound-->"+elmnt.getTagName());
    else
        log.debug("inbound element is null");

    Document dd = createQuantityResponse(5);
    return dd.getDocumentElement();
  }

  protected Document createQuantityResponse(
      int qty
  )
  throws ParserConfigurationException {
    Document          document = null;
    DocumentBuilder   docbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    DOMImplementation domImpl = docbuilder.getDOMImplementation();



    document = domImpl.createDocument(getSchemaNameSpace(),
                                      getSchemaPrefix() + ":QuantityResponse", null);

    Element ack = document.createElement(getSchemaPrefix() + ":quantity");

    document.getDocumentElement().appendChild(ack);



    ack.appendChild(document.createTextNode(qty + ""));




    return document;
  }


  /**
   * @return the schemaPrefix
   */
  public String getSchemaPrefix() {
    return schemaPrefix;
  }


  /**
   * @param schemaPrefix the schemaPrefix to set
   */
  public void setSchemaPrefix(
      String schemaPrefix
  ) {
    this.schemaPrefix = schemaPrefix;
  }


  /**
   * @return the schemaNameSpace
   */
  public String getSchemaNameSpace() {
    return schemaNameSpace;
  }


  /**
   * @param schemaNameSpace the schemaNameSpace to set
   */
  public void setSchemaNameSpace(
      String schemaNameSpace
  ) {
    this.schemaNameSpace = schemaNameSpace;
  }
}
