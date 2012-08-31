package net.sf.classifier4J;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class TextExtractor extends DefaultHandler {

    private StringBuffer buffer;

    private boolean ignoreHeadItems = false;
    private boolean ignoreTextBeforeFirstParagraph = false;
    private boolean onlyLookInParagraphs = false;
    
    // state
    boolean inComment = false;
    boolean inScript = false;
    boolean inSelect = false;
    boolean inStyle = false;
    
    boolean inHead = false;
    
    boolean inTD = false;
    
    boolean inParagraph = false;
    boolean pastFirstParagraph = false;
    
    // inline elements
    boolean inBold = false;
    boolean inItalic = false;
    boolean inEmphasis = false;
    boolean inUnderline = false;
    boolean inLink = false;
    boolean inSpan = false;    
    // end inline elements

    public TextExtractor() {
        super();
    }
    
    public TextExtractor(StringBuffer buffer) {
        this();
        this.buffer = buffer;
    }    
    
    public TextExtractor(StringBuffer buffer, boolean ignoreHeadItems, boolean ignoreTextBeforeFirstParagraph, boolean onlyLookInParagraphs) {
        this(buffer);
        this.ignoreHeadItems = ignoreHeadItems;
        this.ignoreTextBeforeFirstParagraph = ignoreTextBeforeFirstParagraph;
        this.onlyLookInParagraphs = onlyLookInParagraphs;
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
    


    public boolean isIgnoreHeadItems() {
        return ignoreHeadItems;
    }
    

    public void setIgnoreHeadItems(boolean ignoreHeadItems) {
        this.ignoreHeadItems = ignoreHeadItems;
    }
    
    
    protected void setState(String localName, boolean startElement) {
        if ("script".equalsIgnoreCase(localName)) {
            inScript = startElement;
        } else if ("select".equalsIgnoreCase(localName)) {
            inSelect = startElement;
        } else if ("b".equalsIgnoreCase(localName)) {
            inBold = startElement;
        } else if ("i".equalsIgnoreCase(localName)) {
            inItalic = startElement;
        } else if ("em".equalsIgnoreCase(localName)) {
            inEmphasis = startElement;
        } else if ("ul".equalsIgnoreCase(localName)) {
            inLink = startElement;            
        } else if ("a".equalsIgnoreCase(localName)) {
            inLink = startElement;
        } else if ("span".equalsIgnoreCase(localName)) {
            inSpan = startElement;
        } else if ("head".equalsIgnoreCase(localName)) {
            inHead = startElement;
        } else if ("style".equalsIgnoreCase(localName)) {
            inStyle = startElement;            
        } else if ("p".equalsIgnoreCase(localName)) {
            inParagraph = startElement;
            pastFirstParagraph = true;
        } else if ("br".equalsIgnoreCase(localName)) {
            buffer.append(". ");
        } else if ("td".equalsIgnoreCase(localName)) {
            inTD = startElement;
            if (!startElement) {
                // at the end of a table field, treat as a new sentence
                buffer.append(". ");
            }
            
        }
    }    

    public void startElement(String uri, String localName, String qName, Attributes attributes)  throws SAXException {
        setState(localName, true); 
 
        super.startElement(uri, localName, qName, attributes);
    }


    
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        setState(localName, false); 
        
        super.endElement(uri, localName, qName);
    }


    public void characters(char[] chars, int start, int length) throws SAXException {        
        if (isIncludedText(chars)) {            
            String str = (String) new String(chars).subSequence(start, start + length);
            
            int commentStart = str.indexOf("<!--");
            if (commentStart >= 0) {
                inComment = true;
                str = str.substring(0, commentStart);
            }
            
            if (inComment) {
                int commentEnd = str.indexOf("-->");
                if (commentEnd >= 0) {
                    str = str.substring(commentEnd, str.length());
                    inComment = false;
                }
            }
                        
            buffer.append(str.replaceAll("(&.*;)|(#.*;)", "'").replaceAll("\\s", " ").trim()); 
            if (!inInlineElement()) {
                buffer.append(". ");
            } else {
                buffer.append(" ");
            }
            
        }
    }

    private boolean isIncludedText(char[] chars) {
        boolean result = !inScript && !inSelect && !inStyle && chars.length > 0;
        
        if (isOnlyLookInParagraphs()) {
            result = result && inParagraph;
        }
        
        if (isIgnoreTextBeforeFirstParagraph()) {
            result = result && pastFirstParagraph;
        }
        
        if (isIgnoreHeadItems()) {
            return !inHead && result;
        } else {
            return result;
        }
    }

    protected boolean inInlineElement() {
        return (inBold || inItalic || inEmphasis || inUnderline || inLink || inSpan);
    }

}
