/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.service;


import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import com.dhenton9000.wicket.dao.impl.GroupsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is a sample service class. The @Transactional attribute is responsible
 * for committing the transaction.
 *
 * @author dhenton
 */
@Service
public class GroupsServiceImpl extends GenericEntityServiceImpl<Groups,Integer> implements IGroupsService {

    protected GroupsDaoImpl groupsDao;

    @Autowired
    public void setGroupsDao(GroupsDaoImpl gDAO) {
        this.groupsDao = gDAO;
    }

    
    @Override
    public GroupsDaoImpl getDao() {
        return groupsDao;
    }

    @Override
    public Groups getNew() {
        return new Groups();
    }

    @Override
    public Groups getNewWithDefaults() {
        return getNew();
    }
}
