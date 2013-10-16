/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.rest.client;

import org.apache.http.client.HttpClient;


import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * see http://hc.apache.org/httpcomponents-client-ga/examples.html for ways to
 * do things besides the default client
 * http://spring.io/blog/2009/03/27/rest-in-spring-3-resttemplate
 * http://www.springbyexample.org/examples/contact-rest-services-client.html
 *
 * @author dhenton
 */
public class RestClientBase {

    private HttpClient httpClient;
    private RestTemplate restClient;

    public RestClientBase() {
        this.httpClient = HttpClients.custom()
                .setMaxConnPerRoute(20)
                .setMaxConnTotal(40).build();
        this.restClient = new RestTemplate(new NoOPClientRequestFactory(httpClient));
        restClient.setErrorHandler(new ErrorHandler());

    }

    private <T> T execute(final String url, final HttpMethod method, final RequestCallback requestCallback, final ResponseExtractor<T> responseExtractor, final Object... urlVariables)  {
        try {
            
            return getRestClient().execute(url, method, requestCallback, responseExtractor, urlVariables);
        } catch (RestClientException e) {
            Throwable cause = e.getMostSpecificCause();
            throw e;
        }
    }

    /**
     * @return the restClient
     */
    public RestTemplate getRestClient() {
        return restClient;
    }
}
