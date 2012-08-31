package com.dhenton9000.demo.threads.sheep.producer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.log4j.Logger;
import com.dhenton9000.demo.threads.sheep.ActionBase;
import com.dhenton9000.demo.threads.sheep.ISheepQueue;
import com.dhenton9000.demo.threads.sheep.consumer.ISheepConsumer;

/**
 * This class will produce a random number of sheep and will pass it off to the
 * sheep handler. The handler must be present for the Producer to produce as it
 * does not have any place to put the sheep
 * 
 * @author dhh
 * 
 */
public class SheepProducer extends ActionBase implements ISheepProducer {

	private int sheepCounter = 0;
	private static Logger log = Logger.getLogger(SheepProducer.class);
	private final Lock idLock = new ReentrantLock();
	private ISheepConsumer consumer = null;
	private ISheepQueue sheepQueue = null;

	/**
	 * initialize the demo
	 */
	public void start() {
		
		// start the consumers
		consumer.start();
		
		
		//start the monitor thread
		QueueMonitorTask monitorTask = new QueueMonitorTask(getSheepQueue());
		getSheepExcecutor().execute(monitorTask);
		
		// start the producers
		for (int j = 1; j < getInitialThreadCount(); j++) {

			SheepProducerTask command = new SheepProducerTask(j, this);
			getSheepExcecutor().execute(command);
		}
		
		
	}

	/**
	 * handle the creation of a new sheep
	 */
	@Override
	public void acceptNewSheep(SheepProducerTask sheepProducerTask, Sheep sheep) {
		getSheepQueue().addSheep(sheep);

	}

	
	@Override
	public int getnewSheepId() {
		idLock.lock();
		try {
			sheepCounter++;
			return sheepCounter;
		} finally {
			idLock.unlock();
		}
	}

	public void setConsumer(ISheepConsumer consumer) {
		this.consumer = consumer;
	}

	public ISheepConsumer getConsumer() {
		return consumer;
	}

	public void setSheepQueue(ISheepQueue sheepQueue) {
		this.sheepQueue = sheepQueue;
	}

	public ISheepQueue getSheepQueue() {
		return sheepQueue;
	}

	 
	
	
	// try this to see a proper lock with synchronized keyword
	// public synchronized int getnewSheepId() {
	//				
	// sheepCounter++;
	// return sheepCounter;
	// }
	
	
	//  try this to see some threads fail to get a lock and settle for the default
	//	public int getnewSheepId() {
	//		boolean triedLock = idLock.tryLock();
	//
	//		if (triedLock) {
	//			try {
	//				sheepCounter++;
	//				return sheepCounter;
	//			} finally {
	//				idLock.unlock();
	//			}
	//		} else {
	//			return -9;
	//		}
	//
	//	}
	
	
	// this results in duplicate ids being issued
	
	// public int getnewSheepId() {
	//					
	// sheepCounter++;
	// return sheepCounter;
	// }

}
