
package com.dhenton9000.admissions.components.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procedureCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="procedureCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="In-patient"/>
 *     &lt;enumeration value="Day-patient"/>
 *     &lt;enumeration value="Out-patient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "procedureCodeType", namespace = "http://www.mule-health.com/SOA/model/1.0")
@XmlEnum
public enum ProcedureCodeType {

    @XmlEnumValue("In-patient")
    IN_PATIENT("In-patient"),
    @XmlEnumValue("Day-patient")
    DAY_PATIENT("Day-patient"),
    @XmlEnumValue("Out-patient")
    OUT_PATIENT("Out-patient");
    private final String value;

    ProcedureCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProcedureCodeType fromValue(String v) {
        for (ProcedureCodeType c: ProcedureCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
