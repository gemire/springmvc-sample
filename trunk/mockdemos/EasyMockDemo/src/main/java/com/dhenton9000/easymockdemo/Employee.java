/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.easymockdemo;

/**
 *
 * @author Don
 */
public class Employee {

    private String name = null;
    private long employeeId = 0L;
    private long deptId = 0L;

    public Employee(String name, long id,long dept) {
        this.name = name;
        this.employeeId = id;
        this.deptId = dept;
    }

    public Employee() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the employeeId
     */
    public long getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", employeeId=" + employeeId + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.employeeId != other.employeeId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 59 * hash + (int) (this.employeeId ^ (this.employeeId >>> 32));
        return hash;
    }

    /**
     * @return the deptId
     */
    public long getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }
}
