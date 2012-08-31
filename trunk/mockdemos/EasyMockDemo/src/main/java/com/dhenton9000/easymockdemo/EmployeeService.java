/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.easymockdemo;

import java.util.List;

/**
 *
 * @author Don
 */
public class EmployeeService {

    private EmployeeDAO employeeDAO = null;

    Employee getEmployee(long employeeId) {
        Employee eM = null;
        try {
            eM = employeeDAO.getEmployee(employeeId);
        } catch (Exception err) {
        }
        return eM;
    }

    List<Employee> getEmployeesForFunctionalDept(long deptId) {
         List<Employee> employeeList =  
                 employeeDAO.getAllEmployeesForDept(deptId); 
        if (employeeList != null && employeeList.size() > 1)
        {
            return employeeList;
        }
        return null;
    }
    
    Employee save(Employee t)
    {
        if (t != null)
        {
            employeeDAO.saveEmployee(t);
        }
        
        return t;
    }
            

    /**
     * @return the employeeDAO
     */
    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    /**
     * @param employeeDAO the employeeDAO to set
     */
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
