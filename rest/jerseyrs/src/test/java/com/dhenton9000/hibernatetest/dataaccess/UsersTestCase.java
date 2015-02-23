package com.dhenton9000.hibernatetest.dataaccess;

import com.dhenton9000.hibernatesecurity.Users;
import com.dhenton9000.hibernatesecurity.converters.UsersConverter;
import com.dhenton9000.hibernatesecurity.dao.UsersDAO;
import com.dhenton9000.jaxb.utils.MarshallUtil;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsersTestCase {

    private static Logger log = LogManager.getLogger(UsersTestCase.class);
    //private static TestDAO instance = null;
    private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("dataContext.xml");

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

    @Test(expected=javax.xml.bind.MarshalException.class)
   //this is an error because the default actions do not yield an object
   // with annotations
    public void testGetUser() throws Exception {

        UsersDAO uDAO = (UsersDAO) ctx.getBean("usersDAO");

        Users k = uDAO.findById("eas");
        assertNotNull(k);
        assertEquals("Liz Samuels", k.getUsername());
        //error here if XmlTransient not present
        String Obj2XML = MarshallUtil.Obj2XML(k);
        log.debug("\n" + Obj2XML);

    }

   
//test to see if you can add a completely empty object
 
    @Test(expected=org.hibernate.LazyInitializationException.class)
    public void testfindByIdFail() throws Exception
    {
        
        UsersDAO uDAO = (UsersDAO) ctx.getBean("usersDAO");
        Users k = uDAO.findById("gaw");
        List<Object> groupsList = Arrays.asList(k.getGroupAssignmentses().toArray());
        assertEquals(2,groupsList.size());
       
        
    }
    
    @Test
    public void testfindUserWithGroups() throws Exception
    {
        
        UsersDAO uDAO = (UsersDAO) ctx.getBean("usersDAO");
        UsersConverter k = uDAO.findUserWithGroups("gaw");
        assertEquals(2,k.getGroups().size());
        assertEquals(0,k.getApplications().size());
       
        
    }
 
     @Test
    public void testfindUserWithGroupsAndApplications() throws Exception
    {
        
        UsersDAO uDAO = (UsersDAO) ctx.getBean("usersDAO");
        UsersConverter k = uDAO.findUserWithGroupsAndApplications("gaw");
        assertEquals(2,k.getGroups().size());
        assertEquals(31,k.getApplications().size());
       
        
    }
  
}///////////////////////////////////////////////////////////////////////
