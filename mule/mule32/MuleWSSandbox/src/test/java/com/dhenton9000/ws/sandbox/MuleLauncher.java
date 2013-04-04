/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ws.sandbox;

import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegisterResponse;
import com.dhenton9000.registration.bindings.RegistrationDetails;
import com.dhenton9000.registration.components.ws.RegistrationServiceWSDL;
import com.dhenton9000.registration.components.ws.RegistrationServiceWSDLClient;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.apache.log4j.*;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.client.LocalMuleClient;
import org.mule.api.transformer.Transformer;
import org.mule.api.transformer.TransformerException;
import org.mule.module.xml.transformer.jaxb.JAXBUnmarshallerTransformer;

/**
 *
 * @author dhenton
 */
public class MuleLauncher {

    private static final Logger log = LogManager.getLogger(MuleLauncher.class);

    public static void main(String[] args) {

        log.debug("starting launcher");

        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        try {

            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                    "test-mule-webservice.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
//            LocalMuleClient localMuleClient = context.getClient();
            context.start();
            Collection<Transformer> tt = context.getRegistry().getTransformers();
            RegisterInput re = new RegisterInput();
            RegistrationDetails details = new RegistrationDetails();
            details.setMonths(BigInteger.valueOf(55L));
            details.setPaymentPlan("@@@@@@@@@@@@@@@@@@@");
            re.setName("BONZO");
            re.setPassword("DOG");
            re.setRegistrationDate(Calendar.getInstance());
            re.setRegistrationDetails(details);
            RegistrationServiceWSDL port = RegistrationServiceWSDLClient.createPort();
            RegisterResponse reply = port.register(re);
  //          JAXBUnmarshallerTransformer tr = (JAXBUnmarshallerTransformer) context.getRegistry().get("stringToResponse");
            log.info("response " + reply.getResponseInformation());

            // context.stop();
            // context.dispose();
            // System.exit(0);


        } catch (Exception e) {
            String eInfo = "Error Class: " + e.getClass().getName() + "\n"
                    + "message: " + e.getMessage();
            log.error(eInfo);
        }

    }
}
