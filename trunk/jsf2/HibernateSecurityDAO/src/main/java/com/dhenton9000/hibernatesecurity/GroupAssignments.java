package com.dhenton9000.hibernatesecurity;
// Generated Jun 17, 2010 4:41:51 PM by Hibernate Tools 3.2.1.GA






/**
 * GroupAssignments generated by hbm2java
 */
public class GroupAssignments  implements java.io.Serializable {


     private int id;
     private Groups groups;
     private Users users;

    public GroupAssignments() {
    }

    public GroupAssignments(int id, Groups groups, Users users) {
       this.id = id;
       this.groups = groups;
       this.users = users;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Groups getGroups() {
        return this.groups;
    }
    
    public void setGroups(Groups groups) {
        this.groups = groups;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GroupAssignments other = (GroupAssignments) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        return hash;
    }



    public String toString()
    {
        String info = "";

        info = "Assignment -- User: "+ this.getUsers().getUserId() +
                " Group: "+this.getGroups().getGroupName();

        return info;
    }


}

