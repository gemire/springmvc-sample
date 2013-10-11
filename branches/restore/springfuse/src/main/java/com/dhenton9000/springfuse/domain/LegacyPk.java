/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/domain/CompositePk.cpk.vm.java
 */
package com.dhenton9000.springfuse.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class LegacyPk implements Comparable<LegacyPk>, Serializable {
    static final private long serialVersionUID = 1L;

    //--------------------------------------------
    // Primary key columns
    //--------------------------------------------
    private String code;
    private Integer dept;
    private String name;

    public LegacyPk() {
    }

    public LegacyPk(String code, Integer dept, String name) {
        this.code = code;
        this.dept = dept;
        this.name = name;
    }

    /**
     * Helper to determine if this composite primary key can be considered as set or not.
     */
    @Transient
    public boolean isLegacyPkSet() {
        return isCodeSet() && isDeptSet() && isNameSet();
    }

    /**
     * Helper method to determine if this instance is considered empty, that is,
     * if all the non primary key columns are null.
     */
    @Transient
    public boolean isEmpty() {
        return !isCodeSet() && !isDeptSet() && !isNameSet();
    }

    //--------------------------------------------
    // Getters & Setters
    //--------------------------------------------

    //-- [code] ------------------------------

    @NotEmpty
    @Length(max = 8)
    @Column(name = "CODE", nullable = false, length = 8)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Helper that determines if this attribute is set or not.
     */
    @Transient
    public boolean isCodeSet() {
        return getCode() != null && getCode().length() > 0;
    }

    //-- [dept] ------------------------------

    @NotNull
    @Column(name = "DEPT", nullable = false, precision = 10)
    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    /**
     * Helper that determines if this attribute is set or not.
     */
    @Transient
    public boolean isDeptSet() {
        return getDept() != null;
    }

    //-- [name] ------------------------------

    @NotEmpty
    @Length(max = 16)
    @Column(name = "NAME", nullable = false, length = 16)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Helper that determines if this attribute is set or not.
     */
    @Transient
    public boolean isNameSet() {
        return getName() != null && getName().length() > 0;
    }

    //-----------------------------------------------
    // equals & hashCode
    //-----------------------------------------------

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof LegacyPk)) {
            return false;
        }

        LegacyPk other = (LegacyPk) object;
        return new EqualsBuilder().append(getCode(), other.getCode()).append(getDept(), other.getDept()).append(
                getName(), other.getName()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCode()).append(getDept()).append(getName()).toHashCode();
    }

    //-----------------------------------------------
    // Comparable
    //-----------------------------------------------

    public int compareTo(LegacyPk other) {
        return new CompareToBuilder().append(getCode(), other.getCode()).append(getDept(), other.getDept()).append(
                getName(), other.getName()).toComparison();
    }

    //-----------------------------------------------
    // toString / from String
    //-----------------------------------------------

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (isCodeSet()) {
            result.append(getCode());
        }

        result.append(":");

        if (isDeptSet()) {
            result.append(getDept());
        }

        result.append(":");

        if (isNameSet()) {
            result.append(getName());
        }

        return result.toString();
    }

    /**
     * Build an instance from a string version.
     */
    public static LegacyPk fromString(String string) {
        LegacyPk result = new LegacyPk();
        String[] values = string.split(":");
        if (values[0] != null && values[0].length() > 0) {
            result.setCode(values[0]);
        }
        if (values[1] != null && values[1].length() > 0) {
            result.setDept(new Integer(values[1]));
        }
        if (values[2] != null && values[2].length() > 0) {
            result.setName(values[2]);
        }

        return result;
    }
}
