/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatesecurity.dao;


import com.dhenton9000.generic.GenericDAO;
import com.dhenton9000.hibernatesecurity.Groups;
import com.dhenton9000.hibernatesecurity.converters.GroupsConverter;

/**
 *
 * @author dhh
 */
public interface GroupsDAO extends GenericDAO<Groups,Integer> {
    public GroupsConverter findGroupsWithUsersAndApplications(Integer id);
}
