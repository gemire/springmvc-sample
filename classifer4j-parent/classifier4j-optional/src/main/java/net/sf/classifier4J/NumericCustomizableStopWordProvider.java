package net.sf.classifier4J;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import net.sf.classifier4J.CustomizableStopWordProvider;


public class NumericCustomizableStopWordProvider extends  CustomizableStopWordProvider {
    
    public NumericCustomizableStopWordProvider() throws IOException {        
        super();       
    }
    
    public NumericCustomizableStopWordProvider(String resourceName) throws IOException {        
        super(resourceName);       
    }	
	
    @Override
    public boolean isStopWord(String word) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(word);
        if (m.matches()) {            
            return true;
        } else {
            return super.isStopWord(word);
        }
    }



}
