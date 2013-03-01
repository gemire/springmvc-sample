/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ws.sandbox.functional;
import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegisterResponse;
import com.dhenton9000.registration.bindings.RegistrationDetails;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.client.LocalMuleClient;
import org.mule.api.transformer.TransformerException;
import org.mule.module.xml.transformer.jaxb.JAXBUnmarshallerTransformer;
import org.mule.tck.AbstractServiceAndFlowTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This class uses the AbstractServiceAndFlowTestCase
 * @author dhenton
 */
public class WSSandboxFunctionalTest extends AbstractServiceAndFlowTestCase {
    private final Logger logger = LoggerFactory.getLogger(WSSandboxFunctionalTest.class);
    public WSSandboxFunctionalTest(ConfigVariant variant, String configResources) {
        super(variant, configResources);
    }
    /*
     * this appears to run the test for each item below
     * most likely used to comparision test services to flows
     * each file is probably minimal flow/service for comparison
     */
    
    @Parameters
    public static Collection<Object[]> parameters()
    {
        return Arrays.asList(new Object[][]{
            
            {ConfigVariant.FLOW, "test-mule-webservice.xml"}
            
        
        });
    }
     @Override
    protected void doSetUp() throws Exception
    {
        super.doSetUp();

//        FunctionalTestComponent testComponent = getFunctionalTestComponent("test validator");
//        testComponent.setEventCallback(new EventCallback()
//        {
//            @Override
//            public void eventReceived(MuleEventContext context, Object component) throws Exception
//            {
//                receiveLatch.countDown();
//            }
//        });
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
