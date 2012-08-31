/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salmonrun.autotagger;

import java.io.File;
import java.io.IOException;
import net.sf.classifier4J.ClassifierException;
import net.sf.classifier4J.bayesian.WordsDataSourceException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author dhenton
 */
public class AutoTagDemo {

    public void doTest() throws WordsDataSourceException, ClassifierException, IOException {
        File someDbFile = null;
        File[] databaseFilesArray = null;
        File[] webFilesArray = null;
        File[] linuxFilesArray = null;
        AutoTagger autoTagger = new AutoTagger();
        autoTagger.setStopwordFile(new File("/path/to/my/stopwords.txt"));
        autoTagger.setDataSource(new DriverManagerDataSource("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/classifierdb", "user", "pass"));

        autoTagger.addTrainingFiles("database", databaseFilesArray);
        autoTagger.addTrainingFiles("web", webFilesArray);
        autoTagger.addTrainingFiles("linux", linuxFilesArray);
        autoTagger.train();

        double p = autoTagger.getProbabilityOfFileInCategory("database", someDbFile);


    }
}
