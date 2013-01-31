/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.services;

import com.dhenton9000.jpa.dao.ProfessionalDAO;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.inheritance.Professional;
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
public class ProfessionalServiceImpl extends GenericEntityServiceImpl<Professional, Integer> implements ProfessionalService {

    protected ProfessionalDAO professionalDAO;

    @Autowired
    public void setProfessionalDao(ProfessionalDAO professionalDAO) {
        this.professionalDAO = professionalDAO;
    }

    
    @Override
    public GenericDao<Professional, Integer> getDao() {
        return professionalDAO;
    }

    @Override
    public Professional getNew() {
        return new Professional();
    }

    @Override
    public Professional getNewWithDefaults() {
        return getNew();
    }

    
}
