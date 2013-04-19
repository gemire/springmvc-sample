/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.selenium;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;


/**
 *
 * @author dhenton
 */
public class SimpleTest extends HospitalNeo4jSeleniumTestBase {

    private final Logger logger = LoggerFactory.getLogger(SimpleTest.class);

        
    
    @Test
    public void testGetName() {
        
        
        String selectedNode = go().selectATree(1).getSelectedNodeName();
        String formText = this.getFormText("maintainName");
        assertEquals(formText,selectedNode);
         
    }
    
    @Test
    public void testGetNodeId()
    {
        Long selectedNode = go().selectATree(1).getSelectedNodeId();
        assertEquals(new Long(3),selectedNode);
    }
    
    @Test
    public void testAddANodeToCurrent()
    {
        Long rootId = go().selectATree("alpha").getSelectedNodeId();
        String selectedNode = selectNode(rootId.intValue()+2).getSelectedNodeName();
        String formText = this.getFormText("maintainName");
        assertEquals(formText,selectedNode);
    }
}
