package com.dhenton9000.generic;

import java.io.Serializable;
import java.util.List;



public interface GenericDAO<T, ID extends Serializable> {

	public void emptyTable() throws DataAccessLayerException;

	public T findById(ID id) throws DataAccessLayerException;

	/**
	 * used to attach a detached instance to a new session that no changes have
	 * been made.
	 * 
	 * @param detachedInstance
	 * @throws DataAccessLayerException
	 */
	public void attachClean(T detachedInstance) throws DataAccessLayerException;
        
        /**
         * save a detached instance will throw an error if done twice on the
         * same object
         * @param detachedInstance
         * @throws DataAccessLayerException 
         */

	public void save(T detachedInstance) throws DataAccessLayerException;

	public void delete(T detachedInstance) throws DataAccessLayerException;

	public List<T> findAll() throws DataAccessLayerException;

	public void deleteByExample(T example) throws DataAccessLayerException;

	public void evict(T o) throws DataAccessLayerException;

	public Class<T> getPersistenceClass();
        
        public void saveOrUpdate(T instance) throws DataAccessLayerException;
        
        public T merge(T instance) throws DataAccessLayerException;

}