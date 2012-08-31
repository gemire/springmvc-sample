/**
 * Please modify this class to meet your needs
 * This class is not complete
 */
package com.dhenton9000.registration.components.ws;

import com.dhenton9000.registration.bindings.RegisterResponse;
import com.dhenton9000.registration.components.Stax2DomBuilder;
import com.dhenton9000.xml.utils.XmlUtils;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.w3c.dom.Document;
import org.apache.log4j.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamReader;
import org.apache.log4j.LogManager;
import org.mule.DefaultMuleMessage;
import org.w3c.dom.Node;

/**
 * This is the class that will process the input from the web service
 * Since the mule web service is proxied a XMLStreamReader is what 
 * Mule sends in to this code. It strips the first node so if your webservice
 * is wrapped, then the Stax2DomBuilder DOES NOT have to add a node, but if 
 * your service is SOAPBinding.ParameterStyle.BARE, then you will have to add
 * it back in, as is the case here
 * @see{RegistrationServiceWSDL}
 * 
 * This code composes a response that is conformant to the wsdl via JAXB
 * @author dhenton
 */
public class RegistrationServiceProxy implements Callable {

    private static final Logger log = LogManager.getLogger(RegistrationServiceProxy.class);
    private String demoProperty = null;

    @Override
    public Object onCall(MuleEventContext context) throws Exception {

        XMLStreamReader reader = (XMLStreamReader) context.getMessage().getPayload();
        DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        //adding initial node for reconstruction of the input message
        Document doc = docBuild.newDocument();
        Node t = doc.createElement("RegisterInput");
        doc.appendChild(t);
        Stax2DomBuilder builder = new Stax2DomBuilder();
        builder.setIgnoreWhitespace(true);
        /*
         * this build call is used because mule strips the first node
         * so we have to add it back (see above) and then the builder will
         * add to that node, not the document
         */
        builder.build(reader, doc);
        RegisterResponse reg = new RegisterResponse();
        reg.setCurrentTime(Calendar.getInstance());
        reg.setPaymentDepartment("test");
        reg.setTotalCost(BigDecimal.valueOf(22.22d));
        reg.setResponseInformation("OK");

        /* contact the mule bus and place the document onto the bus */
        String path = "vm:/fileOutPath";
        DefaultMuleMessage dM = new DefaultMuleMessage(doc, context.getMuleContext());
        context.dispatchEvent(dM, path);
        
        return createAckResponse(reg);

    }

    private static Document createAckResponse(RegisterResponse o) throws ParserConfigurationException, JAXBException {

        Document doc = null;
        DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = docBuild.newDocument();
        JAXBContext context = JAXBContext.newInstance(RegisterResponse.class);
        context.createMarshaller().marshal(o, doc);
        return doc;
    }

    /**
     * @return the demoProperty
     */
    public String getDemoProperty() {
        return demoProperty;
    }

    /**
     * @param demoProperty the demoProperty to set
     */
    public void setDemoProperty(String demoProperty) {
        this.demoProperty = demoProperty;
    }
}
