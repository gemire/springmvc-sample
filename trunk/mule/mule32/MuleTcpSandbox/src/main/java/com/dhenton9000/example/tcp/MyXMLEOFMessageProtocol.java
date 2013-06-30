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
 * continue reading until either a new message or EOF is found.
 */
public class MyXMLEOFMessageProtocol extends AbstractByteProtocol {

    private static final String XML_PATTERN = "<?xml";
    private static final int READ_BUFFER_SIZE = 4096;
    private static final int PUSHBACK_BUFFER_SIZE = READ_BUFFER_SIZE * 2;
    private ConcurrentMap pbMap = new ConcurrentHashMap();
    private static final Logger logger = LoggerFactory.getLogger(MyXMLEOFMessageProtocol.class);

    public MyXMLEOFMessageProtocol() {
        super(STREAM_OK);
        this.setRethrowExceptionOnRead(true);
    }

    public Object read(InputStream is) throws IOException {
        PushbackInputStream pbis = (PushbackInputStream) pbMap.get(is);
        if (null == pbis) {
            
            logger.debug("no pbis creating it ");
            pbis = new PushbackInputStream(is, PUSHBACK_BUFFER_SIZE);
            PushbackInputStream prev = (PushbackInputStream) pbMap.putIfAbsent(is, pbis);
            pbis = null == prev ? pbis : prev;
        }
        else
        {
            logger.debug("found stream in map");
        }

        int len = -1;
        try {
            // read until xml pattern is seen (and then pushed back) or no more data
            // to read. return all data as message
            logger.debug("in try ");
            byte[] buffer = new byte[READ_BUFFER_SIZE];
            logger.debug("in try 2");
            StringBuffer message = new StringBuffer(READ_BUFFER_SIZE);
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
                    patternIndex = message.toString().indexOf(XML_PATTERN, 1);
                    logger.debug("pattern index of message " + patternIndex);
                    repeat = isRepeat(patternIndex, len, pbis.available());
                    logger.debug("repeat is now " + repeat);
                } else {
                    // never repeat on closed stream (and avoid calling available)
                    logger.debug("len == 0 so repeat false");
                    repeat = false;
                }

            } while (repeat);
            logger.debug("out of while loop with patternIndex of "+patternIndex);
            if (patternIndex > 0) {
                // push back the start of the next message and
                // ignore the pushed-back characters in the return buffer
                logger.debug("cleaning up collection");
                pbis.unread(message.substring(patternIndex, message.length()).getBytes());
                message.setLength(patternIndex);
            }

            // TODO encoding here, too...
            return nullEmptyArray(message.toString().getBytes());

        } finally {
            // TODO - this doesn't seem very reliable, since loop above can end
            // without EOF.  On the other hand, what else can we do?  Entire logic
            // is not very dependable, IMHO.  XmlMessageEOFProtocol is more likely
            // to be correct here, I think.

            // clear from map if stream has ended
            if (len < 0) {
                pbMap.remove(is);
            }
        }
    }

    /**
     * Show we continue reading? This class, following previous implementations,
     * only reads while input is saturated.
     *
     * @see XmlMessageEOFProtocol
     *
     * @param patternIndex The index of the xml tag (or -1 if the next message
     * not found)
     * @param len The amount of data read this loop (or -1 if EOF)
     * @param available The amount of data available to read
     * @return true if the read should continue
     */
    protected boolean isRepeatOne(int patternIndex, int len, int available) {
        return patternIndex < 0 && len == READ_BUFFER_SIZE && available > 0;
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
}
