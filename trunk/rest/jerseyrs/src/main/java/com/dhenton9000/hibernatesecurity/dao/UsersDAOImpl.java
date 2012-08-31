/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatesecurity.dao;

import com.dhenton9000.generic.DataAccessLayerException;
import com.dhenton9000.generic.Utils;
import com.dhenton9000.hibernatesecurity.Users;
import com.dhenton9000.hibernatesecurity.converters.UsersConverter;
import com.dhenton9000.spring.dao.GenericDAOSpringImpl;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 */
public class UsersDAOImpl extends GenericDAOSpringImpl<Users, String> implements UsersDAO {

    private static Logger log = LogManager.getLogger(UsersDAOImpl.class);

    @Override
    public UsersConverter findUserWithGroups(final String id) {
        return findUser(id, false);
    }

    @Override
    public UsersConverter findUserWithGroupsAndApplications(final String id) {
        return findUser(id, true);
    }

    protected UsersConverter findUser(final String id, final boolean hydrate) {

        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        Object ret = transactionTemplate.execute(new TransactionCallback() {

            @Override
            public Object doInTransaction(TransactionStatus status) {
                UsersConverter userCon = null;
                try {
                    Users userObj = (Users) getHibernateTemplate().get(getPersistenceClass(), id);
                    if (userObj != null) {
                        Set g = userObj.getGroupAssignmentses();
                        userCon = new UsersConverter(
                                userObj.getUserId(),
                                userObj.getUsername(),
                                g, hydrate);
                    } else {
                        userCon = new UsersConverter();
                    }
                    return userCon;
                } catch (RuntimeException re) {
                    log.error("get by id failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }// ////
            }
        });

        return (UsersConverter) ret;
    }// end findUserWithGroups
}
