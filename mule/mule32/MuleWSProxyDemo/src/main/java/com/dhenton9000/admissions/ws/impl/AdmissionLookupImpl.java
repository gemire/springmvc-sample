/**
 * Please modify this class to meet your needs This class is not complete
 */
package com.dhenton9000.admissions.ws.impl;

import com.dhenton9000.admissions.components.ws.AdmissionType;
import com.dhenton9000.admissions.components.ws.AdmitSubject;
import com.dhenton9000.admissions.components.ws.AdmitSubjectLookup;
import org.slf4j.Logger;
import com.dhenton9000.admissions.components.ws.AdmitSubjectResponse;
import com.dhenton9000.admissions.components.ws.BillType;
import com.dhenton9000.admissions.components.ws.CareType;
import com.dhenton9000.admissions.components.ws.EpisodeType;
import java.util.Calendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;


public class AdmissionLookupImpl implements Callable
{
    private static final Logger logger = LoggerFactory.getLogger(AdmissionLookupImpl.class.getName());

    @Override
    public Object onCall(MuleEventContext context) throws Exception {
        
        
        Object z = context.getMessage().getPayload();
        logger.debug("class is "+z.getClass().getName());
        logger.debug("\n============\n"+z.toString()+"\n===============\n");
        
        AdmitSubjectResponse _return = new AdmitSubjectResponse();
        String clientId = "fred";
        logger.debug("client id is "+clientId);
        BillType billItem = new BillType();
        billItem.setCostPerNight("29.95");
        billItem.setRunningTotal("99.99");
        billItem.setInitialStayEstimate("10");
        billItem.setStatus("Pending");
         
        EpisodeType episode = new EpisodeType();
        episode.setAdmission(AdmissionType.ELECTIVE);
        episode.setCare(CareType.PUBLIC);
        Calendar c = Calendar.getInstance();
        c.set(2012, Calendar.OCTOBER, 10);
        episode.setStartDate(c);
        Calendar c2 = Calendar.getInstance();
        c2.set(2012, Calendar.OCTOBER, 20);
        episode.setEndDate(c2);
        episode.setPatientId("2343434");
        episode.setEpisodeId("episode id");
          
        _return.setBill(billItem);
        _return.setInsuranceCaseNumber("client id: "+clientId);
      //  _return.setInsuranceCoverStatus("cover status");
        _return.setEpisode(episode);
        return createAckResponse(_return);
    }
    
     private static Document createAckResponse(AdmitSubjectResponse o) throws ParserConfigurationException, JAXBException {

        Document doc = null;
        DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = docBuild.newDocument();
        JAXBContext context = JAXBContext.newInstance(AdmitSubjectResponse.class);
        context.createMarshaller().marshal(o, doc);
        return doc;
    }
    
}