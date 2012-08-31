package net.sf.classifier4J.vectorspace;

import java.util.Hashtable;
import java.util.Map;

/**
 * This class caches the results of vector calculation using a
 * hashtable backend.
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public class CachingVectorGenerator implements IVectorGenerator {
    private Map vectors;
    private IVectorGenerator nestedGenerator;
    /**
     * Creates a new caching vector generator that caches the results
     * of another vector generator.
     * @param generator the generator to get actual results from
     */
    public CachingVectorGenerator(IVectorGenerator generator) {
        this.vectors = new Hashtable();
        this.nestedGenerator = generator;
    }

    /**
     * @see net.sf.classifier4J.vectorspace.IVectorGenerator#getVector(java.lang.String)
     */
    public double[] getVector(String document) {
        //look if there is already a vector of this document
        double[] cached = (double[]) this.vectors.get(document);
        if (cached==null) {
            //if not, calculate one
            cached = this.nestedGenerator.getVector(document);
            this.vectors.put(document, cached);
        }
        return cached;
    }

}
