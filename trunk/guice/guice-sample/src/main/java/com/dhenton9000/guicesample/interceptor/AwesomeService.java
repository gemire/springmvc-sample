package com.dhenton9000.guicesample.interceptor;

public class AwesomeService {

	@TestingAnnotation
	public void doAwesomeThings() {
		System.out.println("how did you get here");
	}

}
