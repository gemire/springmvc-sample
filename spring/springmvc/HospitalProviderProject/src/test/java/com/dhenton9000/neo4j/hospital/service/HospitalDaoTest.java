/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.json.Provider;
import com.dhenton9000.neo4j.hospital.service.HospitalNeo4jDao.NODE_TYPE;
import java.util.Iterator;
import java.util.Map;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class HospitalDaoTest extends HospitalTestBase {

    private final Logger logger = LoggerFactory.getLogger(HospitalDaoTest.class);
    private HospitalNeo4jDao hospitalNeo4jDao = new HospitalNeo4jDaoImpl();
    private HospitalServiceImpl hospitalService = new HospitalServiceImpl();
    private static final String PROVIDER_SAMPLE_NAME = "manjack";
    private static final int SAMPLE_TREE_SIZE = 7;

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
    public void testAttachProviderReturnsNullWhenSentGarbage() throws Exception {
        setupSampleInDb();
        Division d = new Division();
        d.setName("foonman");
        Provider p = new Provider();
        Provider z = hospitalNeo4jDao.attachProvider(d, p);
        assertNull(z);
    }

    @Test(expected = HospitalServiceException.class)
    public void testCantAttachProviderToDivNodeWithDivChildren()
            throws Exception {
        Division d = setupSampleInDb();
        Provider p = new Provider();
        hospitalNeo4jDao.attachProvider(d, p);
    }

    public void testCanAttachProviderToDivNodeWithProviderChildren()
            throws Exception {

        Division d = getSampleRoot();
        Division huey = (Division) d.getChildren().get(1).getChildren().get(0);
        assertNotNull(huey);
        assertEquals("Huey", huey.getName());
        Provider p = new Provider();
        p.setName(PROVIDER_SAMPLE_NAME);
        d = hospitalService.attachFullTree(d);
        hospitalService.attachProvider(huey, p);
        Provider p2 = new Provider();
        p.setName("bonzo");
        hospitalService.attachProvider(huey, p2);
        Node hueyNode = hospitalNeo4jDao.getDivisionNode(huey.getName());
        Iterator<Relationship> iter =
                hueyNode.getRelationships(Direction.OUTGOING).iterator();
        int cc = 0;
        while (iter.hasNext()) {
            cc++;
        }
        assertEquals(2, cc);



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
    public void testRemoveNodeForProvider() throws Exception {
        Provider p = setupSampleInDbWithProviderTheRightWay();
        assertEquals(SAMPLE_TREE_SIZE,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Division).size());
        assertEquals(1,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Provider).size());
        Node pNode = hospitalNeo4jDao.getProviderNode(p.getName());
        assertNotNull(pNode);
        hospitalNeo4jDao.removeNode(pNode);
        assertEquals(SAMPLE_TREE_SIZE,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Division).size());
        assertEquals(0,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Provider).size());
    }

    @Test(expected = HospitalServiceException.class)
    public void testDeletingMustBeDoneWithNoChildren() throws Exception {
        setupSampleInDb();
        assertEquals(SAMPLE_TREE_SIZE,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Division).size());
        assertEquals(0,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Provider).size());
        Node n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNotNull(n1);
        hospitalNeo4jDao.removeNode(n1);
        n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNull(n1);
        assertEquals(SAMPLE_TREE_SIZE - 1,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Division).size());
        //  n1 = hospitalNeo4jDao.getProviderNode(PROVIDER_SAMPLE_NAME);
        //   assertNotNull(n1);

    }

    public void testDeletingSucceeds() throws Exception {
        setupSampleInDb();
        assertEquals(SAMPLE_TREE_SIZE,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Division).size());
        assertEquals(0,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Provider).size());
        Node n1 = hospitalNeo4jDao.getDivisionNode("Huey");
        assertNotNull(n1);
        hospitalNeo4jDao.removeNode(n1);
        n1 = hospitalNeo4jDao.getDivisionNode("Huey");
        assertNull(n1);
        assertEquals(SAMPLE_TREE_SIZE - 1,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Division).size());

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
        assertNotNull(n1);
        assertEquals(SAMPLE_TREE_SIZE,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Division).size());
        assertEquals(1,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Provider).size());
    }

    @Test(expected = HospitalServiceException.class)
    public void testCreateAndAttachDivisionNodeWontAllowEmpty()
            throws Exception {

        hospitalNeo4jDao.createInitialNode("");
    }

    @Test(expected = HospitalServiceException.class)
    public void testCreateAndAttachDivisionNodeWontAllowNull()
            throws Exception {

        hospitalNeo4jDao.createInitialNode(null);
    }

    @Test(expected = HospitalServiceException.class)
    public void testCreateAndAttachDivisionNodeWontAllowSpace()
            throws Exception {

        hospitalNeo4jDao.createInitialNode(" ");
    }

    @Test(expected = HospitalServiceException.class)
    public void testCreateAndAttachProviderNodeWontAllowEmpty()
            throws Exception {

        hospitalNeo4jDao.createInitialNode("a");
        Division d = new Division();
        d.setName("a");
        Provider p = new Provider();
        p.setName("");
        hospitalNeo4jDao.attachProvider(d, p);
    }

    @Test(expected = HospitalServiceException.class)
    public void testCreateAndAttachProviderNodeWontAllowNull()
            throws Exception {

        hospitalNeo4jDao.createInitialNode("a");
        Division d = new Division();
        d.setName("a");
        Provider p = new Provider();
        p.setName(null);
        hospitalNeo4jDao.attachProvider(d, p);
    }

    @Test(expected = HospitalServiceException.class)
    public void testCreateAndAttachProviderNodeWontAllowSpace()
            throws Exception {

        hospitalNeo4jDao.createInitialNode("a");
        Division d = new Division();
        d.setName("a");
        Provider p = new Provider();
        p.setName(" ");
        hospitalNeo4jDao.attachProvider(d, p);
    }

    @Test
    public void testCannotDeleteANodeWithChildren() throws Exception {
    }

    @Test
    public void testThatIdsAreFilledIN() throws Exception {
        Division d = setupSampleInDb();
        assertNotNull(d.getId());

    }

    @Test(expected = RuntimeException.class)
    public void testBuildFromDBSWithUnknownNodeThrowsException() {
        hospitalNeo4jDao.buildDivisionFromDb("get a job");
    }

    @Test
    public void testBuildDivisionFromDb() throws Exception {
        Division d = getSampleRoot();
        Division huey = (Division) d.getChildren().get(1).getChildren().get(0);
        assertNotNull(huey);
        assertEquals("Huey", huey.getName());
        Provider p = new Provider();
        p.setName(PROVIDER_SAMPLE_NAME);
        d = hospitalService.attachFullTree(d);
        p = hospitalService.attachProvider(huey, p);

        Division newD = hospitalNeo4jDao.buildDivisionFromDb(d.getName());



        Division newHuey = (Division) newD.getChildren().get(1).getChildren().get(0);
        assertEquals(huey.getName(), newHuey.getName());
    }

    @Test
    public void testGeNodesReturnNullForNull() {
        Node t = hospitalNeo4jDao.getDivisionNode(null);
        assertNull(t);
        t = hospitalNeo4jDao.getProviderNode(null);
        assertNull(t);
    }

    @Test(expected = HospitalServiceException.class)
    public void throwHospitalServiceExceptionWhenTryingToAttachDuplicate() throws Exception {
        Node initial = hospitalNeo4jDao.createInitialNode("initial");
        Transaction tx = hospitalNeo4jDao.getNeo4jDb().beginTx();
        try {
            hospitalNeo4jDao.createAndAttachDivisionNode(initial, PROVIDER_SAMPLE_NAME);
            hospitalNeo4jDao.createAndAttachDivisionNode(initial, PROVIDER_SAMPLE_NAME);
            tx.success();

        } finally {
            tx.finish();
        }
    }

    @Test
    public void testDisplayForProvider() throws Exception {
        Node initial = hospitalNeo4jDao.createInitialNode("initial");
        Transaction tx = hospitalNeo4jDao.getNeo4jDb().beginTx();
        Node p = null;
        try {
            Node d = hospitalNeo4jDao.createAndAttachDivisionNode(initial, "div");
            p = hospitalNeo4jDao.createAndAttachProviderNode(d, PROVIDER_SAMPLE_NAME);
            tx.success();

        } finally {
            tx.finish();
        }

        assertEquals(PROVIDER_SAMPLE_NAME, hospitalNeo4jDao.getDisplayMessage(p));

    }

    @Test(expected = HospitalServiceException.class)
    public void throwHospitalServiceExceptionWhenTryingToAttachDuplicateMixed() throws Exception {
        Node initial = hospitalNeo4jDao.createInitialNode("initial");
        Transaction tx = hospitalNeo4jDao.getNeo4jDb().beginTx();
        try {
            Node d = hospitalNeo4jDao.createAndAttachProviderNode(initial, PROVIDER_SAMPLE_NAME);
            hospitalNeo4jDao.createAndAttachProviderNode(d, PROVIDER_SAMPLE_NAME);
            tx.success();

        } finally {
            tx.finish();
        }
    }

    @Test
    public void testChangeNodeLabelForDivision() throws Exception {
        setupSampleInDb();
        Node n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNotNull(n1);
        Division mannyDiv = new Division();
        mannyDiv.setName("Manny");
        hospitalNeo4jDao.changeNodeLabel(mannyDiv, "bozon");
        n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNull(n1);
        n1 = hospitalNeo4jDao.getDivisionNode("bozon");
        assertNotNull(n1);
        assertEquals(SAMPLE_TREE_SIZE,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Division).size());
    }

    @Test
    public void testChangeNodeLabelForDivisionIsOkayWithSameThing() throws Exception {
        setupSampleInDb();
        Node n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNotNull(n1);
        Division mannyDiv = new Division();
        mannyDiv.setName("Manny");
        hospitalNeo4jDao.changeNodeLabel(mannyDiv, "Manny");

    }

    @Test(expected = HospitalServiceException.class)
    public void testChangeNodeLabelForDivisionThrowsErrorOnDuplicate() throws Exception {
        setupSampleInDb();
        Node n1 = hospitalNeo4jDao.getDivisionNode("Manny");
        assertNotNull(n1);
        Division mannyDiv = new Division();
        mannyDiv.setName("Manny");
        hospitalNeo4jDao.changeNodeLabel(mannyDiv, "Huey");
        // this will produce a runtime exception so throw an error before
        // in changeNodeLabel
        hospitalNeo4jDao.getDivisionNode("Huey");

    }

    @Test
    public void testChangeNodeLabelForProvider() throws Exception {
        Provider p = setupSampleInDbWithProviderTheRightWay();
        Node n1 = hospitalNeo4jDao.getProviderNode(PROVIDER_SAMPLE_NAME);
        assertNotNull(n1);
        Provider bozonDiv = new Provider();
        bozonDiv.setName(PROVIDER_SAMPLE_NAME);
        hospitalNeo4jDao.changeNodeLabel(bozonDiv, "bozon");
        n1 = hospitalNeo4jDao.getProviderNode(PROVIDER_SAMPLE_NAME);
        assertNull(n1);
        n1 = hospitalNeo4jDao.getProviderNode("bozon");
        assertNotNull(n1);
        assertEquals(1,
                hospitalNeo4jDao.getAllNodesForType(NODE_TYPE.Provider).size());



    }

    @Test
    public void testGetInitialNodesWithSomething() throws Exception {
        String[] a = {"a1", "a2", "a3"};
        Map<String, String> items = hospitalNeo4jDao.getInitialNodes();
        assertNull(items);
        for (String t : a) {
            hospitalNeo4jDao.createInitialNode(t);
        }
        items = hospitalNeo4jDao.getInitialNodes();
        assertEquals(a.length, items.size());


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
