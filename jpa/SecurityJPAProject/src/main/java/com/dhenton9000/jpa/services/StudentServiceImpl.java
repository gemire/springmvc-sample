/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.services;

import com.dhenton9000.jpa.dao.StudentDAO;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.entities.inheritance.Student;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is a sample service class. The @Transactional attribute is responsible
 * for committing the transaction.
 *
 * @author dhenton
 */
@Service
public class StudentServiceImpl extends GenericEntityServiceImpl<Student, Integer> implements StudentService {

    protected StudentDAO studentDAO;

    @Autowired
    public void setStudentDao(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    
  

    @Override
    public Student getNew() {
        return new Student();
    }

    @Override
    public Student getNewWithDefaults() {
        return getNew();
    }
 
    @Override
    public GenericDao<Student, Integer> getDao() {
        return   studentDAO;
    }

    
}
