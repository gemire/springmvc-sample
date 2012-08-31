/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration;

import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.apache.log4j.*;

/**
 * This demo will pass the xml from the web service directly onto 
 * the bus, in this case, just a file endpoint. It appears to be the
 * payload="body" attribute that determines if it is a String or an 
 * XMLStreamReader
 * 
 * @author dhenton
 */
public class MuleLauncher {

    private static String soapSample =
            "<soapenv:Envelope xmlns:soapenv="
            + "\"http://schemas.xmlsoap.org/soap/envelope/\" "
            + "xmlns:uri=\"uri:dhenton9000:registrationService:ref\">"
            + "<soapenv:Header/>"
            + "   <soapenv:Body>"
            + "      <uri:RegisterInput>"
            + "         <uri:name>elephant</uri:name>"
            + "         <uri:password>bonzo</uri:password>"
            + "         <uri:registrationDetails>"
            + "            <uri:paymentPlan>Plan B</uri:paymentPlan>"
            + "            <uri:months>24</uri:months>"
            + "         </uri:registrationDetails>"
            + "         <uri:registrationDate>2010-01-01T12:00:00+01:00</uri:registrationDate>"
            + "      </uri:RegisterInput>"
            + "   </soapenv:Body>"
            + "</soapenv:Envelope>";
    private static final Logger log = LogManager.getLogger(MuleLauncher.class);

    public static void main(String[] args) {

        log.debug("starting launcher");

        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        try {

            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                    "test-mule-client-proxy-validate.xml");

            MuleContext context = muleContextFactory.createMuleContext(configBuilder);
            context.start();

            log.debug("finished");
            HttpTestUtils.doPost("mule-realm",
                    "localhost",
                    "username",
                    "password",
                    "http://localhost:8081/proxy",
                    true, soapSample, "text/xml", "UTF-8");
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
