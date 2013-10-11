package com.dhenton9000.spring.demos.demobeans;

import java.util.ArrayList;

public class Zoo {

	private ArrayList<Creature> creatures = new ArrayList<Creature>();

	public ArrayList<Creature> getCreatures() {
		ArrayList<Creature> t =    new ArrayList<Creature>();
		t.addAll(creatures);
		return t;
	}

	public void setCreatures(ArrayList<Creature> c) {
		
		creatures.addAll(c);
	}
	
	
	
	
	
}
