package com.dhenton9000.guicesample.interceptor;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(GuiceIntegration.class)
public class AwesomeTest {

	@Test
	@TestingAnnotation
	public void testThis() {

		AwesomeService awesomeService = new AwesomeService();
		awesomeService.doAwesomeThings();
	}
}
