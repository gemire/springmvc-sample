/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernate.join.inheritance.dao;



import com.dhenton9000.hibernate.join.inheritance.PersonalComputer;
import com.dhenton9000.hibernate.join.inheritance.Switch;
import com.dhenton9000.hibernate.join.mapping.demo.jointable.Classes;
import com.dhenton9000.hibernate.join.mapping.demo.jointable.Students;
import java.util.HashSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-config.xml"})
@TransactionConfiguration(defaultRollback = true)
public class TestDAO {

    private static Logger log = LoggerFactory.getLogger(TestDAO.class);
  
    
    @Autowired
    private PersonalComputerDAO pDAO;
    
    @Autowired
    private SwitchDAO sDAO;
    
    @Autowired
    private StudentsDAO studentsDAO;
    
    @Autowired
    private ClassesDAO classesDAO;
    

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    
    @Test
    @Transactional
    public void testManyToManyJoins() throws Exception
    {
       
        Students st = new Students("John Smith",3.4f,"jsmith@gmail.com");
        HashSet<Classes> cS = new HashSet<Classes>();
        cS.add(new Classes("English 101",25) );
        cS.add(new Classes("History 35",25) );
        st.setStudentClasses(cS);
        studentsDAO.merge(st);
        List<Classes> cList = classesDAO.findAll();
        assertEquals(2,cList.size());
        Classes k = cList.iterator().next();
        assertNotNull(k);
        Long iK = k.getClassId();
        assertTrue(iK > 0L);
       
         
    }
    
    
    
    
    
     
    @Transactional
    public void basicDAOTest() throws Exception {
     /*
       
        PersonalComputer asset = null;
        Switch switchItem = null;
        asset = new PersonalComputer();
        asset.setAssetDescription("this is marys computer");
        asset.setEmployeeName("mary");
        asset.setIpAddress("192.168.1.2");
        asset.setMemory(5);
        tDAO.saveOrUpdate(asset);

        switchItem = new Switch();
        switchItem.setManufacturerName("Cisco");
        switchItem.setAssetDescription("cisco switch 100");
        switchItem.setSwitchType("multiplex");
        switchItem.setIpAddress("192.168.100.1");
        sDAO.saveOrUpdate(switchItem);

        assertNotNull(tDAO);
        asset = new PersonalComputer();
        asset.setAssetDescription("this is johns computer");
        asset.setEmployeeName("john");
        asset.setIpAddress("192.168.1.1");
        asset.setMemory(35);
        tDAO.saveOrUpdate(asset);
        
        Switch s = sDAO.findById(3);
        s.setAssetDescription("a switch somewhere");
        s.setSwitchIdentifier("switch 4500");
        sDAO.saveOrUpdate(s);
*/

    }
    
    
    //@Transactional
    public void testSwitch()
    {
        // run this and look at the debug output to see how
        // the inheritance effects the sql
        Switch s = sDAO.findById(3);
        PersonalComputer p = pDAO.findById(2);
    }
    
    
    
    
}///////////////////////////////////////////////////////////////////////
