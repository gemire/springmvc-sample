/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jms.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.command.ActiveMQQueue;

/**
 *
 * @author dhenton
 */
public class JmsSenderServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(JmsSenderServlet.class);

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String errorString = "";
        String infoString = "";

        String message = "message";
        message = request.getParameter("message");
        if (message == null) {
            message = "message";
        }

        PrintWriter out = response.getWriter();
        Connection connection = null;
        try {

            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            ConnectionFactory connectionFactory =
                    (ConnectionFactory) envCtx.lookup("jms/ConnectionFactory");
            Queue tomcatQueue = (Queue) envCtx.lookup("jms/TomcatQueue");
            ActiveMQQueue aQueue = (ActiveMQQueue) tomcatQueue;
            connection = connectionFactory.createConnection();
            connection.start();

            Session queueSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = queueSession.createProducer(tomcatQueue);
            TextMessage jmsMessage = queueSession.createTextMessage();
            jmsMessage.setText(message);

            producer.send(jmsMessage);
            infoString += "<p>Sent message of '" + message + "' <p>";
            writeOut(out, errorString, infoString);

        } catch (JMSException ex) {
            errorString += "Jms Exception: " + ex.getMessage() + "<br/>";
            logger.error(errorString);
        } catch (NamingException ex) {
            errorString += "Naming Exception: " + ex.getMessage() + "<br/>";
            logger.error(errorString);
        } catch (Exception ex) {
            errorString += "General Error: " + ex.getMessage()
                    + " -- " + ex.getClass().getName() + "<br/>";
            logger.error(errorString);
        } finally {
            out.close();
            try {
                connection.stop();
            } catch (JMSException ex) {
            }
        }
    }

    private void writeOut(PrintWriter out, String errorString, String infoString) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet JmsTestServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Jms Message Send</h1>");
        out.println("<p>" + infoString + "</p>");
        out.println("<p>" + errorString + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
