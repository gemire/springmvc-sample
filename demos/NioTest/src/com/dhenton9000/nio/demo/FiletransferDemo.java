package com.dhenton9000.nio.demo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FiletransferDemo {

	public static Logger log = LogManager.getLogger(FiletransferDemo.class);

	public void doTransferDemo() throws IOException {
		 
		RandomAccessFile fromFile = new RandomAccessFile("demo/transfer_in.txt", "rw");
		FileChannel      fromChannel = fromFile.getChannel();

		RandomAccessFile toFile = new RandomAccessFile("demo/transfer_out.txt", "rw");
		FileChannel      toChannel = toFile.getChannel();

		long position = 0;
		long count    = 10;
		//long count = 10;

		fromChannel.transferTo(position,count,toChannel);
		//toChannel.transferFrom(fromChannel, position, count)


	}

	 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FiletransferDemo bd = new FiletransferDemo();
		try {
			log.debug("begin");
			//bd.doBufferDemo();
			bd.doTransferDemo();
			log.debug("end");
		} catch (Exception e) {

			log.error("MAIN ERROR\n", e);
		}
	}

}
