package com.dhenton9000.hibernatetest.marshal;
import com.dhenton9000.hibernatesecurity.Users;
import com.dhenton9000.hibernatetest.dataaccess.*;

import com.dhenton9000.hibernatesecurity.converters.ApplicationsConverter;
import com.dhenton9000.hibernatesecurity.converters.GroupsConverter;
import com.dhenton9000.hibernatesecurity.converters.UsersConverter;
import com.dhenton9000.hibernatesecurity.dao.ApplicationsDAO;
import com.dhenton9000.hibernatesecurity.dao.GroupsDAO;
import com.dhenton9000.hibernatesecurity.dao.UsersDAO;
import com.dhenton9000.jaxb.utils.MarshallUtil;
import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MarshalTestCase {

    private static Logger log = LogManager.getLogger(MarshalTestCase.class);
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

    

 

   //  @Test
    public void testfindGroupsMarshall() throws Exception
    {
       
        GroupsDAO gDAO = (GroupsDAO) ctx.getBean("groupsDAO");
        GroupsConverter k = gDAO.findGroupsWithUsersAndApplications(1);
        assertEquals(6,k.getApplications().size());
        assertEquals(20,k.getUsers().size());
                    
        
        String Obj2XML = MarshallUtil.Obj2XML(k);
        //log.debug("\n"+Obj2XML);
    }
     
   // @Test
    public void testfindApplicationsMarshall() throws Exception
    {
       
        ApplicationsDAO gDAO = (ApplicationsDAO) ctx.getBean("applicationsDAO");
        ApplicationsConverter k = gDAO.findApplicationsWithGroupsAndUsers(1);
         
                    
        
        String Obj2XML = MarshallUtil.Obj2XML(k);
       // log.debug("\n"+Obj2XML);
    }   
     
    @Test
    public void testfindUserMarshall() throws Exception
    {
       
        UsersDAO gDAO = (UsersDAO) ctx.getBean("usersDAO");
        Users k = gDAO.findById("gaw");
        log.debug("$$$$$$$$$$$$$$$$$$$$ "+k);
        UsersConverter kConvert = new UsersConverter(k);
         
                    
        
         String Obj2XML = MarshallUtil.Obj2XML(kConvert);
         log.debug("\n"+Obj2XML);
    }   
}///////////////////////////////////////////////////////////////////////
