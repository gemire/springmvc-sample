/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.impl;

import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.wicket.dao.IUsersDao;
import com.google.inject.Singleton;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
@Singleton
public class UsersDaoImpl
        extends GuiceGenericDaoImpl<Users, String>
        implements IUsersDao {

    private final static Logger logger = LoggerFactory.getLogger(UsersDaoImpl.class);

    public UsersDaoImpl() {
        super(Users.class);
    }

    @Override
    public Users getUserById(String userid) {


        SearchTemplate t = new SearchTemplate();
        t.setNamedQuery("Users.findByUserid");
        Users dummyUser = new Users();
        dummyUser.setUserid(userid);
        Users rUser = null;
        List<Users> uList = this.find(dummyUser, t);

        if (uList != null && uList.size() == 1) {
            Users foundUser = uList.get(0);
            rUser = new Users();
            rUser.setUsername(foundUser.getUsername());
            rUser.setUserid(userid);
            rUser.setPrimaryKey(foundUser.getPrimaryKey());
            rUser.setPassword(foundUser.getPassword());
            Set<Groups> groupsSet = new HashSet<Groups>();

            Iterator<Groups> iter = foundUser.getGroupsSet().iterator();
            while (iter.hasNext()) {
                Groups g = new Groups();
                Groups foundGroups = iter.next();
                g.setGroupName(foundGroups.getGroupName());
                g.setId(foundGroups.getId());
                groupsSet.add(g);

            }



            rUser.setGroupsSet(groupsSet);

        }

        return rUser;

    }
}
