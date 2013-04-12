/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.json.Provider;
import com.dhenton9000.neo4j.utils.DatabaseHelper;
import java.util.Iterator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;

/**
 *
 * @author dhenton
 */
public class HospitalNeo4jDaoImpl implements HospitalNeo4jDao {

    private GraphDatabaseService neo4jDb;
    private final Logger log = LogManager.getLogger(HospitalNeo4jDaoImpl.class);
    private DatabaseHelper dbHelper = new DatabaseHelper();

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
        if (nodeName == null) {
            return null;
        }
        try {
            dItem = getDivisionIndex().get(DIVISION_DISPLAY_PROPERTY, nodeName).getSingle();
        } catch (RuntimeException rrr) {
            throw new RuntimeException("getDivisionNode found more than one node for '" + nodeName + "'");
        }
        return dItem;
    }

    @Override
    public Node getProviderNode(String nodeName) {

        Node dItem = null;
        if (nodeName == null) {
            return null;
        }
        try {
            dItem = getProviderIndex().get(PROVIDER_DISPLAY_PROPERTY, nodeName).getSingle();
        } catch (RuntimeException rrr) {
            throw new RuntimeException("getProviderNode found more than one node for '" + nodeName + "'");
        }
        return dItem;
    }

    @Override
    public void attachSubTree(HospitalNode subD, Node parent) throws HospitalServiceException {
        String nodeLabel = subD.getName();
        Node rootNode = createAndAttachDivisionNode(parent, nodeLabel);
        subD.setId(rootNode.getId());
        Iterator<HospitalNode> iter = subD.getChildren().iterator();

        while (iter.hasNext()) {
            HospitalNode dChild = iter.next();
            if (dChild instanceof Division) {
                attachSubTree(dChild, rootNode);
            } else {
                throw new HospitalServiceException("division tree contains a provider "
                        + "attachSubTree cannot be used for attaching providers "
                        + "use attachProvider in the service instead");
            }
        }
    }

    @Override
    public void removeNode(Node n1) {
        NODE_TYPE type = getNodeType(n1);
        Transaction tx = getNeo4jDb().beginTx();
        Index<Node> currentIndex = null;

        try {
            switch (type) {
                case DIVISIONS:
                    currentIndex = getDivisionIndex();
                    break;

                case PROVIDERS:
                    currentIndex = getProviderIndex();
                    break;
            }// end switch

            Iterable<Relationship> relations =
                    n1.getRelationships(Direction.INCOMING);

            Iterator<Relationship> iterRel = relations.iterator();
            while (iterRel.hasNext()) {
                Relationship rel = iterRel.next();
                rel.delete();
            }
            currentIndex.remove(n1);
            n1.delete();
            tx.success();

        } catch (Exception err) {
            log.error("error in removeNode\n " + err.getClass().getName()
                    + " " + err.getMessage());
        } finally {
            tx.finish();
        }
    }

    @Override
    public Division attachFullTree(Division d) throws HospitalServiceException {
        Transaction tx = getNeo4jDb().beginTx();
        Node rootNode = null;
        String nodeLabel = d.getName();
        Node testNode = getDivisionNode(nodeLabel);
        if (testNode == null) {
            try {
                Node graphRefNode = getNeo4jDb().getReferenceNode();
                log.debug("got in attach " + nodeLabel);
                rootNode = createAndAttachDivisionNode(graphRefNode, nodeLabel);
                d.setId(rootNode.getId());
                for (HospitalNode dChild : d.getChildren()) {
                    attachSubTree(dChild, rootNode);
                }

                tx.success();
                //dbHelper.dumpGraphToConsole(neo4jDb);
            } catch (HospitalServiceException herr) {
                throw new HospitalServiceException(herr.getMessage());
            } catch (Exception err) {
                log.error("error in attachFullTree\n " + err.getClass().getName()
                        + " " + err.getMessage());
            } finally {
                tx.finish();
            }
            return buildDivisonFromDb(nodeLabel);
        } else {
            throw new HospitalServiceException("node already exists " + nodeLabel);
        }

    }

    @Override
    public Division buildDivisonFromDb(String startDivisionLabel) {
        Division root = new Division();
        Node dItem = getDivisionNode(startDivisionLabel);
        if (dItem == null) {
            throw new RuntimeException("cannot find a node for '" + startDivisionLabel + "'");
        }
        String nextItem = (String) dItem.getProperty(DIVISION_DISPLAY_PROPERTY);
        root.setName(nextItem);
        root.setId(dItem.getId());
        buildDivisionElement(dItem, root);
        return root;
    }

    private void buildDivisionElement(Node item, HospitalNode parent) {
        String nextItem = getDisplayMessage(item);
        Iterable<Relationship> rels =
                item.getRelationships(Direction.OUTGOING);
        parent.setName(nextItem);

        if (rels.iterator().hasNext()) {
            for (Relationship r : rels) {
                HospitalNode hNode = new Division();
                Node currentNode = r.getEndNode();
                NODE_TYPE type = getNodeType(currentNode);
                switch (type) {
                    case DIVISIONS:

                        hNode = new Division();
                        break;

                    case PROVIDERS:
                        hNode = new Provider();
                        break;

                    default:
                        throw new RuntimeException(" got fault " + currentNode.toString());
                }


                String lVar = getDisplayMessage(currentNode);
                hNode.setName(lVar);
                hNode.setId(currentNode.getId());
                parent.getChildren().add(hNode);
                buildDivisionElement(currentNode, hNode);
            }


        }




    }

    public Node changeNodeLabel(Node n1, String manjack) {




        return n1;
    }

    public Provider attachProvider(Division parent, Provider p) {

        Node parentNode = getDivisionNode(parent.getName());
        if (parentNode == null) {
            return null;
        }
        Transaction tx = getNeo4jDb().beginTx();


        try {
            if (parent.getChildren().size() > 0 && parent.getChildren().get(0) instanceof Division) {
                throw new HospitalServiceException("cannot add a provider to parent with Divisons "
                        +"remove the divisions first");
            }

            createAndAttachDivisionNode(parentNode, p.getName());
            tx.success();

            // } catch (HospitalServiceException herr){
            //     throw new HospitalServiceException(herr.getMessage());
        } catch (Exception err) {
            log.error("error in attachFullTree\n " + err.getClass().getName()
                    + " " + err.getMessage());
        } finally {
            tx.finish();
        }


        return p;
    }
}
