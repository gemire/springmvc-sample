/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.json.Provider;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import static com.dhenton9000.neo4j.hospital.service.HospitalNeo4jDao.*;

/**
 * Service class for processing JSON for the Provider structures
 *
 * @author dhenton
 */
public class HospitalServiceImpl implements HospitalService  {

    private GraphDatabaseService neo4jDb;
    private ObjectMapper mapper = new ObjectMapper();
    private static Logger log = LogManager.getLogger(HospitalServiceImpl.class);
    private HospitalNeo4jDao hospitalDao = null;

    @Override
    public Division attachFullTree(Division d) throws HospitalServiceException {
        Transaction tx = getHospitalDao().getNeo4jDb().beginTx();
        Node rootNode = null;
        String nodeLabel = d.getName();
        Node testNode = getHospitalDao().getDivisionNode(nodeLabel);
        if (testNode == null) {
            try {
                Node graphRefNode = getHospitalDao().getNeo4jDb().getReferenceNode();
                log.debug("got in attach " + nodeLabel);
                rootNode = getHospitalDao().createAndAttachDivisionNode(graphRefNode, nodeLabel);
                d.setId(rootNode.getId());
                for (HospitalNode dChild : d.getChildren()) {
                    getHospitalDao().attachSubTree(dChild, rootNode);
                }

                tx.success();

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
    public String structureToString(Division root) throws IOException {
        String temp = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        return temp;
    }

    @Override
    public String divArrayToString(List<HospitalNode> root) throws IOException {
        String temp = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        return temp;
    }

    @Override
    public Division stringToStructure(String jsonString) throws IOException {
        return mapper.readValue(jsonString, Division.class);
    }

    @Override
    public Division buildDivisonFromDb(String startDivisionLabel) {
        Division root = new Division();
        Node dItem = getHospitalDao().getDivisionNode(startDivisionLabel);
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
        String nextItem = getHospitalDao().getDisplayMessage(item);
        Iterable<Relationship> rels =
                item.getRelationships(Direction.OUTGOING);
        parent.setName(nextItem);

        if (rels.iterator().hasNext()) {
            for (Relationship r : rels) {
                HospitalNode hNode = new Division();
                Node currentNode = r.getEndNode();
                NODE_TYPE type = getHospitalDao().getNodeType(currentNode);
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


                String lVar = getHospitalDao().getDisplayMessage(currentNode);
                hNode.setName(lVar);
                hNode.setId(currentNode.getId());
                parent.getChildren().add(hNode);
                buildDivisionElement(currentNode, hNode);
            }


        }




    }

    /**
     * @return the hospitalDao
     */
    public HospitalNeo4jDao getHospitalDao() {
        return hospitalDao;
    }

    /**
     * @param hospitalDao the hospitalDao to set
     */
    public void setHospitalDao(HospitalNeo4jDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

  



    
}
