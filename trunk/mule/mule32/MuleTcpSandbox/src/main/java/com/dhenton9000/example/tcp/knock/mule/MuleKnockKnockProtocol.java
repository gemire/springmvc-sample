/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp.knock.mule;

import com.dhenton9000.example.tcp.knock.KnockKnockProtocol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.mule.transport.tcp.protocols.AbstractByteProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Don
 */
public class MuleKnockKnockProtocol extends AbstractByteProtocol {

    private static final String XML_PATTERN = "<?xml";
    private static final int READ_BUFFER_SIZE = 4096;
    private static final int PUSHBACK_BUFFER_SIZE = READ_BUFFER_SIZE * 2;
    private ConcurrentMap pbMap = new ConcurrentHashMap();
    private static final Logger logger = LoggerFactory.getLogger(MuleKnockKnockProtocol.class);
    private KnockKnockProtocol kkp = new KnockKnockProtocol();

    public MuleKnockKnockProtocol() {
        super(STREAM_OK);
        this.setRethrowExceptionOnRead(true);
    }

    @Override
    public Object read(InputStream is) throws IOException {
        logger.debug("in knock knock protocol");
        boolean askedForBye = false;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                is));
        String inputLine = null;
        String outputLine = null;


        while ((inputLine = in.readLine()) != null) {
            logger.debug("inputline " + inputLine);
            outputLine = kkp.processInput(inputLine);
            break;

        }
        if (outputLine.equals("Bye") || inputLine.equals("Quit")) {
            askedForBye = true;

        }

        if (askedForBye) {
            return null;
        } else {
            return outputLine;
        }
    }
}