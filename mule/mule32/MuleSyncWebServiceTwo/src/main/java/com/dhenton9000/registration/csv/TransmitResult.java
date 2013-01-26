/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

/**
 * The result of a transmission
 * @author dhenton
 */
public class TransmitResult {
    
    private boolean successful = true;
    private String message = null;
    private long lineNumber = -1L;
    private String lineContents = null;
    private String fileName = null;
    private String processingType = null;

    /**
     * @return the successful
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * @param successful the successful to set
     */
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

   
    /**
     * @return the lineNumber
     */
    public long getLineNumber() {
        return lineNumber;
    }

    /**
     * @param lineNumber the lineNumber to set
     */
    public void setLineNumber(long lineNumber) {
        this.lineNumber = lineNumber;
    }
    
    /**
     * convert a string array to a CSV line
     * @param contents
     * @return contents separated by ","
     */
    public static String convertArrayToCSVLine(String[] contents)
    {
        String info = "";
        for (String t: contents)
        {
            info += t+",";
        }
        info = info.substring(0,info.length()-1);
        
        return info;
    }

    /**
     * @return the lineContents
     */
    public String getLineContents() {
        return lineContents;
    }

    /**
     * @param lineContents the lineContents to set
     */
    public void setLineContents(String lineContents) {
        this.lineContents = lineContents;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "TransmitResult{" + "successful=" + successful + ", message=" + message + ", lineNumber=" + lineNumber + ", fileName=" + fileName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.lineNumber ^ (this.lineNumber >>> 32));
        hash = 29 * hash + (this.fileName != null ? this.fileName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransmitResult other = (TransmitResult) obj;
        if (this.lineNumber != other.lineNumber) {
            return false;
        }
        if ((this.fileName == null) ? (other.fileName != null) : !this.fileName.equals(other.fileName)) {
            return false;
        }
        return true;
    }

    /**
     * @return the processingType
     */
    public String getProcessingType() {
        return processingType;
    }

    /**
     * @param processingType the processingType to set
     */
    public void setProcessingType(String processingType) {
        this.processingType = processingType;
    }

    
    
}
