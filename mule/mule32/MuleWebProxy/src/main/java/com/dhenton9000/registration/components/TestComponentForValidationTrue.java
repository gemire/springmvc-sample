/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.components;

import com.dhenton9000.registration.bindings.RegisterResponse;
import com.dhenton9000.xml.utils.XmlUtils;
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
import org.apache.cxf.staxutils.DepthXMLStreamReader;
import org.codehaus.staxmate.dom.DOMConverter;
import org.w3c.dom.Node;

/**
 * This class illustrates that proxied cxf messages don't have to be a
 * XMLStreamReader @link(RegistrationServiceProxy) though its not clear why
 * this yields a string this is used by the test-mule-client-proxy.xml mule
 * config
 *
 * @author dhenton
 */
public class TestComponentForValidationTrue implements Callable {

    private static final Logger log = LogManager.getLogger(TestComponentForValidationTrue.class);

    @Override
    public Object onCall(MuleEventContext mec) throws Exception {

        log.debug("Testing #################\n");
        log.debug("payload class " + mec.getMessage().getPayload().getClass().getName());


        String p = null;
        try {
            p = mec.getMessage().getPayloadAsString();
        } catch (Exception err) {
            log.error("problem getting payload as string: " + err.getClass().getName() + "\n" + err.getMessage());
        }

        Document doc = null;
        String outInfo = null;
        try {
            DepthXMLStreamReader sr = (DepthXMLStreamReader) mec.getMessage().getPayload();
            XMLStreamReader reader = sr.getReader();
            DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            //adding initial node for reconstruction of the input message
            doc = docBuild.newDocument();

            Node t = doc.createElement("RegisterInput");
            doc.appendChild(t);
            Stax2DomBuilder builder = new Stax2DomBuilder();
            builder.setIgnoreWhitespace(true);
            builder.build(reader, doc);


            if (doc == null) {
                log.debug("doc null");
            } else {
                outInfo = XmlUtils.docToString(doc);
                log.debug("doc " + outInfo);
            }

        } catch (Exception err) {
            log.error("class cast: " + err.getClass().getName() + "\n" + err.getMessage());
        }


        log.debug("Testing #################\n");
//        SMOutputDocument doc = sf.createOutputDocument(new FileOutputStream("output.xml"));
//        doc.setIndentation("\n ", 1, 2); // for unix linefeed, 2 spaces per level    
//        // write doc like:    
//        SMOutputElement root = doc.addElement("elem1");    
//        root.addElement("element2").addCharacters("someData");    
//        doc.closeRoot(); 
//        

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
