/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import java.io.IOException;
import java.util.List;


/**
 * This service handles divisions and providers. There should never be
 * any direct reference to nodes or indices
 * @author dhenton
 */
public interface HospitalService {

   
    
    /**
     * Build a division object from a point in the tree using the start
     * points division label. For example, build the entire tree starting
     * from an existing  node, e.g.  'Midwest'.  
     * 
     * @param startDivisionLabel
     * @return an assembled division object
     */
    Division buildDivisonFromDb(String startDivisionLabel);
    
    
 
    /**
     * given a proper JSON string, return the division object
     * @param jsonString
     * @return
     * @throws IOException 
     */
    Division stringToStructure(String jsonString) throws IOException;
    /**
     * given a proper division object get the JSON string
     * @param root
     * @return
     * @throws IOException 
     */
    String structureToString(Division root) throws IOException;
    
    /**
     * Given a division attach this whole tree to the root node of the
     * neo4j graph. The id property can be empty
     * @param d the graph as as division, this is only a sample, ids will
     * be filled in when attached
     * @return the root Division with the id now filled in
     * @throws  when there is a service error, eg trying to attach a division
     * that already exists
     */
    public Division attachFullTree(Division d) throws HospitalServiceException;
    
    /**
     * 
     * @param list of nodes
     * @return JSON array
     */
    public String divArrayToString(List<HospitalNode> list) throws IOException;
}
