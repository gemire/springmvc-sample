/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.starter.neo4j.hospital;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import com.dhenton9000.neo4j.hospital.json.JSONHospitalServiceImpl;
import com.dhenton9000.neo4j.hospital.json.Provider;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * uses simple tree to test writing an entire tree to an impermanent neo4j db
 *
 * @author dhenton
 */
public class ProviderDivisionTest extends HospitalTestBase {
    public static final String PROVIDER_LABEL = "Provider1";

    private final Logger logger = LoggerFactory.getLogger(ProviderDivisionTest.class);
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
    public void testDbCreate() {
        assertNotNull(this.getGraphDb());
    }

     
    @Test
    public void testJSONForSample() throws IOException
    {
        String t = jService.structureToString(getSampleRoot());
        logger.debug("t\n"+t);
        HospitalNode root = jService.stringToStructure(t);
        HospitalNode h = root.getChildren().get(0);
        assertEquals(PROVIDER_LABEL,h.getName());
        Provider p = (Provider) h;
        assertNotNull(p);
        assertEquals(PROVIDER_LABEL,p.getName());
    }
    
   
    @Override
    protected Division getSampleRoot() {

        ArrayList<HospitalNode> children = new ArrayList<HospitalNode>();
        Division d = null;
        Division root = new Division();
        root.setName("Alpha");
        root.setChildren(children);
        d = new Division();
        d.setName("Manny");
        HospitalNode h = new Provider();
        h.setName(PROVIDER_LABEL);
        children.add(h);
        
        
        return root;

    }

    
}
