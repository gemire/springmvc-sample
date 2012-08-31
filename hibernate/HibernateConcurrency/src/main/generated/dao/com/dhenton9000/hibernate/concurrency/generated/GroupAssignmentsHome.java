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
 * Home object for domain model class GroupAssignments.
 * @see com.dhenton9000.hibernate.concurrency.generated.GroupAssignments
 * @author Hibernate Tools
 */
public class GroupAssignmentsHome {

    private static final Log log = LogFactory.getLog(GroupAssignmentsHome.class);

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
    
    public void persist(GroupAssignments transientInstance) {
        log.debug("persisting GroupAssignments instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(GroupAssignments instance) {
        log.debug("attaching dirty GroupAssignments instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(GroupAssignments instance) {
        log.debug("attaching clean GroupAssignments instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(GroupAssignments persistentInstance) {
        log.debug("deleting GroupAssignments instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public GroupAssignments merge(GroupAssignments detachedInstance) {
        log.debug("merging GroupAssignments instance");
        try {
            GroupAssignments result = (GroupAssignments) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public GroupAssignments findById( java.lang.Integer id) {
        log.debug("getting GroupAssignments instance with id: " + id);
        try {
            GroupAssignments instance = (GroupAssignments) sessionFactory.getCurrentSession()
                    .get("com.dhenton9000.hibernate.concurrency.generated.GroupAssignments", id);
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
    
    public List findByExample(GroupAssignments instance) {
        log.debug("finding GroupAssignments instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.dhenton9000.hibernate.concurrency.generated.GroupAssignments")
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

