/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.dao.tests.inheritance;

import com.dhenton9000.jpa.dao.ApplicationsDAO;
import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.dao.tests.ApplicationsTest;
import com.dhenton9000.jpa.entities.inheritance.PersonAddress;
import com.dhenton9000.jpa.entities.inheritance.Professional;
import com.dhenton9000.jpa.entities.inheritance.Student;
import com.dhenton9000.jpa.services.ApplicationsService;
import com.dhenton9000.jpa.services.ProfessionalService;
import com.dhenton9000.jpa.services.StudentService;
import com.dhenton9000.jpa.util.ValueGenerator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

/**
 *
 * @author dhenton
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:inheritance-jpa-config.xml"})
@Transactional
public class InheritanceTests {

    private static final Logger logger = LoggerFactory.getLogger(InheritanceTests.class);
    @PersistenceContext()
    private EntityManager entityManager;
    @Autowired
    StudentService studentService;
    @Autowired
    ProfessionalService professionalService;

    @Before
    public void onSetUp() throws Exception {
        //reset generator
    }

    @Test
    public void testInject() {
        assertNotNull(professionalService);
    }

    @Test
    public void testSaveStudent() {

        Student s = new Student();
        s.setCreated(new Date());
        s.setFirstName("Fred");
        s.setLastName("Farkel");
        s.setSchoolName("Communist Martyrs High School");
        Set<PersonAddress> pAddress = new HashSet<PersonAddress>();
        PersonAddress p = new PersonAddress();
        p.setAddress("120 N Fred St");
        p.setCity("Blasting Cap");
        p.setState("CO");
        p.setZipPostal("33333");
        p.setCountry("USA");
        p.setCreated(new Date());
        pAddress.add(p);
        s.setPersonAddresses(pAddress);

        studentService.save(s);

        entityManager.flush();
        entityManager.clear();
        SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Students.findAll");
        List<Student> res = studentService.find(new Student(), template);
        assertEquals(1, res.size());
        assertEquals("Farkel", res.get(0).getLastName());


    }

    @Test
    public void testSaveStudentAndProfessional() {

        Student s = new Student();
        s.setCreated(new Date());
        s.setFirstName("Ted");
        s.setLastName("Thompson");
        s.setSchoolName("Communist Martyrs High School");
        Set<PersonAddress> pAddress = new HashSet<PersonAddress>();
        PersonAddress p = new PersonAddress();
        p.setAddress("120 N Fred St");
        p.setCity("Blasting Cap");
        p.setState("CO");
        p.setZipPostal("33333");
        p.setCountry("USA");
        p.setCreated(new Date());
        pAddress.add(p);
        s.setPersonAddresses(pAddress);

        studentService.save(s);

        /// now the professional
        
        
        Professional pp = new Professional();
        pp.setCreated(new Date());
        pp.setFirstName("Bozo");
        pp.setLastName("Clown");
        pp.setCompanyName("American BigBucks");
        pAddress.clear();
        pAddress = new HashSet<PersonAddress>();
        p = new PersonAddress();
        p.setAddress("100 N South St");
        p.setCity("Backbite");
        p.setState("NJ");
        p.setZipPostal("020202");
        p.setCountry("USA");
        p.setCreated(new Date());
        pAddress.add(p);
        pp.setPersonAddresses(pAddress);
        
        professionalService.save(pp);
        
        entityManager.flush();
        entityManager.clear();
        SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Students.findAll");
        List<Student> res = studentService.find(new Student(), template);
        assertEquals(1, res.size());
        assertEquals("Thompson", res.get(0).getLastName());

        template = new SearchTemplate();
        template.setNamedQuery("Professional.findAll");
        List<Professional> resP = professionalService.find(new Professional(), template);
        assertEquals(1, resP.size());
        assertEquals("Clown", resP.get(0).getLastName());
    }
}
