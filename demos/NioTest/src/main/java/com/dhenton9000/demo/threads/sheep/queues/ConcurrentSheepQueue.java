package com.dhenton9000.demo.threads.sheep.queues;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.dhenton9000.demo.threads.sheep.ISheepQueue;
import com.dhenton9000.demo.threads.sheep.producer.Sheep;
import com.dhenton9000.demo.threads.sheep.producer.SheepProducer;

public class ConcurrentSheepQueue implements ISheepQueue {
	private static Logger log = Logger.getLogger(ConcurrentSheepQueue.class);
	
	private LinkedBlockingQueue<Sheep> queue = new LinkedBlockingQueue<Sheep>();
	
	 
	
	@Override
	public void addSheep(Sheep s) {
		
		log.debug("adding "+s);
		try {
			queue.put(s);
		} catch (InterruptedException e) {
			throw new RuntimeException("Interrupt problem: "+e.getMessage());
		}
	}

	@Override
	public Sheep removeSheep() {
		
		Sheep s = null;
		if (queue.size() > 0)
		{
			try {
				s = queue.take();
				log.debug("removing "+s);
			} catch (InterruptedException e) {
				throw new RuntimeException("Interrupt problem: "+e.getMessage());
			}
		}
			
		return s;
	}

	@Override
	public int size() {
		
		if (queue == null)
			return 0;
		else
			return queue.size();
	}

}
