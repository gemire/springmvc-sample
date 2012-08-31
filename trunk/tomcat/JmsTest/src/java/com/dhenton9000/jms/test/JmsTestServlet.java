/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jms.test;

//import com.dhenton9000.caster.QueueCaster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;

/**
 *
 * @author dhenton
 */
public class JmsTestServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(JmsTestServlet.class);

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
        PrintWriter out = response.getWriter();
        String infoString = "";
        String listString = "";
        logger.info("zzzzzzzzzzzzzzzzzzzzzzzzzzz beginning run");

        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            Object oo = envCtx.lookup("jms/ConnectionFactory");
            if (oo != null) {
                infoString += "<h4>Sample lookup: " + oo.getClass().getName() + "</h4>";
             }
            NamingEnumeration<NameClassPair> nameInfo = envCtx.list("jms");
            while (nameInfo.hasMore()) {
                NameClassPair n = nameInfo.next();
                listString += "<li>" + n.getClassName() + " -- " + n.getName() + "</li>";

            }
            Queue tomcatQueue = (Queue) envCtx.lookup("jms/TomcatQueue");
            infoString += "<h4>Tomcat queue: " + tomcatQueue.getQueueName() + "</h4>";
            ActiveMQQueue aQueue = (ActiveMQQueue) tomcatQueue;
            infoString += "<h4>Apache queue: " + aQueue.getDestinationTypeAsString() + "</h4>";

        } catch (Exception ex) {
            String exI = "Error: " + ex.getClass().getName() + "-- " + ex.getMessage();
            logger.error(exI);
            infoString += "Error: <b>" + exI + "</b>";

        }



        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet JmsTestServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>List of items at java:comp/env/jms</h1>");
        out.println("<p>" + infoString + "</p>");
        out.println("<ol>" + listString + "</ol>");
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
