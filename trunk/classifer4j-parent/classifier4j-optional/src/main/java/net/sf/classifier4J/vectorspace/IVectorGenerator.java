package net.sf.classifier4J.vectorspace;

/**
 * Generates a vector representation of a document.
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public interface IVectorGenerator {
    /**
     * Generates a vector representation of a particular document.
     * @param document
     * @return a vector representation
     */
    double[] getVector(String document);
}
