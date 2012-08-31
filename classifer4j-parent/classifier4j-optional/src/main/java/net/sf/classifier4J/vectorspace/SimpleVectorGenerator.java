package net.sf.classifier4J.vectorspace;

import net.sf.classifier4J.ITokenizer;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.map.ListOrderedMap;

/**
 * The SimpleVectorGenerator is based on the simple term-occurrence model.
 * For each term occurring in one of the documents considered, a new
 * entry in the vector is created. For each occurrence of a term in the
 * document, the value of the corresponding entry is increased by one.
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public class SimpleVectorGenerator implements IVectorGenerator {
    //we need an ordered map here in order to keep the position-term-relationship
    private OrderedMap terms;
    private ITokenizer nestedTokenizer;
    /**
     * Generates a new vector generator using a given tokenizer.
     * @param tokenizer the tokenizer to use
     */
    public SimpleVectorGenerator(ITokenizer tokenizer) {
        this.terms = new ListOrderedMap();
        this.nestedTokenizer = tokenizer;
    }

    /**
     * @see net.sf.classifier4J.vectorspace.IVectorGenerator#getVector(java.lang.String)
     */
    public synchronized double[] getVector(String document) {
        //clear term map
        this.clear();
        //tokenize the input string according to the selected tokenizer
        String[] myterms = this.nestedTokenizer.tokenize(document);
        for (int i=0;i<myterms.length;i++) {
            //add each term to the term counter table
            this.addTerm(myterms[i]);
        }
        //create a vector with one entry for each known term 
        double[] vector = new double[this.terms.size()];
        int position = 0;
        //for each known term
        for (MapIterator i = this.terms.mapIterator();i.hasNext();) {
            i.next();
            //initialize the vector according to the number of terms found in the document
            vector[position] = ((Integer) i.getValue()).doubleValue();
            position++;
        }
        return vector;
    }
    /**
     * Adds a new term to the term list for this document
     * @param term the term to be added
     */
    private void addTerm(String term) {
        Integer count = (Integer) this.terms.get(term);
        if (count==null) {
            this.terms.put(term, new Integer(1));
        } else {
            this.terms.put(term, new Integer(count.intValue()+1));
        }
    }
    /**
     * Clears the term list, for a new document.
     */
    private void clear() {
        OrderedMap newmap = new ListOrderedMap();
        for (MapIterator i = this.terms.mapIterator();i.hasNext();) {
            //reinitialize the map using the old order, but with null values, because
            //no terms have been found so far
            newmap.put(i.next(), new Integer(0));
        }
        this.terms = newmap;
    }

}
