/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.impl;

import com.dhenton9000.jpa.dao.hibernate.HibernateGenericDaoImpl;
import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.wicket.dao.IGroupsDao;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dhenton
 */
@Repository
public class GroupsDaoImpl
        extends HibernateGenericDaoImpl<Groups, Integer>
        implements IGroupsDao {

    private final static Logger logger = LoggerFactory.getLogger(GroupsDaoImpl.class);

    public GroupsDaoImpl() {
        super(Groups.class);
    }

    @Override
    public List<Groups> getAllGroups() {


        SearchTemplate t = new SearchTemplate();
        t.setNamedQuery("Groups.findAll");
        // the applications object is a dummy to hold parameters 
        // if the named query is parameterized.
        return this.find(new Groups(), t);

    }

   

}