
package com.dhenton9000.hibernate.test;


import com.dhenton9000.hibernatesecurity.ApplicationGroups;
import com.dhenton9000.hibernatesecurity.Applications;
import com.dhenton9000.hibernatesecurity.GroupAssignments;
import com.dhenton9000.hibernatesecurity.Groups;
import com.dhenton9000.hibernatesecurity.Users;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;


/**
 *
 * @author dyh
 */
public class HibernateCRUD {
  private static Logger log = LogManager.getLogger(HibernateCRUD.class);

  //~--- methods --------------------------------------------------------------


  /**
   * Method description TODO
   *
   *
   * @param a
   */
  public void doDetachTest(
      Applications a
  ) {

    // the object is already detached
    Session session = null;

    try {
      session = NewHibernateUtil.getSessionFactory().openSession();

      if ( session == null ) {
        throw new RuntimeException("null session created");
      }

      session.beginTransaction();
      session.delete(a);
      session.delete(a.getApplicationGroupses().iterator().next());



     session.getTransaction().commit();
    } catch ( HibernateException he ) {
      log.error("hibernate error " + he.getMessage());
      session.getTransaction().rollback();
    } finally {
      if ( session != null ) {
        session.close();
      }
    }
  }


  /**
   * Method description TODO
   *
   */
  public void doSimpleSave() {
    Session session = null;

    try {
      session = NewHibernateUtil.getSessionFactory().openSession();

      if ( session == null ) {
        throw new RuntimeException("null session created");
      }

      session.beginTransaction();

      Applications a = new Applications();

      a.setApplicationName("bilbo");
      a.setId(75);
      session.saveOrUpdate(a);

      HashSet<ApplicationGroups> aG = new HashSet<ApplicationGroups>();
      ApplicationGroups          a1 = new ApplicationGroups();

      a1.setId(4550);
      a1.setApplications(a);

      Groups g = new Groups();

      g.setId(676);
      g.setGroupName("bilboGroup");
      session.saveOrUpdate(g);
      a1.setGroups(g);
      aG.add(a1);
      a.setApplicationGroupses(aG);
      session.saveOrUpdate(a1);
      session.getTransaction().commit();
    } catch ( HibernateException he ) {
      log.error("hibernate error " + he.getMessage());
      session.getTransaction().rollback();
    } finally {
      if ( session != null ) {
        session.close();
      }
    }
  }


  /**
   * if 'cascade="save-update"' is placed on the
   *
   * <set  inverse="true" name="applicationGroupses">
   * of appliations.hbm.xml
   *
   * then you will get three inserts
   *
   *  Hibernate: insert into security.applications (application_name, id) values (?, ?)
   *  Hibernate: insert into security.groups (group_name, id) values (?, ?)
   *  Hibernate: insert into security.application_groups (group_id, application_id, id) values (?, ?, ?)
   *
   * otherwise one if the cascade attribute is not there
   *
   * Hibernate: insert into security.applications (application_name, id) values (?, ?)
   *
   *
   * @return
   */
  public Applications doSimpleSave2() {
    Session      session = null;
    Applications a = null;

    try {
      session = NewHibernateUtil.getSessionFactory().openSession();

      if ( session == null ) {
        throw new RuntimeException("null session created");
      }

      session.beginTransaction();
      a = new Applications();
      a.setApplicationName("zimno");
      a.setId(75);

      Groups g = new Groups();

      g.setId(676);
      g.setGroupName("zimnoGroup");

      ApplicationGroups a1 = new ApplicationGroups();

      a1.setId(1200);
      a1.setGroups(g);
      a1.setApplications(a);
      a.getApplicationGroupses().add(a1);
      session.saveOrUpdate(a);
      session.getTransaction().commit();
    } catch ( HibernateException he ) {
      log.error("hibernate error " + he.getMessage());
      session.getTransaction().rollback();
    } finally {
      if ( session != null ) {
        session.close();
      }
    }

    return a;
  }

  private Session getSession() {
    Session session = null;

    try {
      session = NewHibernateUtil.getSessionFactory().openSession();
    } catch ( Exception e ) {
      log.error("do Query ERROR: " + e.getClass().getName() + " " + e.getMessage());
    }

    return session;
  }


  /**
   * Method description TODO
   *
   *
   * @param args
   */
  public static void main(
      String[] args
  ) {
    HibernateCRUD hR = new HibernateCRUD();
    Applications  a = hR.doSimpleSave2();

    hR.doDetachTest(a);
  }
}
