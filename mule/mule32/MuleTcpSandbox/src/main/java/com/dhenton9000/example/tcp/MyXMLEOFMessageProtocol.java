/*
 * $Id: XmlMessageEOFProtocol.java 20321 2010-11-24 15:21:24Z dfeist $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.dhenton9000.example.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.mule.transport.tcp.protocols.AbstractByteProtocol;
import org.mule.transport.tcp.protocols.XmlMessageProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extend {@link org.mule.transport.tcp.protocols.XmlMessageProtocol} to
 * continue reading until either a new message or EOF is found. A new message is
 * defined by an endtag (xmlPattern) in the form of '</endtag>' set in the
 * spring config.<br> The buffer size is also set in the config, as it needs to
 * be somewhat less than a full message to force rereading the buffer
 */
public class MyXMLEOFMessageProtocol extends AbstractByteProtocol {

    private ConcurrentMap pbMap = new ConcurrentHashMap();
    private static final Logger logger = LoggerFactory.getLogger(MyXMLEOFMessageProtocol.class);
    private int readBufferSize = 50;
    private String xmlPattern = "</message>";

    public MyXMLEOFMessageProtocol() {
        super(STREAM_OK);

    }

    public Object read(InputStream is) throws IOException {
        PushbackInputStream pbis = (PushbackInputStream) pbMap.get(is);
        if (null == pbis) {

            logger.debug("no pbis creating it ");
            pbis = new PushbackInputStream(is, getReadBufferSize() * 2);
            PushbackInputStream prev = (PushbackInputStream) pbMap.putIfAbsent(is, pbis);
            pbis = null == prev ? pbis : prev;
        } else {
            logger.debug("found stream in map");
        }

        int len = -1;
        try {
            // read until xml pattern is seen (and then pushed back) or no more data
            // to read. return all data as message
            logger.debug("in try ");
            byte[] buffer = new byte[getReadBufferSize()];
            logger.debug("in try 2");
            StringBuffer message = new StringBuffer(getReadBufferSize());
            int patternIndex = -1;
            boolean repeat;
            logger.debug("in try 4");

            do {
                logger.debug("top of do loop");
                try {
                    len = safeRead(pbis, buffer);
                } catch (Exception e) {
                    logger.error("saferead error " + e.getClass().getName() + " " + e.getMessage());
                }
                logger.debug("read " + len + " bytes in saferead");
                if (len >= 0) {
                    logger.debug("len > 0 so appending to message");
                    // TODO take encoding into account, ideally from the incoming XML
                    message.append(new String(buffer, 0, len));
                    logger.debug("message is now '" + message.toString() + "'");
                    // start search at 2nd character in buffer (index=1) to
                    // indicate whether we have reached a new document.
                    patternIndex = message.toString().indexOf(getXmlPattern(), 1);
                    logger.debug("pattern index of message " + patternIndex);
                    repeat = isRepeat(patternIndex, len, pbis.available());
                    logger.debug("repeat is now " + repeat);
                } else {
                    // never repeat on closed stream (and avoid calling available)
                    logger.debug("len == 0 so repeat false");
                    repeat = false;
                }

            } while (repeat);
            logger.debug("out of while loop with patternIndex of " + patternIndex);
            if (patternIndex > 0) {
                // push back the start of the next message and
                // ignore the pushed-back characters in the return buffer
                logger.debug("cleaning up collection");
                logger.debug("pbis resetting\n'" + message.substring(patternIndex, message.length()) + "'");
                pbis.unread(message.substring(patternIndex, message.length()).getBytes());
                logger.debug("message before set length\n'" + message.toString());
                logger.debug("pattern index " + patternIndex);
                logger.debug("xmlpattern length " + getXmlPattern().length());
                logger.debug("set length to " + (patternIndex + getXmlPattern().length()));

                message.setLength(patternIndex + getXmlPattern().length());
                logger.debug("message after set length\n'" + message.toString());

                // now chop off the first item
                if (message.toString().indexOf(getXmlPattern()) == 0) {
                    message = (new StringBuffer()).append(message.substring(getXmlPattern().length()));
                }
                logger.debug("message is finally '" + message.toString() + "'");
            }

            // TODO encoding here, too...
            return nullEmptyArray(message.toString().getBytes());

        } finally {


            // clear from map if stream has ended
            if (len < 0) {
                pbMap.remove(is);
            }
        }
    }

    /**
     * Continue reading til EOF or new document found
     *
     * @param patternIndex The index of the xml tag (or -1 if the next message
     * not found)
     * @param len The amount of data read this loop (or -1 if EOF)
     * @param available The amount of data available to read
     * @return true if the read should continue
     */
    protected boolean isRepeat(int patternIndex, int len, int available) {
        return patternIndex < 0;
    }

    /**
     * @return the xmlPattern
     */
    public String getXmlPattern() {

        return xmlPattern;
    }

    /**
     * @param xmlPattern the xmlPattern to set
     */
    public void setXmlPattern(String xmlPattern) {

        this.xmlPattern = xmlPattern;
    }

    /**
     * @return the readBufferSize
     */
    public int getReadBufferSize() {
        return readBufferSize;
    }

    /**
     * @param readBufferSize the readBufferSize to set
     */
    public void setReadBufferSize(int readBufferSize) {
        this.readBufferSize = readBufferSize;
    }
}
