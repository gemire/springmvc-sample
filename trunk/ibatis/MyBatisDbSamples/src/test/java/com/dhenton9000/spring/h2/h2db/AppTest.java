package com.dhenton9000.spring.h2.h2db;

import com.dhenton9000.db.utils.InMemoryDBInitializer;
import com.dhenton9000.restaurants.dao.RestaurantsDao;
import com.dhenton9000.restaurants.model.Restaurant;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:inmemory-derby-spring.xml"})
@Transactional
public class AppTest {

    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    private static ClassPathXmlApplicationContext context = null;

    @BeforeClass
    public static void setUp() {

        context = new ClassPathXmlApplicationContext("inmemory-derby-spring.xml");
        context.getBean(InMemoryDBInitializer.class);
    }

    @Test
    public void testRestaurantDao() {
        RestaurantsDao mapper = (RestaurantsDao) context.getBean("restaurantsMapper");
        List<Restaurant> restaurants = mapper.getAll();
        assertEquals(50, restaurants.size());

    }
}
