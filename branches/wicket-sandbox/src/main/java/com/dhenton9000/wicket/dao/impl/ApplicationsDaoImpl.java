/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.impl;

import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
@Singleton
public class ApplicationsDaoImpl
        extends GuiceGenericDaoImpl<Applications, Integer>
        implements IApplicationsDao {

    private final static Logger logger = LoggerFactory.getLogger(ApplicationsDaoImpl.class);

    public ApplicationsDaoImpl() {
        super(Applications.class);
    }

    @Override
    public List<Applications> getAllApplications() {


        SearchTemplate t = new SearchTemplate();
        t.setNamedQuery("Applications.findAll");
        // the applications object is a dummy to hold parameters 
        // if the named query is parameterized.
        return this.find(new Applications(), t);

    }

    @Override
    public List<Users> findUsersForApplications(Applications app) {
        Integer appKey = app.getId();
        logger.debug("findUsersForApplications " + appKey.toString());
        String queryItem = "SELECT app "
                + "FROM Applications app "
                + "inner  join fetch app.groupsSet groups "
                + "inner  join fetch groups.usersSet users "
                + "where app.id = :appId";
        // logger.debug("\n" + queryItem + "\n");
        Query query = getEntityManager().createQuery(queryItem);
        query.setParameter("appId", appKey);
        List<Applications> results = query.getResultList();
        // logger.info("result "+results.size()+" class " + results.get(0).getClass().getName());

        List<Users> ret = new ArrayList<Users>();
        for (Applications a : results) {
            Iterator<Groups> gIter = a.getGroupsSet().iterator();
            while (gIter.hasNext()) {

                Groups g = gIter.next();
                Iterator<Users> uIter = g.getUsersSet().iterator();
                while (uIter.hasNext()) {
                    Users u = uIter.next();
                    if (ret.contains(u) == false) {
                        ret.add(u);
                    }
                }

            }
        }


        return ret;
    }

    @Override
    public List<Applications> getAllApplicationswithLimits(long start, long count) {
        String queryItem = "SELECT app "
                + "FROM Applications app ";
        Query query = getEntityManager().createQuery(queryItem);
         
        query.setFirstResult((int) start);
        query.setMaxResults((int) count);
        List<Applications> results = query.getResultList();

        return results;
    }
}

/*
    String queryItem = "FROM com.gatesbiz.scorecard.externaldata.model.ExternalFieldProviderText as t  WHERE t.sponsorCompanyId = :sponsorCompanyId  and t.fieldText = :fieldText and t.providerCompanyId =:providerCompanyId ";

		Query query = getEntityManager().createQuery(queryItem);
		query.setParameter("sponsorCompanyId", sponsorCompanyId);
		query.setParameter("providerCompanyId", providerCompanyId);
		query.setParameter("fieldText", fieldText);
		List<ExternalFieldProviderText> results = query.getResultList();
		if (results != null && results.size() > 0) {
			providerText = results.get(0);
		}
		return providerText;
 */