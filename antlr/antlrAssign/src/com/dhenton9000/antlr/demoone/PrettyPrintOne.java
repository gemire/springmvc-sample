package com.dhenton9000.antlr.demoone;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.antlr.demoone.assignment.Program;

public class PrettyPrintOne {
	private static Logger log = LogManager.getLogger(PrettyPrintOne.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ProgramLoader pM = new ProgramLoader();
		String fname = "samples/people.txt";
		try {

			Program p = pM.createProgamContainer(fname);
			String input = FileUtils.readFileToString(new File(fname));
			String outPut = "\nInput:\n" + input + "\n===================\n"
					+ "Output:\n\n" + p.toString();
			log.debug(outPut);

		} catch (IOException e) {
			log.error("IO problem " + fname);
		}

	}

}
