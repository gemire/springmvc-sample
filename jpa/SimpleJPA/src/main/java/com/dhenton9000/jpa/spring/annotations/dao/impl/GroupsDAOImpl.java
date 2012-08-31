/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.spring.annotations.dao.impl;

import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.spring.annotations.dao.GroupsDAO;
import org.apache.log4j.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dhenton
 */
@Repository(value = "groupsDAO")
public class GroupsDAOImpl extends DaoBaseImpl<Groups,Integer> implements GroupsDAO {

    private static final Logger log = LogManager.getLogger(GroupsDAOImpl.class);
    public GroupsDAOImpl()
    {
        super(Groups.class);
    }

    

     @Override
     
    public Groups getHydratedGroup(Integer groupId) throws DataAccessException {
         Groups foundGroup = null;
         String query = "SELECT g FROM Groups g ";
         query += " left outer join fetch g.usersSet u";
         query += " left outer join fetch g.applicationsSet a";
          query += " WHERE g.id = :groupId";
         QueryParameter qParm = new QueryParameter("groupId",groupId);
         foundGroup = getQuerySingleResult(query,qParm);
         return foundGroup;
        
    }
    
}
