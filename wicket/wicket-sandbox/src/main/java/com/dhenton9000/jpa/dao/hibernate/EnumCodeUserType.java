/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/hibernate/support/EnumCodeUserType.p.vm.java
 */
package com.dhenton9000.jpa.dao.hibernate;

public class EnumCodeUserType extends GenericEnumUserType {
    private static final long serialVersionUID = 1L;

    public EnumCodeUserType() {
        super("toCode", "fromCode");
    }

    public static final String FQN = "com.dhenton9000.springfuse.dao.hibernate.EnumCodeUserType";

}
