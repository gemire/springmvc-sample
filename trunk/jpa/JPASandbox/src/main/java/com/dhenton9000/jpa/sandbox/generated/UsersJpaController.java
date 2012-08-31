/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.sandbox.generated;

import com.dhenton9000.jpa.sandbox.generated.exceptions.IllegalOrphanException;
import com.dhenton9000.jpa.sandbox.generated.exceptions.NonexistentEntityException;
import com.dhenton9000.jpa.sandbox.generated.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Don
 */
public class UsersJpaController implements Serializable {

    public UsersJpaController(EntityManagerFactory emf) {
        
        this.emf = emf;
    }
  
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Users users) throws PreexistingEntityException, Exception {
        if (users.getGroupAssignmentsList() == null) {
            users.setGroupAssignmentsList(new ArrayList<GroupAssignments>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<GroupAssignments> attachedGroupAssignmentsList = new ArrayList<GroupAssignments>();
            for (GroupAssignments groupAssignmentsListGroupAssignmentsToAttach : users.getGroupAssignmentsList()) {
                groupAssignmentsListGroupAssignmentsToAttach = em.getReference(groupAssignmentsListGroupAssignmentsToAttach.getClass(), groupAssignmentsListGroupAssignmentsToAttach.getId());
                attachedGroupAssignmentsList.add(groupAssignmentsListGroupAssignmentsToAttach);
            }
            users.setGroupAssignmentsList(attachedGroupAssignmentsList);
            em.persist(users);
            for (GroupAssignments groupAssignmentsListGroupAssignments : users.getGroupAssignmentsList()) {
                Users oldUserIdOfGroupAssignmentsListGroupAssignments = groupAssignmentsListGroupAssignments.getUserId();
                groupAssignmentsListGroupAssignments.setUserId(users);
                groupAssignmentsListGroupAssignments = em.merge(groupAssignmentsListGroupAssignments);
                if (oldUserIdOfGroupAssignmentsListGroupAssignments != null) {
                    oldUserIdOfGroupAssignmentsListGroupAssignments.getGroupAssignmentsList().remove(groupAssignmentsListGroupAssignments);
                    oldUserIdOfGroupAssignmentsListGroupAssignments = em.merge(oldUserIdOfGroupAssignmentsListGroupAssignments);
                }
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

    public void edit(Users users) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users persistentUsers = em.find(Users.class, users.getUserid());
            List<GroupAssignments> groupAssignmentsListOld = persistentUsers.getGroupAssignmentsList();
            List<GroupAssignments> groupAssignmentsListNew = users.getGroupAssignmentsList();
            List<String> illegalOrphanMessages = null;
            for (GroupAssignments groupAssignmentsListOldGroupAssignments : groupAssignmentsListOld) {
                if (!groupAssignmentsListNew.contains(groupAssignmentsListOldGroupAssignments)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain GroupAssignments " + groupAssignmentsListOldGroupAssignments + " since its userId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<GroupAssignments> attachedGroupAssignmentsListNew = new ArrayList<GroupAssignments>();
            for (GroupAssignments groupAssignmentsListNewGroupAssignmentsToAttach : groupAssignmentsListNew) {
                groupAssignmentsListNewGroupAssignmentsToAttach = em.getReference(groupAssignmentsListNewGroupAssignmentsToAttach.getClass(), groupAssignmentsListNewGroupAssignmentsToAttach.getId());
                attachedGroupAssignmentsListNew.add(groupAssignmentsListNewGroupAssignmentsToAttach);
            }
            groupAssignmentsListNew = attachedGroupAssignmentsListNew;
            users.setGroupAssignmentsList(groupAssignmentsListNew);
            users = em.merge(users);
            for (GroupAssignments groupAssignmentsListNewGroupAssignments : groupAssignmentsListNew) {
                if (!groupAssignmentsListOld.contains(groupAssignmentsListNewGroupAssignments)) {
                    Users oldUserIdOfGroupAssignmentsListNewGroupAssignments = groupAssignmentsListNewGroupAssignments.getUserId();
                    groupAssignmentsListNewGroupAssignments.setUserId(users);
                    groupAssignmentsListNewGroupAssignments = em.merge(groupAssignmentsListNewGroupAssignments);
                    if (oldUserIdOfGroupAssignmentsListNewGroupAssignments != null && !oldUserIdOfGroupAssignmentsListNewGroupAssignments.equals(users)) {
                        oldUserIdOfGroupAssignmentsListNewGroupAssignments.getGroupAssignmentsList().remove(groupAssignmentsListNewGroupAssignments);
                        oldUserIdOfGroupAssignmentsListNewGroupAssignments = em.merge(oldUserIdOfGroupAssignmentsListNewGroupAssignments);
                    }
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

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<GroupAssignments> groupAssignmentsListOrphanCheck = users.getGroupAssignmentsList();
            for (GroupAssignments groupAssignmentsListOrphanCheckGroupAssignments : groupAssignmentsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Users (" + users + ") cannot be destroyed since the GroupAssignments " + groupAssignmentsListOrphanCheckGroupAssignments + " in its groupAssignmentsList field has a non-nullable userId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
           Query q = em.createQuery("from Users");
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
