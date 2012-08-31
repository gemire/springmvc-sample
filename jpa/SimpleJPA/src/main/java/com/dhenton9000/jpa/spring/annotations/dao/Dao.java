package com.dhenton9000.jpa.spring.annotations.dao;

/**
 *
 * @author dhenton
 */

import java.io.Serializable;
import javax.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 * This is the main dao interface. Extend this for functionality, then
 * implement the extended interface
 * 
 * @param <T>
 * @param <K>
 */
public interface Dao<T extends Serializable, K> {

	/**
	 * Find by primary key. 
	 * 
	 * @param primaryKey
	 * @return the found entity instance or 
         * null if the entity does not exist
	 */
	T find(K primaryKey);
        
        
        void merge(T entity);

	/**
	 * Get an instance, whose state may be lazily fetched. 
         * If the requested instance does not exist in the database, the
	 * EntityNotFoundException is thrown when the instance state is first 
         * accessed. 
	 * 
	 * @param primaryKey
	 * @return
	 * @throws EntityNotFoundException
	 */
	T getReference(K primaryKey);

	/**
	 * Make an instance managed and persistent.
	 * 
	 * @param entity
	 */
       
	void persist(T entity);

	/**
	 * @param primaryKey
	 * @return
	 * @deprecated use getReference(K primaryKey) instead
	 */
	@Deprecated
	T load(K primaryKey);

	/**
	 * @param primaryKey
	 * @return
	 * @deprecated - use find(K primaryKey) instead
	 */
	@Deprecated
	T get(K primaryKey);

	/**
	 * @param entity
	 * @deprecated - use persist(T entity) instead.
	 */
	@Deprecated
	void save(T entity);
}
