package com.dhenton9000.hibernatetest.dataaccess;

import com.dhenton9000.hibernatesecurity.converters.ApplicationsConverter;
import com.dhenton9000.hibernatesecurity.converters.GroupsConverter;
import com.dhenton9000.hibernatesecurity.dao.ApplicationsDAO;
import com.dhenton9000.hibernatesecurity.dao.GroupsDAO;
import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GroupsTestCase {

    private static Logger log = LogManager.getLogger(GroupsTestCase.class);
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
    public void testfindApplicationsWithGroupsAndUsers() throws Exception
    {
        
        GroupsDAO gDAO = (GroupsDAO) ctx.getBean("groupsDAO");
        GroupsConverter k = gDAO.findGroupsWithUsersAndApplications(1);
        assertEquals(6,k.getApplications().size());
        assertEquals(20,k.getUsers().size());
       
        
    }
  
}///////////////////////////////////////////////////////////////////////
