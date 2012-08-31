/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities.generated;

import com.dhenton9000.jpa.entities.Applications;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.entities.generated.exceptions.NonexistentEntityException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author dhenton
 */
public class ApplicationsJpaController implements Serializable {

    public ApplicationsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Applications applications) {
        if (applications.getGroupsSet() == null) {
            applications.setGroupsSet(new HashSet<Groups>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<Groups> attachedGroupsSet = new HashSet<Groups>();
            for (Groups groupsSetGroupsToAttach : applications.getGroupsSet()) {
                groupsSetGroupsToAttach = em.getReference(groupsSetGroupsToAttach.getClass(), groupsSetGroupsToAttach.getId());
                attachedGroupsSet.add(groupsSetGroupsToAttach);
            }
            applications.setGroupsSet(attachedGroupsSet);
            em.persist(applications);
            for (Groups groupsSetGroups : applications.getGroupsSet()) {
                groupsSetGroups.getApplicationsSet().add(applications);
                groupsSetGroups = em.merge(groupsSetGroups);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Applications applications) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Applications persistentApplications = em.find(Applications.class, applications.getId());
            Set<Groups> groupsSetOld = persistentApplications.getGroupsSet();
            Set<Groups> groupsSetNew = applications.getGroupsSet();
            Set<Groups> attachedGroupsSetNew = new HashSet<Groups>();
            for (Groups groupsSetNewGroupsToAttach : groupsSetNew) {
                groupsSetNewGroupsToAttach = em.getReference(groupsSetNewGroupsToAttach.getClass(), groupsSetNewGroupsToAttach.getId());
                attachedGroupsSetNew.add(groupsSetNewGroupsToAttach);
            }
            groupsSetNew = attachedGroupsSetNew;
            applications.setGroupsSet(groupsSetNew);
            applications = em.merge(applications);
            for (Groups groupsSetOldGroups : groupsSetOld) {
                if (!groupsSetNew.contains(groupsSetOldGroups)) {
                    groupsSetOldGroups.getApplicationsSet().remove(applications);
                    groupsSetOldGroups = em.merge(groupsSetOldGroups);
                }
            }
            for (Groups groupsSetNewGroups : groupsSetNew) {
                if (!groupsSetOld.contains(groupsSetNewGroups)) {
                    groupsSetNewGroups.getApplicationsSet().add(applications);
                    groupsSetNewGroups = em.merge(groupsSetNewGroups);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = applications.getId();
                if (findApplications(id) == null) {
                    throw new NonexistentEntityException("The applications with id " + id + " no longer exists.");
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
            Applications applications;
            try {
                applications = em.getReference(Applications.class, id);
                applications.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The applications with id " + id + " no longer exists.", enfe);
            }
            Set<Groups> groupsSet = applications.getGroupsSet();
            for (Groups groupsSetGroups : groupsSet) {
                groupsSetGroups.getApplicationsSet().remove(applications);
                groupsSetGroups = em.merge(groupsSetGroups);
            }
            em.remove(applications);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Applications> findApplicationsEntities() {
        return findApplicationsEntities(true, -1, -1);
    }

    public List<Applications> findApplicationsEntities(int maxResults, int firstResult) {
        return findApplicationsEntities(false, maxResults, firstResult);
    }

    private List<Applications> findApplicationsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Applications as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Applications findApplications(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Applications.class, id);
        } finally {
            em.close();
        }
    }

    public int getApplicationsCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Applications as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
