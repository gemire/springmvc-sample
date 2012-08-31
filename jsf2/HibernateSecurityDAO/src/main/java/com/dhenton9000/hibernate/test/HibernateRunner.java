
package com.dhenton9000.hibernate.test;

import com.dhenton9000.hibernatesecurity.GroupAssignments;
import com.dhenton9000.hibernatesecurity.Users;
import java.util.Iterator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

/**
 *
 * @author dyh
 */
public class HibernateRunner {

    private static Logger log = LogManager.getLogger(HibernateRunner.class);
    //~--- fields ---------------------------------------------------------------
    // returns just one part, which is a String in this case
    String JUST_ONE_COLUMN =
            "SELECT users.username from com.dhenton9000.hibernatesecurity.Users as users  ";
    // returns an array of objects the array is two deep
    String MULTI_COLUMN =
            "SELECT ga.users.userId,ga.groups.id from com.dhenton9000.hibernatesecurity.GroupAssignments as ga  ";
    String SQL_STRING_OBJECT = "from com.dhenton9000.hibernatesecurity.Users as users ";
    String PARM_QUERY = "FROM com.dhenton9000.hibernatesecurity.Users as users "
            + "WHERE users.userId = :inputName  ";

    String INNER_JOIN_EXAMPLE =
    "SELECT users.username as username,ga_assign.groups.id as g_id, " +
            " ga_assign_apps.applications.applicationName "+
            "from com.dhenton9000.hibernatesecurity.Users as users  " +
            " INNER JOIN users.groupAssignmentses  AS ga_assign " +
            " INNER JOIN ga_assign.groups.applicationGroupses  AS ga_assign_apps " +
            " WHERE users.userId = 'gaw'  " ;
            

/*

 SELECT APPLICATIONS.APPLICATION_NAME, USERS.USER_ID, USERS.USER_NAME
 FROM USERS
 INNER JOIN ((GROUPS
 INNER JOIN (APPLICATIONS
 INNER JOIN APPLICATION_GROUPS ON APPLICATIONS.ID = APPLICATION_GROUPS.APPLICATION_ID)
 ON GROUPS.ID = APPLICATION_GROUPS.GROUP_ID)
 INNER JOIN GROUP_ASSIGNMENTS ON GROUPS.ID = GROUP_ASSIGNMENTS.GROUP_ID) ON USERS.USER_ID
 = GROUP_ASSIGNMENTS.USER_ID
ORDER BY APPLICATIONS.APPLICATION_NAME, USERS.USER_ID;

    */

    //~--- methods --------------------------------------------------------------

    public void doInnerJoinQuery()
    {
        List lz = doQuery(INNER_JOIN_EXAMPLE);
        for (int i=0;i<lz.size();i++)
        {
            Object[] oOne = (Object[]) lz.get(i);

            log.debug("username "+oOne[0]+" app "+oOne[2]);

        }

        log.debug("lz count "+lz.size());
    }


    public void doNamedParmQuery() {


        Session session = null;

        log.debug("start");
        List list = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();

            Query query = session.createQuery(PARM_QUERY);
            query.setString("inputName", "gaw");
            list = query.list();
            Users g = (Users) list.get(0);
            log.debug("got " + g);
            // now that we have an object check its has assignment
            Set h = g.getGroupAssignmentses();
            Iterator iter = h.iterator();
            while (iter.hasNext()) {
                GroupAssignments z = (GroupAssignments) iter.next();
                log.debug(z);
            }

            // now do the query via an object

            String oQuery = "from com.dhenton9000.hibernatesecurity.GroupAssignments" +
                    " as ga  where ga.users=:u";
            query = session.createQuery(oQuery);
            query.setEntity("u",g);
            List results = query.list();
            log.debug("doing object query");
            for (int z=0;z<results.size();z++)
            {
                log.debug(results.get(z));
            }
            log.debug("end object query");


        } catch (Exception e) {
            log.error("do Query ERROR: " + e.getClass().getName() + " " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        log.debug("end");


    }

    public void doMultQuery() {
        List list = doQuery(MULTI_COLUMN);
        for (int i = 0; i < list.size(); i++) {
            Object[] oItems = (Object[]) list.get(i);
            //log.debug("list size "+oItems.length);
            log.debug(oItems[1].getClass().getName());
        }
    }

    /**
     * Demonstration method
     *
     */
    public List doQuery(String q) {
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

    /**
     * Method description TODO
     *
     *
     * @param args
     */
    public static void main(
            String[] args) {
        HibernateRunner hR = new HibernateRunner();
        //hR.doNamedParmQuery();
        //hR.doMultQuery();
        hR.doInnerJoinQuery();
    }
}
