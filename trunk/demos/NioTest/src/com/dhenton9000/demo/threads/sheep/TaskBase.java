package com.dhenton9000.demo.threads.sheep;

import java.util.Random;

import com.dhenton9000.demo.threads.sheep.consumer.ISheepConsumer;
import com.dhenton9000.demo.threads.sheep.producer.ISheepProducer;

public abstract class TaskBase implements Runnable {
	private long threadStartTime = System.currentTimeMillis();
	private long delay = 2000; // the milliseconds that the thread will wait
								// before producing a sheep
	private Random ran = new Random(threadStartTime);
	public long maxDelay = 0;
	public long minDelay = 0;

	public TaskBase(ISheepTask p) {
		this.setMaxDelay(p.getMaxDelay());
		this.setMinDelay(p.getMinDelay());
	}

	 
	
	
	public long getThreadStartTime() {
		return threadStartTime;
	}

	public long getDelay() {
		return delay;
	}

	public void calculateNewDelay() {

		delay = ran.nextInt((int) getMaxDelay()) + getMinDelay();

	}

	public long getMaxDelay() {
		return maxDelay;
	}

	public void setMaxDelay(long maxDelay) {
		this.maxDelay = maxDelay;
	}

	public long getMinDelay() {
		return minDelay;
	}

	public void setMinDelay(long minDelay) {
		this.minDelay = minDelay;
	}

}
