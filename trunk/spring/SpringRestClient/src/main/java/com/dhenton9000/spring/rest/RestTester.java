/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.rest;

import com.dhenton9000.rest.model.Restaurant;
import com.dhenton9000.spring.rest.client.RestClientBase;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

/**
 *
 * @author dhenton
 */
public class RestTester extends RestClientBase {

    private static final Logger logger = LoggerFactory.getLogger(RestTester.class);

    private void doTest() {
        logger.debug("get a job");
        MappingJacksonHttpMessageConverter aa = new MappingJacksonHttpMessageConverter();
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(aa);
        this.getRestClient().setMessageConverters(converters);
        Restaurant t = this.getRestClient().getForObject("http://donhenton.appspot.com/app/rest/restaurant/get/{id}", Restaurant.class, "5479141319114752");
        logger.debug("\n" + t);
    }

    public static void main(String[] args) {

        RestTester rt = new RestTester();
        rt.doTest();

    }
}
