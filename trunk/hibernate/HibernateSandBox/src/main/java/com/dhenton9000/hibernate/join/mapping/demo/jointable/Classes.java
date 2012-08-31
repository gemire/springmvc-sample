/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernate.join.mapping.demo.jointable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name = "CLASSES", catalog = "SANDBOX")
public class Classes implements Serializable {
    @Column(name = "CLASS_NAME")
    private String nameOfClass;
    @Column(name = "SEATING_CAPACITY")
    private int seatingCapacity;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLASS_ID")
    private Long classId;
    
    @ManyToMany(cascade = {
		CascadeType.PERSIST, CascadeType.MERGE
	})
	@JoinTable(name = "CLASS_ASSIGNMENTS", catalog="SANDBOX", joinColumns = {
		@JoinColumn(name = "classId")
	}, inverseJoinColumns = {
		@JoinColumn(name = "studentId")
	})
    private Set<Students> attendingStudents = new HashSet<Students>();

    public Classes()
    {
        
    }
    
    public Classes(Long id)
    {
        classId = id;
    }

    public Classes(String nameOfClass, int seatingCapacity) {
        this.nameOfClass = nameOfClass;
        this.seatingCapacity = seatingCapacity;
    }
    
    
    /**
     * @return the nameOfClass
     */
    public String getNameOfClass() {
        return nameOfClass;
    }

    /**
     * @param nameOfClass the nameOfClass to set
     */
    public void setNameOfClass(String nameOfClass) {
        this.nameOfClass = nameOfClass;
    }

    /**
     * @return the seatingCapacity
     */
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    /**
     * @param seatingCapacity the seatingCapacity to set
     */
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    /**
     * @return the classId
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * @return the attendingStudents
     */
    public Set<Students> getAttendingStudents() {
        return attendingStudents;
    }

    /**
     * @param attendingStudents the attendingStudents to set
     */
    public void setAttendingStudents(Set<Students> attendingStudents) {
        this.attendingStudents = attendingStudents;
    }

   
}
