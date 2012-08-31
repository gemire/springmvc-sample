/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatesecurity.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import com.dhenton9000.hibernatesecurity.*;
import com.dhenton9000.hibernatesecurity.Utils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Don
 */
public class TestClass {

    private static Logger log = LogManager.getLogger(TestClass.class);

    @Test
    public void testSaveOrUpdate() throws DataAccessLayerException {
        Session session = null;
        Transaction tx = null;
        ApplicationGroups aG = null;
         SessionFactory factory = null;
        try {

            SecurityDAO instance = SecurityDAO.getInstance();
            aG = new ApplicationGroups();
            Applications aa = (Applications) instance.find(Applications.class, new Integer(2));

            Groups gg = (Groups) instance.find(Groups.class, new Integer(7));

            aG.setApplications(aa);
            aG.setGroups(gg);

           factory =
                    new Configuration().configure().buildSessionFactory();

            session = factory.openSession();
            tx = session.beginTransaction();

            Integer ii = (Integer) session.save(aG);
            log.debug("ii "+ii.intValue());

           
           tx.rollback();
           session.flush();
           log.debug("ii 2 "+aG.getId());

        } catch (Exception e) {
            tx.rollback();
            throw new DataAccessLayerException(Utils.createErrorMessage(e));
        } finally {
           session.close();
        }


        log.debug("ii 3 "+aG.getId());
    }
}
