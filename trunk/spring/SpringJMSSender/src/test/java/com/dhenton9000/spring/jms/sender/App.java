package com.dhenton9000.spring.jms.sender;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger log = LogManager.getLogger(App.class);
    public void doTest()
    {
        String[] spring_files = {"jms-sender.xml"};
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(spring_files);
        JmsTemplate template = (JmsTemplate) ctx.getBean("destQueueTemplate");
        template.convertAndSend("get a job");
        template.convertAndSend(new Integer(5));
        
        
    }
    
    public static void main( String[] args )
    {
        log.debug("start");
        App app = new App();
        app.doTest();
    }
}
