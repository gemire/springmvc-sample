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
public class InventoryServiceImpl
    extends AbstractDomPayloadEndpoint {

  public static String SCHEMA_NAME_SPACE = "http://dhenton9000.com/QuantityService/wsdl";

  private static Logger log = LogManager.getLogger(InventoryServiceImpl.class);

  //~--- fields ---------------------------------------------------------------

  private String schemaNameSpace = SCHEMA_NAME_SPACE;
  private String schemaPrefix = "inv";



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

    Document dd = createAckResponse("hello",true);
    return dd.getDocumentElement();
  }

 protected Document createAckResponse(String message, boolean success)
			throws ParserConfigurationException {
		Document document = null;
		DocumentBuilder docbuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		DOMImplementation domImpl = docbuilder.getDOMImplementation();

		if (message == null)
			message = "null";

		document = domImpl.createDocument(getSchemaNameSpace(),
				getSchemaPrefix() + ":InventoryResponse", null);

		Element ack = document.createElement(getSchemaPrefix()
				+ ":InventoryResponseAck");
		document.getDocumentElement().appendChild(ack);

		Element successNode = document.createElement(getSchemaPrefix()
				+ ":success");
		successNode.appendChild(document.createTextNode(success + ""));
		ack.appendChild(successNode);
		Element mNode = document.createElement(getSchemaPrefix() + ":Message");
		mNode.appendChild(document.createCDATASection(message));
		ack.appendChild(mNode);

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
