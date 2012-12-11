/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.impl;

import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.google.inject.Singleton;
import java.util.List;

/**
 *
 * @author dhenton
 */
@Singleton
public class ApplicationsDaoImpl
        extends GuiceGenericDaoImpl<Applications, Integer>
        implements IApplicationsDao {

    public ApplicationsDaoImpl() {
        super(Applications.class);
    }

    @Override
    public List<Applications> getAllApplications() {


        SearchTemplate t = new SearchTemplate();
        t.setNamedQuery("Applications.findAll");
        // the applications object is a dummy to hold parameters 
        // if the named query is parameterized.
        return this.find(new Applications(), t);

    }

    @Override
    public List<Users> findUsersForApplications(Applications app) {
        Integer appKey = app.getId();
         SearchTemplate t = new SearchTemplate();
          return null;
    }
}
