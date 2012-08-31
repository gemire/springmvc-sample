/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.lobdemo.dao;

import com.dhenton9000.lobdemo.model.LobTable;
import com.dhenton9000.jpa.dao.hibernate.HibernateGenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dhenton
 */
@Repository
public class LobTableDAOImpl extends HibernateGenericDao<LobTable, Integer> implements LobTableDAO {
    
    
    public LobTableDAOImpl() {
        super(LobTable.class);
    }
    
    
}

 