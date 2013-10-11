package com.dhenton9000.springdemos;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-demos.xml"})

public class AppTest 
{ 
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    // could you classpath scanning
    @Autowired
    private MultiCall multiCall;
    @Autowired
    private DependencyDemo demo;
    
    
    @Test
    public void testMe()
    {
        logger.debug("starting test");
        assertEquals("Hello,Bonzo!",multiCall.speak());
    }
    
    
    @Test
    public void testDependency()
    {
        // the autowire finds the demo
        assertNotNull(demo);
        // mockito provides the dependency, which will have a null implementation
        // of getMessage()
        
        assertNull(demo.getMessage());
  
        ScannedDependency s = new ScannedDependency();
        String t = s.getClass().getName();
    
        assertEquals("com.dhenton9000.springdemos.ScannedDependency",s.getClass().getName());
        
        // mockito loads it so it isn't the same as above.
        Class mock = demo.getDependencyClass();
        assertTrue(mock.getName().indexOf("EnhancerByMockitoWithCGLIB")> 0);
    }
}

