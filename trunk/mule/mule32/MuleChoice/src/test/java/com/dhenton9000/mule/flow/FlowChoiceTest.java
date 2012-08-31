package com.dhenton9000.mule.flow;



import com.dhenton9000.registration.components.ws.RegisterResponse;
import java.math.BigInteger;
import com.dhenton9000.registration.components.ws.RegistrationDetails;
import com.dhenton9000.registration.components.ws.RegisterInput;
import com.dhenton9000.registration.components.ws.RegistrationServiceWSDL;
import java.net.URL;
import com.dhenton9000.registration.components.ws.RegistrationServiceWSDLClient;
import org.mule.tck.junit4.FunctionalTestCase;

import org.junit.Test;


import org.apache.log4j.*;
import static org.junit.Assert.*;

/**
 *
 * @author dhenton
 */
public class FlowChoiceTest extends FunctionalTestCase {

    private static final Logger log = LogManager.getLogger(FlowChoiceTest.class);
    

    @Override
    protected String getConfigResources() {
        //TODO You'll need to edit this file to make the test applicable to your module
        return "test-mule-config.xml";
    }

   //@Test
    public void testChoiceFlow() throws Exception {
        
        URL url = getClass().getClassLoader().getResource("RegistrationService.wsdl");
        RegistrationServiceWSDLClient client = new RegistrationServiceWSDLClient();
        RegistrationServiceWSDL cc =  client.getRegistrationServiceWSDLSOAP();
        RegisterInput input = new RegisterInput();
        input.setName("fred");
        input.setPassword("ted");
        RegistrationDetails rd =  new RegistrationDetails();
        rd.setMonths(new BigInteger("45"));
        input.setRegistrationDetails(rd);
        RegisterResponse reply = cc.register(input);
        assertEquals("ted",reply.getResponseInformation());
        
        /*
        MuleClient client = muleContext.getClient();
        log.debug("sending data in test '" + TEST_MESSAGE + "' ");
        MuleMessage result = client.send("vm://inFlow", TEST_MESSAGE, null);
        log.debug("got back " + result.getPayloadAsString());
        assertNotNull(result);
        assertNull(result.getExceptionPayload());
        assertFalse(result.getPayload() instanceof NullPayload);
        assertEquals("Test Message12xyzabc3", result.getPayloadAsString());
         */

    }
}