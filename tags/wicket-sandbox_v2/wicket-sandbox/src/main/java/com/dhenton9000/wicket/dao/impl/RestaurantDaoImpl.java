/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.impl;

import com.dhenton9000.jpa.dao.hibernate.BaseHibernateGenericDaoImpl;
import com.dhenton9000.jpa.dao.support.NamedQueryUtil;
import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.entities.Restaurant;
import com.dhenton9000.wicket.dao.IRestaurantDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dhenton
 */
@Repository
public class RestaurantDaoImpl
        extends BaseHibernateGenericDaoImpl<Restaurant, Integer>
        implements IRestaurantDao {

    private final static Logger logger = LoggerFactory.getLogger(RestaurantDaoImpl.class);

    public RestaurantDaoImpl() {
        super(Restaurant.class);
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
    
    
    
    @Override
    public List<Restaurant> getAllRestaurants() {


        SearchTemplate t = new SearchTemplate();
        t.setNamedQuery("Restaurant.findAll");
        // the applications object is a dummy to hold parameters 
        // if the named query is parameterized.
        return this.find(new Restaurant(), t);

    }
}