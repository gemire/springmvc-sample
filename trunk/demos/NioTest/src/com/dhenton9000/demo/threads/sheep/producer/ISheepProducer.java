package com.dhenton9000.demo.threads.sheep.producer;

import com.dhenton9000.demo.threads.sheep.ISheepTask;

public interface ISheepProducer extends ISheepTask {

	//handles the creation of a sheep
	public void acceptNewSheep(SheepProducerTask sheepProducerTask, Sheep sheep);
	//gets a unique sheep id
	public int getnewSheepId();
	

	
	
	
	
}
