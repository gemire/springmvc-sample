/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.dao.hibernate.HibernateGenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dhenton
 */
@Repository
public class ApplicationsDAOImpl extends HibernateGenericDaoImpl<Applications,Integer> implements ApplicationsDAO {
    
    
    public ApplicationsDAOImpl() {
        super(Applications.class);
    }
    
    
}

 