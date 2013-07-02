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

/**
 *
 * @author dhenton
 */
public class TcpEofClientTestCase extends FunctionalTestCase
{
    

    @Override
    protected String getConfigResources()
    {
        return "tcp-eof-client-config.xml";
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
    public void testSampleTransmission() throws Exception {
        MuleClient client = muleContext.getClient();
        String message = "ted\nned\nfred\nEXIT\n";
        MuleMessage result = null;
        result = client.send("tcpendpoint", message, null);
        

        assertNotNull(result);
        assertNull(result.getExceptionPayload());
        assertFalse(result.getPayload() instanceof NullPayload);

        // Assert that the expected payload has been received.
        String z = (String) result.getPayload();
        assertTrue(z instanceof String);
        logger.debug("@@@@@@ "+z);
        
       // String dataObject = (String) result.getPayload();

       // Assert id returned as expected  
       // assertEquals(PREPEND+message, dataObject);
        
        TestingServer t = muleContext.getRegistry().lookupObject(TestingServer.class);
        assertEquals(3,t.getConnections().get(0).getMessages().size()); 
    }

    @Test
    public void testMultipleSends() throws Exception {
        MuleClient client = muleContext.getClient();
        String message = "ted\n";
        MuleMessage result = null;
        client.send("tcpendpoint", message, null);
        message = "EXIT\n";
        result = client.send("tcpendpoint", message, null);
        

        assertNotNull(result);
        assertNull(result.getExceptionPayload());
        assertFalse(result.getPayload() instanceof NullPayload);

        // Assert that the expected payload has been received.
        assertTrue(result.getPayload() instanceof String);

        String dataObject = (String) result.getPayload();
        assertEquals(message, dataObject);
       // Assert id returned as expected (note: Echo increments id by 1)
       // assertEquals(PREPEND+message, dataObject);
        
        TestingServer t = muleContext.getRegistry().lookupObject(TestingServer.class);
        assertEquals(1,t.getConnections().get(0).getMessages().size()); 
    }

}
