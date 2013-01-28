package com.dhenton9000.jsr.sandbox;

import com.dhenton9000.jsr.list.demo.CheckingAccount;
import com.dhenton9000.jsr.list.demo.Transactions;
import com.dhenton9000.jsr.validators.JSR303Sample;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class ValidateArrayTests {

    private static Validator validator;
    private final Logger logger = LoggerFactory.getLogger(ValidateArrayTests.class);
    CheckingAccount account = null;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        
         
    }
    
    @Before
    public void beforeEachTest()
    {
        account = new CheckingAccount();
    }

    @Test
    public void testValidationOfArrays()
    {
        account.getTransactions().add(new Transactions("john smith", new Float(99.99)));
        account.getTransactions().add(new Transactions());
        account.getTransactions().add(new Transactions("john smith", null));
        Set<ConstraintViolation<CheckingAccount>> violations = validator.validate(account);
        assertEquals(3,violations.size());
        ConstraintViolation<CheckingAccount> firstViolation = violations.iterator().next();
        assertEquals("transactions[2].amount",firstViolation.getPropertyPath().toString());
        assertEquals("what a crock a null value!!! ",firstViolation.getMessage());
         for (ConstraintViolation<CheckingAccount> violation : violations) {
            logger.debug(violation.getPropertyPath() + " || " + violation.getMessage());
        }
        
    }
}
