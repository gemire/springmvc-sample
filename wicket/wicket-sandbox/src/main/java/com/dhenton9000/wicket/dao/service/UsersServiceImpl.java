/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.service;


import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import com.dhenton9000.wicket.dao.impl.UsersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is a sample service class. The @Transactional attribute is responsible
 * for committing the transaction.
 *
 * @author dhenton
 */
@Service
public class UsersServiceImpl extends GenericEntityServiceImpl<Users, String> implements IUsersService {

    protected UsersDaoImpl usersDAO;

    @Autowired
    public void setUsersDao(UsersDaoImpl usersDAO) {
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
