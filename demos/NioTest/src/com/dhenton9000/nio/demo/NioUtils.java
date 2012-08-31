package com.dhenton9000.nio.demo;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class NioUtils {

	 
	public static Logger log = LogManager.getLogger(NioUtils.class);
	public static final String DEFAULT_ENCODING = "UTF-8";
	public static final Charset charset  = Charset.forName(DEFAULT_ENCODING);

	public static ByteBuffer stringToByteBuffer(String msg)
			throws CharacterCodingException {
		CharsetEncoder encoder = charset.newEncoder();

		return encoder.encode(CharBuffer.wrap(msg));

	}

	public static String byteArrayToString(byte[] byteArray) throws UnsupportedEncodingException {
		String value = new String(byteArray,DEFAULT_ENCODING);
		return value;

	}
	
	public static String byteArrayToString(byte[] byteArray,String encoding) throws UnsupportedEncodingException {
		String value = new String(byteArray,encoding);
		return value;

	}

	public static String byteBufferToString(ByteBuffer buffer)
			throws CharacterCodingException {
		String data = "";
		CharsetDecoder decoder = charset.newDecoder();

		// the flip operation will change state of the buffer
		// so preserve that state and reinstate it

		int old_position = buffer.position();
		int old_limit = buffer.limit();

		buffer.flip();
		data = decoder.decode(buffer).toString();
		// reset buffer's position and limit to its original
		// so it is not altered:

		buffer.position(old_position);
		buffer.limit(old_limit);

		return data;
	}
}

/*
 * 
 * 
 
 */
