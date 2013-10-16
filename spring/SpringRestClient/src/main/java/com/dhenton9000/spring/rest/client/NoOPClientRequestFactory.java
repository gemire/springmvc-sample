/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.rest.client;

import java.io.IOException;
import java.net.URI;
 
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.apache.http.client.HttpClient;
/**
 *
 * @author dhenton
 */
public class NoOPClientRequestFactory extends HttpComponentsClientHttpRequestFactory {

    public NoOPClientRequestFactory(HttpClient httpClient) {
        super(httpClient);
    }

    @Override
    public ClientHttpRequest createRequest(URI uri, HttpMethod method) throws IOException {
        final ClientHttpRequest request = super.createRequest(uri, method);
        try {
            // request.getHeaders().set("headerKey", "headerValue");
        } catch (Exception e) {
        }

        return request;
    }
}
