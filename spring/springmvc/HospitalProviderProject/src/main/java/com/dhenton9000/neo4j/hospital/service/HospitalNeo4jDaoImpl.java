/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.Index;

/**
 *
 * @author dhenton
 */
public class HospitalNeo4jDaoImpl implements HospitalNeo4jDao {

    private GraphDatabaseService neo4jDb;

    @Override
    public Node createAndAttachDivisionNode(Node parent, String nodeLabel) {
        Node currentNode = getNeo4jDb().createNode();
        parent.createRelationshipTo(currentNode, RelationshipTypes.IS_DIVIDED_INTO);
        getTypeIndex().add(currentNode, NODE_TYPE.TYPE.toString(), NODE_TYPE.DIVISIONS.toString());
        currentNode.setProperty(NODE_TYPE.TYPE.toString(), NODE_TYPE.DIVISIONS.toString());
        getDivisionIndex().add(currentNode, DIVISION_DISPLAY_PROPERTY, nodeLabel);
        currentNode.setProperty(DIVISION_DISPLAY_PROPERTY, nodeLabel);
        return currentNode;
    }

    @Override
    public Node createAndAttachProviderNode(Node parent, String nodeLabel) {
        Node currentNode = getNeo4jDb().createNode();
        parent.createRelationshipTo(currentNode, RelationshipTypes.DERIVES_SERVICE_FROM);
        getTypeIndex().add(currentNode, NODE_TYPE.TYPE.toString(), NODE_TYPE.PROVIDERS.toString());
        currentNode.setProperty(NODE_TYPE.TYPE.toString(), NODE_TYPE.PROVIDERS.toString());
        getProviderIndex().add(currentNode, PROVIDER_DISPLAY_PROPERTY, nodeLabel);
        currentNode.setProperty(PROVIDER_DISPLAY_PROPERTY, nodeLabel);
        return currentNode;
    }

    /**
     * @return the neo4jDb
     */
    @Override
    public GraphDatabaseService getNeo4jDb() {
        return neo4jDb;
    }

    /**
     * @param neo4jDb the neo4jDb to set
     */
    @Override
    public void setNeo4jDb(GraphDatabaseService neo4jDb) {
        this.neo4jDb = neo4jDb;
    }

    private Index<Node> getIndex(String indexNodeLabel) {
        return getNeo4jDb().index().forNodes(indexNodeLabel);
    }

    private Index<Node> getDivisionIndex() {
        return getIndex(DIVISION_DISPLAY_INDEX);
    }

    private Index<Node> getProviderIndex() {
        return getIndex(PROVIDER_DISPLAY_INDEX);
    }

    private Index<Node> getTypeIndex() {
        return getIndex(TYPE_INDEX);
    }

 
    
      @Override
    public String getDisplayMessage(Node currentNode) {
        NODE_TYPE type = getNodeType(currentNode);
        String lVar = "";
        switch (type) {
            case DIVISIONS:

                lVar = (String) currentNode.getProperty(DIVISION_DISPLAY_PROPERTY);
                break;

            case PROVIDERS:
                lVar = (String) currentNode.getProperty(PROVIDER_DISPLAY_PROPERTY);
                break;

            default:
                throw new RuntimeException(" got fault " + currentNode.toString());
        }
        return lVar;
    }

    @Override
    public NODE_TYPE getNodeType(Node node) {
        String t = (String) node.getProperty(NODE_TYPE.TYPE.toString());
        NODE_TYPE res = NODE_TYPE.valueOf(t);
        if (res == null) {
            throw new RuntimeException("got node type error " + t);
        }
        return res;
    }

    @Override
    public Node getDivisionNode(String nodeName) {

        Node dItem = null;
        try {
            dItem = getDivisionIndex().get(DIVISION_DISPLAY_PROPERTY, nodeName).getSingle();
        } catch (RuntimeException rrr) {
            throw new RuntimeException("getDivisionNode found more than one node for '"+nodeName+"'");
        }
        return dItem;
    }
    
    @Override
     public void attachSubTree(HospitalNode subD, Node parent) {
        String nodeLabel = subD.getName();
        Node rootNode = createAndAttachDivisionNode(parent, nodeLabel);
        subD.setId(rootNode.getId());
        for (HospitalNode dChild : subD.getChildren()) {
            attachSubTree(dChild, rootNode);
        }
    }

    
}
