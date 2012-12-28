
package com.dhenton9000.hibernatesecurity.dao;

import com.dhenton9000.hibernatesecurity.ApplicationGroups;
import com.dhenton9000.hibernatesecurity.Applications;
import com.dhenton9000.hibernatesecurity.GroupAssignments;
import com.dhenton9000.hibernatesecurity.Groups;
import com.dhenton9000.hibernatesecurity.Users;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

/**
 *
 * @author dyh
 */
public class SecurityDAOTest {

    private static Logger log = LogManager.getLogger(SecurityDAOTest.class);
    private static SecurityDAO instance = null;
    //~--- constructors ---------------------------------------------------------

    /**
     * Constructs ... TODO
     *
     */
    public SecurityDAOTest() {
    }

    //~--- methods --------------------------------------------------------------
    /**
     * Method description TODO
     *
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass()
            throws Exception {

        instance = SecurityDAO.getInstance();

    }

    /**
     * Method description TODO
     *
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass()
            throws Exception {
    }

    /**
     * Method description TODO
     *
     */
    @Before
    public void setUp() {
    }

    /**
     * Method description TODO
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class SecurityDAO.
     */
    @Test
    public void testFind() throws DataAccessLayerException {
        Integer id = new Integer(2);

        Applications result = (Applications) instance.find(Applications.class, id);
        String t = result.getApplicationName();
        assertEquals("Colors", t);


    }

    @Test(expected = org.hibernate.LazyInitializationException.class)
    public void testLazyLoadFail() throws Exception {
        Integer id = new Integer(2);

        Applications result = (Applications) instance.find(Applications.class, id);
        //this call results in a lazy load initialization exception
        Set s = result.getApplicationGroupses();
        assertEquals(5, s.size());


    }

    @Test
    public void testCountForApplications() throws Exception {

        List t = instance.findAll(Applications.class);
        assertNotNull(t);
        assertEquals(57, t.size());
    }

    @Test
    public void testGetPageOfDataForClass() throws Exception {

        int pageSize = 5;
        Page page = instance.getPageOfDataForClass(Users.class, 0, pageSize);
        assertNotNull(page);
        assertTrue(page.isNextPage());
        Users u = (Users) page.getList().get(0);
        assertEquals("alb", u.getUserId());
        assertEquals(pageSize, page.getList().size());
        page = instance.getPageOfDataForClass(Users.class, 1, pageSize);
        u = (Users) page.getList().get(0);
        assertTrue(page.isNextPage());
        assertEquals("brw", u.getUserId());
        page = instance.getPageOfDataForClass(Users.class, 8, pageSize);

        assertFalse(page.isNextPage());

    }

    @Test
    public void testQuery() throws Exception {
        String query = "from ApplicationGroups where id=1";

        List myList = instance.getDataForQuery(query);
        assertEquals(1, myList.size());
        ApplicationGroups aG = (ApplicationGroups) myList.get(0);
        assertEquals(26, aG.getApplications().getId());

    }

    /**
     * Test of findAll method, of class SecurityDAO.
     */
    @Test
    public void testFindAll() throws DataAccessLayerException {


        Class clazz = Groups.class;

        List result = instance.findAll(clazz);
        Groups a = (Groups) result.get(0);
        assertEquals("BrandEdit", a.getGroupName());
        assertEquals(10, result.size());
    }

    @Test
    public void testCountForClass() throws Exception {
        Class clazz = Groups.class;

        long t = instance.getCountForClass(clazz);
        assertEquals(10, t);
    }

    @Test
    public void testCatchDelete() {
        boolean gotit = false;
        try {
            String query = "from Applications where id='2'";

            List myList = instance.getDataForQuery(query);
            assertEquals(1, myList.size());
            Applications aG = (Applications) myList.get(0);
            assertEquals("Colors", aG.getApplicationName());
            instance.delete(aG);
        } catch (DataAccessLayerException err) {
            gotit = true;
        }

        assertTrue(gotit);

    }

//    @Test
//    public void testGroupsForApps() throws Exception {
//
//
//        List t = instance.getGroupsForApplication(new Integer(2));
//        Groups a = (Groups) t.get(0);   pri   private GroupAssignments createSampleGroupAssignment(SecurityDAO instance)
//            throws DataAccessLayerException {
//        GroupAssignments aG = new GroupAssignments();
//        Users u = (Users) instance.find(Users.class, "gaw");
//        Groups gg = (Groups) instance.find(Groups.class, new Integer(2));
//        aG.setUsers(u);
//        aG.setGroups(gg);
//        instance.saveOrUpdate(aG);
//        return aG;
//    }
// private GroupAssignments createSampleGroupAssignment(SecurityDAO instance)
//            throws DataAccessLayerException {
//        GroupAssignments aG = new GroupAssignments();
//        Users u = (Users) instance.find(Users.class, "gaw");
//        Groups gg = (Groups) instance.find(Groups.class, new Integer(2));
//        aG.setUsers(u);
//        aG.setGroups(gg);
//        instance.saveOrUpdate(aG);
//        return aG;
//    }

//        assertEquals(2, t.size());
//        assertEquals(6, a.getId());
//        assertEquals("BrandUsers", a.getGroupName());
//    }

    @Test
    public void testAvailableGroupsForApps() throws Exception {

        List t = instance.getAvailableGroupsForApplication(new Integer(2));
        Groups a = (Groups) t.get(0);
        assertEquals(8, t.size());
        assertEquals(2000, a.getId());
        assertEquals("Admins", a.getGroupName());
    }

   // @Test
//    public void testAutoKeyGeneration() throws Exception {
//
//        ApplicationGroups aG = createSam   private GroupAssignments createSampleGroupAssignment(SecurityDAO instance)
//            throws DataAccessLayerException {
//        GroupAssignments aG = new GroupAssignments();
//        Users u = (Users) instance.find(Users.class, "gaw");
//        Groups gg = (Groups) instance.find(Groups.class, new Integer(2));
//        aG.setUsers(u);
//        aG.setGroups(gg);
//        instance.saveOrUpdate(aG);
//        return aG;
//    }
// pleAppGroup(instance);
//        int idnew = aG.getId();
//        log.debug("idnew is " + idnew);
//        assertTrue(idnew > 160);
//        
//        ApplicationGroups z = instance.deleteApplicationGroup(2, 7);
//
//
//    }

//    private ApplicationGroups createSampleAppGroup(SecurityDAO instance)
//            throws DataAccessLayerException {
//        ApplicationGroups aG = new ApplicationGroups();
//        Applications aa = (Applications) instance.find(Applications.class, new Integer(2));
//        Groups gg = (Groups) instance.find(Groups.class, new Integer(7));
//        aG.setApplications(aa);
//        aG.setGroups(gg);
//        instance.saveOrUpdate(aG);
//        
//   //     instance.delete(aG);
//        
//        
//        return aG;
//    }

//   private GroupAssignments createSampleGroupAssignment(SecurityDAO instance)
//            throws DataAccessLayerException {
//        GroupAssignments aG = new GroupAssignments();
//        Users u = (Users) instance.find(Users.class, "gaw");
//        Groups gg = (Groups) instance.find(Groups.class, new Integer(2));
//        aG.setUsers(u);
//        aG.setGroups(gg);
//        instance.saveOrUpdate(aG);
//        return aG;
//    }

//    @Test
//    public void testDeleteGroupAssignByKeys() throws Exception {
//
//        GroupAssignments aG =  createSampleGroupAssignment(instance);
//        GroupAssignments z = instance.deleteGroupAssignment(2, "gaw");
//        assertNotNull(z);
//        assertEquals(aG.getId(), z.getId());
//
//    }


//    @Test
//    public void testDeleteAppGroupsByKeys() throws Exception {
//
//        ApplicationGroups aG = createSampleAppGroup(instance);
//        assertNotNull(aG);
//        ApplicationGroups z = instance.deleteApplicationGroup(2, 7);
//        assertEquals(aG.getId(), z.getId());
//
//    }

//    @Test
//    public void testErrorOnDuplicateSave() throws Exception {
//
//        String tMessage = "Could not save, duplicate key";
//        Applications aa = (Applications) instance.find(Applications.class, new Integer(2));
//        boolean gotit = false;
//        String eMessage = "";
//        try {
//            instance.save(aa);
//        } catch (DataAccessLayerException ee) {
//            gotit = true;
//            eMessage = ee.getMessage();
//        }
//        assertTrue(gotit);
//        assertEquals(tMessage, eMessage);
//    }


    @Test
    public void testUsersForGroups() throws Exception
    {
        List t = instance.getUsersForGroups(new Integer(5));
        Users a = (Users) t.get(1);
        assertEquals(5, t.size());
        assertEquals("cmb", a.getUserId());

 
    }


   @Test
    public void testAvailableUsersForGroups() throws Exception
    {
        List t = instance.getAvailableUsersForGroups(new Integer(5));
        Users a = (Users) t.get(1);
        assertEquals(37, t.size());
       assertEquals("ale", a.getUserId());


    }
   



    /*
     *
     *  evict and contain remove from the session cache,
     *  but don't do anything else can be used to improve
     *  performance
     * 
    Session session =factory.openSession();
    Event firstEvent =(Event)session.load(Event.class,myEventId);
    //...perform some operation on firstEvent
    if (session.contains(firstEvent)){
    session.evict(firstEvent);
    }
    Event secondEvent =new Event();
    secondEvent.setId(myEventId);
    session.save(secondEvent);
  @Test
//    public void testDeleteGroupAssignByKeys() throws Exception {
//
//        GroupAssignments aG =  createSampleGroupAssignment(instance);
//        GroupAssignments z = instance.deleteGroupAssignment(2, "gaw");
//        assertNotNull(z);
//        assertEquals(aG.getId(), z.getId());
//
//    }

    The session is not thread safe so synchronize if
    necessary
     * 
     *
     *
     */
}
