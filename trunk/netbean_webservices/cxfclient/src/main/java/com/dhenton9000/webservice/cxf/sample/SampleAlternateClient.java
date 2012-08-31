/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.webservice.cxf.sample;

/**
 * <p>This code shows how to set username, password and https 
 * processing on a cxf client. In the football case there is no
 * need for this. This is for demonstration purposes only</p>
 * 
 * 
 * @author dhenton
 */

 




 

import com.dhenton9000.football.generated.ArrayOfString;
import com.dhenton9000.football.generated.Info;
import com.dhenton9000.football.generated.InfoSoapType;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.log4j.*;


public class SampleAlternateClient {
     

	private static Logger  log =  LogManager.getLogger(SampleAlternateClient.class);
   
	private InfoSoapType port;

	public SampleAlternateClient(String url, String username, String password) {
		port = getConfiguredPort(url, username, password);
	}

	private InfoSoapType getConfiguredPort(String url, String username, String password) {

		port = new Info().getInfoSoap();
		BindingProvider bindingPort = (BindingProvider) port;
		// set the properties on the Port this is auth
                // not needed for this example
//		Map<String, Object> requestContext = bindingPort.getRequestContext();
//		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
//		requestContext.put(BindingProvider.USERNAME_PROPERTY, username);
//		requestContext.put(BindingProvider.PASSWORD_PROPERTY, password);
		Client client = ClientProxy.getClient(bindingPort);

		HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

		// Only bother if this is an HTTPS url

		if (url.startsWith("https:")) {
			TLSClientParameters tlsParams = new TLSClientParameters();
			tlsParams.setSecureSocketProtocol("SSL");
			httpConduit.setTlsClientParameters(tlsParams);
			tlsParams.setDisableCNCheck(true);
			TrustAllManager[] tam = {
				new TrustAllManager()
			};
			tlsParams.setTrustManagers(tam);
		}

		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		httpClientPolicy.setAllowChunking(false);
		httpConduit.setClient(httpClientPolicy);

		return port;
	}

	public InfoSoapType getPort() {
		return port;
	}

	public static void main(String[] args) throws Exception {

		String url = "http://footballpool.dataaccess.eu/data/info.wso";
		String username = "user";
		String password = "password";
		SampleAlternateClient client = new SampleAlternateClient(url, username, password);
                ArrayOfString res = client.getPort().cities();
                log.debug(res.getString().size());
		// failed auth will throw an error containing something about unknown character 'A'

	}
}

