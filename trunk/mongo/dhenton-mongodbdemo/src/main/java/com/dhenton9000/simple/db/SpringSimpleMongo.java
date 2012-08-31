/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.simple.db;

/**
 *
 * @author Don
 */

    

import com.mongodb.Mongo;
 
import java.net.UnknownHostException;
 
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class SpringSimpleMongo {
 
    private static final Logger log = LoggerFactory.getLogger(SpringSimpleMongo.class);
 
    public static void main( String[] args )
    {
        try {
            MongoOperations mongoOps = new MongoTemplate(new Mongo(), "mydb");
            mongoOps.insert(new Person("Joe", 34));
            Query q = new Query(Criteria.where("name").is("Joe"));
            Person listPerson=  mongoOps.findOne(q,Person.class);
            log.debug("Person is "+listPerson);
            mongoOps.dropCollection("person");
        }
        catch(UnknownHostException ex) {
            log.error("Unknown host problem "+ex.getMessage());
        }
    }
}