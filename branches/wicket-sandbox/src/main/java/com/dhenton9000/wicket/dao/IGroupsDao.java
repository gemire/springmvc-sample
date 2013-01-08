/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao;

import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.wicket.dao.impl.GroupsDaoImpl;
import com.google.inject.ImplementedBy;
import java.util.List;

/**
 *
 * @author dhenton
 */
@ImplementedBy(GroupsDaoImpl.class)
public interface IGroupsDao extends GenericDao<Groups, Integer>{
    public List<Groups> getAllGroups();
}
