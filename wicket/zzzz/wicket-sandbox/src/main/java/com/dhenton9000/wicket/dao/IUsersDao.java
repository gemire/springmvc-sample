/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao;

import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.wicket.dao.impl.UsersDaoImpl;


/**
 *
 * @author dhenton
 */

public interface IUsersDao extends GenericDao<Users, String> {
    
    public Users getUserById(String userid);
}
