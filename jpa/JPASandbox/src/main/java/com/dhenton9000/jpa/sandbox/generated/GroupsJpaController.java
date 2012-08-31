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
public class GroupsJpaController implements Serializable {

    public GroupsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Groups groups) {
        if (groups.getApplicationGroupsList() == null) {
            groups.setApplicationGroupsList(new ArrayList<ApplicationGroups>());
        }
        if (groups.getGroupAssignmentsList() == null) {
            groups.setGroupAssignmentsList(new ArrayList<GroupAssignments>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ApplicationGroups> attachedApplicationGroupsList = new ArrayList<ApplicationGroups>();
            for (ApplicationGroups applicationGroupsListApplicationGroupsToAttach : groups.getApplicationGroupsList()) {
                applicationGroupsListApplicationGroupsToAttach = em.getReference(applicationGroupsListApplicationGroupsToAttach.getClass(), applicationGroupsListApplicationGroupsToAttach.getId());
                attachedApplicationGroupsList.add(applicationGroupsListApplicationGroupsToAttach);
            }
            groups.setApplicationGroupsList(attachedApplicationGroupsList);
            List<GroupAssignments> attachedGroupAssignmentsList = new ArrayList<GroupAssignments>();
            for (GroupAssignments groupAssignmentsListGroupAssignmentsToAttach : groups.getGroupAssignmentsList()) {
                groupAssignmentsListGroupAssignmentsToAttach = em.getReference(groupAssignmentsListGroupAssignmentsToAttach.getClass(), groupAssignmentsListGroupAssignmentsToAttach.getId());
                attachedGroupAssignmentsList.add(groupAssignmentsListGroupAssignmentsToAttach);
            }
            groups.setGroupAssignmentsList(attachedGroupAssignmentsList);
            em.persist(groups);
            for (ApplicationGroups applicationGroupsListApplicationGroups : groups.getApplicationGroupsList()) {
                Groups oldGroupIdOfApplicationGroupsListApplicationGroups = applicationGroupsListApplicationGroups.getGroupId();
                applicationGroupsListApplicationGroups.setGroupId(groups);
                applicationGroupsListApplicationGroups = em.merge(applicationGroupsListApplicationGroups);
                if (oldGroupIdOfApplicationGroupsListApplicationGroups != null) {
                    oldGroupIdOfApplicationGroupsListApplicationGroups.getApplicationGroupsList().remove(applicationGroupsListApplicationGroups);
                    oldGroupIdOfApplicationGroupsListApplicationGroups = em.merge(oldGroupIdOfApplicationGroupsListApplicationGroups);
                }
            }
            for (GroupAssignments groupAssignmentsListGroupAssignments : groups.getGroupAssignmentsList()) {
                Groups oldGroupIdOfGroupAssignmentsListGroupAssignments = groupAssignmentsListGroupAssignments.getGroupId();
                groupAssignmentsListGroupAssignments.setGroupId(groups);
                groupAssignmentsListGroupAssignments = em.merge(groupAssignmentsListGroupAssignments);
                if (oldGroupIdOfGroupAssignmentsListGroupAssignments != null) {
                    oldGroupIdOfGroupAssignmentsListGroupAssignments.getGroupAssignmentsList().remove(groupAssignmentsListGroupAssignments);
                    oldGroupIdOfGroupAssignmentsListGroupAssignments = em.merge(oldGroupIdOfGroupAssignmentsListGroupAssignments);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Groups groups) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Groups persistentGroups = em.find(Groups.class, groups.getId());
            List<ApplicationGroups> applicationGroupsListOld = persistentGroups.getApplicationGroupsList();
            List<ApplicationGroups> applicationGroupsListNew = groups.getApplicationGroupsList();
            List<GroupAssignments> groupAssignmentsListOld = persistentGroups.getGroupAssignmentsList();
            List<GroupAssignments> groupAssignmentsListNew = groups.getGroupAssignmentsList();
            List<String> illegalOrphanMessages = null;
            for (ApplicationGroups applicationGroupsListOldApplicationGroups : applicationGroupsListOld) {
                if (!applicationGroupsListNew.contains(applicationGroupsListOldApplicationGroups)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ApplicationGroups " + applicationGroupsListOldApplicationGroups + " since its groupId field is not nullable.");
                }
            }
            for (GroupAssignments groupAssignmentsListOldGroupAssignments : groupAssignmentsListOld) {
                if (!groupAssignmentsListNew.contains(groupAssignmentsListOldGroupAssignments)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain GroupAssignments " + groupAssignmentsListOldGroupAssignments + " since its groupId field is not nullable.");
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
            groups.setApplicationGroupsList(applicationGroupsListNew);
            List<GroupAssignments> attachedGroupAssignmentsListNew = new ArrayList<GroupAssignments>();
            for (GroupAssignments groupAssignmentsListNewGroupAssignmentsToAttach : groupAssignmentsListNew) {
                groupAssignmentsListNewGroupAssignmentsToAttach = em.getReference(groupAssignmentsListNewGroupAssignmentsToAttach.getClass(), groupAssignmentsListNewGroupAssignmentsToAttach.getId());
                attachedGroupAssignmentsListNew.add(groupAssignmentsListNewGroupAssignmentsToAttach);
            }
            groupAssignmentsListNew = attachedGroupAssignmentsListNew;
            groups.setGroupAssignmentsList(groupAssignmentsListNew);
            groups = em.merge(groups);
            for (ApplicationGroups applicationGroupsListNewApplicationGroups : applicationGroupsListNew) {
                if (!applicationGroupsListOld.contains(applicationGroupsListNewApplicationGroups)) {
                    Groups oldGroupIdOfApplicationGroupsListNewApplicationGroups = applicationGroupsListNewApplicationGroups.getGroupId();
                    applicationGroupsListNewApplicationGroups.setGroupId(groups);
                    applicationGroupsListNewApplicationGroups = em.merge(applicationGroupsListNewApplicationGroups);
                    if (oldGroupIdOfApplicationGroupsListNewApplicationGroups != null && !oldGroupIdOfApplicationGroupsListNewApplicationGroups.equals(groups)) {
                        oldGroupIdOfApplicationGroupsListNewApplicationGroups.getApplicationGroupsList().remove(applicationGroupsListNewApplicationGroups);
                        oldGroupIdOfApplicationGroupsListNewApplicationGroups = em.merge(oldGroupIdOfApplicationGroupsListNewApplicationGroups);
                    }
                }
            }
            for (GroupAssignments groupAssignmentsListNewGroupAssignments : groupAssignmentsListNew) {
                if (!groupAssignmentsListOld.contains(groupAssignmentsListNewGroupAssignments)) {
                    Groups oldGroupIdOfGroupAssignmentsListNewGroupAssignments = groupAssignmentsListNewGroupAssignments.getGroupId();
                    groupAssignmentsListNewGroupAssignments.setGroupId(groups);
                    groupAssignmentsListNewGroupAssignments = em.merge(groupAssignmentsListNewGroupAssignments);
                    if (oldGroupIdOfGroupAssignmentsListNewGroupAssignments != null && !oldGroupIdOfGroupAssignmentsListNewGroupAssignments.equals(groups)) {
                        oldGroupIdOfGroupAssignmentsListNewGroupAssignments.getGroupAssignmentsList().remove(groupAssignmentsListNewGroupAssignments);
                        oldGroupIdOfGroupAssignmentsListNewGroupAssignments = em.merge(oldGroupIdOfGroupAssignmentsListNewGroupAssignments);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = groups.getId();
                if (findGroups(id) == null) {
                    throw new NonexistentEntityException("The groups with id " + id + " no longer exists.");
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
            Groups groups;
            try {
                groups = em.getReference(Groups.class, id);
                groups.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The groups with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ApplicationGroups> applicationGroupsListOrphanCheck = groups.getApplicationGroupsList();
            for (ApplicationGroups applicationGroupsListOrphanCheckApplicationGroups : applicationGroupsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Groups (" + groups + ") cannot be destroyed since the ApplicationGroups " + applicationGroupsListOrphanCheckApplicationGroups + " in its applicationGroupsList field has a non-nullable groupId field.");
            }
            List<GroupAssignments> groupAssignmentsListOrphanCheck = groups.getGroupAssignmentsList();
            for (GroupAssignments groupAssignmentsListOrphanCheckGroupAssignments : groupAssignmentsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Groups (" + groups + ") cannot be destroyed since the GroupAssignments " + groupAssignmentsListOrphanCheckGroupAssignments + " in its groupAssignmentsList field has a non-nullable groupId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(groups);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Groups> findGroupsEntities() {
        return findGroupsEntities(true, -1, -1);
    }

    public List<Groups> findGroupsEntities(int maxResults, int firstResult) {
        return findGroupsEntities(false, maxResults, firstResult);
    }

    private List<Groups> findGroupsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Groups.class));
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

    public Groups findGroups(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Groups.class, id);
        } finally {
            em.close();
        }
    }

    public int getGroupsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Groups> rt = cq.from(Groups.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
