package com.dhenton9000.spring.rest.client;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.rest.IRestRestaurantService;
import com.dhenton9000.spring.rest.controllers.RestResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;

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
        //     List<HttpMessageConverter<?>> converters = new ArrayList<>();
        //    converters.add(converter);
        //     restClient.setMessageConverters(converters);
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

        String url = this.urlStub + "/" + restaurantId;
        // Restaurant restaurant = restClient.getForObject(url, Restaurant.class);
          RestaurantExtractor extractor = new RestaurantExtractor( RestaurantResultObject.class);
          RestaurantResultObject restaurantResult = restClient.execute(url, HttpMethod.GET, null, extractor);
          if (restaurantResult.getError() != null)
          {
              throw new RuntimeException("Error: "+restaurantResult.getError().getMessage());
          }
         return restaurantResult.getPayload();
        
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

     
    private class RestaurantExtractor implements ResponseExtractor<RestaurantResultObject> {

        private final Class<RestaurantResultObject> deserializedModelClass;

        private final ObjectMapper mapper = new ObjectMapper();

        public RestaurantExtractor(
                Class<RestaurantResultObject> deserializedModelClass) {

            this.deserializedModelClass = deserializedModelClass;

        }

        @Override
        public RestaurantResultObject extractData(ClientHttpResponse response) throws IOException {
            RestaurantResultObject data = new RestaurantResultObject();
            String body = null;
            try {
                //try to get the real thing
                body = IOUtils.toString(response.getBody());
                Restaurant r = mapper.readValue(body, Restaurant.class);
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
                    //IOUtils.toString(response.getBody());
                    // throw new HttpClientErrorException(statusCode, response.getStatusText());
                    break;
                case SERVER_ERROR:
                // read IOUtils.toString(response.getBody())
                //	throw new HttpServerErrorException(statusCode, response.getStatusText());

                default:
                    throw new RestClientException("Unknown status code [" + statusCode + "]");
            }
        }
    }

    public static void main(String[] args) {
        logger.debug("get a job");
        RestaurantRestClient rClient = new RestaurantRestClient("http://localhost:8888/app/backbone/restaurant");
        //Restaurant rr = rClient.getRestaurant("5919770603945984");
        Restaurant rr = rClient.getRestaurant("3");
        if (rr == null) {
            logger.debug("returned restaurant null");
        } else {
            logger.debug("got restaurant " + rr.getName());
        }
        //r.getRestaurant("3");
    }

}
