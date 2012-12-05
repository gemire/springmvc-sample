/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao;

import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.dao.hibernate.HibernateGenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dhenton
 */
@Repository
public class UsersDAOImpl extends HibernateGenericDao<Users, String> implements UsersDAO {
    
    
    public UsersDAOImpl() {
        super(Users.class);
    }
    
    
}

 