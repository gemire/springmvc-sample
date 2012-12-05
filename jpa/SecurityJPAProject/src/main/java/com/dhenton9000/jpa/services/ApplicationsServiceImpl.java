/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.services;

import com.dhenton9000.jpa.dao.ApplicationsDAO;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is a sample service class. The @Transactional attribute is responsible
 * for committing the transaction.
 *
 * @author dhenton
 */
@Service
public class ApplicationsServiceImpl extends GenericEntityServiceImpl<Applications, Integer> implements ApplicationsService {

    protected ApplicationsDAO applicationsDAO;

    @Autowired
    public void setApplicationsDao(ApplicationsDAO applicationsDAO) {
        this.applicationsDAO = applicationsDAO;
    }

    
    @Override
    public GenericDao<Applications, Integer> getDao() {
        return applicationsDAO;
    }

    @Override
    public Applications getNew() {
        return new Applications();
    }

    @Override
    public Applications getNewWithDefaults() {
        return getNew();
    }

    
}
