package com.dhenton9000.jaxb.utils;
 

 
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="groups")
public class Groups implements java.io.Serializable {

    private int id;
    private String groupName = null;
    private ArrayList<Users> users =new ArrayList<>();

    public Groups() {
    }

    public Groups(Groups g) {
        this.id = g.getId();
        this.groupName = g.getGroupName();
        users.addAll(g.getUsers());

    }

    public Groups(Integer id, String name,ArrayList<Users> users ) {
        this.id = id;
        this.groupName = name;
        this.users.addAll(users);
 

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
    public ArrayList<Users> getUsers() {
        return users;
    }

    

     
}
