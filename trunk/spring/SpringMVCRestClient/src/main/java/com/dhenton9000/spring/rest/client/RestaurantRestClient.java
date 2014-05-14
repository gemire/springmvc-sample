package com.dhenton9000.spring.rest.client;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.rest.IRestRestaurantService;
import com.dhenton9000.spring.rest.controllers.RestResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

@SuppressWarnings("deprecation")
public class RestaurantRestClient implements IRestRestaurantService {

    private final HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
    //protected RestTemplate restClient = new RestTemplate(new HeaderAdderRequestFactory(httpClient));
    private final RestTemplate restClient = new RestTemplate(new CommonsClientHttpRequestFactory(httpClient));
    private final static Logger logger = LoggerFactory.getLogger(RestaurantRestClient.class);
    private final String urlStub;

    public RestaurantRestClient(String urlStub) {
        httpClient.getHttpConnectionManager().getParams().setMaxTotalConnections(10);
        httpClient.getHttpConnectionManager().getParams().setMaxConnectionsPerHost(httpClient.getHostConfiguration(), 10);
        restClient.setErrorHandler(new MyErrorHandler());
        this.urlStub = urlStub;
        MappingJacksonHttpMessageConverter converter = new 
                MappingJacksonHttpMessageConverter();
        List<HttpMessageConverter<?>> converters = new ArrayList<>() ;
        converters.add(converter);
        restClient.setMessageConverters(converters);
        //http://localhost:8888/app/backbone/restaurant/
    }

    @Override
    public RestResult addRestaurant(Restaurant restaurant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RestResult saveRestaurant(Restaurant restaurant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Restaurant getRestaurant(String restaurantId) {
        
        String url = this.urlStub+"/"+restaurantId;
        Restaurant  restaurant = restClient.getForObject(url,Restaurant.class);
        return restaurant;
    }

    @Override
    public RestResult deleteRestaurant(String restaurantId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Restaurant> getRestaurantsWithMaxRating(int r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Restaurant> getRestaurantsLike(String searchString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        public void handleError(ClientHttpResponse response) throws IOException {
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

    
    
    public static void main(String[] args)
    {
        logger.debug("get a job");
        RestaurantRestClient r = new RestaurantRestClient("http://localhost:8888/app/backbone/restaurant");
        //r.getRestaurant("5919770603945984");
        r.getRestaurant("3");
    }
    
}
