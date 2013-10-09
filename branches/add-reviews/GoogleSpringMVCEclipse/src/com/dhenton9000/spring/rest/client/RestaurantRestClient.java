package com.dhenton9000.spring.rest.client;

import java.io.IOException;
import java.net.URI;
import java.util.List;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.io.IOUtils;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.rest.IRestRestaurantService;
import com.dhenton9000.spring.rest.controllers.RestResult;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@SuppressWarnings("deprecation")
public class RestaurantRestClient implements IRestRestaurantService {

	//protected HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
	//protected RestTemplate restClient = new RestTemplate(new HeaderAdderRequestFactory(httpClient));
	protected RestTemplate restClient = null;
	
	public RestaurantRestClient()
	{
		//httpClient.getHttpConnectionManager().getParams().setMaxTotalConnections(size * 2);
		//httpClient.getHttpConnectionManager().getParams().setMaxConnectionsPerHost(httpClient.getHostConfiguration(), size);

		restClient.setErrorHandler(new MyErrorHandler());

	}
	
	
	
	@Override
	public RestResult addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult saveRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getRestaurant(String restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult deleteRestaurant(String restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	protected class HeaderAdderRequestFactory extends CommonsClientHttpRequestFactory {
//
//		public HeaderAdderRequestFactory(HttpClient httpClient) {
//			super(httpClient);
//		}
//
//		@Override
//		public ClientHttpRequest createRequest(URI uri, HttpMethod method) throws IOException {
//			final ClientHttpRequest request = super.createRequest(uri, method);
//			try {
//				request.getHeaders().set("HEADER1","ONE");
//			} catch (Exception e) {
//				 
//			}
//
//			return request;
//		}
//	}

	public class MyErrorHandler extends DefaultResponseErrorHandler {

 

		//create a JSON deserializer for the response.getBody();

		@Override
		public void handleError(ClientHttpResponse response) throws   IOException {
			HttpStatus statusCode = response.getStatusCode();
			// response.getStatusText()
			switch (statusCode.series()) {
				case CLIENT_ERROR:
					throw new HttpClientErrorException(statusCode, response.getStatusText());
				case SERVER_ERROR:
					// read IOUtils.toString(response.getBody())
					//	throw new HttpServerErrorException(statusCode, response.getStatusText());
				 
				 
				default:
					throw new RestClientException("Unknown status code [" + statusCode + "]");
			}
		}
	}


}
