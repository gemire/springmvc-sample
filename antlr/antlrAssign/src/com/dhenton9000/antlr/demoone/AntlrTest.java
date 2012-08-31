package com.dhenton9000.antlr.demoone;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


 
import com.dhenton9000.assign.lexers.Assign10Lexer;

 
import com.dhenton9000.assign.parsers.Assign10Parser;
import com.dhenton9000.assign.treewalker.AssignTreeWalker;
//import com.dhenton9000.assign.treewalker.AssignTreeWalker.program_return;



public class AntlrTest {

	private static Logger log = LogManager.getLogger(AntlrTest.class);
	
	public static void main(String args[]) throws Exception {
		Assign10Lexer lex = new Assign10Lexer(new ANTLRFileStream("samples/using.txt",
				"UTF8"));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		try {
			Assign10Parser parser = new Assign10Parser(tokens);
			Assign10Parser.program_return root = parser.program();
			//System.out
			//		.println("tree=" + ((Tree) root.getTree()).toStringTree());
			
			
			
			CommonTree t = (CommonTree) root.getTree();
			
			//System.out.println(t.toStringTree());
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(root.getTree());
			nodes.setTokenStream(tokens);			
			AssignTreeWalker aG = new AssignTreeWalker(nodes);
			 
			
			AssignTreeWalker.program_return pr = aG.program();
		
			Tree myTree = (Tree) pr.getTree();
			log.debug("\n"+myTree.toStringTree());
			
			
			
			
			
			
			
			
			
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
}