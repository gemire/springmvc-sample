/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

/**
 * The Dao directly handles Neo4j nodes and indices
 * @author dhenton
 */
public interface HospitalNeo4jDao {

    public static final String DIVISION_DISPLAY_PROPERTY = "division_display_property";
    public static final String PROVIDER_DISPLAY_PROPERTY = "provider_display_property";
    public static final String DIVISION_DISPLAY_INDEX = "division_display_index";
    public static final String PROVIDER_DISPLAY_INDEX = "provider_display_index";
    public static final String PROVIDER_DB_KEY = "provider_db_key";
    public static final String TYPE_INDEX = "type_index";

    public enum RelationshipTypes implements RelationshipType {

        IS_DIVIDED_INTO,
        DERIVES_SERVICE_FROM
    }

    public enum NODE_TYPE {

        TYPE, DIVISIONS, PROVIDERS, DISTRICTS
    }

    Node createAndAttachDivisionNode(Node parent, String nodeLabel);

    Node createAndAttachProviderNode(Node parent, String nodeLabel);

    
    /**
     * @return the neo4jDb
     */
    GraphDatabaseService getNeo4jDb();

    /**
     * @param neo4jDb the neo4jDb to set
     */
    void setNeo4jDb(GraphDatabaseService neo4jDb);
    
       /**
     * For a given live node compute its label. This takes into account that 
     * labels for Divisions are stored in one place, for providers in another
     * @param currentNode
     * @return 
     */
    String getDisplayMessage(Node currentNode);

    /**
     * Lookup a division node by its label. 
     * @param nodeName
     * @return null if nothing found
     * @throws RuntimeException if more than one value found;
     */
    Node getDivisionNode(String nodeName);

    /**
     * attach subtree of nodes to a parent node
     * @param subD
     * @param parent 
     */
    void attachSubTree(HospitalNode subD, Node parent);

    /**
     * Determine the node type to the enum
     * @param node
     * @return 
     */
    public NODE_TYPE getNodeType(Node node);
}
