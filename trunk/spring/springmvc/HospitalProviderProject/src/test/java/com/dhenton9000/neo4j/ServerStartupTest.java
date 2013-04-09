/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j;

import com.dhenton9000.neo4j.hospital.json.JSONHospitalService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author dhenton
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-beans.xml"})
 
public class ServerStartupTest {
    
    @Autowired
    JSONHospitalService jsonService;
    
    
    @Before
    public void beforeEachTest()
    {
        
    }
    
    
    @Test
    public void testServiceCreation()
            
    {
        assertNotNull(jsonService);
    }
    
    
}
