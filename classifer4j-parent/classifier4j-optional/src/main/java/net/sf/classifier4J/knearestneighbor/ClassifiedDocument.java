package net.sf.classifier4J.knearestneighbor;

/**
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *  This class acts as a wrapper for classified documents. It includes
 *  the category and the content of the document.
 */
public class ClassifiedDocument {
    private String content;
    private String category;
    /**
     * Creates a new classified document using a given string content and
     * a category.
     * @param content string content of the document
     * @param category category identificator
     */
    public ClassifiedDocument(String content, String category) {
        this.content = content;
        //always internalize category strings
        this.category = category.intern();
    }
    /**
     * Gets the category of the categorized document
     * @return the category
     */
    public String getCategory() {
        return this.category;
    }
    /**
     * Sets the category of the document. The category string is internalized
     * in order to achieve higher performance.
     * @param category catefory of the document
     */
    public void setCategory(String category) {
        //category strings are alway internalized
        this.category = category.intern();
    }
    /**
     * Gets the content of the document.
     * @return content of the document
     */
    public String getContent() {
        return this.content;
    }
    /**
     * Sets the content of the document
     * @param content content of the document
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * Finds out wether a document is categorized in a particular category
     * @param cat the category the document might belong to
     * @return true, if the document is part of the category
     */
    public boolean isCategory(String cat) {
        return (this.category==cat.intern());
    }
    /**
     * Creates a string representation for debugging purposes
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return this.category+":"+this.content; //$NON-NLS-1$
    }
}
