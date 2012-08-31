package com.dhenton9000.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource; //import org.mule.util.StringUtils;
import org.xml.sax.SAXException;

public class XMLUtils {

	public static final String DEFAULT_ENCODING = "windows-1252";
	private static Logger log = LogManager.getLogger(XMLUtils.class);

	/**
	 * This function will add a node to parentNode, with the name nodeName and
	 * attach the info parameter as the node text if info is null, then no text
	 * value is added
	 *
	 * @param mainDoc
	 * @param parentNode
	 *            the node you want to attach the new node to
	 * @param nodeName
	 *            the name of the node that you want to attach
	 * @param info
	 *            the text context of the new node
	 * @returns a reference to the element created
	 */
	public static Element addANode(Document mainDoc, Element parentNode,
			String nodeName, String info) {
		Element tt = mainDoc.createElement(nodeName);
		if (info != null)
			tt.setTextContent(info);
		parentNode.appendChild(tt);
		return tt;
	}

	/**
	 * Adds a CDATA node
	 *
	 * @param mainDoc
	 * @param parentNode
	 *            the node you want to attach the new node to
	 * @param nodeName
	 *            the name of the node that you want to attach
	 * @param info
	 *            the text context of the new node
	 * @returns a reference to the element created
	 */
	public static Element addACDataNode(Document mainDoc, Element parentNode,
			String nodeName, String info) {
		Element tt = mainDoc.createElement(nodeName);

		if (info != null) {
			CDATASection cs = mainDoc.createCDATASection(info);
			tt.appendChild(cs);
		}
		parentNode.appendChild(tt);

		return tt;
	}

	/**
	 * This class will load a string resource from the classpath and allows for
	 * defining your own classloader
	 *
	 * @param classPathLocation
	 *            no leading slash use '/' to separate folders
	 * @param cLoader
	 *            optional classloader to use if null, defaults to system class
	 *            loader
	 * @return the string resource won't return null if found, rather it throws
	 *         an runtime exception
	 * @throws IOException
	 * @throws RuntimeException
	 *             if resource not found
	 */
	public static String getStringResource(String classPathLocation,
			ClassLoader cLoader) throws IOException {

		if (cLoader == null) {
			cLoader = ClassLoader.getSystemClassLoader();
		}

		InputStream iS = cLoader.getResourceAsStream(classPathLocation);

		if (iS == null) {
			throw new RuntimeException(
					"getStringResource  couldn't find anything at -- "
							+ classPathLocation);
		}

		InputStreamReader iSR = new InputStreamReader(iS);
		BufferedReader bR = new BufferedReader(iSR);
		StringBuilder ss = new StringBuilder(1000);

		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = bR.read(buf)) != -1) {
			ss.append(buf, 0, numRead);
		}
		bR.close();
		return ss.toString();
	}

	public static String readFileAsString(File ff) throws java.io.IOException {
		StringBuilder fileData = new StringBuilder(1000);

		BufferedReader reader = new BufferedReader(new FileReader(ff));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			fileData.append(buf, 0, numRead);
		}
		reader.close();

		return fileData.toString();

	}

	/**
	 * Convenience method to load a file into a string
	 *
	 * @param tFile
	 * @return a string with the file's contents
	 * @throws Exception
	 */
	public static String readFileAsString(String filePath)
			throws java.io.IOException {

		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			fileData.append(buf, 0, numRead);
		}
		reader.close();
		return fileData.toString();
	}

	/**
	 * Create a DOM document from an input source
	 *
	 * @param source
	 *            the source of the document
	 * @return DOM document
	 * @throws Exception
	 */
	public static Document streamToDoc(InputSource source) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(source);

	}

	/**
	 * Create a DOM document from a string
	 *
	 * @param source
	 *            the source of the document
	 * @return DOM document
	 * @throws Exception
	 */

	public static Document stringToDoc(String xmlSource) throws Exception {
		return streamToDoc(new InputSource(new StringReader(xmlSource)));
	}

	/**
	 * Create a DOM document from a file
	 *
	 * @param source
	 *            the source of the document
	 * @return DOM document
	 * @throws Exception
	 */

	public static Document fileToDoc(String fileLocation) throws Exception {
		File fFile = new File(fileLocation);
		InputSource fSource = new InputSource(new FileInputStream(fFile));
		return streamToDoc(fSource);
	}

	/**
	 * Convert a DOM document to an xml string, with no declaration and pretty
	 * print formatting
	 *
	 * @param doc
	 * @return formatted xml
	 * @throws Exception
	 */
	public static String docToString(Document doc) throws Exception {
		return docToString(doc, true, false);
	}

	/**
	 * Convert a DOM document to an xml string
	 *
	 * @param doc
	 * @param prettyPrint
	 *            true if you want pretty print formatting
	 * @param useDeclaration
	 *            true if you want the xml declaration
	 * @return formatted string
	 * @throws Exception
	 */
	public static String docToString(Document doc, boolean prettyPrint,
			boolean useDeclaration) throws Exception {
		DOMImplementationRegistry registry = DOMImplementationRegistry
				.newInstance();
		DOMImplementationLS domImplLS = (DOMImplementationLS) registry
				.getDOMImplementation("LS");

		LSSerializer ser = domImplLS.createLSSerializer();
		ser.getDomConfig().setParameter("format-pretty-print", prettyPrint);
		ser.getDomConfig().setParameter("xml-declaration", useDeclaration);

		LSOutput out = domImplLS.createLSOutput();

		StringWriter stringOut = new StringWriter();
		out.setCharacterStream(stringOut);
		ser.write(doc, out);

		return stringOut.toString();
	}

	public static void stringToFile(String info, String filePath)
			throws java.io.IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
		writer.write(info);
		writer.close();

	}

	public static void transformXMLToFile(String xml, String xlstFilePath,
			String filePath) throws Exception {
		String res = transformXML(xml, xlstFilePath);
		stringToFile(res, filePath);

	}

	public static String transformXML(String xml, String xlstFilePath)
			throws Exception {
		String transformedXML = "";

		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(
					xlstFilePath));
			StringReader sR = new StringReader(xml);
			StringWriter ww = new StringWriter();
			transformer.transform(new StreamSource(sR), new StreamResult(ww));
			transformedXML = ww.toString();
		} catch (TransformerFactoryConfigurationError e) {
			String info = "transformXML problem:\n Error class:"
					+ e.getClass().getName() + "\n" + "Message: "
					+ e.getMessage();
			throw new Exception(info);
		}
		return transformedXML;
	}

	public static XMLGregorianCalendar XMLDateTimeFromDate(Date date)
			throws DatatypeConfigurationException {

		XMLGregorianCalendar xmlCal = null;
		xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar();

		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		xmlCal.setDay(dateCal.get(Calendar.DAY_OF_MONTH));
		// We do a +1 below because XMLGregorianCalendar goes from 1 to 12
		// while Calendar.MONTH goes from 0 to 11 !!!
		xmlCal.setMonth(dateCal.get(Calendar.MONTH) + 1);
		xmlCal.setYear(dateCal.get(Calendar.YEAR));
		xmlCal.setTime(dateCal.get(Calendar.HOUR_OF_DAY), dateCal
				.get(Calendar.MINUTE), dateCal.get(Calendar.SECOND));
		return xmlCal;

	}

	
	/**
	 * This function will validate a xml document as a string against and xsd.
	 * This function will return null if okay, an error message if not
	 *
	 * @param xmlSource
	 *            the xml to validate in a String variable
	 * @param xsdContents
	 *            the xsd already loaded into a string
	 * @return null if valid error message if not
	 * @throws IOException
	 *             on file problems
	 * @throws Exception
	 *             other errors
	 */
	public static String validateXMLWithErrorInformation(String xmlSource,
			String xsdContents) throws IOException, Exception {
		String message = null;
		SchemaFactory factory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = null;
		StringReader sR = new StringReader(xsdContents);
		Source schemaSource = new StreamSource(sR);

		try {
			schema = factory.newSchema(schemaSource);
		} catch (Exception e) {
			throw new IOException("Schema Problems: " + e.getMessage());
		}
		message = validateXMLWithErrorMessage(xmlSource, schema);
		return message;
	}

	/**
	 * This function will validate a xml document as a string against and xsd.
	 * This function does not provide any information about what failed in the
	 * validation
	 *
	 * @param xmlSource
	 *            the xml to validate in a String variable
	 * @param xsdContents
	 *            the xsd already loaded into a string
	 * @return true if valid
	 * @throws IOException
	 *             on file problems
	 * @throws Exception
	 *             other errors
	 */
	public static boolean validateXML(String xmlSource, String xsdContents)
			throws IOException, Exception {
		boolean isValid = false;
		SchemaFactory factory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = null;
		StringReader sR = new StringReader(xsdContents);
		Source schemaSource = new StreamSource(sR);

		try {
			schema = factory.newSchema(schemaSource);
		} catch (Exception e) {
			throw new IOException("Schema Problems: " + e.getMessage());
		}
		isValid = validateXML(xmlSource, schema);
		return isValid;
	}

	/**
	 * This function will validate a xml document as a string against and xsd.
	 * This function does not provide any information about what failed in the
	 * validation
	 *
	 * @param xmlSource
	 *            the xml to validate in a String variable
	 * @param xsdLocation
	 *            the fullpath location to the xsd
	 * @return true if valid
	 * @throws IOException
	 *             problems with finding files , permissions....
	 * @throws Exception
	 *             other errors
	 *
	 *
	 */

	public static boolean validateXML(String xmlSource, Schema schema)
			throws IOException, Exception {
		boolean isValid = false;
		try {
			validateXMLWithErrors(xmlSource, schema);
		} catch (ParserConfigurationException e) {
			throw new Exception("Parser Problem: " + e.getMessage());
		} catch (SAXException e) {
			if (log.isDebugEnabled())
				log.debug("Sax Exception in validXML " + e.getMessage());
			// this is a validation problem so translate it to boolean false
			return isValid;
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
		isValid = true;
		return isValid;
	}

	/**
	 * This function will validate xml against a schema
	 *
	 * @param xmlSource
	 *            the xml to validate
	 * @param schema
	 *            the schema to use as a Schema object
	 * @return null if validation okay, otherwise the Sax error message
	 * @throws IOException
	 *             if there was a file issue
	 * @throws ParserConfigurationException
	 *             if the parser has problems not related to validation
	 */
	public static String validateXMLWithErrorMessage(String xmlSource,
			Schema schema) throws IOException, ParserConfigurationException {
		String m = null;
		try {
			validateXMLWithErrors(xmlSource, schema);

		} catch (SAXException e) {
			m = e.getMessage();
		}

		return m;
	}

	/**
	 * this function performs validation and throws all errors
	 *
	 * @param xmlSource
	 *            the xml to validate
	 * @param schema
	 *            the schema to use as a Schema object
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	private static void validateXMLWithErrors(String xmlSource, Schema schema)
			throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		builderFactory.setSchema(schema);
		builderFactory.setNamespaceAware(true);

		builderFactory.setIgnoringElementContentWhitespace(true);
		builderFactory.setIgnoringComments(true);

		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		StringReader sR = new StringReader(xmlSource);
		InputSource is = new InputSource(sR);
		Document document = documentBuilder.parse(is);

		// Create a Validator object, which can be used to validate
		// an instance document.
		Validator validator = schema.newValidator();

		// Validate the DOM tree.
		validator.validate(new DOMSource(document));

	}

}
