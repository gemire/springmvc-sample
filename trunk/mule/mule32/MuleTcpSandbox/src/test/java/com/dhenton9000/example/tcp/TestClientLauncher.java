/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClientLauncher {

    private static final Logger logger = LoggerFactory.getLogger(TestClientLauncher.class);
    private static final String messageTemplate =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "<message>get a jobs %d</message>";

    public void startListening() throws IOException {
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            kkSocket = new Socket("localhost", 4444);
            kkSocket.setKeepAlive(true);
            kkSocket.setSoTimeout(0);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            logger.error("cant find localhost");
            System.exit(1);
        } catch (IOException e) {
            logger.error("Couldn't get I/O for the connection to: localhost.");
            System.exit(1);
        }


        String fromServerLine;

        for (int i = 0; i < 3; i++) {
            String fromUser = String.format(messageTemplate, i);
            logger.debug("sending " + fromUser);
            logger.debug("kkSocket closed " + kkSocket.isClosed());
            logger.debug("kkSocket input down " + kkSocket.isInputShutdown());
            logger.debug("kkSocket output down " + kkSocket.isOutputShutdown());
            out.println(fromUser);
            out.flush();

            
        }
        String accum = "";
        while ((fromServerLine = in.readLine()) != null) {
            logger.debug("ServerLine : " + fromServerLine);
            accum += fromServerLine;


        }
        logger.debug("exiting client listener loop server message:\n" + accum);
        out.close();
        in.close();
        kkSocket.close();
        kkSocket = null;
        System.exit(0);

    }

    private static String getMessage(String item) {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(item);
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(inputStream, writer, "UTF-8");
        } catch (IOException ex) {
            throw new RuntimeException("io problem with '" + item + "'");
        }
        return writer.toString();


    }

    public static void main(String[] args) {
        logger.debug("starting client");
        try {
            (new TestClientLauncher()).startListening();
        } catch (Exception e) {
            String eInfo = "Error Class: " + e.getClass().getName() + "\n"
                    + "message: " + e.getMessage();
            logger.error(eInfo);
        }
    }
}
