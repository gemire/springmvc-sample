/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.sandbox.generated;

import com.dhenton9000.jpa.sandbox.generated.exceptions.IllegalOrphanException;
import com.dhenton9000.jpa.sandbox.generated.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
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
        if (applications.getApplicationGroupsList() == null) {
            applications.setApplicationGroupsList(new ArrayList<ApplicationGroups>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ApplicationGroups> attachedApplicationGroupsList = new ArrayList<ApplicationGroups>();
            for (ApplicationGroups applicationGroupsListApplicationGroupsToAttach : applications.getApplicationGroupsList()) {
                applicationGroupsListApplicationGroupsToAttach = em.getReference(applicationGroupsListApplicationGroupsToAttach.getClass(), applicationGroupsListApplicationGroupsToAttach.getId());
                attachedApplicationGroupsList.add(applicationGroupsListApplicationGroupsToAttach);
            }
            applications.setApplicationGroupsList(attachedApplicationGroupsList);
            em.persist(applications);
            for (ApplicationGroups applicationGroupsListApplicationGroups : applications.getApplicationGroupsList()) {
                Applications oldApplicationIdOfApplicationGroupsListApplicationGroups = applicationGroupsListApplicationGroups.getApplicationId();
                applicationGroupsListApplicationGroups.setApplicationId(applications);
                applicationGroupsListApplicationGroups = em.merge(applicationGroupsListApplicationGroups);
                if (oldApplicationIdOfApplicationGroupsListApplicationGroups != null) {
                    oldApplicationIdOfApplicationGroupsListApplicationGroups.getApplicationGroupsList().remove(applicationGroupsListApplicationGroups);
                    oldApplicationIdOfApplicationGroupsListApplicationGroups = em.merge(oldApplicationIdOfApplicationGroupsListApplicationGroups);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Applications applications) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Applications persistentApplications = em.find(Applications.class, applications.getId());
            List<ApplicationGroups> applicationGroupsListOld = persistentApplications.getApplicationGroupsList();
            List<ApplicationGroups> applicationGroupsListNew = applications.getApplicationGroupsList();
            List<String> illegalOrphanMessages = null;
            for (ApplicationGroups applicationGroupsListOldApplicationGroups : applicationGroupsListOld) {
                if (!applicationGroupsListNew.contains(applicationGroupsListOldApplicationGroups)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ApplicationGroups " + applicationGroupsListOldApplicationGroups + " since its applicationId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<ApplicationGroups> attachedApplicationGroupsListNew = new ArrayList<ApplicationGroups>();
            for (ApplicationGroups applicationGroupsListNewApplicationGroupsToAttach : applicationGroupsListNew) {
                applicationGroupsListNewApplicationGroupsToAttach = em.getReference(applicationGroupsListNewApplicationGroupsToAttach.getClass(), applicationGroupsListNewApplicationGroupsToAttach.getId());
                attachedApplicationGroupsListNew.add(applicationGroupsListNewApplicationGroupsToAttach);
            }
            applicationGroupsListNew = attachedApplicationGroupsListNew;
            applications.setApplicationGroupsList(applicationGroupsListNew);
            applications = em.merge(applications);
            for (ApplicationGroups applicationGroupsListNewApplicationGroups : applicationGroupsListNew) {
                if (!applicationGroupsListOld.contains(applicationGroupsListNewApplicationGroups)) {
                    Applications oldApplicationIdOfApplicationGroupsListNewApplicationGroups = applicationGroupsListNewApplicationGroups.getApplicationId();
                    applicationGroupsListNewApplicationGroups.setApplicationId(applications);
                    applicationGroupsListNewApplicationGroups = em.merge(applicationGroupsListNewApplicationGroups);
                    if (oldApplicationIdOfApplicationGroupsListNewApplicationGroups != null && !oldApplicationIdOfApplicationGroupsListNewApplicationGroups.equals(applications)) {
                        oldApplicationIdOfApplicationGroupsListNewApplicationGroups.getApplicationGroupsList().remove(applicationGroupsListNewApplicationGroups);
                        oldApplicationIdOfApplicationGroupsListNewApplicationGroups = em.merge(oldApplicationIdOfApplicationGroupsListNewApplicationGroups);
                    }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<ApplicationGroups> applicationGroupsListOrphanCheck = applications.getApplicationGroupsList();
            for (ApplicationGroups applicationGroupsListOrphanCheckApplicationGroups : applicationGroupsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Applications (" + applications + ") cannot be destroyed since the ApplicationGroups " + applicationGroupsListOrphanCheckApplicationGroups + " in its applicationGroupsList field has a non-nullable applicationId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Applications.class));
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
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Applications> rt = cq.from(Applications.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
