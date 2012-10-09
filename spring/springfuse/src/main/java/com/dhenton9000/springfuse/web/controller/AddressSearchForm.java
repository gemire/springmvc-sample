/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/web/controller/SearchForm.e.vm.java
 */
package com.dhenton9000.springfuse.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dhenton9000.springfuse.domain.Address;
import com.dhenton9000.springfuse.web.util.SearchForm;
import com.dhenton9000.springfuse.web.util.NullRestriction;

public class AddressSearchForm extends SearchForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private Address address = new Address();

    /**
     * The Address instance used as an example.
     */
    public Address getAddress() {
        return address;
    }

    @Override
    public List<NullRestriction> getNullRestrictions() {
        List<NullRestriction> result = new ArrayList<NullRestriction>();
        return result;
    }
}