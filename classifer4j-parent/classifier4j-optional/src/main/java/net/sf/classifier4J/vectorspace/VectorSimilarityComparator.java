package net.sf.classifier4J.vectorspace;

import net.sf.classifier4J.knearestneighbor.ISimilarityCalculator;

/**
 * Calculates the similarity of two documents by evaluating two document vectors.
 * By using a customizable vector generator the user can decide which particular
 * vector space model to use.
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 */
public class VectorSimilarityComparator implements ISimilarityCalculator {
    private IVectorGenerator generator;
    /**
     * Creates a new vector similarity comparator that uses a vector generator
     * to get vector representations of
     * @param vectorGenerator what generator to use when creating vectors from documents 
     */
    public VectorSimilarityComparator(IVectorGenerator vectorGenerator) {
        this.generator = vectorGenerator;
    }

    /**
     * @see net.sf.classifier4J.knearestneighbor.ISimilarityCalculator#getSimilarity(java.lang.String, java.lang.String)
     */
    public double getSimilarity(String document1, String document2) {
        double[] one = this.generator.getVector(document1);
        double[] two = this.generator.getVector(document2);
        return DoubleVectorUtils.cosineOfVectors(one, two);
    }

}
