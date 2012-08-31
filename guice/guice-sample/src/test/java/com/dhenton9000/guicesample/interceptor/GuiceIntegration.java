package com.dhenton9000.guicesample.interceptor;

import org.junit.internal.runners.InitializationError;

public class GuiceIntegration extends GuiceTestRunner {

	public GuiceIntegration(Class classToRun) throws InitializationError {
		super(classToRun, new TestModule());
	}
}
