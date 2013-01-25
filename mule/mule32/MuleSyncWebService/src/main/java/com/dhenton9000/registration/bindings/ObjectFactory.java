
package com.dhenton9000.registration.bindings;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dhenton9000.registration.bindings package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ResponseStatus_QNAME = new QName("uri:dhenton9000:registrationService:ref", "responseStatus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dhenton9000.registration.bindings
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterInput }
     * 
     */
    public RegisterInput createRegisterInput() {
        return new RegisterInput();
    }

    /**
     * Create an instance of {@link RegistrationDetails }
     * 
     */
    public RegistrationDetails createRegistrationDetails() {
        return new RegistrationDetails();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "uri:dhenton9000:registrationService:ref", name = "responseStatus")
    public JAXBElement<String> createResponseStatus(String value) {
        return new JAXBElement<String>(_ResponseStatus_QNAME, String.class, null, value);
    }

}
