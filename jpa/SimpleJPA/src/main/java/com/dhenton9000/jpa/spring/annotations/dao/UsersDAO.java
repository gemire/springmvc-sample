/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.spring.annotations.dao;

import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.entities.generated.exceptions.PreexistingEntityException;
import org.springframework.dao.DataAccessException;


 
/**
 *
 * @author dhenton
 */
public interface UsersDAO extends Dao<Users,String>{

   
   public Users getHydratedUser(String userId) throws DataAccessException;
}
