/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.spring.service;

import com.dhenton9000.jpa.entities.Users;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dhenton
 */
public interface UsersService {
    
   
    public void persist(Users u) throws Exception;
}
