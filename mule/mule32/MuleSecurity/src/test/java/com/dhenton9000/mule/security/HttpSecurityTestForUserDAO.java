/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.security;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.client.LocalMuleClient;
import org.mule.tck.FunctionalTestCase;
import org.apache.log4j.*;
import org.mule.api.MuleContext;
import org.mule.api.transport.PropertyScope;
import org.mule.transport.http.HttpConnector;

/**
 *
 * @author dhenton
 */
public class HttpSecurityTestForUserDAO extends FunctionalTestCase {
private static final Logger log = LogManager.getLogger(HttpSecurityTestForUserDAO.class);
private MuleContext context = null;
    @Override
    protected String getConfigResources() {
        return "security-flow-userdao.xml";
    }
    @Override
    protected MuleContext createMuleContext() throws Exception
    {
        context = super.createMuleContext();
        return context;
    }

    public void testWithMuleClient() throws Exception {
        LocalMuleClient client = context.getClient();
        MuleMessage mm = new DefaultMuleMessage("bite", context);
        MuleMessage mR = client.send("http://username:password@localhost:9081/services/security", mm);
        
       //log.debug("QQQQQ "+mR.getPropertyNames());
       //http.request, http.version, Date, MULE_ENCODING, Content-Length, http.method, Expires, Keep-Alive, http.status, Content-Type, Connection, Server 
       // log.debug("status "+HttpConnector.HTTP_STATUS_PROPERTY+" "+mR.getProperty(HttpConnector.HTTP_STATUS_PROPERTY));
      //  log.debug("length "+mR.getProperty("Content-Length"));
        for (String t:mR.getPropertyNames(PropertyScope.INBOUND))
        {
            log.debug(t+ "-- "+mR.getProperty(t, PropertyScope.INBOUND));
        }
        assertEquals(200+"", mR.getProperty(HttpConnector.HTTP_STATUS_PROPERTY,PropertyScope.INBOUND));
    }

    public void testOKAuthentication() throws Exception {
        int status = HttpTestUtils.doGet("mule-realm", "127.0.0.1",
                "username", "password", "http://127.0.0.1:9081/services/security", true);
        assertEquals(200, status);
    }

    public void testAuthenticationFailureBadCredentialsGet() throws Exception {
        int status = HttpTestUtils.doGet("mule-realm", "127.0.0.1",
                "username", "zzzzzzzz", "http://127.0.0.1:9081/services/security", true);
        assertEquals(401, status);
    }
}
