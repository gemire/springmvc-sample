package net.sf.classifier4J;

import java.io.StringReader;

import net.sf.classifier4J.DefaultTokenizer;

import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.InputSource;

/**
 * <p>HTML Tokenizer, using TagSoup HTML parser.</p>
 * 
 * @author nlothian
 *
 */
public class HTMLTokenizer extends DefaultTokenizer {

    private boolean ignoreHeadItems = false;
    private boolean ignoreTextBeforeFirstParagraph = false;
    private boolean onlyLookInParagraphs = false;    
    
    
    public HTMLTokenizer() {
        super();
    }
    
    public HTMLTokenizer(boolean ignoreHeadItems, boolean ignoreTextBeforeFirstParagraph, boolean onlyLookInParagraphs) {
        this();
        this.ignoreHeadItems = ignoreHeadItems;
        this.ignoreTextBeforeFirstParagraph = ignoreTextBeforeFirstParagraph;
        this.onlyLookInParagraphs = onlyLookInParagraphs;
    }
    
    public boolean isIgnoreHeadItems() {
        return ignoreHeadItems;
    }
    

    public void setIgnoreHeadItems(boolean ignoreHeadItems) {
        this.ignoreHeadItems = ignoreHeadItems;
    }
    

    public boolean isIgnoreTextBeforeFirstParagraph() {
        return ignoreTextBeforeFirstParagraph;
    }
    

    public void setIgnoreTextBeforeFirstParagraph(
            boolean ignoreTextBeforeFirstParagraph) {
        this.ignoreTextBeforeFirstParagraph = ignoreTextBeforeFirstParagraph;
    }
    

    public boolean isOnlyLookInParagraphs() {
        return onlyLookInParagraphs;
    }
    

    public void setOnlyLookInParagraphs(boolean onlyLookInParagraphs) {
        this.onlyLookInParagraphs = onlyLookInParagraphs;
    }    
    
    public String[] tokenize(String text) {
        StringBuffer buffer = new StringBuffer();
        TextExtractor textExtractor = new TextExtractor(buffer); 
        Parser parser = new org.ccil.cowan.tagsoup.Parser();
        parser.setContentHandler(textExtractor);
        try {
            parser.parse(new InputSource(new StringReader(text)));
            return super.tokenize(buffer.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String deHTMLEscape(String aTagFragment) {
        if (aTagFragment == null) {
            return "";
        } else {
            return aTagFragment.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;", "\"").replaceAll("&#039;", "\'");
        }
    }
    
}
