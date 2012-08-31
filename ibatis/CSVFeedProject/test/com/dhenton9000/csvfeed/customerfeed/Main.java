/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.csvfeed.customerfeed;
import com.dhenton9000.feeds.FeedException;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dhenton9000.csvfeed.BaseCSVFeedController;
/**
 *
 * @author Don
 */
public class Main {

        private static Logger log = LogManager.getLogger(Main.class);


   


    public void doWork()
    {
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "cvsfeed-spring.xml");
  
       BaseCSVFeedController customerController =
       (BaseCSVFeedController) ctx.getBean("customerFeed");
        try {
            customerController.createFeed();
        } catch (FeedException ex) {
           log.error("Feed problem "+ex.getMessage());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Main m = new Main();
       m.doWork();
    }

}
