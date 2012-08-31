/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.components;

import com.dhenton9000.registration.bindings.RegisterResponse;
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
import org.apache.log4j.LogManager;
import org.mule.DefaultMuleMessage;

/**
 * This class illustrates that proxied cxf messages don't have to be a 
 * XMLStreamReader @link(RegistrationServiceProxy) though its not clear why
 * this yields a string this is used by the test-mule-client-proxy.xml mule
 * config
 * @author dhenton
 */
public class PermissionsChecker implements Callable {

    private static final Logger log = LogManager.getLogger(PermissionsChecker.class);

    @Override
    public Object onCall(MuleEventContext mec) throws Exception {

        log.debug("Pemissions checker #################\n");
        log.debug("payload " + mec.getMessage().getPayloadAsString());
        log.debug("payload class " + mec.getMessage().getPayload().getClass().getName());
        SecurityContext secContext = mec.getSession().getSecurityContext();
        if (secContext != null) {
            User user = (User) secContext.getAuthentication().getPrincipal();
            log.info("@@@@@@@ " + user.getUsername() + " " + user.getPassword());
            log.info("@@@@@@@ " + user.getAuthorities().size());
        } else {
            log.info("sec is null");
        }
        log.debug("Permissions Checker #################\n");

        String path = "vm:/fileOutPath";
        DefaultMuleMessage dM = new DefaultMuleMessage(mec.getMessage().getPayload(), mec.getMuleContext());
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
