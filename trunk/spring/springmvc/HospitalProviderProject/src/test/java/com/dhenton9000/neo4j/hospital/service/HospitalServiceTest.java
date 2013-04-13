/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 *
 * @author dhenton
 */
public class HospitalServiceTest extends HospitalTestBase {

    private final Logger logger = LoggerFactory.getLogger(HospitalDaoTest.class);
    private HospitalNeo4jDao hospitalNeo4jDao = new HospitalNeo4jDaoImpl();
    private HospitalServiceImpl hospitalService = new HospitalServiceImpl();
    private static final String SAMPLE_NAME = "manjack";

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
    public void testInitialNodeCreate() throws Exception {
        Division d = hospitalService.createInitialDivision(SAMPLE_NAME);
        assertEquals(new Long(1), d.getId());
        assertNotNull(hospitalNeo4jDao.getDivisionNode(SAMPLE_NAME));
    }

    @Test
    public void testInitalNodeCreateToJSON() throws Exception {
        Division d = hospitalService.createInitialDivision(SAMPLE_NAME);
        String t = hospitalService.structureToString(d);
        String ex = "{\n"
                + "  \"type\" : \"Division\",\n"
                + "  \"name\" : \"manjack\",\n"
                + "  \"id\" : 1,\n"
                + "  \"children\" : [ ],\n"
                + "  \"is_open\" : true\n"
                + "}";
         
         assertEquals(ex,t);

    }

    @Test(expected = HospitalServiceException.class)
    public void testCantDuplicateInitialNodes() throws Exception {
        hospitalService.createInitialDivision(SAMPLE_NAME);
        hospitalService.createInitialDivision(SAMPLE_NAME);
    }
}
