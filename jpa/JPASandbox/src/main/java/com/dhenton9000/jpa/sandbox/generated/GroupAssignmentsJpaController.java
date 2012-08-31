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
public class GroupAssignmentsJpaController implements Serializable {

    public GroupAssignmentsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GroupAssignments groupAssignments) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users userId = groupAssignments.getUserId();
            if (userId != null) {
                userId = em.getReference(userId.getClass(), userId.getUserid());
                groupAssignments.setUserId(userId);
            }
            Groups groupId = groupAssignments.getGroupId();
            if (groupId != null) {
                groupId = em.getReference(groupId.getClass(), groupId.getId());
                groupAssignments.setGroupId(groupId);
            }
            em.persist(groupAssignments);
            if (userId != null) {
                userId.getGroupAssignmentsList().add(groupAssignments);
                userId = em.merge(userId);
            }
            if (groupId != null) {
                groupId.getGroupAssignmentsList().add(groupAssignments);
                groupId = em.merge(groupId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GroupAssignments groupAssignments) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GroupAssignments persistentGroupAssignments = em.find(GroupAssignments.class, groupAssignments.getId());
            Users userIdOld = persistentGroupAssignments.getUserId();
            Users userIdNew = groupAssignments.getUserId();
            Groups groupIdOld = persistentGroupAssignments.getGroupId();
            Groups groupIdNew = groupAssignments.getGroupId();
            if (userIdNew != null) {
                userIdNew = em.getReference(userIdNew.getClass(), userIdNew.getUserid());
                groupAssignments.setUserId(userIdNew);
            }
            if (groupIdNew != null) {
                groupIdNew = em.getReference(groupIdNew.getClass(), groupIdNew.getId());
                groupAssignments.setGroupId(groupIdNew);
            }
            groupAssignments = em.merge(groupAssignments);
            if (userIdOld != null && !userIdOld.equals(userIdNew)) {
                userIdOld.getGroupAssignmentsList().remove(groupAssignments);
                userIdOld = em.merge(userIdOld);
            }
            if (userIdNew != null && !userIdNew.equals(userIdOld)) {
                userIdNew.getGroupAssignmentsList().add(groupAssignments);
                userIdNew = em.merge(userIdNew);
            }
            if (groupIdOld != null && !groupIdOld.equals(groupIdNew)) {
                groupIdOld.getGroupAssignmentsList().remove(groupAssignments);
                groupIdOld = em.merge(groupIdOld);
            }
            if (groupIdNew != null && !groupIdNew.equals(groupIdOld)) {
                groupIdNew.getGroupAssignmentsList().add(groupAssignments);
                groupIdNew = em.merge(groupIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = groupAssignments.getId();
                if (findGroupAssignments(id) == null) {
                    throw new NonexistentEntityException("The groupAssignments with id " + id + " no longer exists.");
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
            GroupAssignments groupAssignments;
            try {
                groupAssignments = em.getReference(GroupAssignments.class, id);
                groupAssignments.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The groupAssignments with id " + id + " no longer exists.", enfe);
            }
            Users userId = groupAssignments.getUserId();
            if (userId != null) {
                userId.getGroupAssignmentsList().remove(groupAssignments);
                userId = em.merge(userId);
            }
            Groups groupId = groupAssignments.getGroupId();
            if (groupId != null) {
                groupId.getGroupAssignmentsList().remove(groupAssignments);
                groupId = em.merge(groupId);
            }
            em.remove(groupAssignments);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GroupAssignments> findGroupAssignmentsEntities() {
        return findGroupAssignmentsEntities(true, -1, -1);
    }

    public List<GroupAssignments> findGroupAssignmentsEntities(int maxResults, int firstResult) {
        return findGroupAssignmentsEntities(false, maxResults, firstResult);
    }

    private List<GroupAssignments> findGroupAssignmentsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GroupAssignments.class));
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

    public GroupAssignments findGroupAssignments(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GroupAssignments.class, id);
        } finally {
            em.close();
        }
    }

    public int getGroupAssignmentsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GroupAssignments> rt = cq.from(GroupAssignments.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
