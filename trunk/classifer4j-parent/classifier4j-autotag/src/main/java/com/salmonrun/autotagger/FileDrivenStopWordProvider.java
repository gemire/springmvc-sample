/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salmonrun.autotagger;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;
import net.sf.classifier4J.IStopWordProvider;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * http://sujitpal.blogspot.com/2007/04/document-classification-using-naive.html
 * @author dhenton
 */
public class FileDrivenStopWordProvider implements IStopWordProvider {

  private SortedSet<String> words = new TreeSet<String>();
   private Log LOGGER = LogFactory.getLog(this.getClass());
  public FileDrivenStopWordProvider(File stopWordFile) {
    try {
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(new FileInputStream(stopWordFile)));
      String word;
      while ((word = reader.readLine()) != null) {
        words.add(StringUtils.lowerCase(word.trim()));
      }
    } catch (FileNotFoundException e) {
      LOGGER.error("File:" + stopWordFile.getName() + " does not exist", e);
    } catch (IOException e) {
      LOGGER.error("Error reading file:" + stopWordFile.getName(), e);
    }
  }
  
    @Override
  public boolean isStopWord(String word) {
    return words.contains(StringUtils.lowerCase(word.trim())) || StringUtils.isNumeric(word);
  }
}