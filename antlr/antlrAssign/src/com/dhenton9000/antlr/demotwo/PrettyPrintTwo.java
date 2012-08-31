package com.dhenton9000.antlr.demotwo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

 
import com.dhenton9000.assign.lexers.AssignLexer;
import com.dhenton9000.assign.lexers.AssignNWSLexer;
import com.dhenton9000.assign.parsers.AssignNWSParser;
import com.dhenton9000.assign.parsers.AssignParser;
import com.dhenton9000.assign.treewalker.AssignTreeTmplWalker;
import com.dhenton9000.assign.treewalker.AssignTreeTmplWalkerNWS;

public class PrettyPrintTwo {
	private static Logger log = LogManager.getLogger(PrettyPrintTwo.class);

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws IOException  {
		log.debug("start");
		FileReader groupFileR = new FileReader("src/com/dhenton9000/antlr/demotwo/pprint.stg");
		StringTemplateGroup templates = new StringTemplateGroup(groupFileR);
		
		AssignNWSLexer lex = new AssignNWSLexer(new ANTLRFileStream("samples/people.txt",
		"UTF8"));
		try {
		CommonTokenStream tokens = new CommonTokenStream(lex);
		AssignNWSParser parser = new AssignNWSParser(tokens);
		AssignNWSParser.program_return root = parser.program();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(root
				.getTree());
		nodes.setTokenStream(tokens);
		AssignTreeTmplWalkerNWS aG = new AssignTreeTmplWalkerNWS(nodes);
		aG.setTemplateLib(templates);
		AssignTreeTmplWalkerNWS.program_return pr = aG.program();
		Object out = pr.getTemplate();
		log.debug("\n\n"+out.toString());

		
		log.debug("done");
		 
	} catch (RecognitionException e) {
		log.error("Recognition Problem", e);
	 
	}
	}
}
