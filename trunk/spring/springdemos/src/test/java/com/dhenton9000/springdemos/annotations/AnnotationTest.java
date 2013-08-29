/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springdemos.annotations;

import org.mockito.InjectMocks;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import  org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * http://ahlearns.wordpress.com/2012/03/02/spring-3-autowired-unit-tests-with-mockito/
 *
 * @author dhenton
 */
@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationTest.class);
    //this annotation will inject the mock that is listed below
    @InjectMocks
    private AnnotatedResourceSample sample;
    @Mock
    ReportService reportService;
    private static final String MESSAGE = "get a job";

    @Before
    public void beforeTest() {
       // this is the same as the annotation
       // reportService = Mockito.mock(ReportService.class);
    }

    @Test
    public void TestInject() {
        Mockito.when(reportService.report()).thenReturn(MESSAGE);
        assertNotNull(sample);
        assertEquals(MESSAGE,sample.report());
        Mockito.verify(reportService,Mockito.atMost(1)).report();
    }
}
