/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernate.join.inheritance.dao;

 
import com.dhenton9000.hibernate.join.mapping.demo.jointable.Students;
import com.dhenton9000.spring.dao.GenericDAOSpringImpl;

/**
 *
 * @author Don
 */
public class StudentsDAOImpl extends 
        GenericDAOSpringImpl<Students,Long> implements StudentsDAO {
    
}
