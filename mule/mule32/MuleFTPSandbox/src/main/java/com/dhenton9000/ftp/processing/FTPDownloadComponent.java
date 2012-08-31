package com.dhenton9000.ftp.processing;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.mule.transport.file.FileConnector;

/**
 * This class receives the FTP stream in the flow ftpProcessFlow 
 * <ol> 
 * <li>write down the stream to fullFileDest</li>
 * <li>compose mule message with payload as path (payload is fullFileDest)</li>
 * <li>add properties to the mule message such as originalFileName</li>
 * </ol>
 * 
 *
 * @author dhenton
 */
public class FTPDownloadComponent implements Callable {

    private static Logger log = LogManager.getLogger(FTPDownloadComponent.class);
    //this is the folder that is used to store the downloaded results from FTP
    private String transferFolderLocation = null;
    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "SUCCESS";
    public static final String FILE_TRANSFER_STATUS_PROPERTY = "FILE_TRANSFER_STATUS";
    public static final String FTP_DOWNLOAD_TASK_NAME_PROPERTY = "FTP_DOWNLOAD_TASK_NAME";

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {

        Object o = eventContext.getMessage().getPayload();

//        Set<String> inboundSet = eventContext.getMessage().getPropertyNames(PropertyScope.INBOUND);
//        
//        Iterator<String> iS = inboundSet.iterator();
//        while (iS.hasNext())
//        {
//            String key = iS.next();
//            Object prop = eventContext.getMessage().getProperty(key, PropertyScope.INBOUND);
//            log.debug("inbound "+key+"--> "+prop.toString());
//        }
//        
//        Set<String> outboundSet = eventContext.getMessage().getPropertyNames(PropertyScope.OUTBOUND);
//        
//        iS = outboundSet.iterator();
//        while (iS.hasNext())
//        {
//            String key = iS.next();
//            Object prop = eventContext.getMessage().getProperty(key, PropertyScope.OUTBOUND);
//            log.debug("outbound "+key+"--> "+prop.toString());
//        }

        if (transferFolderLocation == null) {
            throw new RuntimeException("You must set the transferFileLocation!");
        }
        if ((o instanceof InputStream) == false) {
            throw new RuntimeException("Expecting input stream but got " + o.getClass().getName());
        }

       String ftpDownloadTaskName = eventContext.getMessage().
                getProperty(FTP_DOWNLOAD_TASK_NAME_PROPERTY, PropertyScope.OUTBOUND);
       
        String fileName = null;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
        String dateTimeStamp = sdf.format(d);
        String originalFileName = eventContext.getMessage().
                getProperty("originalFileName", PropertyScope.OUTBOUND);
        String[] fItems = originalFileName.split("\\.");
        fileName = fItems[0] + "_" + dateTimeStamp + "." + fItems[1];
        // this is the full file name and path that the ftp 
        // contents will be written too
        String fullFileDest = getTransferFolderLocation() + "/" + fileName;
        String fileTransferStatus = FAIL;
        log.debug("beginning ftp download to '"+fullFileDest+"' for task "+ftpDownloadTaskName);
        File transferFolderFile = new File(getTransferFolderLocation());
        if (transferFolderFile.canWrite() == false) {
            throw new RuntimeException("Cannot write to '" + getTransferFolderLocation() + "'");

        }

        try {

            File fullFileDestFile = new File(fullFileDest);
            InputStream inputStream = (InputStream) o;
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(fullFileDestFile);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            inputStream.close();
            out.flush();
            out.close();
            // got here so we are successful else FAIL
            fileTransferStatus = SUCCESS;
            log.debug("finished ftp download for '"+fullFileDest+"' for task "+ftpDownloadTaskName);
        } catch (Exception iErr) {
            log.error("File writing problem\n" + iErr.getClass().getName()
                    + "\n" + iErr.getMessage());
        }


        DefaultMuleMessage dM = new DefaultMuleMessage(fullFileDest, eventContext.getMuleContext());
        // this can be set in the flow with a message-properties-transformer
         if (ftpDownloadTaskName != null) {
            dM.setProperty(FTP_DOWNLOAD_TASK_NAME_PROPERTY, ftpDownloadTaskName, PropertyScope.OUTBOUND);
        }
        // use to route if there was a problem don't move on
        dM.setProperty(FILE_TRANSFER_STATUS_PROPERTY, fileTransferStatus, PropertyScope.OUTBOUND);
        dM.setProperty(FileConnector.PROPERTY_ORIGINAL_FILENAME, originalFileName, PropertyScope.OUTBOUND);
        return dM;
    }

    /**
     * @return the transferFolderLocation
     */
    public String getTransferFolderLocation() {
        return transferFolderLocation;
    }

    /**
     * @param transferFolderLocation the transferFolderLocation to set
     */
    public void setTransferFolderLocation(String transferFolderLocation) {
        this.transferFolderLocation = transferFolderLocation;
    }
}
