package net.sf.classifier4J.knearestneighbor;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public class ClassifiedDocumentTest extends TestCase {
    private ClassifiedDocument doc;
    protected void setUp() throws Exception {
        this.doc = new ClassifiedDocument("content", "category");
    }

    /*
     * Test method for 'net.sf.classifier4J.knearestneighbor.ClassifiedDocument.ClassifiedDocument(String, String)'
     */
    public void testClassifiedDocument() {
        assertEquals(new ClassifiedDocument("a", "b").getCategory(), "b");
        assertEquals(new ClassifiedDocument("b", "a").getContent(), "b");
    }

    /*
     * Test method for 'net.sf.classifier4J.knearestneighbor.ClassifiedDocument.getCategory()'
     */
    public void testGetCategory() {
        assertEquals(this.doc.getCategory(), "category");
    }

    /*
     * Test method for 'net.sf.classifier4J.knearestneighbor.ClassifiedDocument.setCategory(String)'
     */
    public void testSetCategory() {
        this.doc.setCategory("kategorie");
        assertEquals(this.doc.getCategory(), "kategorie");
    }

    /*
     * Test method for 'net.sf.classifier4J.knearestneighbor.ClassifiedDocument.getContent()'
     */
    public void testGetContent() {
        assertEquals(this.doc.getContent(), "content");
    }

    /*
     * Test method for 'net.sf.classifier4J.knearestneighbor.ClassifiedDocument.setContent(String)'
     */
    public void testSetContent() {
        this.doc.setContent("inhalt");
        assertEquals(this.doc.getContent(), "inhalt");

    }

    /*
     * Test method for 'net.sf.classifier4J.knearestneighbor.ClassifiedDocument.isCategory(String)'
     */
    public void testIsCategory() {
        assertTrue(this.doc.isCategory("category"));
    }

    /*
     * Test method for 'net.sf.classifier4J.knearestneighbor.ClassifiedDocument.toString()'
     */
    public void testToString() {
        assertEquals(this.doc.toString(), "category:content");
    }

}
