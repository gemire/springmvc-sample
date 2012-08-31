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
public interface EmployeeDAO {
    
    Employee getEmployee(long employeeId);
    List<Employee> getAllEmployeesForDept(long deptId);
    void saveEmployee(Employee item);
}
