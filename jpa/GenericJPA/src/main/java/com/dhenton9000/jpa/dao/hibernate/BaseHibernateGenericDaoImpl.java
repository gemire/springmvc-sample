/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao.hibernate;

import static com.dhenton9000.jpa.dao.hibernate.HibernateUtil.isEntityIdManuallyAssigned;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.dao.support.NamedQueryUtil;
import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.domain.Identifiable;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
//import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dhenton
 */
public  class BaseHibernateGenericDaoImpl<E extends Identifiable<PK>, PK extends Serializable> 
implements GenericDao<E, PK> {
    private final Logger logger = LoggerFactory.getLogger(BaseHibernateGenericDaoImpl.class);
    protected String cacheRegion;
    // ------------------------------------------
    // Configuration
    // ------------------------------------------
    protected boolean cacheable = true;
    
    // ------------------------------------------
    // Dependencies
    // ------------------------------------------
    protected NamedQueryUtil namedQueryUtil;
    protected Class<E> type;
    protected EntityManager entityManager;

    
     public BaseHibernateGenericDaoImpl(Class<E> type) {
        this.type = type;
        this.cacheRegion = type.getCanonicalName();
    }
    
    
    
    /**
     * {@inheritDoc}
     */
    
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
    
    @Override
    public void delete(Iterable<E> entities) {
        Validate.notNull(entities, "Cannot delete null collection");
        for (E entity : entities) {
            delete(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings(value = "unchecked")
    
    @Override
    public List<E> find(E entity, SearchTemplate searchTemplate) {
        Validate.notNull(entity, "The passed entity cannot be null");
        SearchTemplate localSearchTemplate = getLocalSearchTemplate(searchTemplate);
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

    @Override
    public E findById(PK key) {
        return getEntityManager().find(type, key);
    }

    /**
     * {@inheritDoc}
     */
    
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
     * {@inheritDoc}
     */
  
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

    protected Criterion getByPatternCriterion(SearchTemplate searchTemplate) {
        return HibernateUtil.constructPattern(type, searchTemplate);
    }

    public String getCacheRegion() {
        return cacheRegion;
    }

    public boolean getCacheable() {
        return cacheable;
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
            // AND
            // AND
        }
        return criteria;
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

    /**
     * Simple helper to obtain the current Session.
     */
    protected Session getCurrentSession() {
        return (Session) getEntityManager().getDelegate();
    }

    public  EntityManager getEntityManager()
    {
        return entityManager;
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

    public NamedQueryUtil getNamedQueryUtil() {
        return namedQueryUtil;
    }

    @Override
    
    public E merge(E entity) {
        logger.debug("begin merge");
        Validate.notNull(entity, "The entity to merge cannot be null element");
        return getEntityManager().merge(entity);
    }

    /**
     * {@inheritDoc}
     */
     
    @Override
    public void refresh(E entity) {
        if (entityManager.contains(entity)) {
            entityManager.refresh(entity);
        }
    }

    @Override
    
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
     * Set the default cacheRegion property to use when the searchTemplate
     * argument is null or do not specify one.
     */
    public void setCacheRegion(String cacheRegion) {
        this.cacheRegion = cacheRegion;
    }

    /**
     * Set the default cacheable property to be used when the searchTemplate
     * argument is null or do not specify one.
     */
    public void setCacheable(boolean cacheable) {
        this.cacheable = cacheable;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    public void setNamedQueryUtil(NamedQueryUtil namedQueryUtil) {
        this.namedQueryUtil = namedQueryUtil;
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
    
}
