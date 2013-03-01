/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ws.sandbox.functional;

import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegisterResponse;
import com.dhenton9000.registration.bindings.RegistrationDetails;
import java.math.BigInteger;
import java.util.Calendar;
import org.junit.Test;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.client.LocalMuleClient;
import org.mule.api.transformer.TransformerException;
import org.mule.module.xml.transformer.jaxb.JAXBUnmarshallerTransformer;
import org.mule.tck.junit4.FunctionalTestCase;
import static org.junit.Assert.*;

/**
 *
 * @author dhenton
 */
public class SimpleFunctionalTest extends FunctionalTestCase {

    @Override
    protected String getConfigResources() {
         // return "test-mule-webservice.xml , fred.xml";
           return "test-mule-webservice.xml";
    }
    
    
    
     @Test
     public void testWebService() throws Exception
     {
         
            LocalMuleClient localMuleClient = this.muleContext.getClient();
            RegisterInput re = new RegisterInput();
            RegistrationDetails details = new RegistrationDetails();
            details.setMonths(BigInteger.valueOf(55L));
            details.setPaymentPlan("bozo");
            re.setName("fred");
            re.setPassword("ted");
            re.setRegistrationDate(Calendar.getInstance());
            re.setRegistrationDetails(details);

            MuleMessage mm = new DefaultMuleMessage(re, this.muleContext);
            MuleMessage reply = localMuleClient.send("vm://registrationWebClientDispatch", mm);
            JAXBUnmarshallerTransformer tr = (JAXBUnmarshallerTransformer) this.muleContext.getRegistry().get("stringToResponse");
            RegisterResponse response = null;
            try {
                response = (RegisterResponse) tr.transform(reply.getPayloadAsString());

            } catch (TransformerException ex) {
                logger.error("transformer problem " + ex.getMessage());
            }
            assertEquals("55",response.getResponseInformation());
           // logger.debug("From main the reply is '" + response.getResponseInformation()+"'");

     }
    
    
}
