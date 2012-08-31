/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.security;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.mule.transport.http.HttpConstants;

/**
 *
 * @author Don
 */
public class HttpTestUtils {

    public static int NOT_SET = -99;

    public static int doGet(String realm,
            String host,
            String user,
            String pass,
            String url,
            boolean handshake) throws Exception {
        HttpClient client = new HttpClient();
        int status = NOT_SET;
        client.getParams().setAuthenticationPreemptive(true);
        client.getState().setCredentials(new AuthScope(host, -1, realm),
                new UsernamePasswordCredentials(user, pass));
        GetMethod get = new GetMethod(url);
        get.setDoAuthentication(handshake);

        try {
            status = client.executeMethod(get);
            if (status == HttpConstants.SC_UNAUTHORIZED && handshake == true) {
                // doAuthentication = true means that if the request returns 401,
                // the HttpClient will resend the request with credentials
                status = client.executeMethod(get);
            }

        } finally {
            get.releaseConnection();
        }
        return status;
    }

    private int doPost(String realm,
            String host,
            String user,
            String pass,
            String url,
            boolean handshake, String soapRequest, String mimeType, String encoding) throws Exception {
        HttpClient client = new HttpClient();
        client.getParams().setAuthenticationPreemptive(true);
        client.getState().setCredentials(new AuthScope(host, -1, realm),
                new UsernamePasswordCredentials(user, pass));
        int status = NOT_SET;
        PostMethod post = new PostMethod(url);
        post.setDoAuthentication(handshake);
        StringRequestEntity requestEntity = new StringRequestEntity(soapRequest, mimeType, encoding);
        post.setRequestEntity(requestEntity);
        try {
            status = client.executeMethod(post);
            if (status == HttpConstants.SC_UNAUTHORIZED && handshake == true) {
                // doAuthentication = true means that if the request returns 401,
                // the HttpClient will resend the request with credentials
                status = client.executeMethod(post);
            }

        } finally {
            post.releaseConnection();
        }
        return status;
    }
}
