/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.jersey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.apache.log4j.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dhenton
 */
public class JerseyFunctionalTest extends FunctionalTestCase {

    private static Logger log = LogManager.getLogger(JerseyFunctionalTest.class);
    private static final int BUF_SIZE = 1024;
    
    @Override
    protected String getConfigResources() {
        return "test-mule-config.xml";
    }

    /**
     *  this is failing so shows that there are some issues using Mule
     *  Client for Jersey endpoints
     * @throws MuleException 
     */
    public void testSendingMessage() throws Exception {
        final MuleClient muleClient = JerseyFunctionalTest.muleContext.getClient();
        if (muleClient == null) {
            throw new RuntimeException("mule client null ");
        }

        MuleMessage dM = new DefaultMuleMessage("/sayhello/zed", muleContext);
        MuleMessage z = muleClient.send("http://localhost:8500", dM);
        InputStream inS = (InputStream) z.getPayload();
        assertNotNull(z.getExceptionPayload());
        String reply = readInputStreamToString(inS);

    }

    private String readInputStreamToString(InputStream iS) throws IOException {
        InputStreamReader iSR = new InputStreamReader(iS);
        BufferedReader bR = new BufferedReader(iSR);
        StringBuilder ss = new StringBuilder(BUF_SIZE);

        char[] buf = new char[BUF_SIZE];
        int numRead = 0;
        while ((numRead = bR.read(buf)) != -1) {
            ss.append(buf, 0, numRead);
        }
        bR.close();
        return ss.toString();
    }

    public void testJerseyClient() throws Exception {
        Client jerseyClient = new Client();
        WebResource resource = jerseyClient.resource("http://localhost:8500/sayhello/");
        MediaType mediaType = MediaType.TEXT_PLAIN_TYPE;
        String reply = resource.path("fred").accept(mediaType).get(String.class);
        assertEquals("Hello fred", reply);
    }
    
    
    
    
    
}