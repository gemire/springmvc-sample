package com.dhenton9000.demo.threads.sheep.queues;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.dhenton9000.demo.threads.sheep.ISheepQueue;
import com.dhenton9000.demo.threads.sheep.producer.Sheep;
import com.dhenton9000.demo.threads.sheep.producer.SheepProducer;

public class NonConcurrentSheepQueue implements ISheepQueue {
	private static Logger log = Logger.getLogger(NonConcurrentSheepQueue.class);
	
	private LinkedList<Sheep> queue = new LinkedList<Sheep>();
	
	
	
	@Override
	public void addSheep(Sheep s) {
		
		//log.debug("adding "+s);
		queue.add(s);
	}

	@Override
	public Sheep removeSheep() {
		
		Sheep s = null;
		//if this isn't synchronized, thread A can pass thru here (queue.size > 0)
		//and thread B empties the queue before it gets to the next command,
		//so thread A errors with NoSuchElementException
		//on the next command -- removeFirst();
		//producer at 400/700 consumer at 40/70
		
		if (queue.size() > 0)
			s = queue.removeFirst();
		return s;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if (queue == null)
			return 0;
		else
			return queue.size();
	}

}
