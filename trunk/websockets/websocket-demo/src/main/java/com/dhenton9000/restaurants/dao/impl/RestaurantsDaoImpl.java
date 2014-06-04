/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.restaurants.dao.impl;

import com.dhenton9000.restaurants.dao.RestaurantsDao;
import com.dhenton9000.restaurants.model.Restaurant;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class RestaurantsDaoImpl extends SqlSessionDaoSupport implements RestaurantsDao {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantsDaoImpl.class);

    @Override
    public List<Restaurant> getAll() {

        return this.getSqlSession().selectList("getAll");
    }
}
