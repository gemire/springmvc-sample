/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration;

import com.dhenton9000.registration.bindings.RegisterResponse;
import com.dhenton9000.xml.utils.XmlUtils;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.mule.tck.FunctionalTestCase;
import org.w3c.dom.Node;
import org.apache.log4j.*;
import org.w3c.dom.Document;

/**
 *
 * @author dhenton
 */
public class StaxTest extends TestCase {

    private static final Logger log = LogManager.getLogger(StaxTest.class);

    /*
    extends FunctionalTestCase
    @Override
    protected String getConfigResources() {
    return "test-mule-webproxy.xml";
    }
     */
    public void testMarshall() throws Exception {
        RegisterResponse o = new RegisterResponse();
        o.setCurrentTime(Calendar.getInstance());
        o.setPaymentDepartment("test");
        o.setTotalCost(BigDecimal.valueOf(22.22d));
        o.setResponseInformation("OK");
        Document doc = marshallSample(o);
        String z = XmlUtils.docToString(doc);
        log.debug("\n" + z);
    }

    private static Document marshallSample(RegisterResponse o) throws ParserConfigurationException, JAXBException {


        Document doc = null;
        DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = docBuild.newDocument();
        JAXBContext context = JAXBContext.newInstance(RegisterResponse.class);
        context.createMarshaller().marshal(o, doc);


        return doc;
    }
}
