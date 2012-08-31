package net.sf.classifier4J.vectorspace;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public class Messages {
    private static final String BUNDLE_NAME = "net.sf.classifier4J.vectorspace.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(BUNDLE_NAME);

    private Messages() {
        //private constructor for exclusive factory use
    }
    /**
     * Gets a localized message string from a resource key
     * @param key the resouce key
     * @return the message string
     */
    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
