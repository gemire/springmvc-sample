/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/hibernate/support/HibernateGenericDao.p.vm.java
 */
package com.dhenton9000.wicket.dao.impl;

import com.dhenton9000.jpa.dao.hibernate.HibernateUtil;
import static com.dhenton9000.jpa.dao.hibernate.HibernateUtil.isEntityIdManuallyAssigned;
//import com.dhenton9000.jpa.dao.hibernate.NamedQueryUtilHibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.Validate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.google.inject.persist.Transactional;


import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.dao.support.NamedQueryUtil;
import com.dhenton9000.jpa.dao.support.NamedQueryUtilHibernate;
import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.domain.Identifiable;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Partial Hibernate implementation of the {@link GenericDao} interface.<br> The
 * exceptions are converted to generic spring unchecked exceptions.
 */
public abstract class GuiceGenericDaoImpl<E extends Identifiable<PK>, PK extends Serializable> implements
        GenericDao<E, PK> {

    private Class<E> type;
    private final static Logger logger = LoggerFactory.getLogger(GuiceGenericDaoImpl.class);

    /**
     * This constructor needs the real type of the generic type E so it can be
     * passed to the {@link EntityManager}.
     */
    public GuiceGenericDaoImpl(Class<E> type) {
        this.type = type;
        this.cacheRegion = type.getCanonicalName();
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public E get(E entity) {
        if (entity == null) {
            return null;
        }

        Serializable id = entity.getPrimaryKey();
        if (id == null) {
            return null;
        }

        E entityFound = getEntityManager().find(type, id);

        if (entityFound == null) {
            logger.warn("get returned null with pk=" + id);
        }

        return entityFound;
    }

    @Transactional
    @Override
    public E findById(Serializable id) {
        if (id == null) {
            return null;
        }

        E entityFound = getEntityManager().find(type, id);

        if (entityFound == null) {
            logger.warn("get returned null with pk=" + id);
        }

        return entityFound;
    }

    
    @Override
    @Transactional
    public E merge(E entity)
    {
        logger.debug("begin save");
        Validate.notNull(entity, "The entity to save cannot be null element");
        E newMergedEntity = getEntityManager().merge(entity);
        return newMergedEntity;
    }
    
    
    
    @Override
    @Transactional
    public void save(E entity) {
        logger.debug("begin save");
        Validate.notNull(entity, "The entity to save cannot be null element");

        // creation with auto generated id
        if (!entity.isPrimaryKeySet()) {
            logger.debug("in auto generated for save");
            getEntityManager().persist(entity);
            return;
        }

        // creation with manually assigned key
        if (isEntityIdManuallyAssigned(type) && !getEntityManager().contains(entity)) {
            logger.debug("in manually assigned for save");
            getEntityManager().persist(entity);
            return;
        }
        
         
        
        
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void refresh(E entity) {
        if (entityManager.contains(entity)) {
            entityManager.refresh(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<E> find(E entity, SearchTemplate parameterSample) {
        Validate.notNull(entity, "The passed entity cannot be null");
        SearchTemplate localSearchTemplate = getLocalSearchTemplate(parameterSample);

        if (localSearchTemplate.hasNamedQuery()) {
            return (List<E>) getNamedQueryUtil().findByNamedQuery(localSearchTemplate, entity);
        }

        Criteria criteria = getCriteria(entity, localSearchTemplate);
        HibernateUtil.applyPaginationAndOrderOnCriteria(criteria, localSearchTemplate);

        List<E> entities = (List<E>) criteria.list();
        if (logger.isDebugEnabled()) {
            logger.debug("Returned " + entities.size() + " elements");
        }

        return entities;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public int findCount(E entity, SearchTemplate searchTemplate) {
        Validate.notNull(entity, "The entity cannot be null");
        SearchTemplate localSearchTemplate = getLocalSearchTemplate(searchTemplate);

        if (localSearchTemplate.hasNamedQuery()) {
            return getNamedQueryUtil().numberByNamedQuery(localSearchTemplate, entity).intValue();
        }

        Criteria criteria = getCriteria(entity, searchTemplate);
        criteria.setProjection(Projections.rowCount());

        Number count = (Number) criteria.uniqueResult();

        if (count != null) {
            return count.intValue();
        } else {
            logger.warn("findCount returned null!");
            return 0;
        }
    }

    /**
     * Create a criteria with caching enabled
     *
     * @param entity the entity to use in search by Example
     * @param searchTemplate the specific parameters such as named queries,
     * extra infos, limitations, order, ...
     * @return an hibernate criteria
     */
    protected Criteria getCriteria(E entity, SearchTemplate searchTemplate) {
        Criteria criteria = getCurrentSession().createCriteria(type);
        setUpCacheOnCriteria(criteria, searchTemplate);

        List<Criterion> criterions = getCriterions(entity, searchTemplate);
        for (Criterion criterion : criterions) {
            criteria.add(criterion); // AND
        }

        return criteria;
    }

    protected void setUpCacheOnCriteria(Criteria criteria, SearchTemplate searchTemplate) {
        if (searchTemplate.isCacheable()) {
            criteria.setCacheable(true);

            if (searchTemplate.hasCacheRegion()) {
                criteria.setCacheRegion(searchTemplate.getCacheRegion());
            } else {
                criteria.setCacheRegion(getCacheRegion());
            }
        }
    }

    protected List<Criterion> getCriterions(E entity, SearchTemplate searchTemplate) {
        List<Criterion> criterions = new ArrayList<Criterion>();

        // search by date range
        Criterion dateCriterion = getByDateCriterion(searchTemplate);
        if (dateCriterion != null) {
            criterions.add(dateCriterion);
        }

        // search by example
        Criterion exampleCriterion = getByExampleCriterion(entity, searchTemplate);
        if (exampleCriterion != null) {
            criterions.add(exampleCriterion);
        }

        // search by pattern
        Criterion patternCriterion = getByPatternCriterion(searchTemplate);
        if (patternCriterion != null) {
            criterions.add(patternCriterion);
        }

        // additional criterion (for example isNull criterion on x-to-many association)
        for (Criterion c : searchTemplate.getCriterions()) {
            criterions.add(c);
        }

        return criterions;
    }

    protected Criterion getByDateCriterion(SearchTemplate searchTemplate) {
        return HibernateUtil.constructDate(searchTemplate);
    }

    protected Criterion getByExampleCriterion(E entity, SearchTemplate searchTemplate) {
        Criterion example = HibernateUtil.constructExample(entity, searchTemplate);
        List<Criterion> extras = getByExampleExtraCriterions(entity, searchTemplate);

        if (extras != null && extras.size() > 0) {
            Junction conjunction = Restrictions.conjunction();
            for (Criterion extra : extras) {
                conjunction.add(extra);
            }
            conjunction.add(example);
            return conjunction;
        } else {
            return example;
        }
    }

    protected Criterion getByPatternCriterion(SearchTemplate searchTemplate) {
        return HibernateUtil.constructPattern(type, searchTemplate);
    }

    /**
     * Subclass may provide extra criterion. Used along with search by example.
     * Default implementation does nothing. Principal use case is to add
     * criterion so the id fields part of the composite primary key are included
     * in a search by example.
     *
     * @param entity
     * @param searchTemplate
     * @return a criterion that will be appended (AND) to the example criterion.
     * Null if no criterion should be appended.
     */
    protected List<Criterion> getByExampleExtraCriterions(E entity, SearchTemplate searchTemplate) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void save(Iterable<E> entities) {
        Validate.notNull(entities, "The entities to save cannot be null");

        for (E entity : entities) {
            save(entity);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Save List done");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void delete(E entity) {
        if (getEntityManager().contains(entity)) {
            getEntityManager().remove(entity);
        } else {
            // could be a delete on a transient instance
            E entityRef = getEntityManager().getReference(type, entity.getPrimaryKey());

            if (entityRef != null) {
                getEntityManager().remove(entityRef);
            } else {
                logger.warn("Attempt to delete an instance that is not present in the database: " + entity.toString());
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void delete(Iterable<E> entities) {
        Validate.notNull(entities, "Cannot delete null collection");
        for (E entity : entities) {
            delete(entity);
        }
    }

    /**
     * Create a new search template, taking into account the passed
     * searchTemplate and the cacheable and cacheRegion properties of this
     * instance.
     */
    public SearchTemplate getLocalSearchTemplate(SearchTemplate searchTemplate) {
        if (searchTemplate == null) {
            SearchTemplate localSearchTemplate = new SearchTemplate();
            localSearchTemplate.setCacheable(getCacheable());
            localSearchTemplate.setCacheRegion(getCacheRegion());
            return localSearchTemplate;
        }

        SearchTemplate localSearchTemplate = new SearchTemplate(searchTemplate);

        if (searchTemplate.isCacheable() == null) {
            localSearchTemplate.setCacheable(getCacheable());
        }

        if (!searchTemplate.hasCacheRegion()) {
            localSearchTemplate.setCacheRegion(getCacheRegion());
        }

        return localSearchTemplate;
    }

    /**
     * Simple helper to obtain the current Session.
     */
    protected Session getCurrentSession() {
        return (Session) getEntityManager().getDelegate();
    }
    // ------------------------------------------
    // Dependencies
    // ------------------------------------------
    @Inject
    private EntityManager entityManager;
    private NamedQueryUtil namedQueryUtil = null;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public NamedQueryUtil getNamedQueryUtil() {
        if (namedQueryUtil == null) {
            namedQueryUtil = new NamedQueryUtilHibernate(entityManager);
        }

        return namedQueryUtil;
    }
    // ------------------------------------------
    // Configuration
    // ------------------------------------------
    private boolean cacheable = true;
    private String cacheRegion;

    /**
     * Set the default cacheable property to be used when the searchTemplate
     * argument is null or do not specify one.
     */
    public void setCacheable(boolean cacheable) {
        this.cacheable = cacheable;
    }

    public boolean getCacheable() {
        return cacheable;
    }

    /**
     * Set the default cacheRegion property to use when the searchTemplate
     * argument is null or do not specify one.
     */
    public void setCacheRegion(String cacheRegion) {
        this.cacheRegion = cacheRegion;
    }

    public String getCacheRegion() {
        return cacheRegion;
    }
}