/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao;

import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.wicket.dao.impl.ApplicationsDaoImpl;
import java.util.List;

/**
 *
 * @author dhenton
 */

public interface IApplicationsDao extends GenericDao<Applications, Integer>{
    
    List<Applications> getAllApplications();

    public List<Users> findUsersForApplications(Applications app);
    
    public List<Applications> getAllApplicationswithLimits(long start, long count);
    
}
