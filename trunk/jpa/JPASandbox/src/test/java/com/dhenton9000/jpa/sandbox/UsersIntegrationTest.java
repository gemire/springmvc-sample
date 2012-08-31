/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.sandbox;

import com.dhenton9000.jpa.sandbox.generated.Users;
import com.dhenton9000.jpa.sandbox.repositories.UsersRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Don
 */
@ContextConfiguration("classpath:test-jpa-spring.xml")
public class UsersIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UsersRepository usersRepository;

    @Transactional
    @Test
    public void testInsert() {
        Users user = new Users();
        user.setUserid("bbb");
        user.setUsername("billy bob bonzo");
        usersRepository.save(user);
        assertEquals(42, usersRepository.count());
    }

    @Test
    public void findsCustomersAccounts() {

        assertEquals(41, usersRepository.count());
        
    }
    
    
}
