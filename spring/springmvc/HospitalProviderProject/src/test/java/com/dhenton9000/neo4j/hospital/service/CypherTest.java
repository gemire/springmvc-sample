/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import static com.dhenton9000.neo4j.hospital.service.HospitalNeo4jDao.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * uses simple tree to test writing an entire tree to an impermanent neo4j db
 *
 * @author dhenton
 */
public class CypherTest extends HospitalTestBase {

    private final Logger logger = LoggerFactory.getLogger(CypherTest.class);
    //private HospitalServiceImpl hospitalNeo4jDao = new HospitalServiceImpl();
    private ObjectMapper mapper = new ObjectMapper();
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
    public void testDbCreate() {
        assertNotNull(this.getGraphDb());
    }

    @Test
    public void testCreateNeo4jGraphFromDivision() throws Exception {
        String label = "Test";
        Division d = new Division();
        d.setName(label);
        d = hospitalService.attachFullTree(d);
        assertEquals(label, d.getName());
        assertEquals(new Long(1L), new Long(d.getId()));
        assertEquals(0, d.getChildren().size());
    }

    @Test
    public void testCreateNeo4jGraphFromSample() throws Exception {
        String label = "Alpha";
        Division d = getSampleRoot();
        d.setName(label);
        d = hospitalService.attachFullTree(d);
        assertEquals(label, d.getName());
        assertEquals(new Long(1L), new Long(d.getId()));
        assertEquals(3, d.getChildren().size());
        assertNotNull(d.getId());
        HospitalNode moeDiv = d.getChildren().get(1);
        assertEquals(new Long(3L), new Long(moeDiv.getId()));
        assertEquals("Moe", moeDiv.getName());
        assertEquals(3, moeDiv.getChildren().size());
        HospitalNode hueyDiv = moeDiv.getChildren().get(0);
        assertEquals("Huey", hueyDiv.getName());
        assertEquals(new Long(4L), new Long(hueyDiv.getId()));
        logger.info(hospitalService.structureToString(d));

    }

    @Test
    public void testCreateNeo4jGraphFromSampleActuallyExists() throws Exception {
        String label = "Alpha";
        Division d = getSampleRoot();
        d.setName(label);
        d = hospitalService.attachFullTree(d);
        Node n4 = hospitalNeo4jDao.getNeo4jDb().getNodeById(4);
        assertNotNull(n4);
        assertEquals("Huey",n4.getProperty(DIVISION_DISPLAY_PROPERTY));

    }

    @Test
    public void testCypher() throws  Exception {
 
        Transaction tx = hospitalNeo4jDao.getNeo4jDb().beginTx();
        try {
            Node graphRefNode = hospitalNeo4jDao.getNeo4jDb().getReferenceNode();
            hospitalNeo4jDao.createAndAttachDivisionNode(graphRefNode, "fred");
            tx.success();
        } finally {
            tx.finish();
        }
        ExecutionEngine engine = new ExecutionEngine(hospitalNeo4jDao.getNeo4jDb());
        String q = "start n=node(1) return n";
        logger.info(" q\n" + q);
        final ExecutionResult executionResult = engine.execute(q);
        // these methods exhaust the iterator
        //logger.debug(executionResult.dumpToString());
       // assertEquals(2, executionResult.size());
       // logger.debug(executionResult.dumpToString());
        String cLabel = "n";
        List<String> columns = executionResult.javaColumns();
        assertEquals(1, columns.size());
        assertEquals(cLabel, columns.get(0));
        Iterator<Object> columnAs = executionResult.javaColumnAs(cLabel);
        while (columnAs.hasNext()) {
            Node j = (Node) columnAs.next();
            assertEquals("fred",j.getProperty(DIVISION_DISPLAY_PROPERTY,null));
        }


    }

    @Test
    public void testCypherForDivisions() throws Exception {
        String label = "Alpha";
        Division d = getSampleRoot();
        d.setName(label);
        d = hospitalService.attachFullTree(d);
        ExecutionEngine engine = new ExecutionEngine(hospitalNeo4jDao.getNeo4jDb());
        String q = "start n=node(*) return n";
        logger.info(" q\n" + q);
        final ExecutionResult executionResult = engine.execute(q);
        //both of these methods will exhaust the iterator!!!!
       // assertEquals(8, executionResult.size());
       // logger.debug(executionResult.dumpToString());
        
        String cLabel = "n";
        List<String> columns = executionResult.javaColumns();
        assertEquals(1, columns.size());

        assertEquals(cLabel, columns.get(0));

        Iterator<Object> columnAs = executionResult.javaColumnAs(cLabel);
        while (columnAs.hasNext()) {
            Object j = columnAs.next();
           // logger.debug("j " + j.toString());
        }
       

    }

    
    @Ignore
    public void testLoadJSON() throws Exception {
        // InputStream in = this.getClass().getClassLoader().getResourceAsStream("json_tree.json");

        // mapper.readValue(in, Division.class);


        Division root = getSampleRoot();
        root.getChildren().get(0).setId(new Long(55));
        String temp = mapper.defaultPrettyPrintingWriter().writeValueAsString(root);
        logger.info("\n" + temp);

    }
}
