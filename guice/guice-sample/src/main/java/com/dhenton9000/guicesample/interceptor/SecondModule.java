package com.dhenton9000.guicesample.interceptor;

 
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

 
public class SecondModule extends AbstractModule {

	@Override
	protected void configure() {
		SecondInterceptor secondInterceptor = new SecondInterceptor();
		requestInjection(secondInterceptor);
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(TestingAnnotation.class), secondInterceptor);
	}
}
