
package com.dhenton9000.hibernatesecurity.dao;

import com.dhenton9000.hibernatesecurity.*;
import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class provides DAO services for the persistence system for the
 * Security application
 * @author dyh
 */
public class SecurityDAO {

    private static Logger log = LogManager.getLogger(SecurityDAO.class);
    private static SecurityDAO instance = null;

    //~--- constructors ---------------------------------------------------------
    /**
     *
     * The constructor  initializes the factory
     */
    private SecurityDAO() {
        try {
            HibernateFactory.buildIfNeeded();
        } catch (DataAccessLayerException ex) {
            log.error("Security DAO start problem " + Utils.createErrorMessage(ex));
        }
    }

    //~--- methods --------------------------------------------------------------
    /**
     * Method description TODO
     *
     *
     * @return
     */
    public static synchronized SecurityDAO getInstance() {
        if (instance == null) {
            instance = new SecurityDAO();
        }

        return instance;
    }

    /**
     * save or update the object save if new update if already present
     *
     * @param obj
     *
     * @throws DataAccessLayerException if during an update the key is
     * violated or on general error
     */
    public void saveOrUpdate(
            Object obj)
            throws DataAccessLayerException {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (ConstraintViolationException er) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException("Could not update, duplicate key");
        } catch (Exception e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }
    }

    /**
     *
     * Adds a new object to the persistence system
     *
     * @param obj
     *
     * @throws DataAccessLayerException if trying to add a duplicate key
     */
    public void save(
            Object obj)
            throws DataAccessLayerException {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } catch (ConstraintViolationException er) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException("Could not save, duplicate key");
        } catch (Exception e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }
    }

    /**
     * Delete an object
     *
     *
     * @param obj
     *
     * @throws DataAccessLayerException
     */
    public void delete(
            Object obj)
            throws DataAccessLayerException {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (Exception e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }
    }

    /**
     * Find a single table row for an id
     *
     *
     * @param itemClass
     * @param id
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    public Object find(
            Class itemClass,
            Serializable id)
            throws DataAccessLayerException {
        Object a = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            a = session.get(itemClass,  id);

            // if session.load is used instead of get above you may
            // get a proxy object that freaks when you ask for a property
            // get vs load.
            // get returns null when nothing found load will return an object
            // that only gets filled later when accessed.
            tx.commit();
        } catch (Exception e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return a;
    }

    /**
     * gets the groups that are not assigned to
     * the given application
     * @param appId
     * @return
     * @throws DataAccessLayerException
     */
    public List getGroupsForApplication(
            Integer appId)
            throws DataAccessLayerException {
        String sqlVar = "FROM com.dhenton9000.hibernatesecurity.ApplicationGroups as g "
                + "WHERE g.applications.id = :appId ";

        return getGroupsForApps(sqlVar, appId);
    }

    /**
     * Get the available groups that can be assigned to an
     * application
     * @param appId
     * @return
     * @throws DataAccessLayerException
     */
    public List getAvailableGroupsForApplication(
            Integer appId)
            throws DataAccessLayerException {
        String sqlVar = "FROM com.dhenton9000.hibernatesecurity.Groups as g "
                + " WHERE g.id not in ( " + " SELECT ag.groups.id FROM "
                + " com.dhenton9000.hibernatesecurity.ApplicationGroups as ag "
                + " WHERE ag.applications.id = :appId " + ")ORDER BY g.groupName ";
        List newResults = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(sqlVar);

            query.setInteger("appId", appId);

            List results = query.list();
            Iterator iter = results.iterator();

            while (iter.hasNext()) {
                Groups gT = new Groups();
                Groups aG = (Groups) iter.next();

                gT.setGroupName(aG.getGroupName());
                gT.setId(aG.getId());
                newResults.add(gT);
            }
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return newResults;
    }

    private List getGroupsForApps(
            String sqlVar,
            Integer appId)
            throws DataAccessLayerException {
        List newResults = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(sqlVar);

            query.setInteger("appId", appId);

            List results = query.list();
            Iterator iter = results.iterator();

            while (iter.hasNext()) {
                Groups gT = new Groups();
                ApplicationGroups aG = (ApplicationGroups) iter.next();

                gT.setGroupName(aG.getGroups().getGroupName());
                gT.setId(aG.getGroups().getId());
                newResults.add(gT);
            }
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return newResults;
    }

    /**
     * Method description TODO
     *
     *
     * @param queryString
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    public List getDataForQuery(
            String queryString)
            throws DataAccessLayerException {
        List objects = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(queryString);

            objects = query.list();

            // log.debug(objects);
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        // log.debug(objects);
        return objects;
    }

    /**
     * This will get a page of data for a given query
     * @param queryString the hibernate query string to use
     * @param pageNum page number starting with 1 the page number is
     * 1 based and will be used to set first result to (pageNum -1) * pageSize
     * @param pageSize the size of objects to retrieve
     * @return returns the list of objects
     *
     * @throws DataAccessLayerException
     */
    public Page getPageOfData(
            String queryString,
            int pageNum,
            int pageSize)
            throws DataAccessLayerException {
        Page page = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(queryString);

            page = new Page(query, pageNum, pageSize);
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return page;
    }

    /**
     * Method description TODO
     *
     *
     * @param clazz
     * @param pageNum
     * @param pageSize
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    public Page getPageOfDataForClass(
            Class clazz,
            int pageNum,
            int pageSize)
            throws DataAccessLayerException {
        Page page = null;
        String q = "from " + clazz.getName();

        page = getPageOfData(q, pageNum, pageSize);

        return page;
    }

    /**
     * Method description TODO
     *
     *
     * @param clazz
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    public List findAll(
            Class clazz)
            throws DataAccessLayerException {
        List objects = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("from " + clazz.getName());

            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return objects;
    }

    /**
     * Method description TODO
     *
     *
     * @param aId
     * @param uId
     */
    public GroupAssignments deleteGroupAssignment(
            int gId,
            String uId) throws DataAccessLayerException {
        List objects = null;
        Session session = null;
        Transaction tx = null;
        GroupAssignments aG = null;
        String sqlVar = "FROM com.dhenton9000.hibernatesecurity.GroupAssignments "
                + "as ag " + " WHERE ag.groups.id     =:groupId "
                + " AND ag.users.userId = :uId ";


        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(sqlVar);

            query.setInteger("groupId", gId);
            query.setString("uId", uId);
            objects = query.list();
            aG = (GroupAssignments) objects.get(0);
            session.delete(aG);
            tx.commit();
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return aG;



    }

    /**
     * Method description TODO
     *
     *
     * @param appId
     * @param groupId
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    public ApplicationGroups deleteApplicationGroup(
            int appId,
            int groupId)
            throws DataAccessLayerException {
        List objects = null;
        Session session = null;
        Transaction tx = null;
        ApplicationGroups aG = null;
        String sqlVar = "FROM com.dhenton9000.hibernatesecurity.ApplicationGroups "
                + "as ag " + " WHERE ag.groups.id     =:groupId "
                + " AND ag.applications.id = :appId ";

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
  
            Query query = session.createQuery(sqlVar);

            query.setInteger("groupId", groupId);
            query.setInteger("appId", appId);
            objects = query.list();
            if (objects.size() == 1)
            {
            	aG = (ApplicationGroups) objects.get(0);
                session.delete(aG);
            	tx.commit();
            }
            else
            {
            	HibernateFactory.rollback(tx);
            }
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return aG;
    }

    /**
     * Method description TODO
     *
     *
     * @param clazz
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    public long getCountForClass(
            Class clazz)
            throws DataAccessLayerException {
        long count = 0;
        List objects = null;
        Session session = null;
        Transaction tx = null;
        String countQuery = "SELECT count(*) from " + clazz.getName();

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(countQuery);

            objects = query.list();

            Long ii = (Long) objects.get(0);

            if (ii != null) {
                count = ii.intValue();
            }

            tx.commit();
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return count;
    }

    void evict(
            Object aG)
            throws DataAccessLayerException {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            session.evict(aG);
            tx.commit();
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }
    }

    /**
     * Get the available groups that can be assigned to an
     * application
     *
     * @param groupId
     * @return
     * @throws DataAccessLayerException
     */
    public List getAvailableUsersForGroups(
            Integer groupId)
            throws DataAccessLayerException {
        String sqlVar = "FROM com.dhenton9000.hibernatesecurity.Users as u "
                + " WHERE u.userId not in (   SELECT ga.users.userId FROM "
                + " com.dhenton9000.hibernatesecurity.GroupAssignments as ga "
                + " WHERE ga.groups.id = :groupId " + ")ORDER BY u.userId ";
        List newResults = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(sqlVar);

            query.setInteger("groupId", groupId);

            List results = query.list();
            Iterator iter = results.iterator();

            while (iter.hasNext()) {
                Users uT = new Users();
                Users aG = (Users) iter.next();

                uT.setUsername(aG.getUsername());
                uT.setUserId(aG.getUserId());
                newResults.add(uT);
            }
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return newResults;
    }

    /**
     * Method description TODO
     *
     *
     * @param groupId
     *
     * @return
     *
     * @throws DataAccessLayerException
     */
    public List getUsersForGroups(
            Integer groupId)
            throws DataAccessLayerException {
        List newResults = new ArrayList();
        Session session = null;
        Transaction tx = null;
        String sqlVar = "FROM com.dhenton9000.hibernatesecurity.GroupAssignments as g "
                + "WHERE g.groups.id = :groupId  " + " order by g.users.userId ";

        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(sqlVar);

            query.setInteger("groupId", groupId);

            List results = query.list();
            Iterator iter = results.iterator();

            while (iter.hasNext()) {
                Users uT = new Users();
                GroupAssignments gA = (GroupAssignments) iter.next();

                uT.setUsername(gA.getUsers().getUsername());
                uT.setUserId(gA.getUsers().getUserId());
                newResults.add(uT);
            }
        } catch (HibernateException e) {
            HibernateFactory.rollback(tx);

            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
            HibernateFactory.close(session);
        }

        return newResults;
    }
}
