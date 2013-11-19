/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.servlet;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class PropertyInitServlet extends HttpServlet {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyInitServlet.class);
    
    
     public PropertyInitServlet() {
        super();
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("property init constructor");
        }
    }
     
     public void init(ServletConfig config) throws ServletException {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("in init()");
        }
        System.setProperty("derby.stream.error.method", "InMemoryDBInitializer.disableDerbyLogFile"); 
        super.init(config);
    } 
     
     
     
}
