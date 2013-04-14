/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.json.Provider;
import java.util.List;
import java.util.Map;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

/**
 * The Dao directly handles Neo4j nodes and indices
 *
 * @author dhenton
 */
public interface HospitalNeo4jDao {

    public static final String DIVISION_DISPLAY_PROPERTY = "division_display_property";
    public static final String PROVIDER_DISPLAY_PROPERTY = "provider_display_property";
    public static final String DIVISION_DISPLAY_INDEX = "division_display_index";
    public static final String TYPE_INDEX_PROPERTY = "TYPE";
    public static final String PROVIDER_DISPLAY_INDEX = "provider_display_index";
    public static final String PROVIDER_DB_KEY = "provider_db_key";
    public static final String TYPE_INDEX = "type_index";

    public enum RelationshipTypes implements RelationshipType {

        IS_DIVIDED_INTO,
        DERIVES_SERVICE_FROM
    }

    public enum NODE_TYPE {

        DIVISIONS, PROVIDERS
    }

    /**
     * remove a node and handle all indices
     *
     * @param n1
     */
    void removeNode(Node n1);

    /**
     * create a node attached immediately to the neo4j root. In business terms,
     * this is the company
     *
     * @param nodeLabel
     * @return
     */
    Node createInitialNode(String nodeLabel)
            throws HospitalServiceException;

    /**
     * Attach a divisions node with the provided label to the parent
     *
     * @param parent
     * @param nodeLabel
     * @return
     * @throws HospitalServiceException on duplicate request
     */
    Node createAndAttachDivisionNode(Node parent, String nodeLabel)
            throws HospitalServiceException;

    /**
     * Attach a provider node with the provided label to the parent
     *
     * @param parent
     * @param nodeLabel
     * @return
     * @throws HospitalServiceException on duplicate request or if trying to
     * attach to an illegal node
     */
    Node createAndAttachProviderNode(Node parent, String nodeLabel) throws HospitalServiceException;

    /**
     * Persist a division and all its children. Return a pointer to the division
     * with its id
     *
     * @param d
     * @return
     * @throws HospitalServiceException
     */
    Division attachFullTree(Division d) throws HospitalServiceException;

    /**
     * build a complete division tree from the persistence store
     *
     * @param startDivisionLabel
     * @return
     */
    Division buildDivisionFromDb(String startDivisionLabel);

    /**
     * change the label on an existing node
     *
     * @param n1
     * @param newLabel
     * @return
     */
    Node changeNodeLabel(Node n1, String newLabel);

    /**
     * Get all the nodes under the given type
     *
     * @param type
     * @return
     */
    List<Node> getAllNodesForType(NODE_TYPE type);

    /**
     * return a node by its neo4j id
     *
     * @param id
     * @return
     */
    Node getNodeById(Long id);

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
     *
     * @param currentNode
     * @return
     */
    String getDisplayMessage(Node currentNode);

    /**
     * Lookup a division node by its label.
     *
     * @param nodeName
     * @return null if nothing found
     * @throws RuntimeException if more than one value found;
     */
    Node getDivisionNode(String nodeName);

    /**
     * Lookup a division node by its label.
     *
     * @param nodeName
     * @return null if nothing found
     * @throws RuntimeException if more than one value found;
     */
    Node getProviderNode(String nodeName);

    /**
     * attach subtree of nodes to a parent node
     *
     * @param subD
     * @param parent
     *
     */
    void attachSubTree(HospitalNode subD, Node parent) throws HospitalServiceException;

    /**
     * Determine the node type to the enum
     *
     * @param node
     * @return
     */
    NODE_TYPE getNodeType(Node node);

    /**
     * Attach a provider to a parent
     *
     * @param parent
     * @param p
     * @return the provider or null if parent not found
     * @throws when the parent already has divisions attached
     */
    Provider attachProvider(Division parent, Provider p) throws HospitalServiceException;

    /**
     * get a map of the first nodes, or tree start points, with the id as key
     * and name/label as value returns null if nothing found
     *
     * @return
     *
     */
    Map<String, String> getInitialNodes();

    /**
     * attach a new node to an existing parent
     * @param parentLabel
     * @param newDivisionLabel
     * @throws HospitalServiceException if parent doesn't exist, 
     * if request label is a duplicate, if requested label is for a Provider
     */
    void attachDivisionbyLabels(String parentLabel,
            String newDivisionLabel) throws HospitalServiceException;
}
