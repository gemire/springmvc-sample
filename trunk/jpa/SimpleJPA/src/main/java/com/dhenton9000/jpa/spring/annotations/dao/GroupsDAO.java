/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.spring.annotations.dao;

import com.dhenton9000.jpa.entities.Groups;
import org.springframework.dao.DataAccessException;
 
 
/**
 *
 * @author dhenton
 */
public interface GroupsDAO extends Dao<Groups,Integer>{

   public Groups getHydratedGroup(Integer groupId) throws DataAccessException;
}
