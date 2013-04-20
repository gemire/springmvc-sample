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
        assertEquals(formText, selectedNode);

    }

    @Test
    public void testGetNodeId() {
        Long selectedNode = go().selectATree(1).getSelectedNodeId();
        assertEquals(new Long(1), selectedNode);
    }

    @Test
    public void testGetNodeIdForName() {
        int t = go().selectATree("snarf").getNodeIdForName("b1");
        assertEquals(8, t);
    }

    @Test
    public void testDelete() {
        go().createTree("monsoon").addNodeToCurrent("bratwurst").removeNode("bratwurst").removeNode("monsoon");

    }

    @Test
    public void testFindErrors() {
        go().createTree("monsoon");
        String t = getErrorText();
        logger.debug("t is " + t);
        assertNotNull(t);
        // assertNull(getErrorText());
        // addNodeToCurrent("monsoon");
        // assertNotNull(getErrorText());

    }

    @Test
    public void testGetNodeIdForNameFail() {
        int t = go().selectATree("snarf").getNodeIdForName("gasbag");
        assertEquals(-1, t);
    }

    @Ignore
    public void testAddANodeToCurrent() {
        Long rootId = go().selectATree("alpha").getSelectedNodeId();
        String selectedNode = selectNode(rootId.intValue() + 2).getSelectedNodeName();
        String formText = this.getFormText("maintainName");
        assertEquals(formText, selectedNode);
    }
}
