package com.dhenton9000.guicesample.interceptor;

 
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

 
public class FirstModule extends AbstractModule {

	@Override
	protected void configure() {
		FirstInterceptor firstInterceptor = new FirstInterceptor();
		requestInjection(firstInterceptor);
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(TestingAnnotation.class), firstInterceptor);
	}
}
