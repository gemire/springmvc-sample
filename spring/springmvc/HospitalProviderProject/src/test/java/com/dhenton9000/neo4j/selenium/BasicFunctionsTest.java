/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.selenium;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import static org.junit.Assert.*;

/**
 *
 * @author dhenton
 */
public class BasicFunctionsTest extends HospitalNeo4jSeleniumTestBase {

    private final Logger logger = LoggerFactory.getLogger(BasicFunctionsTest.class);
    private final static String[] TEST_NODE = {"root100", "root100-alpha", "root100-beta"};
    private final static Long[] TEST_NODE_ID = new Long[TEST_NODE.length];

    @BeforeClass
    public static void beforeTests() {
        //createTestTree();
    }

    @AfterClass
    public static void afterTests() {
        // deleteTestTree();
    }

    private void createTestTree() {
        go().createTree(TEST_NODE[0]);
        pause();
        Long id = this.getSelectedNodeId();
        TEST_NODE_ID[0] = id;
        pause();
        addNodeToCurrent(TEST_NODE[1]);
        pause();
        id = this.getSelectedNodeId();
        TEST_NODE_ID[1] = id;
        pause();
        addNodeToCurrent(TEST_NODE[2]);
        pause();
        id = this.getSelectedNodeId();
        TEST_NODE_ID[2] = id;
    }

    private void deleteTestTree() {
        go().selectATree(TEST_NODE[0]).pause()
                .selectNode(TEST_NODE_ID[2].intValue())
                .pause()
                .removeNode(TEST_NODE[2])
                .selectNode(TEST_NODE_ID[1].intValue())
                .pause()
                .removeNode(TEST_NODE[1])
                .selectNode(TEST_NODE_ID[0].intValue())
                .pause()
                .removeNode(TEST_NODE[0]);
    }

    @Test
    public void testAddDeleteTestTree() {

        createTestTree();
        pause();
        deleteTestTree();
    }
}
