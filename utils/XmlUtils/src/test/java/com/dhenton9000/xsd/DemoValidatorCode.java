/*
 * This is a non working demo of creating a validator using the Resolver
 * ClasspathResolver
 * 
 */
package com.dhenton9000.xsd;

import com.dhenton9000.utils.xml.ClasspathResolver;
import com.dhenton9000.utils.xml.XMLUtils;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.SAXException;

/**
 *
 * @author dhenton
 */
public class DemoValidatorCode {

    /**
     * create a validator schemas
     *
     * @param schemaClasspathLocation the base or initial schema
     * @param resolver a resolver which will follow import statements, null if
     * not needed
     * @param cLoader the classloader, if null, defaults to system classloader
     * @return a validator
     * @throws IOException file problems
     * @throws SAXException parsing problems
     */
    public static Validator createValidator(String schemaClasspathLocation, LSResourceResolver resolver, ClassLoader cLoader) throws IOException, SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        if (cLoader == null) {
            cLoader = ClassLoader.getSystemClassLoader();
        }
        if (resolver != null) {

            factory.setResourceResolver(resolver);

        }

        String xsdContents = null;
        StringReader sR = null;

        Source schemaSource = null;

        xsdContents = XMLUtils.getStringResource(schemaClasspathLocation, cLoader);
        sR = new StringReader(xsdContents);
        schemaSource = new StreamSource(sR);
        Schema schema = factory.newSchema(schemaSource);
        Validator validator = schema.newValidator();
        return validator;
    }

    public void demoValidation() throws Exception {
        String info = XMLUtils.getStringResource("samples/sample.xml", this.getClass().getClassLoader());
        Document d = XMLUtils.stringToDoc(info);
        StringReader stringReader = new StringReader(info);
        Validator schemaValidator = createValidator("wsdl/sampleSchema.xsd", 
                new ClasspathResolver("wsdl"), this.getClass().getClassLoader());



        schemaValidator.validate(new StreamSource(stringReader));
    }
}
