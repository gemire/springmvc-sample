/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mule.example.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.mule.transport.tcp.protocols.AbstractByteProtocol;
import org.mule.transport.tcp.protocols.XmlMessageEOFProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class POXMessageProtocol extends AbstractByteProtocol
{
    
    private static final String XML_PATTERN = "</info>";
    private final Logger logger = LoggerFactory.getLogger(POXMessageProtocol.class);
    private static final int READ_BUFFER_SIZE = 4096;
    private static final int PUSHBACK_BUFFER_SIZE = READ_BUFFER_SIZE * 2;

   // private ConcurrentMap pbMap = new ConcurrentHashMap();

    public POXMessageProtocol()
    {
        super(STREAM_OK);
    }

    @Override
    public Object read(InputStream is) throws IOException
    {
        PushbackInputStream pbis = new PushbackInputStream(is, PUSHBACK_BUFFER_SIZE);
       
        int len = -1;
        try
        {
            // read until xml pattern is seen (and then pushed back) or no more data
            // to read. return all data as message
            byte[] buffer = new byte[READ_BUFFER_SIZE];
            StringBuffer message = new StringBuffer(READ_BUFFER_SIZE);
            int patternIndex = -1;
            boolean repeat = true;
            boolean foundPattern = false;
            do
            {
                len = safeRead(pbis, buffer);
                if (len >= 0)
                {
                    // TODO take encoding into account, ideally from the incoming XML
                    message.append(new String(buffer, 0, len));
                    logger.info("@@@@@@@@@@@@@@@@@@@@@message "+message.toString());
                    // start search at 2nd character in buffer (index=1) to
                    // indicate whether we have reached a new document.
                    patternIndex = message.toString().indexOf(XML_PATTERN, 0);
                    if (patternIndex > 1)
                    {
                        repeat = false;
                        foundPattern = true;
                        pbis.close();
                        is.close();
                    }
                }
                else
                {
                    // never repeat on closed stream (and avoid calling available)
                    repeat = false;
                }

            }
            while (repeat);
            byte[] returnValue = null;
            if (foundPattern)
            {
                returnValue = nullEmptyArray(message.toString().getBytes());
            }
            else
            {
                return null;
            }
            // TODO encoding here, too...
            return returnValue;

        }
        finally
        {
            // TODO - this doesn't seem very reliable, since loop above can end
            // without EOF.  On the other hand, what else can we do?  Entire logic
            // is not very dependable, IMHO.  XmlMessageEOFProtocol is more likely
            // to be correct here, I think.

            // clear from map if stream has ended
           
        }
    }

    /**
     * Show we continue reading?  This class, following previous implementations, only
     * reads while input is saturated.
     * @see XmlMessageEOFProtocol
     *
     * @param patternIndex The index of the xml tag (or -1 if the next message not found)
     * @param len The amount of data read this loop (or -1 if EOF)
     * @param available The amount of data available to read
     * @return true if the read should continue
     */
    protected boolean isRepeat(int patternIndex, int len, int available)
    {
        return patternIndex < 0;
    }
}

 