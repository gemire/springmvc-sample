/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.webservice.cxf.sample;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
 

/**
 * This is a trust manager that will trust everything, used 
 * for testing
 * @author dhenton
 */
public class TrustAllManager implements X509TrustManager {

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return new X509Certificate[0];
	}

	@Override
	public void checkClientTrusted(@SuppressWarnings("unused") java.security.cert.X509Certificate[] certs, @SuppressWarnings("unused") String authType) {
	}

	@Override
	public void checkServerTrusted(@SuppressWarnings("unused") java.security.cert.X509Certificate[] certs, @SuppressWarnings("unused") String authType) {
	}
}