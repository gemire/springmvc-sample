package com.dhenton9000.nio.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BufferDemo {

	public static Logger log = LogManager.getLogger(BufferDemo.class);

	public void doBufferDemo() throws IOException {
		FileInputStream fcin = new FileInputStream("demo/read.txt");
		
		FileChannel fc_in = fcin.getChannel();
		FileChannel fc_out = fcin.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc_in.read(buffer);
		String t = NioUtils.byteBufferToString(buffer);
		log.debug("file contents: "+t);
		log.debug("position  a " + buffer.position());
		log.debug("limit  a " + buffer.limit());


		
		
		fc_in.close();
		fcin.close();
		fc_out.close();
		

	}

	public void doReadInWriteOut() throws IOException
	{
		FileOutputStream fcout = new FileOutputStream("demo/out_read.txt");
		FileInputStream fcin = new FileInputStream("demo/read.txt");
		
		FileChannel fc_in = fcin.getChannel();
		FileChannel fc_out = fcout.getChannel();
		
		
		
		ByteBuffer buffer = ByteBuffer.allocate((int) fc_in.size());
		fc_in.read(buffer);
		buffer.flip();
		fc_out.write(buffer);
		
		fc_in.close();
		fcin.close();
		fc_out.close();
		fcout.close();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferDemo bd = new BufferDemo();
		try {
			log.debug("begin");
			//bd.doBufferDemo();
			bd.doReadInWriteOut();
			log.debug("end");
		} catch (Exception e) {

			log.error("MAIN ERROR\n", e);
		}
	}

}
