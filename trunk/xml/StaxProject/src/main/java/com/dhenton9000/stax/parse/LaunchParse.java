package com.dhenton9000.stax.parse;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.xml.stream.events.Attribute;

/**
 * Hello world!
 *
 */
public class LaunchParse {

    static Logger logger = LoggerFactory.getLogger(LaunchParse.class);

    public static void main(String[] args) {
        LaunchParse p = new LaunchParse();
        try {
            logger.info("begin parse");
            p.doParse("BookCatalog.xml");
            logger.info("end parse");
        } catch (Exception ex) {
            logger.error("Input setup error: " + ex.getClass().getName()
                    + " " + ex.getMessage());

        }
    }

    private void doParse(String classPathLocation) throws Exception {

        ClassLoader cLoader = ClassLoader.getSystemClassLoader();
        InputStream iS = cLoader.getResourceAsStream(classPathLocation);


        /////////////////////////////////////////////////////////////////////
        XMLInputFactory xmlif = null;


        xmlif = XMLInputFactory.newInstance();
        xmlif.setProperty(
                XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES,
                Boolean.TRUE);
        xmlif.setProperty(
                XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,
                Boolean.FALSE);
        //set the IS_COALESCING property to true , if application desires to
        //get whole text data as one event.            
        xmlif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.FALSE);

        // mule will provide the stream reader
        ////////////////////////////////////////////////////////
        LibraryBook currentLibraryBook = null;
        ArrayList<LibraryBook> books = new ArrayList<LibraryBook>();

        XMLStreamReader xmlr = xmlif.createXMLStreamReader(
                classPathLocation, iS);


        XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(xmlr);
        XMLEventWriter writer = XMLOutputFactory.newInstance()
                .createXMLEventWriter(System.out);

        while (reader.hasNext()) {

            XMLEvent event = (XMLEvent) reader.next();

            switch (event.getEventType()) {
                case XMLEvent.START_ELEMENT:
                    StartElement sElem = event.asStartElement();
                    logger.debug("start element " + sElem.getName().getLocalPart());

                    if (sElem.getName().getLocalPart().equals("Book")) {
                        currentLibraryBook = new LibraryBook();
                        Iterator<Attribute> attribIter = sElem.getAttributes();
                        Attribute a = attribIter.next();
                        currentLibraryBook.setLibraryName(a.getValue());

                    }
                    //Title, Author, Date
                    if (sElem.getName().getLocalPart().equals("Title")) {

                        XMLEvent event2 = (XMLEvent) reader.next();
                        currentLibraryBook.setTitle(event2.asCharacters().getData());

                    }

                    if (sElem.getName().getLocalPart().equals("Author")) {

                        XMLEvent event2 = (XMLEvent) reader.next();
                        currentLibraryBook.setAuthor(event2.asCharacters().getData());

                    }
                     if (sElem.getName().getLocalPart().equals("ISBN")) {

                        XMLEvent event2 = (XMLEvent) reader.next();
                        currentLibraryBook.setISBN(event2.asCharacters().getData());

                    }
                    if (sElem.getName().getLocalPart().equals("Cost")) {

                        XMLEvent event2 = (XMLEvent) reader.next();
                        currentLibraryBook.setCost(Float.parseFloat(event2.asCharacters().getData()));
                        Iterator<Attribute> attribIter = sElem.getAttributes();
                        Attribute a = attribIter.next();
                        currentLibraryBook.setCurrency(a.getValue());
                    }



                    break;


                case XMLEvent.END_ELEMENT:
                    EndElement eElem = event.asEndElement();
                    logger.debug("end element " + eElem.getName().getLocalPart());
                    if (eElem.getName().getLocalPart().equals("Book")) {
                        books.add(currentLibraryBook);
                        currentLibraryBook = null;
                    }
                    break;
            }
        }// end while


        for (LibraryBook b : books) {
            logger.debug("book: " + b);
        }




    }
}
