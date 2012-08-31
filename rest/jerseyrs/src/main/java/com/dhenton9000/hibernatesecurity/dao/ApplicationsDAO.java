/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatesecurity.dao;


import com.dhenton9000.generic.GenericDAO;
import com.dhenton9000.hibernatesecurity.Applications;
import com.dhenton9000.hibernatesecurity.converters.ApplicationsConverter;

/**
 *
 * @author dhh
 */
public interface ApplicationsDAO extends GenericDAO<Applications,Integer> {
    public ApplicationsConverter findApplicationsWithGroups(Integer id);
    public ApplicationsConverter findApplicationsWithGroupsAndUsers(Integer id);
}
