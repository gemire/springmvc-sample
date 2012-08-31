package com.dhenton9000.hibernate.concurrency.generated;
// Generated May 26, 2011 1:33:10 PM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class ApplicationGroups.
 * @see com.dhenton9000.hibernate.concurrency.generated.ApplicationGroups
 * @author Hibernate Tools
 */
public class ApplicationGroupsHome {

    private static final Log log = LogFactory.getLog(ApplicationGroupsHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(ApplicationGroups transientInstance) {
        log.debug("persisting ApplicationGroups instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(ApplicationGroups instance) {
        log.debug("attaching dirty ApplicationGroups instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ApplicationGroups instance) {
        log.debug("attaching clean ApplicationGroups instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(ApplicationGroups persistentInstance) {
        log.debug("deleting ApplicationGroups instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ApplicationGroups merge(ApplicationGroups detachedInstance) {
        log.debug("merging ApplicationGroups instance");
        try {
            ApplicationGroups result = (ApplicationGroups) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ApplicationGroups findById( java.lang.Integer id) {
        log.debug("getting ApplicationGroups instance with id: " + id);
        try {
            ApplicationGroups instance = (ApplicationGroups) sessionFactory.getCurrentSession()
                    .get("com.dhenton9000.hibernate.concurrency.generated.ApplicationGroups", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List findByExample(ApplicationGroups instance) {
        log.debug("finding ApplicationGroups instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.dhenton9000.hibernate.concurrency.generated.ApplicationGroups")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
}

