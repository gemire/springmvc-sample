package com.dhenton9000.demo.threads.sheep.producer;

import org.apache.log4j.Logger;

import com.dhenton9000.demo.threads.sheep.ISheepQueue;
import com.dhenton9000.demo.threads.sheep.consumer.SheepConsumerTask;

public class QueueMonitorTask implements Runnable{
	
	private ISheepQueue sheepQueue = null;
	private volatile boolean forever = true;
	private long currentElapsedTime = System.currentTimeMillis();
	public static final long MONITOR_INTERVAL = 500;
	private static Logger log = Logger.getLogger(QueueMonitorTask.class);

	public QueueMonitorTask(ISheepQueue s) {
		
		sheepQueue = s;
		 
	}

	@Override
	public void run() {
		while (forever)
		{
			// milliseconds since last set
			long interval = System.currentTimeMillis() - currentElapsedTime;
			if (interval >  MONITOR_INTERVAL )
			{
				currentElapsedTime = System.currentTimeMillis();
				reportQueueSize();
				 
			}
			 
			
			
		}
	}

	private void reportQueueSize() {
		System.out.println("*****Queue Size is "+ sheepQueue.size()+"*****");
		
	}
	
	
	
	
	

}
