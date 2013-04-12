/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.json.Provider;
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
import org.junit.Ignore;
import org.neo4j.graphdb.Node;

/**
 *
 * @author dhenton
 */
public class HospitalDaoTest extends HospitalTestBase {

    private final Logger logger = LoggerFactory.getLogger(HospitalDaoTest.class);
    private HospitalNeo4jDao hospitalNeo4jDao = new HospitalNeo4jDaoImpl();
    private HospitalServiceImpl hospitalService = new HospitalServiceImpl();
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
    public void testGettingNodesByName() throws Exception {
        Division d = setupSampleInDb();
        assertNotNull(d.getId());
        Node n1 = hospitalNeo4jDao.getDivisionNode("bonzo");
        assertNull(n1);
        n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNotNull(n1);
    }

    @Test(expected = HospitalServiceException.class)
    public void shouldHandleAddingTreeTwice() throws Exception {
        setupSampleInDb();
        setupSampleInDb();
    }

    @Test
    public void testDeletingNode() throws Exception {
        setupSampleInDb();
        Node n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNotNull(n1);
        hospitalNeo4jDao.removeNode(n1);
        n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNull(n1);

        //  n1 = hospitalNeo4jDao.getProviderNode(PROVIDER_SAMPLE_NAME);
        //   assertNotNull(n1);

    }

    @Test(expected = HospitalServiceException.class)
    public void testYouCantAddAProviderThruFullTree() throws Exception {
        setupSampleInDbWithProviderTheWrongWay();

    }

    @Test
    public void testAddingAProvider() throws Exception {
        setupSampleInDbWithProviderTheRightWay();
        Node n1 = hospitalNeo4jDao.getDivisionNode(PROVIDER_SAMPLE_NAME);
        assertNull(n1);
        n1 = hospitalNeo4jDao.getProviderNode(PROVIDER_SAMPLE_NAME);
        assertNull(n1);
    }

    @Ignore
    public void testEditingNodeLabel() throws Exception {
        setupSampleInDb();
        Node n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNotNull(n1);
        hospitalNeo4jDao.changeNodeLabel(n1, "bozon");
        n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNull(n1);
        n1 = hospitalNeo4jDao.getDivisionNode("bozon");
        assertNotNull(n1);

    }

    private Division setupSampleInDbWithProviderTheRightWay() throws Exception {
        Division d = getSampleRoot();
        Division huey = (Division) d.getChildren().get(1).getChildren().get(2);
        Provider p = new Provider();
        p.setName(PROVIDER_SAMPLE_NAME);
        huey.getChildren().add(p);
        p = hospitalService.attachProvider(huey, p);
        return d;
    }

    private Division setupSampleInDbWithProviderTheWrongWay() throws Exception {
        Division d = getSampleRoot();
        HospitalNode huey = d.getChildren().get(1).getChildren().get(2);
        Provider p = new Provider();
        p.setName(PROVIDER_SAMPLE_NAME);
        huey.getChildren().add(p);
        d = hospitalService.attachFullTree(d);
        return d;
    }

    private Division setupSampleInDb() throws Exception {

        Division d = getSampleRoot();
        d = hospitalNeo4jDao.attachFullTree(d);
        return d;
    }
}
