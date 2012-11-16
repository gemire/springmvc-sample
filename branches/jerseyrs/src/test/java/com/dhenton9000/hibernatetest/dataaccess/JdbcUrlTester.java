/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatetest.dataaccess;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author dhenton
 */
public class JdbcUrlTester {

    private static Logger logger = LogManager.getLogger(JdbcUrlTester.class);

    public void doTest() throws SQLException {
        Connection conn = null;
        try {

            Properties connectionProps = new Properties();
            connectionProps.put("user", "sec");
            connectionProps.put("password", "sec");

            
            //jdbc:derby://myhost.mydomain.com:1527/mydb;create=true;user=user1;password=secret4me
            
            String query = "select * from users where userid = 'mkm'";
            conn =
                    DriverManager.getConnection("jdbc:derby://localhost:1527/sec;user=sec;password=sec");

            ResultSet rs = null;
            Statement stmt = null;

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                logger.debug(rs.getString(1));
            }
        } finally {
            conn.close();
        }

    }

    public static void main(String[] args) {

        JdbcUrlTester j = new JdbcUrlTester();

        try {
            j.doTest();
        } catch (Exception ex) {
            logger.error("Sql problem " + ex.getMessage());
        }
    }
}
