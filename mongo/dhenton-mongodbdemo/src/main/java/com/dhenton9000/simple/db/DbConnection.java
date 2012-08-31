/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.simple.db;



import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.net.UnknownHostException;

public class DbConnection {

    private static Mongo m;
    private static DB db;

    public static DBCollection getDBCollection(String collection) {
        try {
            m = new Mongo("localhost", 27017);
        } catch (UnknownHostException ex) {
        } catch (MongoException ex) {
        }
        db = m.getDB("accounts");
        return db.getCollection(collection);
    }
}

