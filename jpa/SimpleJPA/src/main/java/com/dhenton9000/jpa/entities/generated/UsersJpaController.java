/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities.generated;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.entities.generated.exceptions.NonexistentEntityException;
import com.dhenton9000.jpa.entities.generated.exceptions.PreexistingEntityException;
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
public class UsersJpaController implements Serializable {

    public UsersJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Users users) throws PreexistingEntityException, Exception {
        if (users.getGroupsSet() == null) {
            users.setGroupsSet(new HashSet<Groups>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<Groups> attachedGroupsSet = new HashSet<Groups>();
            for (Groups groupsSetGroupsToAttach : users.getGroupsSet()) {
                groupsSetGroupsToAttach = em.getReference(groupsSetGroupsToAttach.getClass(), groupsSetGroupsToAttach.getId());
                attachedGroupsSet.add(groupsSetGroupsToAttach);
            }
            users.setGroupsSet(attachedGroupsSet);
            em.persist(users);
            for (Groups groupsSetGroups : users.getGroupsSet()) {
                groupsSetGroups.getUsersSet().add(users);
                groupsSetGroups = em.merge(groupsSetGroups);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsers(users.getUserid()) != null) {
                throw new PreexistingEntityException("Users " + users + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Users users) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users persistentUsers = em.find(Users.class, users.getUserid());
            Set<Groups> groupsSetOld = persistentUsers.getGroupsSet();
            Set<Groups> groupsSetNew = users.getGroupsSet();
            Set<Groups> attachedGroupsSetNew = new HashSet<Groups>();
            for (Groups groupsSetNewGroupsToAttach : groupsSetNew) {
                groupsSetNewGroupsToAttach = em.getReference(groupsSetNewGroupsToAttach.getClass(), groupsSetNewGroupsToAttach.getId());
                attachedGroupsSetNew.add(groupsSetNewGroupsToAttach);
            }
            groupsSetNew = attachedGroupsSetNew;
            users.setGroupsSet(groupsSetNew);
            users = em.merge(users);
            for (Groups groupsSetOldGroups : groupsSetOld) {
                if (!groupsSetNew.contains(groupsSetOldGroups)) {
                    groupsSetOldGroups.getUsersSet().remove(users);
                    groupsSetOldGroups = em.merge(groupsSetOldGroups);
                }
            }
            for (Groups groupsSetNewGroups : groupsSetNew) {
                if (!groupsSetOld.contains(groupsSetNewGroups)) {
                    groupsSetNewGroups.getUsersSet().add(users);
                    groupsSetNewGroups = em.merge(groupsSetNewGroups);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = users.getUserid();
                if (findUsers(id) == null) {
                    throw new NonexistentEntityException("The users with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users users;
            try {
                users = em.getReference(Users.class, id);
                users.getUserid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The users with id " + id + " no longer exists.", enfe);
            }
            Set<Groups> groupsSet = users.getGroupsSet();
            for (Groups groupsSetGroups : groupsSet) {
                groupsSetGroups.getUsersSet().remove(users);
                groupsSetGroups = em.merge(groupsSetGroups);
            }
            em.remove(users);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Users> findUsersEntities() {
        return findUsersEntities(true, -1, -1);
    }

    public List<Users> findUsersEntities(int maxResults, int firstResult) {
        return findUsersEntities(false, maxResults, firstResult);
    }

    private List<Users> findUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Users as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Users findUsers(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsersCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Users as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
