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

/**
 *
 * @author dhenton
 */
public class BasicFunctionsTest extends HospitalNeo4jSeleniumTestBase {

    private final Logger logger = LoggerFactory.getLogger(BasicFunctionsTest.class);
    private final static String TEST_TREE_ROOT = "root100";
    private final static String[] TEST_NODE = {"root100-alpha", "root100-beta"};

    @Before
    public void beforeTests() {
        // createTestTree();
    }

    @After
    public void afterTests() {
        // deleteTestTree();
    }

    private void createTestTree() {
        go().createTree(TEST_TREE_ROOT)
                .addNodeToCurrent(TEST_NODE[0])
                .selectNode(TEST_TREE_ROOT)
                .addNodeToCurrent(TEST_NODE[1]);
    }

    private void deleteTestTree() {
        go().selectATree(TEST_TREE_ROOT).pause()
                .selectNode(TEST_NODE[1])
                .pause()
                // .removeNode(TEST_NODE[1])
                .selectNode(TEST_NODE[0]).pause()
                // .removeNode(TEST_NODE[0])
                .selectNode(TEST_TREE_ROOT);
        // .removeNode(TEST_TREE_ROOT);
    }

    @Test
    public void testAddDeleteTestTree() {
           go().selectATree(TEST_TREE_ROOT)
                .pause()
                .selectNode(TEST_NODE[0])
                .pause()
                .selectNode(TEST_NODE[1])
                .pause();
                
    }
}
