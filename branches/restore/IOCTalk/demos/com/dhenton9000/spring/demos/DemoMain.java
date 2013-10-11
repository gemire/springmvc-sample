/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.demos;


import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.spring.demos.demobeans.Creature;
import com.dhenton9000.spring.demos.demobeans.Zoo;
/**
 *
 * @author dhh
 */
public class DemoMain {
    private static Logger log = LogManager.getLogger(DemoMain.class);
    private static ClassPathXmlApplicationContext ctx =
        new ClassPathXmlApplicationContext("spring-demo.xml");
    
    /**
     * Demonstrates various injection methods and interface coding
     */
    public void doZooDemo()
    {
    	Zoo z = (Zoo) ctx.getBean("Zoo");
    	
    	ArrayList<Creature> creatures = z.getCreatures();
    	int creatureCount = creatures.size();
    	log.debug("The zoo has "+creatureCount + " creatures");
    	log.debug("\n=================\n");
    	int k = 1;
    	for (Creature c: creatures)
    	{
    		log.debug("Creature "+ k+ " says "+ c.speak());
    		k++;
    	}
    }
    
    public static void main(String[] args) {
      
        log.debug("demonstration");
        DemoMain dM = new DemoMain();
        dM.doZooDemo();
        
        
    }
}
