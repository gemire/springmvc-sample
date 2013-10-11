/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springdemos.mockito;

/**
 * This class can be used to substitute a Mockito noop class for a dependency
 * intended to handle the case where the dependency is through classpath
 * scanning and annotations, and is just there as a placeholder
 * 
 * @author dhenton
 */
 
import org.mockito.Mockito;
import org.springframework.beans.factory.FactoryBean;

public class MockitoFactoryBean<T> implements FactoryBean<T> {

	
	private Class<T> classToBeMocked;
	
	public MockitoFactoryBean(Class<T> classToBeMocked)
	{
		this.classToBeMocked = classToBeMocked;
	}

	@Override
	public T getObject() throws Exception {
		 
		return Mockito.mock(classToBeMocked);
	}

	@Override
	public Class<?> getObjectType() {
		

		return classToBeMocked;
	}

	@Override
	public boolean isSingleton() {
		

		return true;
	}
	 
}
