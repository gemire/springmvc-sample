/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.rest.client.extractors;


import com.dhenton9000.spring.rest.client.ErrorClass;
import com.dhenton9000.spring.rest.client.results.GenericResultObject;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;

/**
 *
 * @author dhenton
 * @param <E> the wrapper class
 * @param <T> the underlying return value of Interest
 */
public class GenericExtractor<T,E extends GenericResultObject<T>> implements ResponseExtractor<E>{

    private final Class<T> deserializedModelClass;
    private final Class<E> deserializedResultClass;
    private final ObjectMapper mapper = new ObjectMapper();
    private final static Logger logger = LoggerFactory.getLogger(GenericExtractor.class);
    
    public GenericExtractor(Class<T> deserializedModelClass,Class<E> deserializedResultClass)
    {
        this.deserializedResultClass =  deserializedResultClass;
        this.deserializedModelClass =  deserializedModelClass;
    }        
            
    
    
    @Override
    public E extractData(ClientHttpResponse response) throws IOException {
 
        E data =  null;
        try {
            data = (E) this.deserializedResultClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            final String info = "Could not create an instance of "
                    +this.deserializedResultClass.getName();
            logger.error(info);
            throw new RuntimeException(info);
        }
        
        String body = null;
            try {
                //try to get the real thing
                body = IOUtils.toString(response.getBody());
              T r = mapper.readValue(body, this.deserializedModelClass);
              data.setPayload(r);
                
            } catch (UnrecognizedPropertyException uE) {
                logger.info("### " + body);
                ErrorClass r = mapper.readValue(body, ErrorClass.class);
                data.setError(r);

            } catch (Exception err) {
                String info = "extract Data general problem: "
                        + err.getClass().getName() + " " + err.getMessage();
               // logger.error(info);
                ErrorClass r = mapper.readValue(body, ErrorClass.class);
                data.setError(r);
                 
            }
        return data;
    }
    
}
