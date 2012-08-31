/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.lobdemo.dao;


import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import com.dhenton9000.lobdemo.model.LobTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is a sample service class. The @Transactional attribute is responsible
 * for committing the transaction.
 *
 * @author dhenton
 */
@Service
public class LobTableServiceImpl extends GenericEntityServiceImpl<LobTable, Integer> implements LobTableService {

    protected LobTableDAO lobTableDAO;

    @Autowired
    public void setLobTableDao(LobTableDAO lobTableDAO) {
        this.lobTableDAO = lobTableDAO;
    }

    
    @Override
    public GenericDao<LobTable, Integer> getDao() {
        return lobTableDAO;
    }

    @Override
    public LobTable getNew() {
        return new LobTable();
    }

    @Override
    public LobTable getNewWithDefaults() {
        return getNew();
    }

    
}
