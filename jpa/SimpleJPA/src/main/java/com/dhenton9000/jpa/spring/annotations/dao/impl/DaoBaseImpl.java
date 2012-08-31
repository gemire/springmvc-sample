/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.spring.annotations.dao.impl;

/**
 *
 * @author dhenton
 */
import com.dhenton9000.jpa.spring.annotations.dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DaoBaseImpl<T extends Serializable, K> implements Dao<T, K> {

    private EntityManager entityManager = null;
    private static final Logger log = LogManager.getLogger(DaoBaseImpl.class);

    protected static final class QueryParameter {

        private final String name;
        private final Object value;

        public QueryParameter(String name, Object value) {
            super();
            this.name = name;
            this.value = value;
        }

        private String getName() {
            return name;
        }

        private Object getValue() {
            return value;
        }
    }

    private static enum QueryType {

        NAMED, JPA, NATIVE;
    }
    private Class<? extends T> entityClass;

    public DaoBaseImpl(Class<? extends T> entityClass) {
        super();
        this.entityClass = entityClass;

    }

    public DaoBaseImpl() {
    }

    @Override
    public final T find(K primaryKey) {
        return getEntityManager().find(entityClass, primaryKey);
    }

    @Override
    public final T getReference(K primaryKey) throws EntityNotFoundException {
        return getEntityManager().getReference(entityClass, primaryKey);
    }

    /**
     * Persists the given entity
     *
     * This method will immediately flush so monitoring tools can detect where
     * slow SQL statements are originating from
     */
    @Override
     
    public final void persist(T entity) {
       EntityManager em = getEntityManager();
       em.persist(entity);
       em.flush();
       
    }

    @Override
    public final void merge(T entity) {
        getEntityManager().merge(entity);
        getEntityManager().flush();
    }

    /**
     * This method is not defined on the Dao interface. If a user chooses to
     * have a remove method on their dao, the implementation will be done.
     *
     * This method will immediately flush so monitoring tools can detect where
     * slow SQL statements are originating from
     *
     * @param entity
     */
    public final void remove(T entity) {
        getEntityManager().remove(entity);
        getEntityManager().flush();
    }

    protected List<? extends T> getNamedQueryResultList(String namedQuery, QueryParameter... parameters) {
        return buildTypedQuery(QueryType.NAMED, namedQuery, entityClass, parameters).getResultList();
    }

    protected T getNamedQuerySingleResult(String namedQuery, QueryParameter... parameters) {
        List<? extends T> list = buildTypedQuery(QueryType.NAMED, namedQuery, entityClass, parameters).getResultList();
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new NonUniqueResultException();
        }
    }

    protected List<? extends T> getQueryResultList(String jpaQuery, QueryParameter... parameters) {
        return buildTypedQuery(QueryType.JPA, jpaQuery, entityClass, parameters).getResultList();
    }

    protected T getQuerySingleResult(String jpaQuery, QueryParameter... parameters) {
        return buildTypedQuery(QueryType.JPA, jpaQuery, entityClass, parameters).getSingleResult();
    }

    private <Q> TypedQuery<Q> buildTypedQuery(QueryType queryType, String query, Class<Q> queryTypeClass, QueryParameter... parameters) {
        TypedQuery<Q> typedQuery;
        switch (queryType) {
            case NAMED:
                typedQuery = getEntityManager().createNamedQuery(query, queryTypeClass);
                break;
            case JPA:
                typedQuery = getEntityManager().createQuery(query, queryTypeClass);
                break;
            default:
                throw new IllegalArgumentException("Unimplemented queryType: " + queryType);
        }
        return setQueryParameters(typedQuery, parameters);
    }

    private <Q> TypedQuery<Q> setQueryParameters(TypedQuery<Q> query, QueryParameter... parameters) {
        for (QueryParameter parameter : parameters) {
            query.setParameter(parameter.getName(), parameter.getValue());
        }
        return query;
    }

    @Override
    public T load(K primaryKey) {
        return getReference(primaryKey);
    }

    @Override
    public T get(K primaryKey) {
        return find(primaryKey);
    }

    @Override
    public void save(T entity) {
        persist(entity);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }

    public EntityManager getEntityManager() {

        return this.entityManager;
    }
}
