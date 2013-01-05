/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao;

import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Wine;
import com.dhenton9000.wicket.dao.impl.WineDaoImpl;
import com.google.inject.ImplementedBy;
 

/**
 *
 * @author dhenton
 */
@ImplementedBy(WineDaoImpl.class)
public interface IWineDao extends GenericDao<Wine, Integer>{
    
    
}
