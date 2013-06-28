package com.dhenton9000.demo.threads.sheep.consumer;

import org.apache.log4j.Logger;

import com.dhenton9000.demo.threads.sheep.ActionBase;
import com.dhenton9000.demo.threads.sheep.ISheepQueue;
 

public class SheepConsumer extends ActionBase implements ISheepConsumer {

	private static Logger log = Logger.getLogger(SheepConsumer.class);
	private ISheepQueue sheepQueue = null;

	

	@Override
	public void start() {
		 
		for (int j = 0; j < getInitialThreadCount(); j++) {

			SheepConsumerTask command = new SheepConsumerTask(j + 1, this);
			getSheepExcecutor().execute(command);
		}

	}



	public void setSheepQueue(ISheepQueue sheepQueue) {
		this.sheepQueue = sheepQueue;
	}



	public ISheepQueue getSheepQueue() {
		return sheepQueue;
	}



	
	

}
