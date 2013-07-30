/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.db.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class InMemoryDBInitializer {

     
	private static final Logger logger = LoggerFactory.getLogger(InMemoryDBInitializer.class);

        public InMemoryDBInitializer()
        {
            logger.info("called constructor");
        }
        
        public void doInit() throws Exception
        {
            logger.info("called doInit");
            String dbURL = "jdbc:derby:memory:demo;create=true";
            Connection conn = null;
            try {
                logger.info("starting script run");
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                conn = DriverManager.getConnection(dbURL);
                ScriptRunner runner = new ScriptRunner(conn,true,false);
                InputStream  is = this.getClass().getResourceAsStream("/db/restaurants_derby.sql");
                logger.debug("got script");
                if (is == null)
                {
                    throw new RuntimeException("cannot find script ");
                }
                InputStreamReader isReader = new InputStreamReader(is);
                
                runner.runScript(isReader);
             } catch (java.sql.SQLException sqle) {
               
                throw sqle;
            }
        }
        
        
      
     
}
