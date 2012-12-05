/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.services;

import com.dhenton9000.jpa.dao.UsersDAO;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a sample service class. The @Transactional attribute is responsible
 * for committing the transaction.
 *
 * @author dhenton
 */
@Service
public class UsersServiceImpl extends GenericEntityServiceImpl<Users, String> implements UsersService {

    protected UsersDAO usersDAO;

    @Autowired
    public void setUsersDao(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    
    @Override
    public GenericDao<Users, String> getDao() {
        return usersDAO;
    }

    @Override
    public Users getNew() {
        return new Users();
    }

    @Override
    public Users getNewWithDefaults() {
        return getNew();
    }
}
