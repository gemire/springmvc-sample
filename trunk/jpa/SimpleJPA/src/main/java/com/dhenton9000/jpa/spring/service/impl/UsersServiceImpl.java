/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.spring.service.impl;

import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.entities.generated.exceptions.PreexistingEntityException;
import com.dhenton9000.jpa.spring.annotations.dao.GroupsDAO;
import com.dhenton9000.jpa.spring.annotations.dao.UsersDAO;
import com.dhenton9000.jpa.spring.service.UsersService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author dhenton
 */
@Service(value="usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO userDAO;
    @Autowired 
    private GroupsDAO groupDAO;
  
    
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void persist(Users u) throws Exception {
       
            userDAO.persist(u);
       
    }
    

    /**
     * @return the userDAO
     */
    public UsersDAO getUserDAO() {
        return userDAO;
    }

    /**
     * @param userDAO the userDAO to set
     */
    public void setUserDAO(UsersDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * @return the groupDAO
     */
    public GroupsDAO getGroupDAO() {
        return groupDAO;
    }

    /**
     * @param groupDAO the groupDAO to set
     */
    public void setGroupDAO(GroupsDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

     
    
    
}
