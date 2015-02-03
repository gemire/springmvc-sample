/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatesecurity.service;

import com.dhenton9000.hibernatesecurity.ApplicationGroups;
import com.dhenton9000.hibernatesecurity.GroupAssignments;
import com.dhenton9000.hibernatesecurity.dao.DataAccessLayerException;
import com.dhenton9000.hibernatesecurity.dao.Page;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface ISecurityService {

    /**
     * Delete an object
     *
     *
     * @param obj
     *
     * @throws DataAccessLayerException
     */
    void delete(Object obj) throws DataAccessLayerException;

    /**
     * Method description TODO
     *
     *
     * @param appId
     * @param groupId
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    ApplicationGroups deleteApplicationGroup(int appId, int groupId) throws DataAccessLayerException;

    /**
     * Method description TODO
     *
     *
     * @param aId
     * @param uId
     */
    GroupAssignments deleteGroupAssignment(int gId, String uId) throws DataAccessLayerException;

    /**
     * Find a single table row for an id
     *
     *
     * @param itemClass
     * @param id
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    Object find(Class itemClass, Serializable id) throws DataAccessLayerException;

    /**
     * Method description TODO
     *
     *
     * @param clazz
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    List findAll(Class clazz) throws DataAccessLayerException;

    /**
     * Get the available groups that can be assigned to an
     * application
     * @param appId
     * @return
     * @throws DataAccessLayerException
     */
    List getAvailableGroupsForApplication(Integer appId) throws DataAccessLayerException;

    /**
     * Get the available groups that can be assigned to an
     * application
     *
     * @param groupId
     * @return
     * @throws DataAccessLayerException
     */
    List getAvailableUsersForGroups(Integer groupId) throws DataAccessLayerException;

    /**
     * Method description TODO
     *
     *
     * @param clazz
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    long getCountForClass(Class clazz) throws DataAccessLayerException;

    /**
     * Method description TODO
     *
     *
     * @param queryString
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    List getDataForQuery(String queryString) throws DataAccessLayerException;

    /**
     * gets the groups that are not assigned to
     * the given application
     * @param appId
     * @return
     * @throws DataAccessLayerException
     */
    List getGroupsForApplication(Integer appId) throws DataAccessLayerException;

    /**
     * This will get a page of data for a given query
     * @param queryString the hibernate query string to use
     * @param pageNum page number starting with 1 the page number is
     * 1 based and will be used to set first result to (pageNum -1) * pageSize
     * @param pageSize the size of objects to retrieve
     * @return returns the list of objects
     *
     * @throws DataAccessLayerException
     */
    Page getPageOfData(String queryString, int pageNum, int pageSize) throws DataAccessLayerException;

    /**
     * Method description TODO
     *
     *
     * @param clazz
     * @param pageNum
     * @param pageSize
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    Page getPageOfDataForClass(Class clazz, int pageNum, int pageSize) throws DataAccessLayerException;

    /**
     * Method description TODO
     *
     *
     * @param groupId
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    List getUsersForGroups(Integer groupId) throws DataAccessLayerException;

    /**
     *
     * Adds a new object to the persistence system
     *
     * @param obj
     *
     * @throws DataAccessLayerException if trying to add a duplicate key
     */
    void save(Object obj) throws DataAccessLayerException;

    /**
     * save or update the object save if new update if already present
     *
     * @param obj
     *
     * @throws DataAccessLayerException if during an update the key is
     * violated or on general error
     */
    void saveOrUpdate(Object obj) throws DataAccessLayerException;
    
}
