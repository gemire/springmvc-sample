package net.sf.classifier4J.knearestneighbor;

import net.sf.classifier4J.ClassifierException;
import net.sf.classifier4J.DefaultTokenizer;
import net.sf.classifier4J.ITokenizer;
import net.sf.classifier4J.bayesian.WordsDataSourceException;
import net.sf.classifier4J.vectorspace.CachingVectorGenerator;
import net.sf.classifier4J.vectorspace.IVectorGenerator;
import net.sf.classifier4J.vectorspace.SimpleVectorGenerator;
import net.sf.classifier4J.vectorspace.VectorSimilarityComparator;
import junit.framework.TestCase;

/**
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public class KNearestNeighborClassifierTest extends TestCase {
    private KNearestNeighborClassifier classifier;
    protected void setUp() throws Exception {
        ITokenizer tokenizer = new DefaultTokenizer();
        IVectorGenerator generator = new CachingVectorGenerator(new SimpleVectorGenerator(tokenizer));
        ISimilarityCalculator comp = new VectorSimilarityComparator(generator);
        
        this.classifier = new KNearestNeighborClassifier(2, comp);
        this.classifier.teachMatch("building", "das rote haus");
        this.classifier.teachMatch("building", "das blaue haus");
        this.classifier.teachMatch("building", "mein haus ist mein schloss");
        this.classifier.teachMatch("building", "mein haus ist mein haus");
        this.classifier.teachMatch("building", "das haus ist rot");
        this.classifier.teachMatch("building", "das haus ist blau");
        this.classifier.teachMatch("avian", "das huhn hat husten");
        this.classifier.teachMatch("avian", "das huhn hat schnupfen");
        this.classifier.teachMatch("avian", "mein huhn");
        this.classifier.teachMatch("avian", "dein huhn");
        this.classifier.teachMatch("avian", "unser huhn");
    }

    /*
     * Test method for 'net.sf.classifier4J.knearestneighbor.KNearestNeighborClassifier.getCategory(String)'
     */
    public void testGetCategory() {
        assertEquals("building", this.classifier.getCategory("das rote haus"));
        assertEquals("building", this.classifier.getCategory("mein rotes haus"));
        assertEquals("building", this.classifier.getCategory("mein schones haus"));
        assertEquals("building", this.classifier.getCategory("mein haus ist ein haus"));
        assertEquals("building", this.classifier.getCategory("unser haus"));
        
        assertEquals("avian", this.classifier.getCategory("das huhn"));
        assertEquals("avian", this.classifier.getCategory("das huhn macht buh"));
        assertEquals("avian", this.classifier.getCategory("das huhn ist mein huhn"));
        assertEquals("avian", this.classifier.getCategory("das huhn sagt hallo"));
    }
    
    public void testKNearestNeighborClassifier() {
        assertNotNull(new KNearestNeighborClassifier(new ISimilarityCalculator(){

            public double getSimilarity(String document1, String document2) {
                return 0;
            }}));
        assertNotNull(new KNearestNeighborClassifier(1, new ISimilarityCalculator(){

            public double getSimilarity(String document1, String document2) {
                return 0;
            }}));
    }
    
    public void testClassify() throws WordsDataSourceException, ClassifierException {
        assertEquals(0, this.classifier.classify("mein kleines huhn"), 0d);
        assertEquals(1, this.classifier.classify("avian","das huhn"), 0d);
    }
    
    public void testIsMatch() {
        assertEquals(true, this.classifier.isMatch("avian","das huhn"));
        assertEquals(false, this.classifier.isMatch("avian","das haus"));
    }
    
    public void testSetMatchCutoff() {
        this.classifier.setMatchCutoff(0);
    }
    
    public void testTeachNonMatch() {
        this.classifier.teachNonMatch("avian", "das huhn hat husten");
        this.classifier.teachNonMatch("avian", "das huhn hat schnupfen");
        this.classifier.teachNonMatch("avian", "mein huhn");
        this.classifier.teachNonMatch("avian", "dein huhn");
        this.classifier.teachNonMatch("avian", "unser huhn");
        assertEquals(false, this.classifier.isMatch("avian","das huhn"));
    }

}
