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
import java.util.Map;

/**
 * This service handles divisions and providers. There should never be any
 * direct reference to nodes or indices
 *
 * @author dhenton
 */
public interface HospitalService {

    /**
     * Build a division object from a point in the tree using the start points
     * division label. For example, build the entire tree starting from an
     * existing node, e.g. 'Midwest'.
     *
     * @param startDivisionLabel
     * @return an assembled division object
     */
    Division buildDivisonFromDb(String startDivisionLabel);

    /**
     * given a proper JSON string, return the division object
     *
     * @param jsonString
     * @return
     * @throws IOException
     */
    Division stringToStructure(String jsonString) throws IOException;

    /**
     * given a proper division object get the JSON string
     *
     * @param root
     * @return
     * @throws IOException
     */
    String structureToString(Division root) throws IOException;

    /**
     * Given a division attach this whole tree to the root node of the neo4j
     * graph. The id property can be empty
     *
     * @param d the graph as as division, this is only a sample, ids will be
     * filled in when attached
     * @return the root Division with the id now filled in
     * @throws when there is a service error, eg trying to attach a division
     * that already exists
     */
    Division attachFullTree(Division d) throws HospitalServiceException;

    /**
     *
     * @param list of nodes
     * @return JSON array
     */
    String divArrayToString(List<HospitalNode> list) throws IOException;

    /**
     * Attach a provider to a division node. Will handle the following logic
     * <ul> 
     * <li>cannot attach a provider to a provider</li> 
     * <li>parent cannot have any other Divisions as children</li> 
     * </ul> 
     * The Division must have an id or a label/name at least one
     *
     * @param p
     * @param parent
     * @return the Provider with a real id or null if parent not found
     */
    Provider attachProvider(Division parent, Provider provider)
            throws HospitalServiceException;
    
    /**
     * create a initial node off of the neo4j root with the divisionLabel as
     * name
     * @param divisionLabel
     * @return the division
     * @throws HospitalServiceException if duplicated
     */
    Division createInitialDivision(String divisionLabel) throws HospitalServiceException;

    /**
     * create a map of the initial first nodes in the db
     * key is the label of the node, as is the value
     * @return 
     */
    public Map<String,String> getInitialTreeMap();

    /**
     * attach a new Division to an existing Division as parentLabel
     * @param parentLabel
     * @param newDivisionLabel 
     * @return the new Division's id
     * @throws when parent node is not found or new label is a duplicate
     */
    public Long attachDivisionbyLabels(String parentLabel, 
            String newDivisionLabel) throws HospitalServiceException;
    
    /**
     * change the label of a node
     * @param newLabel
     * @throws HospitalServiceException 
     */
    public void
            changeLabel(HospitalNode hospitalNode, String newLabel) 
            throws HospitalServiceException;

    public HospitalNode getNodeById(Long parseLong);
    
    
    public void deleteNode(HospitalNode h) 
            throws HospitalServiceException;
}
