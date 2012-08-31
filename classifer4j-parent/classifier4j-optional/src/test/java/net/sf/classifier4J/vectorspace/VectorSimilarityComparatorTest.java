package net.sf.classifier4J.vectorspace;

import net.sf.classifier4J.DefaultTokenizer;
import net.sf.classifier4J.ITokenizer;
import net.sf.classifier4J.vectorspace.VectorSimilarityComparator;
import junit.framework.TestCase;

/**
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public class VectorSimilarityComparatorTest extends TestCase {
    public void testGetSimilarity() {
        String doc1 = "das rote haus";
        String doc2 = "das blaue haus";
        String doc3 = "das blaue huhn";
        
        ITokenizer tokenizer = new DefaultTokenizer();
        IVectorGenerator generator = new CachingVectorGenerator(new SimpleVectorGenerator(tokenizer));
        VectorSimilarityComparator comp = new VectorSimilarityComparator(generator);
        
        assertEquals(2d/3d, comp.getSimilarity(doc1, doc2), 0.0001);
        assertEquals(2d/3d, comp.getSimilarity(doc2, doc1), 0.0001);
        assertEquals(2d/3d, comp.getSimilarity(doc2, doc3), 0.0001);
        assertEquals(2d/3d, comp.getSimilarity(doc3, doc2), 0.0001);
        assertEquals(1d/3d, comp.getSimilarity(doc1, doc3), 0.0001);
        assertEquals(1d/3d, comp.getSimilarity(doc3, doc1), 0.0001);
        assertEquals(1d, comp.getSimilarity(doc1, doc1), 0.0001);
        assertEquals(1d, comp.getSimilarity(doc2, doc2), 0.0001);
        assertEquals(1d, comp.getSimilarity(doc3, doc3), 0.0001);
    }
}
