package com.dhenton9000.demo.threads.sheep.consumer;

import org.apache.log4j.Logger;
import com.dhenton9000.demo.threads.sheep.ISheepQueue;
import com.dhenton9000.demo.threads.sheep.TaskBase;
import com.dhenton9000.demo.threads.sheep.producer.Sheep;

public class SheepConsumerTask extends TaskBase {

	private int threadId = 0;
	private ISheepConsumer parent = null;
	private volatile boolean forever = true;
	private long currentElapsedTime = 0;
	private static Logger log = Logger.getLogger(SheepConsumerTask.class);

	public SheepConsumerTask(int i, ISheepConsumer p) {
		super(p);
		setThreadId(i);
		setParent(p);
		calculateNewDelay();
		currentElapsedTime = this.getThreadStartTime();
		
	}

	@Override
	public void run() {
		while (forever)
		{
			// milliseconds since last set
			long interval = System.currentTimeMillis() - currentElapsedTime;
			if (interval > getDelay())
			{
				currentElapsedTime = System.currentTimeMillis();
				calculateNewDelay();
				consumeSheep();
			}
			 
			
			
		}
		
	}
	
	private void consumeSheep()
	{
		ISheepQueue queue = getParent().getSheepQueue();
		Sheep s = null;
		
		try {
			queue.removeSheep();
		} catch (Exception e) {
			log.error("removeSheep problem: "+e.getMessage(),e);
		}
		
		String info = "";
		if (s == null)
			info = "null";
		else
			info = s.toString();
		
		//log.debug("thread "+getThreadId()+" is removing "+info);
	}
	

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setParent(ISheepConsumer parent) {
		this.parent = parent;
	}

	public ISheepConsumer getParent() {
		return parent;
	}

}
