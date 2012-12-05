/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.impl;


 
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.google.inject.Singleton;

/**
 *
 * @author dhenton
 */
@Singleton
public class ApplicationsDaoImpl 
extends GuiceGenericDaoImpl<Applications,Integer> 
implements IApplicationsDao {
    
     
     public ApplicationsDaoImpl() {
        super(Applications.class);
    }
}
