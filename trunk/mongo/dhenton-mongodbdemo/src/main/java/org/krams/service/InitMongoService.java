package org.krams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.krams.domain.LineItems;
import org.krams.domain.Orders;
import org.krams.domain.Role;
import org.krams.domain.User;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Service for initializing MongoDB with sample data using {@link MongoTemplate}
 */
public class InitMongoService {
	
	 
	private MongoTemplate mongoTemplate;

	public void init() {
		// Drop existing collections
		getMongoTemplate().dropCollection("role");
		getMongoTemplate().dropCollection("user");
                getMongoTemplate().dropCollection("orders");

                Orders order = new Orders();
                order.setCustomerName("Fred Farkel");
                order.setOrderId(55);
                List<LineItems> lineItems = new ArrayList<LineItems>();
                order.setOrderLines(lineItems);
                lineItems.add(new LineItems(110,"buzzsaws"));
                lineItems.add(new LineItems(4,"hackers"));
                getMongoTemplate().insert(order, "orders");
		// Create new records
		Role adminRole = new Role();
		adminRole.setId(UUID.randomUUID().toString());
		adminRole.setRole(1);
		
		Role userRole = new Role();
		userRole.setId(UUID.randomUUID().toString());
		userRole.setRole(2);
		
		User john = new User();
		john.setId(UUID.randomUUID().toString());
		john.setFirstName("John");
		john.setLastName("Smith");
		john.setPassword("21232f297a57a5a743894a0e4a801fc3");
		john.setRole(adminRole);
		john.setUsername("john");
		
		User jane = new User();
		jane.setId(UUID.randomUUID().toString());
		jane.setFirstName("Jane");
		jane.setLastName("Adams");
		jane.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
		jane.setRole(userRole);
		jane.setUsername("jane");
		
		// Insert to db
		getMongoTemplate().insert(john, "user");
		getMongoTemplate().insert(jane, "user");
		getMongoTemplate().insert(adminRole, "role");
		getMongoTemplate().insert(userRole, "role");
	}

    /**
     * @return the mongoTemplate
     */
    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    /**
     * @param mongoTemplate the mongoTemplate to set
     */
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
        
    
        
        
}
