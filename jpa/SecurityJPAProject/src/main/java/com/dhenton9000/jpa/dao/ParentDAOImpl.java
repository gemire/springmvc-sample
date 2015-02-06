/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao;

import com.dhenton9000.jpa.dao.hibernate.BaseHibernateGenericDaoImpl;
import com.dhenton9000.jpa.dao.support.NamedQueryUtil;
import com.dhenton9000.jpa.entities.Parent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dhenton
 */
@Repository
public class ParentDAOImpl

extends BaseHibernateGenericDaoImpl<Parent, Integer> 
implements ParentDao

{
     public ParentDAOImpl() {
        super(Parent.class);
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
