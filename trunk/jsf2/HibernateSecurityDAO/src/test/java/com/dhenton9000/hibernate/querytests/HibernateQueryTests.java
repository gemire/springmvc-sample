/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernate.querytests;

import com.dhenton9000.hibernate.test.NewHibernateUtil;
import com.dhenton9000.hibernatesecurity.GroupAssignments;
import com.dhenton9000.hibernatesecurity.Users;
import java.util.Iterator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

/**
 *
 * @author dyh
 */
public class HibernateQueryTests {

    private static Logger log = LogManager.getLogger(HibernateQueryTests.class);
    //~--- fields ---------------------------------------------------------------
    // returns just one part, which is a String in this case
    String JUST_ONE_COLUMN =
            "SELECT users.username from com.dhenton9000.hibernatesecurity.Users as users  ";
    //  below returns an array of objects the array is two deep that is each element in the
    //  array is a column
    String MULTI_COLUMN =
            "SELECT ga.users.userId,ga.groups.id from com.dhenton9000.hibernatesecurity.GroupAssignments as ga  ";
    String SQL_STRING_OBJECT = "from com.dhenton9000.hibernatesecurity.Users as users ";
    String PARM_QUERY = "FROM com.dhenton9000.hibernatesecurity.Users as users "
            + "WHERE users.userId = :inputName  ";
    String INNER_JOIN_EXAMPLE =
            "SELECT users.username as username,ga_assign.groups.id as g_id, "
            + " ga_assign_apps.applications.applicationName "
            + "from com.dhenton9000.hibernatesecurity.Users as users  "
            + " INNER JOIN users.groupAssignmentses  AS ga_assign "
            + " INNER JOIN ga_assign.groups.applicationGroupses  AS ga_assign_apps "
            + " WHERE users.userId = 'gaw'  ";

    @Test
    public void doInnerJoinQueryTest() {
        List lz = doQuery(INNER_JOIN_EXAMPLE);

        Object[] oOne = (Object[]) lz.get(4);
        assertEquals(3, oOne.length);
        assertEquals("HeelHeightRange", oOne[2]);
        assertEquals(31, lz.size());
    }
    @Test
    public void doNamedParmQuery() {


        Session session = null;

        log.debug("start");
        List list = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();

            Query query = session.createQuery(PARM_QUERY);
            query.setString("inputName", "gaw");
            list = query.list();
            assertEquals(1, list.size());
            Users g = (Users) list.get(0);
            assertEquals("gaw", g.getUserId());
            // now that we have an object check its has assignment
            Set h = g.getGroupAssignmentses();
            assertEquals(2, h.size());
            int cc = 0;
            Iterator iter = h.iterator();
            while (iter.hasNext()) {
                GroupAssignments z = (GroupAssignments) iter.next();
                if (cc == 2) {
                    assertEquals("PowerUsers", z.getGroups().getGroupName());
                }
                cc++;
            }



        } catch (Exception e) {
            log.error("do Query ERROR: " + e.getClass().getName() + " " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        log.debug("end");


    }

    @Test
    public void doNamedParmQueryByObject() {


        Session session = null;
        List list = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();

            Query query = session.createQuery(PARM_QUERY);
            query.setString("inputName", "gaw");
            list = query.list();
            assertEquals(1, list.size());
            Users g = (Users) list.get(0);
 
            // now do the query via an object

            String oQuery = "from com.dhenton9000.hibernatesecurity.GroupAssignments"
                    + " as ga  where ga.users=:u";
            query = session.createQuery(oQuery);
            query.setEntity("u", g);
            List results = query.list();
            assertEquals(2, results.size());
           
        } catch (Exception e) {
            log.error("do Query ERROR: " + e.getClass().getName() + " " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        log.debug("end");


    }

    @Test
    public void doMultQuery() {
        List list = doQuery(MULTI_COLUMN);



        Object[] oItems = (Object[]) list.get(3);
        assertEquals(Integer.class, oItems[1].getClass());
        assertEquals(117, list.size());
        assertEquals(2, oItems.length);
        assertEquals(new Integer(8), oItems[1]);
    }

    private List doQuery(String q) {
        Session session = null;

        log.debug("start");
        List list = null;
        // returns the full object
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();

            Query query = session.createQuery(q);
            list = query.list();


        } catch (Exception e) {
            log.error("do Query ERROR: " + e.getClass().getName() + " " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        log.debug("end");
        return list;
    }
}
