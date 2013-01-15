/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.file.transformers;

import au.com.bytecode.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A transformer that will handle csv files. The abstract method transformLine
 * must be filled in.
 * @author dhenton
 */
public abstract class AbstractCsvTransformer implements IFileBufferTransformer {

    public static final char DEFAULT_QUOTE_CHARACTER = '^';
    public static final char DEFAULT_SEPARATOR = ',';
    private char quoteCharacter = '"';
    private char separator = ',';
    private int fileHeaderCount = 1;
    private boolean strictQuotes = false;

    /**
     * @return the quoteCharacter
     */
    public char getQuoteCharacter() {
        return quoteCharacter;
    }

    /**
     * @param quoteCharacter the quoteCharacter to set
     */
    public void setQuoteCharacter(char quoteCharacter) {
        this.quoteCharacter = quoteCharacter;
    }

    /**
     * @return the separator
     */
    public char getSeparator() {
        return separator;
    }

    /**
     * @param separator the separator to set
     */
    public void setSeparator(char separator) {
        this.separator = separator;
    }

    /**
     * @return the fileHeaderCount
     */
    public int getFileHeaderCount() {
        return fileHeaderCount;
    }

    /**
     * @param fileHeaderCount this is the number of lines to get to the header
     * usually 1, sometimes lines are stuffed above the header
     */
    public void setFileHeaderCount(int fileHeaderCount) {
        this.fileHeaderCount = fileHeaderCount;
    }

    /**
     * @return the strictQuotes
     */
    public boolean isStrictQuotes() {
        return strictQuotes;
    }

    /**
     * @param strictQuotes the strictQuotes to set
     */
    public void setStrictQuotes(boolean strictQuotes) {
        this.strictQuotes = strictQuotes;
    }

    @Override
    public void processFileBuffer(BufferedReader buff,FileOutputStream fOut) throws IOException {
        CSVReader reader = null;
        reader = new CSVReader(buff, getSeparator(), getQuoteCharacter(), strictQuotes);
        List<String> columnLabels = new ArrayList<String>();
        String[] line = null;

        int headerCount = 0;
        // this will load the last line in the header as the column list
        while (headerCount < getFileHeaderCount()) {
            line = reader.readNext();
            columnLabels = Collections.unmodifiableList(Arrays.asList(line));
            headerCount++;
        }

        while ((line = reader.readNext()) != null) {
            Map<String, String> dataMap = loadMapLine(line, columnLabels);
            transformLine(dataMap);

        }

    }

    public Map<String, String> loadMapLine(String[] line,
            List<String> columnLabels) {
        int ndx = 0;


        Map<String, String> dataMap = new HashMap<String, String>();
        for (String label : columnLabels) {
            String value = line[ndx].trim();
            dataMap.put(label, value);
            ndx++;
        }
        return dataMap;
    }

    public abstract void transformLine(Map<String, String> dataMap);
}
