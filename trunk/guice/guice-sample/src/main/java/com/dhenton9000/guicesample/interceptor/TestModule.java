package com.dhenton9000.guicesample.interceptor;

import com.google.inject.AbstractModule;

public class TestModule extends AbstractModule {

	private final FirstModule firstModule;
	private final SecondModule secondModule;

	public TestModule() {
		super();
		firstModule = new FirstModule();
		secondModule = new SecondModule();
	}

	@Override
	protected void configure() {
		install(secondModule);
		install(firstModule);
	}

}
