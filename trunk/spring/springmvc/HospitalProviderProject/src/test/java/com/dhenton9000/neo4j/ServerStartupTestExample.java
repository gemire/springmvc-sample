/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j;

import com.dhenton9000.neo4j.hospital.service.HospitalService;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author dhenton
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:test-spring-beans.xml"})
 
public class ServerStartupTestExample {
    
    @Autowired
    HospitalService jsonService;
    
    
    @Before
    public void beforeEachTest()
    {
        
    }
    
    
    @Ignore
    public void testServiceCreation()
            
    {
        assertNotNull(jsonService);
    }
    
    
}
