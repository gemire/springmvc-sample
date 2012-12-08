/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/test/java/manager/ModelGenerator.e.vm.java
 */
package com.dhenton9000.springfuse.service;

import java.util.*;

import com.dhenton9000.springfuse.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhenton9000.springfuse.domain.ContactInfo;
import com.dhenton9000.springfuse.domain.enums.CivilityEnum;

import com.dhenton9000.springfuse.domain.Account;
import com.dhenton9000.springfuse.service.AccountService;
import com.dhenton9000.springfuse.service.AccountGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Service
public class ContactInfoGenerator {

    /**
     * Returns a new ContactInfo instance filled with random values.
     */
    public ContactInfo getContactInfo() {
        ContactInfo contactInfo = new ContactInfo();

        // simple attributes follows
        contactInfo.setCivility(CivilityEnum.MR);
        contactInfo.setLastName("d");
        contactInfo.setFirstName("d");
        contactInfo.setBirthDate(new Date());
        contactInfo.setOtherDate(new Date());
        // mandatory relation
        Account parent = accountGenerator.getAccount();
        accountService.save(parent);
        contactInfo.setParent(parent);
        return contactInfo;
    }

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountGenerator accountGenerator;
}