/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.splitter.reporter.work;

/**
 *
 * @author dhenton
 */
public class WorkItem {
   private WORK_TYPE workType = null;
    private String workContents = null;
    

    public enum WORK_TYPE {ALPHA, BETA};
    
     
   public WorkItem(WORK_TYPE type, String message) {
        this.workType = type;
        this.workContents = message;
    }

   public WorkItem(){}
    /**
     * @return the workType
     */
    public WORK_TYPE getWorkType() {
        return workType;
    }

    /**
     * @param workType the workType to set
     */
    public void setWorkType(WORK_TYPE workType) {
        this.workType = workType;
    }

    /**
     * @return the workContents
     */
    public String getWorkContents() {
        return workContents;
    }

    /**
     * @param workContents the workContents to set
     */
    public void setWorkContents(String workContents) {
        this.workContents = workContents;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WorkItem other = (WorkItem) obj;
        if (this.workType != other.workType) {
            return false;
        }
        if ((this.workContents == null) ? (other.workContents != null) : !this.workContents.equals(other.workContents)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.workType != null ? this.workType.hashCode() : 0);
        hash = 83 * hash + (this.workContents != null ? this.workContents.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "WorkItem{" + "workType=" + workType + ", workContents=" + workContents + '}';
    }
   
    
}
