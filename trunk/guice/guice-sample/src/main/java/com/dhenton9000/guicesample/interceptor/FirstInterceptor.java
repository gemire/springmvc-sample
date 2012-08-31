package com.dhenton9000.guicesample.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.OutOfScopeException;

public class FirstInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		throw new OutOfScopeException("out");
	}

}
