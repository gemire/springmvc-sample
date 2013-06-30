/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp;

import java.io.IOException;
import java.io.InputStream;
import org.mule.transport.tcp.protocols.AbstractByteProtocol;

/**
 *
 * @author Don
 */
public class EndMessageProtocol  extends AbstractByteProtocol {
    
    
    public EndMessageProtocol() {
        super(STREAM_OK);
    }

    @Override
    public Object read(InputStream is) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
