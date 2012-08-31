package com.dhenton9000.antlr.assignment;

import java.io.IOException;


import com.dhenton9000.antlr.demoone.ProgramLoader;
import com.dhenton9000.antlr.demoone.assignment.Program;

 

public class BaseTest {

	
	protected Program getSampleProgram(String fileNamePath) throws IOException
	{
		ProgramLoader pL = new ProgramLoader();
		return pL.createProgamContainer(fileNamePath);
		
	}
	
	
	
}
