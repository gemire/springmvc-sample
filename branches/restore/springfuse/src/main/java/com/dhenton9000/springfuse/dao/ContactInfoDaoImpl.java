/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/hibernate/DAOHibernate.e.vm.java
 */
package com.dhenton9000.springfuse.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.dhenton9000.springfuse.dao.ContactInfoDao;
import com.dhenton9000.springfuse.dao.hibernate.HibernateUtil;
import com.dhenton9000.springfuse.dao.support.SearchTemplate;

import com.dhenton9000.springfuse.domain.Account;
import com.dhenton9000.springfuse.domain.ContactInfo;
import com.dhenton9000.springfuse.dao.hibernate.HibernateGenericDao;

/**
 * Hibernate implementation of the ContactInfo DAO interface.
 */
@Repository
public class ContactInfoDaoImpl extends HibernateGenericDao<ContactInfo, Integer> implements ContactInfoDao {
    public ContactInfoDaoImpl() {
        super(ContactInfo.class);
    }

    /**
     * Constructs the search by example criteria using not only the passed contactInfo but also its associated entities. 
     */
    @Override
    public Criteria getCriteria(ContactInfo contactInfo, SearchTemplate searchTemplate) {
        // Call super to construct the criteria of the 'root' entity.
        Criteria criteria = super.getCriteria(contactInfo, searchTemplate);

        // one-to-one: "parent"
        // Note 1: If 'accountId' != null, no need to add a criteria as the current criteria 
        // already takes this property into account.
        // Note 2: By convention, if the example for "parent" has no property set 
        // and "parent" is not null we assume that you want a not null criteria. 
        if (contactInfo.getAccountId() == null && contactInfo.getParent() != null) {
            criteria.add(Restrictions.isNotNull("parent"));
            criteria.createCriteria("parent").add(
                    HibernateUtil.constructExample(contactInfo.getParent(), searchTemplate));
        }

        return criteria;
    }
}