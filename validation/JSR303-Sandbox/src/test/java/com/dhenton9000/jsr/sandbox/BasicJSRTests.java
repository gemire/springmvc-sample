package com.dhenton9000.jsr.sandbox;

import com.dhenton9000.jsr.validators.JSR303Sample;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class BasicJSRTests {

    private static Validator validator;
    private final Logger logger = LoggerFactory.getLogger(BasicJSRTests.class);

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testFailedValidation() {
        JSR303Sample sample = new JSR303Sample();
        Set<ConstraintViolation<JSR303Sample>> violations = validator.validate(sample);
        assertEquals(4, violations.size());
        for (ConstraintViolation<JSR303Sample> violation : violations) {
            logger.debug(violation.getPropertyPath() + " || " + violation.getMessage());
        }
    }

    @Test
    public void testSuccessfulValidation() {
        JSR303Sample sample = new JSR303Sample();
        sample.setAge(22);
        sample.setEmail("elmo@gasbag.com");
        sample.setPassword("elmo");
        sample.setPasswordVerification("elmo");
        Set<ConstraintViolation<JSR303Sample>> violations = validator.validate(sample);
        assertEquals(0, violations.size());

    }

    @Test
    public void testCustomMessageOnNull() {
        JSR303Sample sample = new JSR303Sample();
        sample.setAge(22);
        // sample.setEmail("elmo@gasbag.com");
        sample.setPassword("elmo");
        sample.setPasswordVerification("elmo");
        Set<ConstraintViolation<JSR303Sample>> violations = validator.validate(sample);
        assertEquals(1, violations.size());
        ConstraintViolation<JSR303Sample> v = violations.iterator().next();
        assertEquals("You must enter an email", v.getMessage());
    }

    @Test
    public void testCustomMessageOnCustomTag() {
        // see the ValidationMessages.properties file
        JSR303Sample sample = new JSR303Sample();
        sample.setAge(22);
        sample.setEmail("elmo@gasbag.com");
        sample.setPassword("elmo");
        sample.setPasswordVerification("zzzelmo");
        Set<ConstraintViolation<JSR303Sample>> violations = validator.validate(sample);
        assertEquals(1, violations.size());
        ConstraintViolation<JSR303Sample> v = violations.iterator().next();
        assertEquals("Passwords must match you moron!!!", v.getMessage());



    }

    @Test
    public void testCustomNullMessageViaAnnotation() {
        // on the annotation for the Sample Bean
        JSR303Sample sample = new JSR303Sample();
        sample.setAge(22);
        // sample.setEmail("elmo@gasbag.com");
        sample.setPassword("elmo");
        sample.setPasswordVerification("elmo");
        Set<ConstraintViolation<JSR303Sample>> violations = validator.validate(sample);
        assertEquals(1, violations.size());
        ConstraintViolation<JSR303Sample> v = violations.iterator().next();
        assertEquals("You must enter an email", v.getMessage());


    }

    @Test
    public void testCustomizeAgeMessageInPropertiesFile() {
        //set in ValidationMessages.properties
        
        JSR303Sample sample = new JSR303Sample();
        sample.setAge(75);
        sample.setEmail("elmo@gasbag.com");
        sample.setPassword("elmo");
        sample.setPasswordVerification("elmo");
        Set<ConstraintViolation<JSR303Sample>> violations = validator.validate(sample);
        assertEquals(1, violations.size());
        ConstraintViolation<JSR303Sample> v = violations.iterator().next();
        assertEquals("no geezers over 65", v.getMessage());

    }
}
