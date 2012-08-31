package com.dhenton9000.demo.threads.sheep.consumer;

import com.dhenton9000.demo.threads.sheep.ISheepQueue;
import com.dhenton9000.demo.threads.sheep.ISheepTask;







public interface ISheepConsumer extends ISheepTask {


	public void start();
	public ISheepQueue getSheepQueue();
	 
	
}
