
package com.dhenton9000.admissions.components.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for admissionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="admissionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Elective"/>
 *     &lt;enumeration value="Emergency"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "admissionType", namespace = "http://www.mule-health.com/SOA/model/1.0")
@XmlEnum
public enum AdmissionType {

    @XmlEnumValue("Elective")
    ELECTIVE("Elective"),
    @XmlEnumValue("Emergency")
    EMERGENCY("Emergency");
    private final String value;

    AdmissionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdmissionType fromValue(String v) {
        for (AdmissionType c: AdmissionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
