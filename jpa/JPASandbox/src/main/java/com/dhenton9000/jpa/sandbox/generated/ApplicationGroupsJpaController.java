/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.sandbox.generated;

import com.dhenton9000.jpa.sandbox.generated.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author dhenton
 */
public class ApplicationGroupsJpaController implements Serializable {

    public ApplicationGroupsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ApplicationGroups applicationGroups) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Groups groupId = applicationGroups.getGroupId();
            if (groupId != null) {
                groupId = em.getReference(groupId.getClass(), groupId.getId());
                applicationGroups.setGroupId(groupId);
            }
            Applications applicationId = applicationGroups.getApplicationId();
            if (applicationId != null) {
                applicationId = em.getReference(applicationId.getClass(), applicationId.getId());
                applicationGroups.setApplicationId(applicationId);
            }
            em.persist(applicationGroups);
            if (groupId != null) {
                groupId.getApplicationGroupsList().add(applicationGroups);
                groupId = em.merge(groupId);
            }
            if (applicationId != null) {
                applicationId.getApplicationGroupsList().add(applicationGroups);
                applicationId = em.merge(applicationId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ApplicationGroups applicationGroups) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ApplicationGroups persistentApplicationGroups = em.find(ApplicationGroups.class, applicationGroups.getId());
            Groups groupIdOld = persistentApplicationGroups.getGroupId();
            Groups groupIdNew = applicationGroups.getGroupId();
            Applications applicationIdOld = persistentApplicationGroups.getApplicationId();
            Applications applicationIdNew = applicationGroups.getApplicationId();
            if (groupIdNew != null) {
                groupIdNew = em.getReference(groupIdNew.getClass(), groupIdNew.getId());
                applicationGroups.setGroupId(groupIdNew);
            }
            if (applicationIdNew != null) {
                applicationIdNew = em.getReference(applicationIdNew.getClass(), applicationIdNew.getId());
                applicationGroups.setApplicationId(applicationIdNew);
            }
            applicationGroups = em.merge(applicationGroups);
            if (groupIdOld != null && !groupIdOld.equals(groupIdNew)) {
                groupIdOld.getApplicationGroupsList().remove(applicationGroups);
                groupIdOld = em.merge(groupIdOld);
            }
            if (groupIdNew != null && !groupIdNew.equals(groupIdOld)) {
                groupIdNew.getApplicationGroupsList().add(applicationGroups);
                groupIdNew = em.merge(groupIdNew);
            }
            if (applicationIdOld != null && !applicationIdOld.equals(applicationIdNew)) {
                applicationIdOld.getApplicationGroupsList().remove(applicationGroups);
                applicationIdOld = em.merge(applicationIdOld);
            }
            if (applicationIdNew != null && !applicationIdNew.equals(applicationIdOld)) {
                applicationIdNew.getApplicationGroupsList().add(applicationGroups);
                applicationIdNew = em.merge(applicationIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = applicationGroups.getId();
                if (findApplicationGroups(id) == null) {
                    throw new NonexistentEntityException("The applicationGroups with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ApplicationGroups applicationGroups;
            try {
                applicationGroups = em.getReference(ApplicationGroups.class, id);
                applicationGroups.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The applicationGroups with id " + id + " no longer exists.", enfe);
            }
            Groups groupId = applicationGroups.getGroupId();
            if (groupId != null) {
                groupId.getApplicationGroupsList().remove(applicationGroups);
                groupId = em.merge(groupId);
            }
            Applications applicationId = applicationGroups.getApplicationId();
            if (applicationId != null) {
                applicationId.getApplicationGroupsList().remove(applicationGroups);
                applicationId = em.merge(applicationId);
            }
            em.remove(applicationGroups);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ApplicationGroups> findApplicationGroupsEntities() {
        return findApplicationGroupsEntities(true, -1, -1);
    }

    public List<ApplicationGroups> findApplicationGroupsEntities(int maxResults, int firstResult) {
        return findApplicationGroupsEntities(false, maxResults, firstResult);
    }

    private List<ApplicationGroups> findApplicationGroupsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ApplicationGroups.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ApplicationGroups findApplicationGroups(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ApplicationGroups.class, id);
        } finally {
            em.close();
        }
    }

    public int getApplicationGroupsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ApplicationGroups> rt = cq.from(ApplicationGroups.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
