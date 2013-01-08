/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

/**
 *
 * @author dhenton
 */
/**
 * Constellio, Open Source Enterprise Search Copyright (C) 2010 DocuLibre inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to: Free Software Foundation,
 * Inc. 51 Franklin Street, Fifth Floor Boston, MA 02110-1301 USA
 */
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.domain.Identifiable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.lang.SerializationUtils;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

@SuppressWarnings("serial")
public abstract class ReloadableEntityModel<T extends Identifiable<PK>, PK extends Serializable> 
extends LoadableDetachableModel {

    private Class<T> entityClass;
    private PK id;
    private T entity;
    private byte[] serializedEntity;
    private IModel entityModel;

    public ReloadableEntityModel(Class<T> entityClass, PK id) {
        this.entityClass = entityClass;
        this.id = id;
    }

    public ReloadableEntityModel(T entity) {
        this.entity = entity;
    }

    public ReloadableEntityModel(IModel entityModel) {
        this.entityModel = entityModel;
    }
    
    public abstract GenericDao getDao();

    @Override
    protected final T load() {
        T result;
        if (entityModel != null) {
            entity = (T) entityModel.getObject();
            entityModel.detach();
            entityModel = null;
        } else if (serializedEntity != null) {
            entity = (T) SerializationUtils.deserialize(serializedEntity);
            result = entity;
        }
        if (entity != null) {
            result = entity;
        } else {

            GenericDao<T, PK> crudServices = getDao();
            if (id != null) {
                result = entity = crudServices.findById(id);
            } else {
                result = null;
            }
        }
        if (serializedEntity != null) {
            serializedEntity = null;
        }
        return result;
    }

    @Override
    public void detach() {
        if (entityModel != null) {
            entity = (T) entityModel.getObject();
            entityModel.detach();
            entityModel = null;
        }
        prepareForSerialization();
        super.detach();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        prepareForSerialization();
        oos.defaultWriteObject();
    }

    @SuppressWarnings("unchecked")
    private void prepareForSerialization() {
        if (entity != null) {
            if (entity.getPrimaryKey() != null) {
                entityClass = (Class<T>) entity.getClass();
                id = entity.getPrimaryKey();
                entity = null;
                serializedEntity = null;
            } else {
                serializedEntity = SerializationUtils.serialize((Serializable) entity);
                entity = null;
            }
        }
    }

    /**
     * @return the entityClass
     */
    public Class<T> getEntityClass() {
        return entityClass;
    }
}
