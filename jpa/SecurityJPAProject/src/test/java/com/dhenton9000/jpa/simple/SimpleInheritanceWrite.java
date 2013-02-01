/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.simple;

 
import com.dhenton9000.jpa.dao.support.SearchTemplate;
import com.dhenton9000.jpa.entities.inheritance.PersonAddress;
import com.dhenton9000.jpa.entities.inheritance.Student;
import com.dhenton9000.jpa.services.StudentService;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple demonstration of doing a transactional action this can only be 
 * run once as it actually commits to the database
 * @see{com.dhenton9000.jpa.services.UsersServiceImpl}
 * @author dhenton
 */
public class SimpleInheritanceWrite {
    
     private static final Logger logger = LoggerFactory.getLogger( SimpleInheritanceWrite.class);
     ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/inheritance-jpa-config.xml");
    public static void main(String[] args)
    {
        
        SimpleInheritanceWrite sw = new SimpleInheritanceWrite();
        try {
            sw.doWrite();
        } catch (Exception ex) {
          logger.error("problem ",ex);
        }
        
    }
    
    /**
     * note that the usersService must be the interface, not the concrete
     * implementation as it is proxied.
     * @throws Exception 
     */
   
    public void doWrite() throws Exception
    {
        StudentService  sService = (StudentService) context.getBean("studentService");
//        Users u = new Users();
//        u.setUserid("bozo");
//        u.setUsername("bozo K clown");
//        usersService.save(u);
        logger.debug("sService "+sService);
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
        
    //    sService.save(s);
        SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Students.findAll");
        List<Student> res = sService.find(new Student(), template);
        logger.debug(""+res.size());
        

    }
}
