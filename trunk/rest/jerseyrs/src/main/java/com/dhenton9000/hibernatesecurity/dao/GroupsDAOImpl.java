/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatesecurity.dao;

import com.dhenton9000.generic.DataAccessLayerException;
import com.dhenton9000.generic.Utils;
import com.dhenton9000.hibernatesecurity.Groups;
import com.dhenton9000.hibernatesecurity.converters.GroupsConverter;
import com.dhenton9000.spring.dao.GenericDAOSpringImpl;
import java.util.Set;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 */
public class GroupsDAOImpl extends GenericDAOSpringImpl<Groups, Integer> implements GroupsDAO {

    private static Logger log = LogManager.getLogger(GroupsDAOImpl.class);

    @Override
    public GroupsConverter findGroupsWithUsersAndApplications(final Integer id) {

        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        Object ret = transactionTemplate.execute(new TransactionCallback() {

            @Override
            public Object doInTransaction(TransactionStatus status) {
                GroupsConverter groupCon = null;
                try {
                    Groups grpObj = (Groups) getHibernateTemplate().get(getPersistenceClass(), id);
                    if (grpObj != null) {
                        Set g = grpObj.getApplicationGroupses();
                        Set z = grpObj.getGroupAssignmentses();
                        groupCon = new GroupsConverter(
                                grpObj.getId(),
                                grpObj.getGroupName(),
                                g, z);
                    } else {
                        groupCon = new GroupsConverter();
                    }
                    return groupCon;
                } catch (RuntimeException re) {
                    log.error("get by id failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }// ////
            }
        });

        return (GroupsConverter) ret;
    }// end find Groups
}
