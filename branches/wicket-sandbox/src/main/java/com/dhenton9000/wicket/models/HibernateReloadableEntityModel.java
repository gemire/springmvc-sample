/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

import com.dhenton9000.jpa.dao.hibernate.HibernateGenericDaoImpl;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.domain.Identifiable;
import java.io.Serializable;
import org.apache.wicket.model.IModel;

/**
 *
 * @author dhenton
 */
public class HibernateReloadableEntityModel<T extends Identifiable<PK>, PK extends Serializable>
        extends ReloadableEntityModel {

    public HibernateReloadableEntityModel(Class entityClass, Long id) {
        super(entityClass, id);
    }

    public HibernateReloadableEntityModel(Identifiable entity) {
        super(entity);
    }

    public HibernateReloadableEntityModel(IModel entityModel) {
        super(entityModel);
    }

    
    
    
    @Override
     public GenericDao getDao()
     {
         GenericDao<T, PK> crudServices = new HibernateGenericDaoImpl<T, PK>(getEntityClass());
         return crudServices;
     }
    
}
