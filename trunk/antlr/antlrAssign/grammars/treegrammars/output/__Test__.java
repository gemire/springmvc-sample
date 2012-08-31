import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        AssignLexer lex = new AssignLexer(new ANTLRFileStream("C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\samples\\people.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);


        AssignParser parser = new AssignParser(tokens);
        AssignParser.program_return r = parser.program();
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(r.getTree());


        AssignTreeTmplWalker walker = new AssignTreeTmplWalker(nodes);
        try {
            walker.program();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }

    }

}