/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.components;

import com.dhenton9000.registration.bindings.RegisterResponse;
import com.dhenton9000.xml.utils.XmlUtils;
import java.io.FileOutputStream;
import org.mule.api.security.SecurityContext;
import org.springframework.security.core.userdetails.User;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.w3c.dom.Document;
import org.apache.log4j.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import org.apache.log4j.LogManager;
import org.codehaus.staxmate.SMOutputFactory;
import org.codehaus.staxmate.out.SMOutputDocument;
import org.codehaus.staxmate.out.SMOutputElement;
import org.mule.DefaultMuleMessage;
import javax.xml.stream.XMLStreamWriter;
import org.apache.cxf.staxutils.DepthXMLStreamReader;
import org.codehaus.staxmate.dom.DOMConverter;

/**
 * This class illustrates that proxied cxf messages don't have to be a
 * XMLStreamReader @link(RegistrationServiceProxy) though its not clear why
 * this yields a string this is used by the test-mule-client-proxy.xml mule
 * config
 *
 * @author dhenton
 */
public class TestComponentForNoValidation implements Callable {

    private static final Logger log = LogManager.getLogger(TestComponentForNoValidation.class);

    @Override
    public Object onCall(MuleEventContext mec) throws Exception {

        log.debug("Testing #################\n");
        log.debug("payload class " + mec.getMessage().getPayload().getClass().getName());


        String p = null;
        try {
            p = mec.getMessage().getPayloadAsString();
            log.debug("payload as string\n"+p);
        }
         catch (Exception err) {
            log.error("problem getting payload as string: " + err.getClass().getName() + "\n" + err.getMessage());
        }

        Document doc = XmlUtils.stringToDoc(p);

        log.debug("Testing #################\n");
     

        String path = "vm:/fileOutPath";
        DefaultMuleMessage dM = new DefaultMuleMessage(doc, mec.getMuleContext());
        mec.dispatchEvent(dM, path);
        RegisterResponse reg = new RegisterResponse();
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
}
