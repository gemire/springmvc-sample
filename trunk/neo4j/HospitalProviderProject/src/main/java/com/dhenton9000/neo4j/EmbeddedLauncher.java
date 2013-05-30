/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j;

 
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author dhenton
 */
public class EmbeddedLauncher {
    
    private static ClassPathXmlApplicationContext context = null;
    
    public static void main(String[] args)
    {
        context = new ClassPathXmlApplicationContext("test-spring-beans.xml");
    }
    
}
