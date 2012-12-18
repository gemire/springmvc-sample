
package com.dhenton9000.admissions.components.ws.billing;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for careType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="careType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Private"/>
 *     &lt;enumeration value="Public"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "careType", namespace = "http://www.mule-health.com/SOA/model/1.0")
@XmlEnum
public enum CareType {

    @XmlEnumValue("Private")
    PRIVATE("Private"),
    @XmlEnumValue("Public")
    PUBLIC("Public");
    private final String value;

    CareType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CareType fromValue(String v) {
        for (CareType c: CareType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
