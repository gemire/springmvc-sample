/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.starter.neo4j.hospital;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.json.JSONHospitalServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;
import org.neo4j.graphdb.Node;

/**
 *
 * @author dhenton
 */
public class HospitalWebServiceTest extends HospitalTestBase {
    
    
    private final Logger logger = LoggerFactory.getLogger(HospitalWebServiceTest.class);
    private JSONHospitalServiceImpl jService = new JSONHospitalServiceImpl();
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void before() {
        this.prepareTestDatabase();
        jService.setNeo4jDb(this.getGraphDb());

    }

    @After
    public void after() {
        this.destroyTestDatabase();
    }
    
    @Test 
    public void testGettingNodesByName() throws Exception
    {
         Division d = setupSampleInDb();
         assertNotNull(d.getId());
         Node n1 = jService.getDivisionNode("bonzo");
         assertNull(n1);
         n1 = jService.getDivisionNode("Manny");
         assertNotNull(n1);
    }
    
    @Test(expected=HospitalServiceException.class)
    public void shouldHandleAddingTreeTwice() throws Exception
    {
          setupSampleInDb();
          setupSampleInDb();
    }
    
    
    
    private Division setupSampleInDb() throws  Exception
    {
        String label = "Alpha";
        Division d = getSampleRoot();
        d.setName(label);
        d = jService.attachFullTree(d);
        return d;
    }
    
}
