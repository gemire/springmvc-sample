/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.utils.xml;

/**
 *
 * @author dhenton
 */
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * A entity resolver that resolves an entity's location within the classpath. It
 * assumes that all schemas lie within a single package, which is passed in the
 * constructor or setter prior to use: eg com/fred/xsd. thus a schema which has
 * a import statement of the form: &lt;xs:import namespace="mynamespace"
 * schemaLocation="AlphaSchema.xsd" /&gt; will have to have the file 
 * AlphaSchema.xsd in the classpath at &lt;schemaFolder&gt;/AlphaSchema.xsd
 *
 */
public class ClasspathResolver implements EntityResolver, LSResourceResolver {

    /**
     * Class logger.
     */
    private final Logger log = LogManager.getLogger(ClasspathResolver.class);
    private String schemaFolder = null;

    public ClasspathResolver(String schemaFolder) {
        this.schemaFolder = schemaFolder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        InputStream resourceStream = resolver(publicId, systemId);
        if (resourceStream != null) {
            return new InputSource(resourceStream);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
        return new LSInputImpl(publicId, systemId, resolver(publicId, systemId));
    }

    /**
     * Resolves an id against the classpath. System ID is tried first, then
     * public ID.
     *
     * @param publicId resources public ID
     * @param systemId resources system ID
     *
     * @return resolved resource or null
     */
    protected InputStream resolver(String publicId, String systemId) {
        String resource = null;
        InputStream resourceIns = null;

        if (systemId != null) {
            resource = getSchemaFolder() + "/" + systemId;
            log.debug("Attempting to resolve, within the classpath, the entity with the following system id: " + resource);
            resourceIns = getClass().getClassLoader().getResourceAsStream(resource);
        }

        if (resourceIns == null && publicId != null) {
            resource = getSchemaFolder() + "/" + publicId;
            log.debug("Attempting to resolve, within the classpath, the entity with the following public id: " + resource);
            resourceIns = getClass().getClassLoader().getResourceAsStream(resource);
        }

        if (resourceIns == null) {
            log.debug("Entity was not resolved from classpath");
            return null;
        }
        log.debug("Entity resolved from classpath");
        return resourceIns;
    }

    public String getSchemaFolder() {
        return schemaFolder;
    }

    public void setSchemaFolder(String schemaFolder) {
        this.schemaFolder = schemaFolder;
    }

    /**
     * Implementation of DOM 3 {@link LSInput}.
     */
    protected class LSInputImpl implements LSInput {

        /**
         * Public ID of the resolved resource.
         */
        private String publicId;
        /**
         * System ID of the resolved recource.
         */
        private String systemId;
        /**
         * Resolved resource.
         */
        private BufferedInputStream buffInput;

        /**
         * Constructor.
         *
         * @param pubId public id of the resolved resource
         * @param sysId system id of the resolved resource
         * @param input resolved resource
         */
        public LSInputImpl(String pubId, String sysId, InputStream input) {
            publicId = pubId;
            systemId = sysId;
            buffInput = new BufferedInputStream(input);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getBaseURI() {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public InputStream getByteStream() {
            return buffInput;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean getCertifiedText() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Reader getCharacterStream() {
            return new InputStreamReader(buffInput);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getEncoding() {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getPublicId() {
            return publicId;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getStringData() {
            synchronized (buffInput) {
                try {
                    buffInput.reset();
                    byte[] input = new byte[buffInput.available()];
                    buffInput.read(input);
                    return new String(input);
                } catch (IOException e) {
                    return null;
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getSystemId() {
            return systemId;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setBaseURI(String uri) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setByteStream(InputStream byteStream) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setCertifiedText(boolean isCertifiedText) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setCharacterStream(Reader characterStream) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setEncoding(String encoding) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setPublicId(String id) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setStringData(String stringData) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setSystemId(String id) {
        }
    }
}