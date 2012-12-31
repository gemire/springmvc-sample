/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.impl;

import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.dhenton9000.wicket.dao.IGroupsDao;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
@Singleton
public class GroupsDaoImpl
        extends GuiceGenericDaoImpl<Groups, Integer>
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