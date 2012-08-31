/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatesecurity.dao;

import com.dhenton9000.generic.DataAccessLayerException;
import com.dhenton9000.generic.Utils;
import com.dhenton9000.hibernatesecurity.Applications;
import com.dhenton9000.hibernatesecurity.converters.ApplicationsConverter;
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
public class ApplicationsDAOImpl extends GenericDAOSpringImpl<Applications,Integer> implements ApplicationsDAO {
 private static Logger log = LogManager.getLogger(ApplicationsDAOImpl.class);
    @Override
    public ApplicationsConverter findApplicationsWithGroups(Integer id) {
       return findApplication(id,false);
    }

    @Override
    public ApplicationsConverter findApplicationsWithGroupsAndUsers(Integer id) {
        return findApplication(id,true);
    }
    
    protected ApplicationsConverter findApplication(final Integer id, final boolean hydrate) {
    
              TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        Object ret = transactionTemplate.execute(new TransactionCallback() {

            @Override
            public Object doInTransaction(TransactionStatus status) {
                ApplicationsConverter appCon = null;
                try {
                    Applications appObj = (Applications) getHibernateTemplate().get(getPersistenceClass(), id);
                    if (appObj != null)
                    {
                    Set g = appObj.getApplicationGroupses();
                    appCon = new ApplicationsConverter(
                            appObj.getId(),
                            appObj.getApplicationName(),
                            g,hydrate);
                    }
                    else
                    {
                        appCon = new ApplicationsConverter();
                    }
                    return appCon;
                } catch (RuntimeException re) {
                    log.error("get by id failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }// ////
            }
        });

        return (ApplicationsConverter) ret;
      
      
      
      
      
      
    }// end findApplication
}
