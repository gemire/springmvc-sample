/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp.test.server;

import static com.dhenton9000.example.tcp.test.server.TestingServer.EXIT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dhenton
 */
public class TestingServerTestCase {

    private static final Logger logger = LoggerFactory.getLogger(TestingServerTestCase.class);
    private TestingServer server = null;

    @Before
    public void beforeTest() throws Exception {
        server = new TestingServer();
        server.startServer();
    }

    @Test
    public void testSomething() throws Exception {
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;


        kkSocket = new Socket("localhost", server.getPortNumber());
        out = new PrintWriter(kkSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        String fromServer;
        out.println("EXIT");
        out.flush();
        boolean didExit = false;
        while ((fromServer = in.readLine()) != null) {
            assertEquals(EXIT,fromServer.toUpperCase().trim());
            int test = fromServer.toUpperCase().trim().indexOf(EXIT);
            if (test > -1)
            {
                didExit = true;
                break;
            }    
          }
        logger.info("client ending");
        assertTrue(didExit);
        out.close();
        in.close();
        kkSocket.close();
        
        
    }

    @After
    public void afterTest() throws Exception {
        server.killServer();
    }
}
