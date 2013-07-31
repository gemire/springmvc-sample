/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.db.utils;

import java.io.IOException;
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
    private static boolean didInit = false;

    public InMemoryDBInitializer() {
        logger.info("called constructor");
        
    }

    public void doInit() throws Exception {
        if (!didInit) {
            logger.info("called doInit");
           
            String dbURL = "jdbc:derby:memory:demo;create=true";
            Connection conn = null;
            didInit = true;
            try {
                logger.info("starting script run");
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                conn = DriverManager.getConnection(dbURL);
                ScriptRunner runner = new ScriptRunner(conn, true, false);

                runScript(runner, "/db/restaurants_derby.sql");
                runScript(runner, "/db/sec_derby.sql");
            } catch (java.sql.SQLException sqle) {

                throw sqle;
            }
        }
    }

    public static java.io.OutputStream disableDerbyLogFile() {
        return new java.io.OutputStream() {
            @Override
            public void write(int b) throws IOException {
                // Ignore all log messages
            }
        };
    }

    private void runScript(ScriptRunner runner, String scriptPath) throws Exception {
        InputStream is = this.getClass().getResourceAsStream(scriptPath);
        if (is == null) {
            throw new RuntimeException("cannot find script at " + scriptPath);
        }
        InputStreamReader isReader = new InputStreamReader(is);

        runner.runScript(isReader);
    }
}
