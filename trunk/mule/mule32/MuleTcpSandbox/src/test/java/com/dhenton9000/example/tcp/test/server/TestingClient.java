/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp.test.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.lang.StringUtils;
import static com.dhenton9000.example.tcp.test.server.TestingServer.EXIT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class TestingClient {
     private static final Logger logger = LoggerFactory.getLogger(TestingClient.class);
   
       public static void main(String[] args) throws IOException {

        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            kkSocket = new Socket("localhost", 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            logger.error("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            logger.error("Couldn't get I/O for the connection");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;
        out.println("get a job");
        out.flush();
        while ((fromServer = in.readLine()) != null) {
            logger.debug("Server: " + fromServer);
            int test = fromServer.toUpperCase().trim().indexOf(EXIT);
            logger.debug("'"+fromServer.toUpperCase().trim()+"' "+test);
            if (test > -1)
            {
                break;
            }    
            fromUser = stdIn.readLine();
	    if (fromUser != null || StringUtils.isBlank(fromUser) == false) {
                logger.debug("Client: " + fromUser);
                out.println(fromUser);
	    }
        }
        logger.info("client ending");
        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }
    
    
    
}
