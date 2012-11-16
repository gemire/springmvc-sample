/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatesecurity.dao;


import com.dhenton9000.generic.GenericDAO;
import com.dhenton9000.hibernatesecurity.Users;
import com.dhenton9000.hibernatesecurity.converters.UsersConverter;

/**
 *
 * @author dhh
 */
public interface UsersDAO extends GenericDAO<Users,String> {
    
    public UsersConverter findUserWithGroups(String userId);
    public UsersConverter findUserWithGroupsAndApplications(String userId);
}
