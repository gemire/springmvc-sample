/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.file.transformers;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * process the buffer to the file, created by an outside source
 * @author dhenton
 */
public interface IFileBufferTransformer {
    
 

    public void processFileBuffer(BufferedReader buffInput, FileOutputStream fout)throws IOException;
    
}
