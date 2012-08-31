package com.dhenton9000.hibernatesecurity.converters;
// Generated Jun 17, 2010 4:41:51 PM by Hibernate Tools 3.2.1.GA

import com.dhenton9000.hibernatesecurity.ApplicationGroups;
import com.dhenton9000.hibernatesecurity.Applications;
import com.dhenton9000.hibernatesecurity.GroupAssignments;
import com.dhenton9000.hibernatesecurity.Groups;
import com.dhenton9000.hibernatesecurity.Users;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="groups")
public class GroupsConverter implements java.io.Serializable {

    private int id;
    private String groupName = null;
    private ArrayList<UsersConverter> users = new ArrayList<UsersConverter>();
    private boolean fullyHydrated = false;
    private ArrayList<ApplicationsConverter> applications = new ArrayList<ApplicationsConverter>();

    public GroupsConverter() {
    }

    public GroupsConverter(Groups g) {
        this.id = g.getId();
        this.groupName = g.getGroupName();

    }

    public GroupsConverter(Integer id, String name, Set appGroups, Set groupAssign) {
        this.id = id;
        this.groupName = name;


        List<Object> gasList = Arrays.asList(groupAssign.toArray());
        for (Object aa : gasList) {
            GroupAssignments aGrp = (GroupAssignments) aa;
            Users a = (Users) aGrp.getUsers();
            UsersConverter ac = new UsersConverter(a);
            users.add(ac);
        }

        List<Object> appsList = Arrays.asList(appGroups.toArray());
        for (Object aa : appsList) {
            ApplicationGroups aGrp = (ApplicationGroups) aa;
            Applications a = (Applications) aGrp.getApplications();
            ApplicationsConverter ac = new ApplicationsConverter(a);
            applications.add(ac);
        }



    }// end constructor
    @XmlElement(name="groupId")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return the users
     */
     
    @XmlElementWrapper(name = "users")
    @XmlElement(name = "user")     
    public ArrayList<UsersConverter> getUsers() {
        return users;
    }

    /**
     * @return the fullyHydrated
     */
    @XmlTransient
    public boolean isFullyHydrated() {
        return fullyHydrated;
    }

    /**
     * @param fullyHydrated the fullyHydrated to set
     */
    public void setFullyHydrated(boolean fullyHydrated) {
        this.fullyHydrated = fullyHydrated;
    }

    /**
     * @return the applications
     */
    @XmlElementWrapper(name = "applications")
    @XmlElement(name = "application")
   public ArrayList<ApplicationsConverter> getApplications() {
        return applications;
    }
}
