package com.dhenton9000.antlr.demoone.assignment;

import java.util.ArrayList;

public class Program  extends BaseComponent {

	private ArrayList<IfContainer> ifStatements = new ArrayList<IfContainer>();

	public ArrayList<IfContainer> getIfStatements() {
		return ifStatements;
	}
	
	public String toString()
	{
		String info = "";
		
		
		for (IfContainer ifF: getIfStatements())
		{
			info += ifF.toString();
		}
		
		
		
		
		return info;
	}
	
}
