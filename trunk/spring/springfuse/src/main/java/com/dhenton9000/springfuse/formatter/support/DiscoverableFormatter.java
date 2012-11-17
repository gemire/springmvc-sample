/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/formatter/support/DiscoverableFormatter.p.vm.java
 */
package com.dhenton9000.springfuse.formatter.support;

import org.springframework.format.Formatter;

/**
 * This is a marker interface so the {@link CustomFormattingConversionServiceFactory} so your {@link Formatter} gather all the implementation using Spring.
 * 
 * @see CustomFormattingConversionServiceFactory
 * @see Formatter
 */
public interface DiscoverableFormatter<T> extends Formatter<T> {
    Class<T> getTarget();
}