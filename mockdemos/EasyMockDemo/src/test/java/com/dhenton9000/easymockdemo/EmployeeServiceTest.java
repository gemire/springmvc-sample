package com.dhenton9000.easymockdemo;

import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.*;
import static org.easymock.EasyMock.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



//https://sites.google.com/a/pintailconsultingllc.com/java/easymock-examples




/**
 * This class does some basic easy mock testing.
 * calling Easymock.expect says 'I expect this to be called' and can be
 * modified with the times() call to say how many times. If you expect
 * that it won't be called leave off the expect call
 * use verify on the end to check on the count of calls on the mock.
 * 
 * @author dhenton
 */
public class EmployeeServiceTest {

    public static final long DEPT_ID = 10L;
    public static final long EMPLOYEE_FRED = 45L;
    public static final long EMPLOYEE_TED = 415L;
    private static EmployeeDAO employeeDAOMock = null;
    private static EmployeeService employeeService = null;

    @BeforeClass
    public static void beforeClass() {
        employeeService = new EmployeeService();
    }

    @Before
    public void doBeforeEachTest() {
        employeeDAOMock = createMock(EmployeeDAO.class);
        employeeService.setEmployeeDAO(employeeDAOMock);
    }

    @Test
    public void mockTestFindsWhatIsSet() {
        Employee emp = new Employee("fred", EMPLOYEE_FRED, DEPT_ID);
        expect(employeeDAOMock.getEmployee(EMPLOYEE_FRED)).andReturn(emp);
        replay(employeeDAOMock);

        Employee t = employeeService.getEmployee(EMPLOYEE_FRED);
        assertEquals(emp, t);
       
        verify(employeeDAOMock);
    }

    /**
     * if you ask for something that isn't set up, Easymock pukes
     */
    @Test(expected = AssertionError.class)
    public void mockTestFindsWhatIsNotSet() {
        Employee emp = new Employee("fred", EMPLOYEE_FRED, DEPT_ID);
        expect(employeeDAOMock.getEmployee(EMPLOYEE_FRED)).andReturn(emp);
        replay(employeeDAOMock);
        employeeService.getEmployee(EMPLOYEE_FRED + 66L);
        verify(employeeDAOMock);

    }

    @Test
    public void showThatErrorReturnsNull() {
        assertNotNull(employeeService.getEmployeeDAO());
        expect(employeeDAOMock.getEmployee(EMPLOYEE_FRED)).andThrow(new RuntimeException("get a job"));
        replay(employeeDAOMock);
        Employee t = employeeService.getEmployee(EMPLOYEE_FRED);
        assertNull(t);
        verify(employeeDAOMock);

    }

    /** empty list returns null
     * 
     */
    @Test
    public void nonFunctionalList() {
        List<Employee> empList = new ArrayList<Employee>();
        expect(employeeDAOMock.getAllEmployeesForDept(DEPT_ID)).andReturn(empList);
        replay(employeeDAOMock);
        List<Employee> resultList = employeeService.getEmployeesForFunctionalDept(DEPT_ID);
        assertNull(resultList);
        verify(employeeDAOMock);

    }

    /**
     * two or more items in the list passes
     */
    @Test
    public void FunctionalListForTwo() {
        Employee emp = new Employee("fred", EMPLOYEE_FRED, DEPT_ID);
        Employee emp2 = new Employee("ted", EMPLOYEE_TED, DEPT_ID);
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(emp);
        empList.add(emp2);
        expect(employeeDAOMock.getAllEmployeesForDept(DEPT_ID)).andReturn(empList);
        replay(employeeDAOMock);
        List<Employee> resultList = employeeService.getEmployeesForFunctionalDept(DEPT_ID);
        assertEquals(2, resultList.size());
        verify(employeeDAOMock);

    }

    /**
     * if only one item is in the list, then return null as it
     * is considered non functional
     */
    @Test
    public void nonFunctionalListForOne() {
        Employee emp = new Employee("fred", EMPLOYEE_FRED, DEPT_ID);
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(emp);
        expect(employeeDAOMock.getAllEmployeesForDept(DEPT_ID)).andReturn(empList);
        replay(employeeDAOMock);
        List<Employee> resultList = employeeService.getEmployeesForFunctionalDept(DEPT_ID);
        assertNull(resultList);
        verify(employeeDAOMock);

    }
    
    /**
     * This says that the DAO void method save should be called once;
     */
    @Test
    public void testSave()
    {
       Employee emp = new Employee("fred", EMPLOYEE_FRED, DEPT_ID);
       employeeDAOMock.saveEmployee(emp);
       expectLastCall();
       replay(employeeDAOMock);
       employeeService.save(emp);
       verify(employeeDAOMock);
        
     
    }
    
    /**
     * this says I expect the void call twice, which is wrong
     */
      @Test(expected=AssertionError.class)
    public void testSaveWillFailOnTwice()
    {
       Employee emp = new Employee("fred", EMPLOYEE_FRED, DEPT_ID);
       employeeDAOMock.saveEmployee(emp);
       employeeDAOMock.saveEmployee(emp);
       expectLastCall();
       replay(employeeDAOMock);
       employeeService.save(emp);
       verify(employeeDAOMock);
        
     
    }
    
}