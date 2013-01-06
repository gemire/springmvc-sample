/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.domain.Identifiable;
import com.dhenton9000.wicket.dao.impl.GuiceGenericDaoImpl;
import java.io.Serializable;
import org.apache.wicket.model.IModel;

/**
 *
 * @author dhenton
 */
public class GuiceReloadableEntityModel<T extends Identifiable<PK>, PK extends Serializable>
        extends ReloadableEntityModel {

    public GuiceReloadableEntityModel(Class entityClass, Long id) {
        super(entityClass, id);
    }

    public GuiceReloadableEntityModel(Identifiable entity) {
        super(entity);
    }

    public GuiceReloadableEntityModel(IModel entityModel) {
        super(entityModel);
    }

    
    
    
    @Override
     public GenericDao getDao()
     {
         GenericDao<T, PK> crudServices = new GuiceGenericDaoImpl<T, PK>(getEntityClass());
         return crudServices;
     }
    
}
