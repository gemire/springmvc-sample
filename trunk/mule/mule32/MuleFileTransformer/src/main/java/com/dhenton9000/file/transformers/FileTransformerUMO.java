/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.file.transformers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import org.apache.commons.io.FileUtils;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class will handle taking the input stream from mule and will pass the
 * individual line item to a series of transformers, which will be injected via
 * Spring. This transformer assumes that the file is a csv or some other
 * delimited item.
 *
 * @author dhenton
 */
public class FileTransformerUMO implements Callable {

  
    private final Logger logger = LoggerFactory.getLogger(FileTransformerUMO.class);
    private String fileOutputLocation = "";
    private IFileBufferTransformer transformer = null;
    private String fileMoveToLocation = "";
    private boolean moveTo = false;

    /**
     * @return the fileOutputLocation
     */
    public String getFileOutputLocation() {
        if (fileOutputLocation == null) {
            throw new RuntimeException("fileOutputLocation must be set");
        }
        return fileOutputLocation;
    }

    /**
     * @param fileOutputLocation the fileOutputLocation to set
     */
    public void setFileOutputLocation(String fileOutputLocation) {
        this.fileOutputLocation = fileOutputLocation;
    }

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        FileInputStream fstream = (FileInputStream) eventContext.getMessage().getPayload();
        String originalFileName = eventContext.getMessage().getProperty("originalFileName",
                PropertyScope.INBOUND);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader buffInput = new BufferedReader(new InputStreamReader(in)); 
        final File fileOut = new File(getFileOutputLocation());
        FileOutputStream fout = new FileOutputStream(fileOut);
        
        transformer.processFileBuffer(buffInput,fout);
        fout.close();
        if (moveTo)
        {
             FileUtils.moveFile(fileOut, 
                     new File( getFileMoveToLocation()+originalFileName+"_1"));
        }



        return null;
    }

    /**
     * @return the transformer
     */
    public IFileBufferTransformer getTransformer() {
           if (transformer == null) {
            throw new RuntimeException("transformer must be set");
        }

        return transformer;
    }

    /**
     * @param transformer the transformer to set
     */
    public void setTransformer(IFileBufferTransformer transformer) {
        this.transformer = transformer;
    }

    /**
     * @return the fileMoveToLocation this is where the file will
     * be moved to if moveTo is true it is a folder
     */
    public String getFileMoveToLocation() {
        return fileMoveToLocation;
    }

    /**
     * @param fileMoveToLocation the fileMoveToLocation to set
     */
    public void setFileMoveToLocation(String fileMoveToLocation) {
        this.fileMoveToLocation = fileMoveToLocation;
    }

    /**
     * @return the moveTo
     */
    public boolean isMoveTo() {
        return moveTo;
    }

    /**
     * @param moveTo the moveTo to set
     */
    public void setMoveTo(boolean moveTo) {
        this.moveTo = moveTo;
    }

   
   
}
