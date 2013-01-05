/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.impl;

import com.dhenton9000.jpa.entities.Wine;
import com.dhenton9000.wicket.dao.IWineDao;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
@Singleton
public class WineDaoImpl
        extends GuiceGenericDaoImpl<Wine, Integer>
        implements IWineDao {

    private final static Logger logger = LoggerFactory.getLogger(WineDaoImpl.class);

    public WineDaoImpl() {
        super(Wine.class);
    }
}