package com.dhenton9000.hibernatetest.dataaccess;

import com.dhenton9000.hibernatesecurity.converters.ApplicationsConverter;
import com.dhenton9000.hibernatesecurity.dao.ApplicationsDAO;
import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationsTestCase {

    private static Logger log = LogManager.getLogger(ApplicationsTestCase.class);
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

    

 
    
    @Test
    public void testfindApplicationsWithGroups() throws Exception
    {
        
        ApplicationsDAO uDAO = (ApplicationsDAO) ctx.getBean("applicationsDAO");
        ApplicationsConverter k = uDAO.findApplicationsWithGroups(4);
        assertEquals(2,k.getGroups().size());
        assertEquals(0,k.getUsers().size());
       
        
    }
 
     @Test
    public void testfindApplicationsWithGroupsAndUsers() throws Exception
    {
        
        ApplicationsDAO uDAO = (ApplicationsDAO) ctx.getBean("applicationsDAO");
        ApplicationsConverter k = uDAO.findApplicationsWithGroupsAndUsers(4);
        assertEquals(2,k.getGroups().size());
        assertEquals(31,k.getUsers().size());
       
        
    }
  
}///////////////////////////////////////////////////////////////////////
