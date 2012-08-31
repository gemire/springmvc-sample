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
@Table(name = "STUDENTS", catalog = "SANDBOX")
public class Students implements Serializable {
    
    @Column(name = "STUDENT_NAME")
    private String studentName;
    @Column(name = "STUDENT_GPA")
    private Float gpa;
    @Column(name = "EMAIL",nullable=false)
    private String email;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID")
    private Long studentId;
    
    /*
    @ManyToMany(
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        mappedBy = "attendingStudents",
        targetEntity = Classes.class
    )
    */
    
    @ManyToMany(cascade = {
		CascadeType.PERSIST, CascadeType.MERGE
	})
	@JoinTable(name = "CLASS_ASSIGNMENTS", catalog="SANDBOX", joinColumns = {
		@JoinColumn(name = "studentId")
	}, inverseJoinColumns = {
		@JoinColumn(name = "classId")
	})
    
    private Set<Classes> studentClasses = new HashSet<Classes>();
    
    
    public Students(Long s)
    {
        studentId = s;
    }
     
    public Students()
    {
        
    }

    public Students(String studentName, Float gpa, String email) {
        this.studentName = studentName;
        this.gpa = gpa;
        this.email = email;
    }
    
    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the studentId
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * @return the studentClasses
     */
    public Set<Classes> getStudentClasses() {
        return studentClasses;
    }

    /**
     * @param studentClasses the studentClasses to set
     */
    public void setStudentClasses(Set<Classes> studentClasses) {
        this.studentClasses = studentClasses;
    }

    /**
     * @return the gpa
     */
    public Float getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }
    
    
}
