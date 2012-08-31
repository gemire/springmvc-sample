package net.sf.classifier4J.knearestneighbor;

/**
 * A similarity calculator calculates the similarity of two arbitrary
 * documents according to a document model. Different implementations
 * of this interface will implement different document models.
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 */
public interface ISimilarityCalculator {
    /**
     * Determines the similarity of two documents. The value is between 0 and 1.0 for
     * no similarity or full equality. The order of the documents does not matter, so
     * <pre><code>
     * getSimilarity(String document1, String document2)==getSimilarity(String document2, String document1)
     * </code></pre>
     * @param document1 the first document
     * @param document2 the second document
     * @return similarity value between 0 (no similarity) and 1 (complete equality)
     */
    public double getSimilarity(String document1, String document2);
}
