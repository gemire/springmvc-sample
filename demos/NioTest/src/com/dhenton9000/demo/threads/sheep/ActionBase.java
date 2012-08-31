package com.dhenton9000.demo.threads.sheep;

import java.util.concurrent.Executor;

public  class ActionBase {

	private long maxDelay = 0;
	private long minDelay = 0;
	private int initialThreadCount = 0;
	private Executor sheepExcecutor = null;
	


	public void setSheepExcecutor(Executor sheepExcecutor) {
		this.sheepExcecutor = sheepExcecutor;
	}

	public Executor getSheepExcecutor() {
		return sheepExcecutor;
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
	
	public void setInitialThreadCount(int initialThreadCount) {
		this.initialThreadCount = initialThreadCount;
	}

	public int getInitialThreadCount() {
		return initialThreadCount;
	}
}
