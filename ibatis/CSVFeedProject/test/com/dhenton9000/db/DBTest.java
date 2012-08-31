/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.db;

import com.mysql.jdbc.Statement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Don
 */
public class DBTest {

    private static Logger log = LogManager.getLogger(DBTest.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "cvsfeed-spring.xml");
        //log.debug("ctx "+ctx);
        MysqlDataSource d = (MysqlDataSource) ctx.getBean("birt_dataSource");
        log.debug("d is " + d.getServerName());

        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            conn = d.getConnection();
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery("SELECT * From Customers");
            int cc = 0;
            while (rs.next()) {

                log.debug(cc);
                cc ++;
            }


        } catch (Exception e) {
        } finally {


            try {
                conn.close();
            } catch (Exception e) {
            }
        }



    }
}
