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
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class InMemoryDBInitializer {

    private static final Logger logger = LoggerFactory.getLogger(InMemoryDBInitializer.class);
    private static boolean didInit = false;
    private String dbURL = null;
    private String driverClass = null;
    private List<String> dbscripts = null;

    public InMemoryDBInitializer() {
        logger.info("called constructor");

    }

    public void doInit() throws Exception {
        if (!didInit) {
            logger.info("called doInit");

            Connection conn = null;
            didInit = true;
            try {
                logger.info("starting script run");
                Class.forName(getDriverClass()).newInstance();
                conn = DriverManager.getConnection(this.getDbURL());
                ScriptRunner runner = new ScriptRunner(conn, true, false);
                for (String scr : getDbscripts()) {
                    runScript(runner, scr);
                }


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

    /**
     * @return the dbURL
     */
    public String getDbURL() {
        return dbURL;
    }

    /**
     * @param dbURL the dbURL to set
     */
    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    /**
     * @return the driverClass
     */
    public String getDriverClass() {
        return driverClass;
    }

    /**
     * @param driverClass the driverClass to set
     */
    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    /**
     * @return the dbscripts
     */
    public List<String> getDbscripts() {
        return dbscripts;
    }

    /**
     * @param dbscripts the dbscripts to set
     */
    public void setDbscripts(List<String> dbscripts) {
        this.dbscripts = dbscripts;
    }
}
