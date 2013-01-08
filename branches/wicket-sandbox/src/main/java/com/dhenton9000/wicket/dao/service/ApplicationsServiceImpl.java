/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.service;

import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import com.dhenton9000.wicket.dao.impl.ApplicationsDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is a sample service class. The
 *
 * @Transactional attribute is responsible for committing the transaction.
 *
 * @author dhenton
 */
@Service
public class ApplicationsServiceImpl extends GenericEntityServiceImpl<Applications, Integer> implements IApplicationsService {

    protected IApplicationsDao applicationsDao;

    @Autowired
    public void setApplicationsDao(IApplicationsDao applicationsDAO) {
        this.applicationsDao = applicationsDAO;
    }

    @Override
    public IApplicationsDao getDao() {
        return applicationsDao;
    }

    @Override
    public Applications getNew() {
        return new Applications();
    }

    @Override
    public Applications getNewWithDefaults() {
        return getNew();
    }
    
    @Override
    public List<Applications> getAllApplications()
    {
        return getDao().getAllApplications();
    }

    @Override
    public List<Users> findUsersForApplications(Applications selectedApplication) {
       return getDao().findUsersForApplications(selectedApplication);
    }
    
}
