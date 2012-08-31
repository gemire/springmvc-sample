package com.dhenton9000.demo.threads.sheep.producer;

import com.dhenton9000.demo.threads.sheep.TaskBase;

public class SheepProducerTask extends TaskBase{

	private int threadId = 0;
	private ISheepProducer parent = null;
	private Sheep sheep = null;
	//volatile means 'modified by multiple threads' and create a synch block automagically
	// on itself
	private volatile boolean forever = true;
	private long currentElapsedTime = 0;

	
	public SheepProducerTask (int i,ISheepProducer p)
	{
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
				createSheep();
			}
			 
			
			
		}
		
		
		
		 
	}


	private void createSheep()
	{
		Sheep sheep = new Sheep();
		int sheepId = getParent().getnewSheepId();
		sheep.setName("s"+getThreadId()+"_"+sheepId);
		sheep.setId(sheepId);
		getParent().acceptNewSheep(this, sheep);
	}

	public void setThreadId(int id) {
		this.threadId = id;
	}



	public int getThreadId() {
		return threadId;
	}



	public void setParent(ISheepProducer parent) {
		this.parent = parent;
	}



	public ISheepProducer getParent() {
		return parent;
	}



	public boolean isForever() {
		return forever;
	}



	public void setForever(boolean forever) {
		this.forever = forever;
	}



	public Sheep getSheep() {
		return sheep;
	}





}
