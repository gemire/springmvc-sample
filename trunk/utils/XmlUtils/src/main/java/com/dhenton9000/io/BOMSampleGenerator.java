/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dhenton
 */
public class BOMSampleGenerator {
    public static final String SAMPLE_TEXT = "alpha\nbeta\ngamma\n";

    public void saveFile(String file, String data,boolean addBOM) throws IOException {
// Use UTF-8 with BOM mark format
        FileOutputStream fos = null;
        OutputStreamWriter w = null;
        try {
// new file and write BOM bytes first
            fos = new FileOutputStream(file);
            byte[] bom = new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
            if (addBOM) {
                fos.write(bom);
            }

// open UTF8 writer
            w = new OutputStreamWriter(fos, "UTF-8");
            w.append(data);

        } finally {
            if (w != null) {
                try {
                    w.close();
                } catch (Exception ex) {
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception ex) {
                }
            }
        }
    }
    
    
    public static void main(String[] args)
    {
        try {
            final BOMSampleGenerator generator = new BOMSampleGenerator();
            generator.saveFile("no_BOM_Sample.txt", SAMPLE_TEXT, false);
            generator.saveFile("BOM_Sample.txt", SAMPLE_TEXT, true);
        } catch (IOException ex) {
            Logger.getLogger(BOMSampleGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
