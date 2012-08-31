package com.dhenton9000.jpa.spring.annotations.dao.impl;
 
import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Groups;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.spring.annotations.dao.GroupsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhenton9000.jpa.spring.annotations.dao.UsersDAO;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


/**
 *  http://blog.xebia.com/2009/03/23/jpa-implementation-patterns-saving-detached-entities/ 
 * @author dhenton
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-jpa-config.xml" })
public class UsersDaoTests {
    private static final String BOZO9000 = "aaa";
    private static final int HERO_COLOR_GROUP_ID = 4;
    private static Logger log = LogManager.getLogger(UsersDaoTests.class);
    
    @Autowired
    private ApplicationContext context;
    @Autowired
    private UsersDAO userDAO;
    @Autowired
    private GroupsDAO groupDAO;
    
    @Before
    public void beforeTest()
    {
        
    }
    
    @Test
    public void testAutoWire() throws Exception
    {
        assertNotNull(userDAO);
        assertNotNull(groupDAO);
    }
    
    @Test
    public void testGroups() throws Exception
    {
        Groups group = groupDAO.find(new Integer(5));
        assertEquals("HeroColor",group.getGroupName());
    }
    
    
    @Test
    public void testGettingUsers() throws Exception
    {
         Users testUser = userDAO.find("gaw");
         assertNotNull(testUser);
         assertEquals("George Wolefenstein",testUser.getUsername());
        
    }
    
    @Test
    public void testGettingGroupsForUsers() throws Exception
    {    
         Users testUser = userDAO.getHydratedUser("gaw");
         assertNotNull(testUser);
         assertNotNull(testUser.getGroupsSet());
         assertEquals(2,testUser.getGroupsSet().size());
         Groups g = testUser.getGroupsSet().iterator().next();
         assertEquals("PowerUsers",g.getGroupName());
         Set<Applications> apps = g.getApplicationsSet();
         assertNotNull(apps);
         assertEquals(29,apps.size());
 
         Set<Users> gUsers = g.getUsersSet();
         assertNotNull(gUsers);
         assertEquals(14,gUsers.size());
          
    }   
    
    @Test
    @Transactional 
     @Rollback(false)
    public void testWriteToDataBase() throws Exception
    {
        
        log.debug("start");
        UsersDAOImpl uD = (UsersDAOImpl) userDAO;
        Users user = new Users();
        user.setUserid(BOZO9000);
        user.setUsername("Bozo the clown");
        
 
        userDAO.persist(user);
//        Groups g2 = groupDAO.getHydratedGroup(new Integer(HERO_COLOR_GROUP_ID));
//        g2.getUsersSet().add(user);
//         
//        groupDAO.merge(g2);
            
        Users fUser = userDAO.find(BOZO9000);
        assertNotNull(fUser);
        assertEquals(BOZO9000,fUser.getUserid());
        
    }
    
}