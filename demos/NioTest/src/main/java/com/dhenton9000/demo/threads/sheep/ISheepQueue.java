package com.dhenton9000.demo.threads.sheep;

import com.dhenton9000.demo.threads.sheep.producer.Sheep;

public interface ISheepQueue {

	
	public void addSheep(Sheep s);
	public Sheep removeSheep();
	public int size();
}
