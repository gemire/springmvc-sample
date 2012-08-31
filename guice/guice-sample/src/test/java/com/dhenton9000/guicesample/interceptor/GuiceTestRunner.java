package com.dhenton9000.guicesample.interceptor;

import org.junit.internal.runners.InitializationError;
import org.junit.internal.runners.JUnit4ClassRunner;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GuiceTestRunner extends JUnit4ClassRunner {

	private final Injector injector;

	public GuiceTestRunner(final Class<?> classToRun, Module... modules) throws InitializationError {
		super(classToRun);
		this.injector = Guice.createInjector(modules);
	}

	@Override
	public Object createTest() {
		return injector.getInstance(getTestClass().getJavaClass());
	}

	protected Injector getInjector() {
		return injector;
	}
}