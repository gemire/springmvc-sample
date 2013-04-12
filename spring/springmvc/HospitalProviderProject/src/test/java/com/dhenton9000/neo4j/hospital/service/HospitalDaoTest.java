/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.service.HospitalNeo4jDao;
import com.dhenton9000.neo4j.hospital.service.HospitalNeo4jDaoImpl;
import com.dhenton9000.neo4j.hospital.service.HospitalService;
import com.dhenton9000.neo4j.hospital.service.HospitalServiceImpl;
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
public class HospitalDaoTest extends HospitalTestBase {
    
    
    private final Logger logger = LoggerFactory.getLogger(HospitalDaoTest.class);
    private  HospitalNeo4jDao  hospitalNeo4jDao = new HospitalNeo4jDaoImpl();
    private  HospitalServiceImpl hospitalService = new HospitalServiceImpl();
    
    @Before
    public void before() {
        this.prepareTestDatabase();
        hospitalNeo4jDao.setNeo4jDb(this.getGraphDb());
        hospitalService.setHospitalDao(hospitalNeo4jDao);
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
         Node n1 = hospitalNeo4jDao.getDivisionNode("bonzo");
         assertNull(n1);
         n1 = hospitalNeo4jDao.getDivisionNode("Manny");
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
        d = hospitalService.attachFullTree(d);
        return d;
    }
    
}
