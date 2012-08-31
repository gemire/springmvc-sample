import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import com.dhenton9000.assign.parsers.*;
import com.dhenton9000.assign.lexers.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        AssignNWSLexer lex = new AssignNWSLexer(new ANTLRFileStream("C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\samples\\people.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        AssignNWSParser g = new AssignNWSParser(tokens, 49100, null);
        try {
            g.program();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}