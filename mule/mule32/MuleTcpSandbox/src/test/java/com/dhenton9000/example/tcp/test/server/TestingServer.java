/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp.test.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class TestingServer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(TestingServer.class);
    public static final String PREPEND = "I got:";
    public static final String EXIT = "EXIT";
    public static final String KILL = "KILL";
    private int serverSOTimeout = 0;
    private int bufferSize = 512;
    private int portNumber = 4444;
    private int maxConnections = 5;
    private boolean killRequested = false;
    private ArrayList<ThreadConnection> connections = new ArrayList<ThreadConnection>();
    private Thread serverThread;

    @Override
    public void run()  {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPortNumber());
            serverSocket.setSoTimeout(getServerSOTimeout());
            serverSocket.setReceiveBufferSize(getBufferSize());

        } catch (IOException e) {
            throw new RuntimeException("Could not listen on port: " + getPortNumber() + " " + e.getMessage());

        }
        int i = 0;
        // start handling connections
        while ((i++ < getMaxConnections()) || (getMaxConnections() == 0)) {
            logger.debug("in server while loop");
            ThreadConnection connection;
             if (killRequested)
                break;
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException ex) {
                throw new RuntimeException("cannot create client socket");
            }
           
            connection = new ThreadConnection(clientSocket);
            getConnections().add(connection);
            Thread t = new Thread(connection);
            t.start();
            
        }

        if (i > getMaxConnections()) {
            throw new RuntimeException("connect max of " + getMaxConnections() + " exceeded");
        }
        logger.debug("exit server loop with kill "+killRequested);

    }

    /**
     * @return the connections
     */
    public ArrayList<ThreadConnection> getConnections() {
        return connections;
    }

    protected void removeClient(ThreadConnection aThis) throws IOException {

        aThis.getClientSocket().close();
        aThis.setActive(false);

    }

    public class ThreadConnection implements Runnable {

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 89 * hash + (this.getClientSocket() != null ? this.getClientSocket().hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ThreadConnection other = (ThreadConnection) obj;
            if (this.getClientSocket() != other.getClientSocket() && (this.getClientSocket() == null
                    || !this.clientSocket.equals(other.clientSocket))) {
                return false;
            }
            return true;
        }
        private Socket clientSocket;
        private boolean active = false;
        private ArrayList<String> messages = new ArrayList<String>();

        private ThreadConnection(Socket clientSocket) {
            this.clientSocket = clientSocket;
            active = true;
        }

        @Override
        public void run() {

            String input = "";
            String line = "";

            try {
                // Get input from the client

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                        getClientSocket().getInputStream()));
                PrintStream out = new PrintStream(getClientSocket().getOutputStream());

                // 'EXIT' means close connection
                while ((line = in.readLine()) != null && !line.toUpperCase().equals(EXIT)) {
                    logger.debug("in readline of thread connection");
                    input = input + line;
                    messages.add(line);
                    logger.debug("got '"+line+"'");
                    
                    out.println(PREPEND + line);
                    

                }

                // Now write to the client
                out.println(EXIT);
                removeClient(this);


            } catch (IOException ioe) {
                logger.error("IOException on socket listen: " + ioe);

            }
        }

        /**
         * @return the clientSocket
         */
        public Socket getClientSocket() {
            return clientSocket;
        }

        /**
         * @return the active
         */
        public boolean isActive() {
            return active;
        }

        /**
         * @param active the active to set
         */
        public void setActive(boolean active) {
            this.active = active;
        }

        /**
         * @return the messages
         */
        public ArrayList<String> getMessages() {
            return messages;
        }
    }

    public static void main(String[] args) {
        try {
            logger.info("beginning test server");
            (new TestingServer()).run();
        } catch (Exception ex) {
            logger.error("Main error: " + ex.getClass().getName() + " " + ex.getMessage());

        }
    }
    

    /**
     * @return the serverSOTimeout
     */
    public int getServerSOTimeout() {
        return serverSOTimeout;
    }

    /**
     * @param serverSOTimeout the serverSOTimeout to set
     */
    public void setServerSOTimeout(int serverSOTimeout) {
        this.serverSOTimeout = serverSOTimeout;
    }

    /**
     * @return the bufferSize
     */
    public int getBufferSize() {
        return bufferSize;
    }

    /**
     * @param bufferSize the bufferSize to set
     */
    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    /**
     * @return the portNumber
     */
    public int getPortNumber() {
        return portNumber;
    }

    /**
     * @param portNumber the portNumber to set
     */
    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * @return the maxConnections
     */
    public int getMaxConnections() {
        return maxConnections;
    }

    /**
     * @param maxConnections the maxConnections to set
     */
    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void startServer() throws Exception
    {
        serverThread = new Thread(this);
        serverThread.start();
    }
    
    
    public void killServer() throws Exception {
         
        
        Socket kkSocket = new Socket("localhost", 4444);
        PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
        out.println(KILL);
        killRequested = true;
        out.close();
        kkSocket.close();
        
    }
}
