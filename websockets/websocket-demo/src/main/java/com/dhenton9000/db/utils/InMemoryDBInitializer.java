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
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class InMemoryDBInitializer {

    private static final Logger logger = LoggerFactory.getLogger(InMemoryDBInitializer.class);
    private static boolean didInit = false;
    private List<String> dbscripts = null;
    private DataSource dataSource;

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
                conn = getDataSource().getConnection();
                ScriptRunner runner = new ScriptRunner(conn, true, false);
                for (String scr : getDbscripts()) {
                    runScript(runner, scr);
                }


            } catch (java.sql.SQLException sqle) {

                throw sqle;
            }
            finally
            {
                if (conn != null)
                {
                    
                    conn.close();
                }
                    
                
            }
        }// end did Init
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

    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    
}