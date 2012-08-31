/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernatesecurity.springdao;

import com.dhenton9000.hibernatesecurity.Applications;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

/**
 *
 * @author dyh
 */
public class SecuritySpringDAO {

    private static Logger log = LogManager.getLogger(SecuritySpringDAO.class);
    private HibernateTemplate hibernateTemplate = null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory, false);
    }


    /**
     * @return the hibernateTempate
     */
    public HibernateTemplate getHibernateTempate() {
        return hibernateTemplate;
    }
//
//    /**
//     * @param hibernateTempate the hibernateTempate to set
//     */
//    public void setHibernateTempate(HibernateTemplate hibernateTempate) {
//        this.hibernateTemplate = hibernateTempate;
//    }


    public Applications findApplication(Integer i)
    {

        String findString = "from Applications where id = ?";
        Object[] parms = new Object[] {i};
        List results = getHibernateTempate().find(findString,parms);

        return results.size() > 0 ? (Applications) results.get(0) : null;

    }





}
