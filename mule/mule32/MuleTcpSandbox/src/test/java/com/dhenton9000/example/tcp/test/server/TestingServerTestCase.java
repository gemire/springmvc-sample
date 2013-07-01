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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author dhenton
 */
public class TestingServerTestCase {

    private static final Logger logger = LoggerFactory.getLogger(TestingServerTestCase.class);
    private static TestingServer server = null;
    private static final int DELAY = 1;

    @BeforeClass
    public static void beforeTest() throws Exception {
        server = new TestingServer();
        server.startServer();
              final CountDownLatch latch = new CountDownLatch(1);
        latch.await(DELAY, TimeUnit.SECONDS);
 
         logger.debug("!!!!! started server");

    }

    @Test
    public void testSimpleCall() throws Exception {
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        logger.debug("begin testSimpleCall");
        kkSocket = new Socket("localhost", server.getPortNumber());
        out = new PrintWriter(kkSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        String fromServer;
        out.println("EXIT");
        out.flush();
        boolean didExit = false;
        while ((fromServer = in.readLine()) != null) {

            int test = fromServer.toUpperCase().trim().indexOf(EXIT);
            if (test > -1) {
                didExit = true;
                break;
            }
        }
        out.close();
        in.close();
        kkSocket.close();
        logger.info("endSimpleCall");
        assertTrue(didExit);
        assertEquals(1, server.getConnections().size());
        assertEquals(0, server.getConnections().get(0).getMessages().size());

    }

    @Test
    public void testCallWithMessages() throws Exception {
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        logger.debug("begin testCallWithMessages");
        kkSocket = new Socket("localhost", server.getPortNumber());
        out = new PrintWriter(kkSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        out.println("Manny");
        out.println("Moe");
        out.println("Jack");
        out.flush();
        Thread.sleep(100L);
        out.close();
        in.close();
        kkSocket.close();
        assertEquals(1, server.getConnections().size());
        assertEquals(3, server.getConnections().get(0).getMessages().size());

    }

    @After
    public void afterTest() throws Exception {
        logger.debug("begin after test");
        try {
            server.resetServer();
        } catch (Exception err) {
            logger.error("after server error " + err.getClass().getName() + " " + err.getMessage());
        }
        logger.debug("!!!!! reset server");
        //Thread.sleep(100);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        server.killServer();
    }
}
