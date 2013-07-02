/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp.test.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.mule.transport.tcp.protocols.AbstractByteProtocol;
import static org.mule.transport.tcp.protocols.AbstractByteProtocol.STREAM_OK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class TestProtocol extends AbstractByteProtocol {

    private static final Logger logger = LoggerFactory.getLogger(TestProtocol.class);

    public TestProtocol() {
        super(STREAM_OK);
        //this.setRethrowExceptionOnRead(true);
    }

    @Override
    public Object read(InputStream is) throws IOException {
        logger.debug("in protocol read");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                is));
        String inputLine = null;



        while ((inputLine = in.readLine()) != null) {
            logger.debug("protocol inputline " + inputLine);
            break;

        }
        logger.debug("protocol about to return "+inputLine);
        return inputLine;




    }
}
