/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springsamples;

import com.dhenton9000.orders.OrderDownloader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 *
 * @author dhh
 */
public class Main {
    private static Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-orders.xml");
        log.debug("starting order downloads");
        OrderDownloader oDownloader = (OrderDownloader) ctx.getBean("constructorDownloader");
        oDownloader.doOrderDownload();
        log.debug("finishing downloads");
    }
}
