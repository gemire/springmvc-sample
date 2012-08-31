/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities.generated;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import com.dhenton9000.jpa.entities.Users;
import java.util.HashSet;
import java.util.Set;
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.entities.generated.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
        if (groups.getUsersSet() == null) {
            groups.setUsersSet(new HashSet<Users>());
        }
        if (groups.getApplicationsSet() == null) {
            groups.setApplicationsSet(new HashSet<Applications>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<Users> attachedUsersSet = new HashSet<Users>();
            for (Users usersSetUsersToAttach : groups.getUsersSet()) {
                usersSetUsersToAttach = em.getReference(usersSetUsersToAttach.getClass(), usersSetUsersToAttach.getUserid());
                attachedUsersSet.add(usersSetUsersToAttach);
            }
            groups.setUsersSet(attachedUsersSet);
            Set<Applications> attachedApplicationsSet = new HashSet<Applications>();
            for (Applications applicationsSetApplicationsToAttach : groups.getApplicationsSet()) {
                applicationsSetApplicationsToAttach = em.getReference(applicationsSetApplicationsToAttach.getClass(), applicationsSetApplicationsToAttach.getId());
                attachedApplicationsSet.add(applicationsSetApplicationsToAttach);
            }
            groups.setApplicationsSet(attachedApplicationsSet);
            em.persist(groups);
            for (Users usersSetUsers : groups.getUsersSet()) {
                usersSetUsers.getGroupsSet().add(groups);
                usersSetUsers = em.merge(usersSetUsers);
            }
            for (Applications applicationsSetApplications : groups.getApplicationsSet()) {
                applicationsSetApplications.getGroupsSet().add(groups);
                applicationsSetApplications = em.merge(applicationsSetApplications);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Groups groups) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Groups persistentGroups = em.find(Groups.class, groups.getId());
            Set<Users> usersSetOld = persistentGroups.getUsersSet();
            Set<Users> usersSetNew = groups.getUsersSet();
            Set<Applications> applicationsSetOld = persistentGroups.getApplicationsSet();
            Set<Applications> applicationsSetNew = groups.getApplicationsSet();
            Set<Users> attachedUsersSetNew = new HashSet<Users>();
            for (Users usersSetNewUsersToAttach : usersSetNew) {
                usersSetNewUsersToAttach = em.getReference(usersSetNewUsersToAttach.getClass(), usersSetNewUsersToAttach.getUserid());
                attachedUsersSetNew.add(usersSetNewUsersToAttach);
            }
            usersSetNew = attachedUsersSetNew;
            groups.setUsersSet(usersSetNew);
            Set<Applications> attachedApplicationsSetNew = new HashSet<Applications>();
            for (Applications applicationsSetNewApplicationsToAttach : applicationsSetNew) {
                applicationsSetNewApplicationsToAttach = em.getReference(applicationsSetNewApplicationsToAttach.getClass(), applicationsSetNewApplicationsToAttach.getId());
                attachedApplicationsSetNew.add(applicationsSetNewApplicationsToAttach);
            }
            applicationsSetNew = attachedApplicationsSetNew;
            groups.setApplicationsSet(applicationsSetNew);
            groups = em.merge(groups);
            for (Users usersSetOldUsers : usersSetOld) {
                if (!usersSetNew.contains(usersSetOldUsers)) {
                    usersSetOldUsers.getGroupsSet().remove(groups);
                    usersSetOldUsers = em.merge(usersSetOldUsers);
                }
            }
            for (Users usersSetNewUsers : usersSetNew) {
                if (!usersSetOld.contains(usersSetNewUsers)) {
                    usersSetNewUsers.getGroupsSet().add(groups);
                    usersSetNewUsers = em.merge(usersSetNewUsers);
                }
            }
            for (Applications applicationsSetOldApplications : applicationsSetOld) {
                if (!applicationsSetNew.contains(applicationsSetOldApplications)) {
                    applicationsSetOldApplications.getGroupsSet().remove(groups);
                    applicationsSetOldApplications = em.merge(applicationsSetOldApplications);
                }
            }
            for (Applications applicationsSetNewApplications : applicationsSetNew) {
                if (!applicationsSetOld.contains(applicationsSetNewApplications)) {
                    applicationsSetNewApplications.getGroupsSet().add(groups);
                    applicationsSetNewApplications = em.merge(applicationsSetNewApplications);
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

    public void destroy(Integer id) throws NonexistentEntityException {
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
            Set<Users> usersSet = groups.getUsersSet();
            for (Users usersSetUsers : usersSet) {
                usersSetUsers.getGroupsSet().remove(groups);
                usersSetUsers = em.merge(usersSetUsers);
            }
            Set<Applications> applicationsSet = groups.getApplicationsSet();
            for (Applications applicationsSetApplications : applicationsSet) {
                applicationsSetApplications.getGroupsSet().remove(groups);
                applicationsSetApplications = em.merge(applicationsSetApplications);
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
            Query q = em.createQuery("select object(o) from Groups as o");
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
            Query q = em.createQuery("select count(o) from Groups as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
