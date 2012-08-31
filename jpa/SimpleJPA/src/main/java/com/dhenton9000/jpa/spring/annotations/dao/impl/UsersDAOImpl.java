/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.spring.annotations.dao.impl;

import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.spring.annotations.dao.UsersDAO;
import org.apache.log4j.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dhenton
 */
 
@Repository(value="usersDAO") 
public class UsersDAOImpl extends DaoBaseImpl<Users,String> implements UsersDAO {

    private static final Logger log = LogManager.getLogger(UsersDAOImpl.class);
    public UsersDAOImpl()
    {
        super(Users.class);
    }

    @Override
    public Users getHydratedUser(String userId) throws DataAccessException {
         Users foundUser = null;
         String query = "SELECT u FROM Users u ";
         query += " left outer join fetch u.groupsSet g";
         query += " left outer join fetch g.applicationsSet uu";
         query += " left outer join fetch g.usersSet uu";
         query += " WHERE u.userid = :userId";
         QueryParameter qParm = new QueryParameter("userId", userId);
         foundUser = getQuerySingleResult(query,qParm);
         return foundUser;
        
    }

    
    
     
     

    
    
    
    
}
