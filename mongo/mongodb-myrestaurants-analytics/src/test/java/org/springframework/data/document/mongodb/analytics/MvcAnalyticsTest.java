package org.springframework.data.document.mongodb.analytics;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.document.analytics.ControllerCounter;
import org.springframework.data.document.analytics.MvcEvent;
import org.springframework.data.document.analytics.Parameters;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.query.BasicQuery;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.QueryBuilder;
import com.mongodb.WriteResult;

public class MvcAnalyticsTest {

	MongoOperations operations;

	@Before
	public void setUp() throws Exception {
		Mongo m = new Mongo();
		operations = new MongoTemplate(m, "mvc");
	}

	@Test
	public void clean() {
		operations.dropCollection("mvc");
		operations.createCollection("mvc");
		operations.dropCollection("counters");
		operations.createCollection("counters");
	}

	@Test
	public void loadMvcEventData() {

		operations.dropCollection("mvc");
		operations.createCollection("mvc");
		// datasize, favoriteRestId
		createAndStoreMvcEvent(5, 1);
		createAndStoreMvcEvent(6, 2);
		createAndStoreMvcEvent(3, 3);
		createAndStoreMvcEvent(8, 4);

		List<MvcEvent> mvcEvents = operations.findAll(MvcEvent.class, "mvc");
		Assert.assertEquals(22, mvcEvents.size());

		operations.findAll(MvcEvent.class, "mvc");

	}

	@Test
	public void loadCounterData() {
		for (int i = 0; i < 10; i++) {
			storeCounterData("SignUpController", "createForm");
			storeCounterData("SignUpController", "create");
			storeCounterData("SignUpController", "show");
			storeCounterData("RestaurantController", "addFavoriteRestaurant");
		}
		for (int i = 0; i < 5; i++) {
			storeCounterData("RestaurantController", "list");
			storeCounterData("SignUpController", "show");
		}

	}

	@Test
	public void queryCounterData() {
		DBObject query = QueryBuilder.start("name").is("SignUpController").get();
		for (DBObject dbo : operations.getCollection("counters").find(query)) {
			System.out.println(dbo);
		}
		List<ControllerCounter> counters = operations.find(
				new BasicQuery("{ 'name' : 'SignUpController'} "),
				ControllerCounter.class,
				"counters");
		for (ControllerCounter controllerCounter : counters) {
			System.out.println(controllerCounter);
		}
	}

	/*
	 *
	 * var start = new Date(2010,9,1); var end = new Date(2010,11,1);
	 * db.mvc.group( { cond: {"action": "addFavoriteRestaurant", "date": {$gte:
	 * start, $lt: end}} , key: {"parameters.p1": true} , initial: {count: 0} ,
	 * reduce: function(doc, out){ out.count++; } } );
	 */

	@Test
	public void listAllMvcEvents() {
		List<MvcEvent> mvcEvents = operations.findAll(MvcEvent.class, "mvc");
		for (MvcEvent mvcEvent : mvcEvents) {
			System.out.println(mvcEvent.getDate());
		}
	}

	@Test
	public void groupQuery() {
		// This circumvents exception translation
		DBCollection collection = operations.getCollection("mvc");

		// QueryBuilder qb = new QueryBuilder();
		// qb.start("date").greaterThan(object)
		Calendar startDate = Calendar.getInstance();
		startDate.clear();
		startDate.set(Calendar.YEAR, 2010);
		startDate.set(Calendar.MONTH, 5);
		Calendar endDate = Calendar.getInstance();
		endDate.clear();
		endDate.set(Calendar.YEAR, 2010);
		endDate.set(Calendar.MONTH, 12);

		/*
		 * QueryBuilder qb = new QueryBuilder(); Query q =
		 * qb.find("date").gte(startDate
		 * .getTime()).lt(endDate.getTime()).and("action"
		 * ).is("addFavoriteRestaurant").build(); DBObject cond2 =
		 * q.getQueryObject();
		 */
		DBObject cond = QueryBuilder.start("date").greaterThanEquals(startDate.getTime()).lessThan(endDate.getTime())
				.and("action").is("addFavoriteRestaurant").get();
		DBObject key = new BasicDBObject("parameters.p1", true);
		/*
		 * DBObject dateQ = new BasicDBObject(); dateQ.put("$gte",
		 * startDate.getTime()); dateQ.put("$lt", endDate.getTime()); DBObject
		 * cond = new BasicDBObject(); cond.put("action",
		 * "addFavoriteRestaurant"); cond.put("date", dateQ);
		 */

		DBObject intitial = new BasicDBObject("count", 0);
		DBObject result = collection.group(key, cond, intitial, "function(doc, out){ out.count++; }");
		if (result instanceof BasicDBList) {
			BasicDBList dbList = (BasicDBList) result;
			for (Object element : dbList) {
				DBObject dbo = (DBObject) element;
				System.out.println(dbo);
			}
		}
		System.out.println(result);
	}

	@Test
	public void storeControllerCounterInfo() {

		BasicDBObject query = new BasicDBObject("name", "controller1");

		BasicDBObject changes = new BasicDBObject();
		changes.put("$set", new BasicDBObject("name", "controller1"));
		changes.put("$inc", new BasicDBObject("count", 1));

		// mongoTemplate.upsertAndModify(dbo("key","value"), inc("count",1));
		// dbo(set("name","controller"), inc("count", 1));

		// /mongoTemplate.update(collection("counters")

		WriteResult r = operations.getCollection("counters").update(query, changes, true, false);
		// { "err" : "Modifiers and non-modifiers cannot be mixed" , "code" : 10154 , "n" : 0 , "ok" : 1.0}
		// { "err" : null , "updatedExisting" : false , "upserted" : { "$oid" : "4cba814a5a4900000000495d"} , "n" : 1 , "ok"
		// : 1.0}
		// { "err" : null , "updatedExisting" : true , "n" : 1 , "ok" : 1.0}
		System.out.println(r);

		// changes = new BasicDBObject("methods", new BasicDBObject("find", 1));
		// mongoTemplate.getCollection("counters").update(query, changes, true,
		// false);
	}

	@Test
	public void updateMethodCounter() {
		DBObject query = new BasicDBObject("name", "controller1");
		DBObject changes = new BasicDBObject("$inc", new BasicDBObject("methods.find", 1));
		operations.getCollection("counters").update(query, changes, true, false);
	}

	public void storeCounterData(String controllerName, String methodName) {
		BasicDBObject query = new BasicDBObject("name", controllerName);

		BasicDBObject changes = new BasicDBObject();
		changes.put("$set", new BasicDBObject("name", controllerName));
		changes.put("$inc", new BasicDBObject("count", 1));

		WriteResult r = operations.getCollection("counters").update(query, changes, true, false);
		System.out.println(r);

		changes = new BasicDBObject("$inc", new BasicDBObject("methods." + methodName, 1));
		r = operations.getCollection("counters").update(query, changes, true, false);
		System.out.println(r);
	}

	private void createAndStoreMvcEvent(int dataSize, int p1) {
		for (int i = 0; i < dataSize; i++) {
			MvcEvent event = generateEvent(p1);
			operations.save(event, "mvc");
		}
	}

	private MvcEvent generateEvent(Integer p1) {
		MvcEvent event = new MvcEvent();

		event.setController("RestaurantController");
		event.setAction("addFavoriteRestaurant");
		event.setDate(new Date());
		event.setRemoteUser("mpollack");
		event.setRequestAddress("127.0.0.1");
		event.setRequestUri("/myrestaurants-analytics/restaurants");
		Parameters params = new Parameters();
		params.setP1(p1.toString());
		params.setP2("2");
		event.setParameters(params);

		return event;
	}
}
