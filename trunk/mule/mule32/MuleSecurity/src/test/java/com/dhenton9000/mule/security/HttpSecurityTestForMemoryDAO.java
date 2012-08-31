/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.security;

import org.mule.tck.FunctionalTestCase;
 
/**
 *
 * @author dhenton
 */
public class HttpSecurityTestForMemoryDAO extends FunctionalTestCase {
    
 
    @Override
    protected String getConfigResources()
    {
        return "security-flow-memory.xml";
    }
    
   
    public void testOKAuthentication() throws Exception
    {
        int status = HttpTestUtils.doGet("mule-realm", "127.0.0.1",
                "username", "password", "http://127.0.0.1:9081/services/security", true);
        assertEquals(200,status);
    }
    
   public void testAuthenticationFailureBadCredentialsGet() throws Exception
    {
        int status = HttpTestUtils.doGet("mule-realm", "127.0.0.1",
                "username", "zzzzzzzz", "http://127.0.0.1:9081/services/security", true);
         assertEquals(401,status);
    }
    

}
