/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp.functional;

import com.dhenton9000.example.tcp.test.server.TestingServer;
import org.junit.Test;
import org.mule.tck.junit4.FunctionalTestCase;
import static org.junit.Assert.*;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.api.registry.RegistrationException;
import org.mule.transport.NullPayload;
import static com.dhenton9000.example.tcp.test.server.TestingServer.*;
import org.junit.Ignore;

/**
 *
 * @author dhenton
 */
public class TcpProtocolClientTestCase extends FunctionalTestCase
{
    

    @Override
    protected String getConfigResources()
    {
        return "tcp-protocol-client-config.xml";
    }
    
    
    @Test
    public void testSomething() throws RegistrationException
    {
       // TestingServer t = muleContext.getRegistry().lookupObject(TestingServer.class);
       // logger.debug(t.toString());
       // assertNotNull(t);
        assertTrue(true);
    }
    
    
    
   

    @Test
    public void testMultipleSendsWithFailAfterExit() throws Exception {
         
        MuleClient client = muleContext.getClient();
 
        String message = "ted";
        MuleMessage result = null;
        result = client.send("tcpProtocolEndpoint", message+"\n", null);
        assertEquals(PREPEND+message,(String) result.getPayload());
        
        message = "EXIT";
        result = client.send("tcpProtocolEndpoint", message+"\n", null);
        assertEquals(message,(String) result.getPayload());
       
        logger.debug("beginning bonzo send");
        message = "bonzo";
        result = client.send("tcpProtocolEndpoint", message+"\n", null);
        logger.debug("finishing bonzo send");
        assertNotNull(result);
        assertNull(result.getExceptionPayload());
        assertTrue(result.getPayload() instanceof NullPayload);
        
        
        
        TestingServer t = muleContext.getRegistry().lookupObject(TestingServer.class);
        assertEquals(1,t.getConnections().get(0).getMessages().size()); 
    }
    
    
    @Test
    public void testMultipleSendsWithNewClient() throws Exception {
        MuleClient client = muleContext.getClient();
 
        String message = "ted";
        MuleMessage result = null;
        result = client.send("tcpProtocolEndpoint", message+"\n", null);
        assertEquals(PREPEND+message,(String) result.getPayload());
        
        message = "EXIT";
        result = client.send("tcpProtocolEndpoint", message+"\n", null);
        assertEquals(message,(String) result.getPayload());
       
        client = muleContext.getClient();
         
        message = "bonzo";
        result = client.send("tcpProtocolEndpoint", message+"\n", null);
        
        assertNotNull(result);
        assertNull(result.getExceptionPayload());
        assertFalse("got null from third call",result.getPayload() instanceof NullPayload);
        assertEquals(message,(String) result.getPayload());
        
        TestingServer t = muleContext.getRegistry().lookupObject(TestingServer.class);
        assertEquals(2,t.getConnections().get(0).getMessages().size()); 
    }
    

}
