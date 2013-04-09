/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.json;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author dhenton
 */
public class JSONSerializationTest {

    private final Logger logger = LoggerFactory.getLogger(JSONSerializationTest.class);
    private static JSONHospitalServiceImpl jsonService = new JSONHospitalServiceImpl();
    private static final String SAMPLE = "{\"type\":\"Division\",\"id\":1,\"name\":\"Alpha\",\"children\":[{\"type\":\"Division\",\"id\":2,\"name\":\"Division2\"},{\"type\":\"Provider\",\"id\":3,\"name\":\"Provider2\",\"children\":[{\"type\":\"Provider\",\"id\":4,\"name\":\"Provider4\"}]},{\"type\":\"Provider\",\"id\":5,\"name\":\"Provider3\"}]}";

    @Test
    public void checkStringToNode() throws Exception {

        Division d = new Division();
        d.setName("get a job");
        d.setisOpen(true);

        String s = jsonService.structureToString(d);
        logger.debug("\n\n"+s+"\n\n");
         logger.debug("\n\n"+SAMPLE+"\n\n");
        Division d2 = jsonService.stringToStructure(s);
        assertEquals(d.getName(),d2.getName());
        assertEquals(d.isOpen(),d2.isOpen());

    }
    
    @Test
    public void testWebSample() throws Exception
    {
        Division d2 = jsonService.stringToStructure(SAMPLE);
        ArrayList<HospitalNode> dList = new ArrayList<HospitalNode>();
        dList.add(d2);
        String fred = jsonService.divArrayToString(dList);
        logger.debug("\n\n\n"+fred+"\n\n");
        
    }
}
