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
import com.dhenton9000.hibernatesecurity.dao.SecurityDAO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dhenton
 */
public class SecurityService implements ISecurityService {

    @Override
    public void delete(Object obj) throws DataAccessLayerException {
        SecurityDAO.getInstance().delete(obj);
    }

    @Override
    public ApplicationGroups deleteApplicationGroup(int appId, int groupId) throws DataAccessLayerException {
        return SecurityDAO.getInstance().deleteApplicationGroup(appId, groupId);
    }

    @Override
    public GroupAssignments deleteGroupAssignment(int gId, String uId) throws DataAccessLayerException {
       return SecurityDAO.getInstance().deleteGroupAssignment(gId, uId);
    }

    @Override
    public Object find(Class itemClass, Serializable id) throws DataAccessLayerException {
       return  SecurityDAO.getInstance().find(itemClass, id);
    }

    @Override
    public List findAll(Class clazz) throws DataAccessLayerException {
        return  SecurityDAO.getInstance().findAll(clazz);
    }

    @Override
    public List getAvailableGroupsForApplication(Integer appId) throws DataAccessLayerException {
        return  SecurityDAO.getInstance().getAvailableGroupsForApplication(appId);
    }

    @Override
    public List getAvailableUsersForGroups(Integer groupId) throws DataAccessLayerException {
       return  SecurityDAO.getInstance().getAvailableUsersForGroups(groupId);
    }

    @Override
    public long getCountForClass(Class clazz) throws DataAccessLayerException {
        return  SecurityDAO.getInstance().getCountForClass(clazz);
    }

    @Override
    public List getDataForQuery(String queryString) throws DataAccessLayerException {
        return  SecurityDAO.getInstance().getDataForQuery(queryString);
    }

    @Override
    public List getGroupsForApplication(Integer appId) throws DataAccessLayerException {
       return  SecurityDAO.getInstance().getGroupsForApplication(appId);
    }

    @Override
    public Page getPageOfData(String queryString, int pageNum, int pageSize) throws DataAccessLayerException {
        return  SecurityDAO.getInstance().getPageOfData(queryString, pageNum, pageSize);
    }

    @Override
    public Page getPageOfDataForClass(Class clazz, int pageNum, int pageSize) throws DataAccessLayerException {
         return  SecurityDAO.getInstance().getPageOfDataForClass(clazz, pageNum, pageSize);
    }

    @Override
    public List getUsersForGroups(Integer groupId) throws DataAccessLayerException {
        return  SecurityDAO.getInstance().getUsersForGroups(groupId);
    }

    @Override
    public void save(Object obj) throws DataAccessLayerException {
           SecurityDAO.getInstance().save(obj);
    }

    @Override
    public void saveOrUpdate(Object obj) throws DataAccessLayerException {
          SecurityDAO.getInstance().saveOrUpdate(obj);
    }

}
