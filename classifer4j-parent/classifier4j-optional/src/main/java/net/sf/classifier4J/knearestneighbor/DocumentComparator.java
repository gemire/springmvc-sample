package net.sf.classifier4J.knearestneighbor;

import java.util.Comparator;

/**
 * The document comparator is used to sort lists of documents according
 * to their similarity to some reference document.
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 */
public class DocumentComparator implements Comparator {
    private ISimilarityCalculator similarityCalculator;
    private String referenceDocument;
    /**
     * Creates a new DocumentComparator using a given similarity calculator and a
     * reference document.
     * @param calculator used to calculate the similarity
     * @param reference the reference document
     */
    public DocumentComparator(ISimilarityCalculator calculator, String reference) {
        this.similarityCalculator = calculator;
        this.referenceDocument = reference;
    }

    /**
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(Object document1, Object document2) {
        double sim1 = this.similarityCalculator.getSimilarity(this.referenceDocument, document1.toString());
        double sim2 = this.similarityCalculator.getSimilarity(this.referenceDocument, document2.toString());
        if (sim1<sim2) {
            return 1; 
        } else if (sim1>sim2) {
            return -1;
        }
        return 0;
    }

}
