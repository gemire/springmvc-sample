/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dhenton
 */
public class MaintainTreeFormBean {
    
    private String insertParentName = "";
    private String insertName = "";
    private String maintainName = "";
    private String maintainType = "";
    private String createTreeName = "";
    private String selectedTree = "NONE";
    private String selectedNodeId = "";
    private String treeData = "";
    private Map<String, String> treeSelectList = new HashMap<String, String>();

    /**
     * @return the insertParentName
     */
    public String getInsertParentName() {
        return insertParentName;
    }

    /**
     * @param insertParentName the insertParentName to set
     */
    public void setInsertParentName(String insertParentName) {
        this.insertParentName = insertParentName;
    }

    /**
     * @return the insertName
     */
    public String getInsertName() {
        return insertName;
    }

    /**
     * @param insertName the insertName to set
     */
    public void setInsertName(String insertName) {
        this.insertName = insertName;
    }

    /**
     * @return the maintainName
     */
    public String getMaintainName() {
        return maintainName;
    }

    /**
     * @param maintainName the maintainName to set
     */
    public void setMaintainName(String maintainName) {
        this.maintainName = maintainName;
    }

   
    /**
     * @return the maintainType
     */
    public String getMaintainType() {
        return maintainType;
    }

    /**
     * @param maintainType the maintainType to set
     */
    public void setMaintainType(String maintainType) {
        this.maintainType = maintainType;
    }

    /**
     * @return the createTreeName
     */
    public String getCreateTreeName() {
        return createTreeName;
    }

    /**
     * @param createTreeName the createTreeName to set
     */
    public void setCreateTreeName(String createTreeName) {
        this.createTreeName = createTreeName;
    }

    /**
     * @return the selectedTree
     */
    public String getSelectedTree() {
        return selectedTree;
    }

    /**
     * @param selectedTree the selectedTree to set
     */
    public void setSelectedTree(String selectedTree) {
        this.selectedTree = selectedTree;
    }

    /**
     * @return the treeData
     */
    public String getTreeData() {
        return treeData;
    }

    /**
     * @param treeData the treeData to set
     */
    public void setTreeData(String treeData) {
        this.treeData = treeData;
    }

    /**
     * @return the selectedNodeId
     */
    public String getSelectedNodeId() {
        return selectedNodeId;
    }

    /**
     * @param selectedNodeId the selectedNodeId to set
     */
    public void setSelectedNodeId(String selectedNodeId) {
        this.selectedNodeId = selectedNodeId;
    }

    /**
     * @return the treeSelectList
     */
    public Map<String, String> getTreeSelectList() {
        return treeSelectList;
    }

    /**
     * @param treeSelectList the treeSelectList to set
     */
    public void setTreeSelectList(Map<String, String> treeSelectList) {
        this.treeSelectList = treeSelectList;
    }
    
    
}
