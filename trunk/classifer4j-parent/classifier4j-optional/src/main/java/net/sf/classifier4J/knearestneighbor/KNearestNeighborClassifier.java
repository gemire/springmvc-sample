package net.sf.classifier4J.knearestneighbor;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import net.sf.classifier4J.AbstractCategorizedTrainableClassifier;
import net.sf.classifier4J.ITrainableClassifier;

/**
 * The k-nearest neighbor classification algorithm works on a given
 * list of documents and their categorization. Categorization of a new
 * document works as follows: Calculate the similarity of the new document
 * to all other documents in the database. Select the k most similar documents
 * (called neighbors), find out which category most of the neighbors have
 * and return this category.
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public class KNearestNeighborClassifier extends AbstractCategorizedTrainableClassifier implements ITrainableClassifier {
    /**
     * The default value of neighbors to consider.
     */
    private final static int DEFAULT_K = 10; 
    /**
     * The numbers of neighbors to consider.
     */
    private int k;
    /**
     * Creates a new K-Nearest-Neighbors-Classifier using the default
     * K-Value.
     */
    private List classifiedDocuments;
    private ISimilarityCalculator similarityCalculator;
    /**
     * Creates a new Classified, based on the k-nearest-neighbors algorithm using
     * a given similarity calculator that calculates similarity between two documents.
     * @param simcalc calculates similarities between two documents
     */
    public KNearestNeighborClassifier(ISimilarityCalculator simcalc) {
        this(KNearestNeighborClassifier.DEFAULT_K, simcalc);
    }
    /**
     * Creates a new K-Nearest-Neighbors-Classifier using a given K-Value.
     * @param k the value of neighbors to determine the matching category from
     * @param simcalc calculates similarities between two documents
     */
    public KNearestNeighborClassifier(int k, ISimilarityCalculator simcalc) {
        this.k = k;
        this.similarityCalculator = simcalc;
        this.classifiedDocuments = new Vector();
    }

    /**
     * @see net.sf.classifier4J.ICategorisedClassifier#classify(java.lang.String, java.lang.String)
     */
    public double classify(String category, String input) {
        if (isMatch(category, input)) {
            return 1d;
        }
        return 0;
    }
    /**
     * Gets a category suggestion from the classification algorithm by considering
     * the categories of the k-most similar documents in the database.
     * @param input the input document
     * @return a category string or null if no matching category has been found
     */
    public String getCategory(String input) {
        Collections.sort(this.classifiedDocuments, new DocumentComparator(this.similarityCalculator, input));
        Map categoryCount = new Hashtable(this.k);
        //go through the k top hits of the list of classified documents
        for (int i = 0;i<this.k;i++) {
            //find out the category
            ClassifiedDocument document = (ClassifiedDocument) this.classifiedDocuments.get(i);
            //and the number of occurrences of this category so far
            Integer count = (Integer) categoryCount.get(document.getCategory());
            if (count==null) {
                //if none, start with one
                count = new Integer(1);
            } else {
                //else increase the counter by one
                count = new Integer(count.intValue() + 1);
            }
            categoryCount.put(document.getCategory(), count);
        }
        int max = 0;
        String category = null;
        for (Iterator i = categoryCount.keySet().iterator();i.hasNext();) {
            String mycategory = (String) i.next();
            int value = ((Integer) categoryCount.get(mycategory)).intValue();
            if (value>=max) {
                max = value;
                category = mycategory;
            }
        }
        return category;
    }

    /**
     * @see net.sf.classifier4J.ICategorisedClassifier#isMatch(java.lang.String, java.lang.String)
     */
    public boolean isMatch(String category, String input) {
        return (this.getCategory(input).intern()==category.intern());
    }

    /**
     * @see net.sf.classifier4J.IClassifier#setMatchCutoff(double)
     */
    public void setMatchCutoff(double cutoff) {
        //there is no need for this method in this context
    }
    /**
     * @see net.sf.classifier4J.ITrainable#teachMatch(java.lang.String, java.lang.String)
     */
    public void teachMatch(String category, String input) {
        this.classifiedDocuments.add(new ClassifiedDocument(input, category));
    }

    /**
     * @see net.sf.classifier4J.ITrainable#teachNonMatch(java.lang.String, java.lang.String)
     */
    public void teachNonMatch(String category, String input) {
        //the k-nearest-neighbor model does not deal with non-matches, so these are just removed
        //from the database of documents
        for (Iterator i = this.classifiedDocuments.iterator();i.hasNext();) {
            ClassifiedDocument document = (ClassifiedDocument) i.next();
            if ((document.getCategory().equals(category))&&(document.getContent().equals(input))) {
                i.remove();
            }
        }
    }
}
