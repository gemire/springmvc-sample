/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao;

import com.dhenton9000.wicket.dao.impl.ApplicationsDaoImpl;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Applications;
import com.google.inject.ImplementedBy;
import java.util.List;

/**
 *
 * @author dhenton
 */
@ImplementedBy(ApplicationsDaoImpl.class)
public interface IApplicationsDao extends GenericDao<Applications, Integer>{
    
    List<Applications> getAllApplications();
    
}
