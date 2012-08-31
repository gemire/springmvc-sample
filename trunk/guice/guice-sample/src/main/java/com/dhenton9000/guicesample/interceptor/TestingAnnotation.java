package com.dhenton9000.guicesample.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
ElementType.METHOD, ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TestingAnnotation {

	Class<? extends Exception>[] rollbackOn() default RuntimeException.class;

	Class<? extends Exception>[] ignore() default {};
}
