/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

import com.dhenton9000.jpa.dao.hibernate.HibernateGenericDaoImpl;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.domain.Identifiable;
import com.dhenton9000.jpa.service.support.GenericEntityService;
import java.io.Serializable;
import org.apache.wicket.model.IModel;

/**
 *
 * @author dhenton
 */
public class HibernateReloadableEntityModel<T extends Identifiable<PK>, PK extends Serializable>
        extends ReloadableEntityModel {
    
    private GenericEntityService service = null;

    public HibernateReloadableEntityModel(Class entityClass, Long id) {
        super(entityClass, id);
    }

    public HibernateReloadableEntityModel(Identifiable entity) {
        super(entity);
    }

    public HibernateReloadableEntityModel(IModel entityModel) {
        super(entityModel);
    }

    /**
     * @return the service
     */
    @Override
    public GenericEntityService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    @Override
    public void setService(GenericEntityService service) {
        this.service = service;
    }

     

     

    

    
 

    
    
}
