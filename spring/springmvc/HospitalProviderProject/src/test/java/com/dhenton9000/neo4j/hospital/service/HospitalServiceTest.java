/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.json.Provider;
import java.util.Iterator;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

/**
 *
 * @author dhenton
 */
public class HospitalServiceTest extends HospitalTestBase {

    private final Logger logger = LoggerFactory.getLogger(HospitalDaoTest.class);
    private HospitalNeo4jDao hospitalNeo4jDao = new HospitalNeo4jDaoImpl();
    private HospitalServiceImpl hospitalService = new HospitalServiceImpl();
    private static final String SAMPLE_NAME = "barf";
    private static final String PROVIDER_SAMPLE_NAME = "manjack";

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
                + "  \"name\" : \"" + SAMPLE_NAME + "\",\n"
                + "  \"id\" : 1,\n"
                + "  \"children\" : [ ],\n"
                + "  \"is_open\" : true\n"
                + "}";

        assertEquals(ex, t);

    }

    @Test(expected = HospitalServiceException.class)
    public void testCantDuplicateInitialNodes() throws Exception {
        hospitalService.createInitialDivision(SAMPLE_NAME);
        hospitalService.createInitialDivision(SAMPLE_NAME);
    }

    @Test(expected = HospitalServiceException.class)
    public void testAttachDivisionbyLabelsThrowsErrorWhenParentNonExistant()
            throws Exception {
        setupSampleInDb();
        hospitalService.attachDivisionbyLabels("bozo", "elmo");


    }

    @Test(expected = HospitalServiceException.class)
    public void testAttachDivisionbyLabelsThrowsErrorWhenChildExists()
            throws Exception {
        setupSampleInDb();
        hospitalService.attachDivisionbyLabels("Alpha", "Manny");


    }

     
    
    @Test
    public void testBuildDivisonFromDb() throws Exception {
        setupSampleInDb();
        Division items = hospitalService.buildDivisonFromDb("Alpha");
        assertEquals(new Long(1),items.getId()); 
    }
    
    @Test
    public void testGetInitialTreeMap() throws Exception {
        setupSampleInDb();
        Map<String, String> items = hospitalService.getInitialTreeMap();
        assertEquals(1,items.keySet().size());
        String t = (String) items.get("Alpha");
        assertEquals("Alpha",t);
    }

    @Test
    public void testAttachDivisionbyLabels()
            throws Exception {
        setupSampleInDb();
        hospitalService.attachDivisionbyLabels("Dewey", SAMPLE_NAME);
        Node t1 = hospitalNeo4jDao.getDivisionNode(SAMPLE_NAME);
        assertNotNull(t1);
        t1 = hospitalNeo4jDao.getDivisionNode("Dewey");
        int cc = 0;
        Iterator<Relationship> iter = t1.getRelationships(Direction.OUTGOING).iterator();
        while (iter.hasNext()) {
            Relationship r = iter.next();
            String t = (String) r.getEndNode().getProperty(HospitalNeo4jDao.DIVISION_DISPLAY_PROPERTY);
            assertEquals(SAMPLE_NAME, t);
            cc++;
            if (cc > 100) {
                fail("Infinite loop");
            }
        }
        assertEquals(1, cc);


    }

    @Test(expected = HospitalServiceException.class)
    public void testAttachDivisionbyLabelsThrowsErrorWhenParentIsProvider()
            throws Exception {
        Provider p = setupSampleInDbWithProviderTheRightWay();
        hospitalService.attachDivisionbyLabels(p.getName(), "Blotto");


    }

    private Division setupSampleInDb() throws Exception {

        Division d = getSampleRoot();
        d = hospitalNeo4jDao.attachFullTree(d);
        return d;
    }

    private Provider setupSampleInDbWithProviderTheRightWay() throws Exception {
        Division d = getSampleRoot();
        Division huey = (Division) d.getChildren().get(1).getChildren().get(0);
        assertNotNull(huey);
        assertEquals("Huey", huey.getName());
        Provider p = new Provider();
        p.setName(PROVIDER_SAMPLE_NAME);
        d = hospitalService.attachFullTree(d);
        p = hospitalService.attachProvider(huey, p);
        return p;
    }
}
