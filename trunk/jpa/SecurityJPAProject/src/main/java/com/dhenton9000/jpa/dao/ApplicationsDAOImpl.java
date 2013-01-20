/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao;

import com.dhenton9000.jpa.dao.hibernate.BaseHibernateGenericDaoImpl;
import com.dhenton9000.jpa.dao.support.NamedQueryUtil;
import com.dhenton9000.jpa.entities.Applications;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dhenton
 */
@Repository
public class ApplicationsDAOImpl 
extends BaseHibernateGenericDaoImpl<Applications, Integer> 
implements ApplicationsDAO {

    public ApplicationsDAOImpl() {
        super(Applications.class);
    }

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired
    @Override
    public void setNamedQueryUtil(NamedQueryUtil namedQueryUtil) {
        this.namedQueryUtil = namedQueryUtil;
    }
}
