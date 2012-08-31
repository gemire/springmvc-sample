package com.dhenton9000.antlr.demoone;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.antlr.demoone.assignment.IfContainer;
import com.dhenton9000.antlr.demoone.assignment.Program;
import com.dhenton9000.assign.lexers.Assign10Lexer;
import com.dhenton9000.assign.parsers.Assign10Parser;
import com.dhenton9000.assign.treewalker.AssignTreeWalker;

public class ProgramLoader {
	private static Logger log = LogManager.getLogger(ProgramLoader.class);

	public Program createProgamContainer(String fileNamePath) throws IOException
	{
		Tree tree = createTree(fileNamePath);
		Program result = loadFromTree(tree);
		return result;
	}
	
	
	
	protected Program loadFromTree(Tree tree) {
		Program programResult = new Program();
		
		for (int i=0;i< tree.getChildCount();i++)
		{
			Tree ifTree =  tree.getChild(i);
			IfContainer ifC = new IfContainer();
			ifC.loadFromTree(ifTree);
			//log.debug("\n"+ifC.toString());
			programResult.getIfStatements().add(ifC);
			
		}// end for if statements
		
		return programResult;
	}


	protected Tree createTree(String fileNamePath) throws IOException {

		Assign10Lexer lex = new Assign10Lexer(new ANTLRFileStream(fileNamePath,
				"UTF8"));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		Tree myTree = null;
		try {
			Assign10Parser parser = new Assign10Parser(tokens);
			Assign10Parser.program_return root = parser.program();
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(root
					.getTree());
			nodes.setTokenStream(tokens);
			AssignTreeWalker aG = new AssignTreeWalker(nodes);
			AssignTreeWalker.program_return pr = aG.program();

			myTree = (Tree) pr.getTree();
			//log.debug("\n" + myTree.toStringTree());

		} catch (RecognitionException e) {
			log.error("Recognition Problem", e);
		}
		return myTree;
	}

}
