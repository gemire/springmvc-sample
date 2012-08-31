/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ftp.processing;

import java.io.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.mule.transport.file.FileConnector;
import org.apache.commons.io.FileUtils;

/**
 * This is the component that will fire when the message is sent to the
 * FileAnnouncementMonitor flow.
 *
 * @author dhenton
 */
public class MuleMoverComponent implements Callable {

    private static Logger log = LogManager.getLogger(MuleMoverComponent.class);
    private String destinationFolderLocation = null;

    /**
     * the payload is the fully qualified path to the file that was written down
     * after FTP With that information, and the destinationFolderLocation
     * property, it will write the file down to that location
     *
     * @param eventContext
     * @return
     * @throws Exception
     */
    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        
        File destFolderFile = new File(getDestinationFolderLocation());
        if (destFolderFile.canWrite() == false) {
            throw new RuntimeException("cannot write to folder '" + getDestinationFolderLocation() + "'");
        }

        
        String originalFileName = eventContext.getMessage().getProperty(FileConnector.PROPERTY_ORIGINAL_FILENAME, PropertyScope.INBOUND);
        if (originalFileName == null) {
            throw new RuntimeException("FileConnector.PROPERTY_ORIGINAL_FILENAME property must be set on the message");

        }

        String pathToFileToMove = (String) eventContext.getMessage().getPayload();
        log.debug("beginning moving file '"+pathToFileToMove+"' in "+this.getClass().getSimpleName());
        if (pathToFileToMove == null) {
            throw new RuntimeException("the file to move is not in the payload");
        }
        File fileToMove = new File(pathToFileToMove);
        if (fileToMove.canRead()) {
            moveFile(fileToMove, originalFileName);

        } else {
            throw new RuntimeException("cannot read file '" + pathToFileToMove + "' ");
        }
        log.debug("finished moving file '"+pathToFileToMove+"' in "+this.getClass().getSimpleName());
 
        return null;
    }

    private void moveFile(File fileToMove, String originalFileName) throws IOException {
        String filePathToWriteTo = getDestinationFolderLocation() + "/" + originalFileName;
        log.debug("moving file '"+fileToMove.getAbsolutePath()+"' to '"+filePathToWriteTo+"'");
        File fileToWriteTo = new File(filePathToWriteTo);
        FileUtils.moveFile(fileToMove, fileToWriteTo);

    }

    /**
     * @return the destinationFolderLocation
     */
    public String getDestinationFolderLocation() {
        return destinationFolderLocation;
    }

    /**
     * @param destinationFolderLocation the destinationFolderLocation to set
     */
    public void setDestinationFolderLocation(String destinationFolderLocation) {
        this.destinationFolderLocation = destinationFolderLocation;
    }
}
