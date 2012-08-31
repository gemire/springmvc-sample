package com.dhenton9000.spring.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.dhenton9000.generic.DataAccessLayerException;
import com.dhenton9000.generic.GenericDAO;
import com.dhenton9000.generic.Utils;

/**
 * A generic DAO implementation using Spring. The idea is to extend both
 * the interface and this class specifying the class and the class of the key
 * @author Don
 * @param <T> The hibernate class
 * @param <ID> The class of the ID object
 */
@SuppressWarnings("unchecked")
public abstract class GenericDAOSpringImpl<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDAO<T, ID> {

    private static Logger log = LogManager.getLogger(GenericDAOSpringImpl.class);
    private Class<T> persistenceClass = null;
    private PlatformTransactionManager transactionManager;

    /**
     * constructor
     */
    public GenericDAOSpringImpl() {

        this.persistenceClass = (Class<T>) 
                ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * getter for the parameterized class
     * @return the class of the parameter
     */
    public Class<T> getPersistenceClass() {
        return persistenceClass;
    }

    public void attachClean(final T detachedInstance)
            throws DataAccessLayerException {
        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {

                try {

                    getHibernateTemplate().lock(detachedInstance, LockMode.NONE);
                } catch (RuntimeException re) {
                    log.error("attachClean failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }
            }// ////
        });

    }

    /**
     * 
     * @param example
     * @throws DataAccessLayerException
     */
    public void deleteByExample(final T example)
            throws DataAccessLayerException {
        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {

                try {

                    List<T> results = getSession().createCriteria(
                            example.getClass()).add(Example.create(example)).list();

                    log.debug("delete by example successful, result size: "
                            + results.size());

                    Iterator<T> iter = results.iterator();

                    while (iter.hasNext()) {
                        Object o = iter.next();
                        getHibernateTemplate().delete(o);

                    }

                } catch (RuntimeException re) {
                    log.error("deleteByExample failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }

            }// ////
        });

    }

    /**
     * Completely empty the underlying database store
     */
    public void emptyTable() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {

                try {

                    Query query = getSession().createQuery(
                            "delete from " + getPersistenceClass().getCanonicalName());
                    int var = query.executeUpdate();
                    log.debug("emptyTable deleted " + var + " records ");

                } catch (RuntimeException re) {
                    log.error("emptytable failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }

            }// ////
        });

    }

    /**
     * remove an object from the hibernate cache
     * @param o
     */
    public void evict(final T o) {

        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {

                try {
                    log.debug("evicting for "
                            + getPersistenceClass().getCanonicalName());
                    getHibernateTemplate().evict(o);
                } catch (RuntimeException re) {
                    log.error("evict failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }
            }// ////
        });
    }

    /**
     * simple findAll
     * @return list of objects
     * @throws DataAccessLayerException
     */
    public List<T> findAll() throws DataAccessLayerException {
        log.debug("finding all instances for "
                + getPersistenceClass().getCanonicalName());

        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        Object ret = transactionTemplate.execute(new TransactionCallback() {

            public Object doInTransaction(TransactionStatus status) {

                try {
                    String queryString = "from "
                            + getPersistenceClass().getCanonicalName();
                    return getHibernateTemplate().find(queryString);
                } catch (RuntimeException re) {
                    log.error("findall failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }

            }// ////
        });

        return (List<T>) ret;

    }

    /**
     * 
     * @param detachedInstance
     * @throws DataAccessLayerException
     */
    public void delete(final T detachedInstance)
            throws DataAccessLayerException {

        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {

                try {
                    getHibernateTemplate().delete(detachedInstance);
                    log.debug("delete successful");
                } catch (RuntimeException re) {
                    log.error("delete failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }

            }// ////
        });

    }

    /**
     * 
     * @param id
     * @return
     */
    public T findById(final ID id) {
        log.debug("getting instance with id: " + id);
        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        Object ret = transactionTemplate.execute(new TransactionCallback() {

            public Object doInTransaction(TransactionStatus status) {

                try {
                    return getHibernateTemplate().get(getPersistenceClass(), id);

                } catch (RuntimeException re) {
                    log.error("get by id failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }// ////
            }
        });

        return (T) ret;
    }

    public void save(final T detachedInstance) throws DataAccessLayerException {
        log.debug("saving instance");

        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {

                try {

                    getHibernateTemplate().save(detachedInstance);

                    log.debug("save successful");
                } catch (RuntimeException re) {
                    log.error("save failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }

            }// ////
        });

    }

    /**
     * 
     * @param detachedInstance
     * @throws DataAccessLayerException
     */
    public void saveOrUpdate(final T detachedInstance) throws DataAccessLayerException {
        log.debug("saving or updating instance");

        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {

                try {

                    getHibernateTemplate().saveOrUpdate(detachedInstance);

                    log.debug("save or update successful");
                } catch (RuntimeException re) {
                    log.error("save or update failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }

            }// ////
        });

    }

    /**
     * 
     * @param detachedInstance
     * @return
     * @throws DataAccessLayerException
     */
    public T merge(final T detachedInstance) throws DataAccessLayerException {
        log.debug("merging instance");

        TransactionTemplate transactionTemplate = new TransactionTemplate(
                getTransactionManager());

        Object ret = transactionTemplate.execute(new TransactionCallback() {

            @Override
            public Object doInTransaction(TransactionStatus status) {
                Object obj = null;
                try {

                    obj = getHibernateTemplate().merge(detachedInstance);

                    log.debug("merge successful");
                } catch (RuntimeException re) {
                    log.error("merge failed", re);
                    throw new DataAccessLayerException(Utils.createErrorMessage(re));
                }
                return obj;
            }// ////
        });
        return (T) ret;
    }

    /**
     * 
     * @param transactionManager
     */
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 
     * @return
     */
    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }
}
