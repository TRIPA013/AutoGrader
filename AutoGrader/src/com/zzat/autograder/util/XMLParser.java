package com.zzat.autograder.util;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParser {

	private static final String ASSIGNMENT_XML = "Assignment.xml";

	private static final String ASSIGNMENT_DTD_XML = "Assignment-DTD.xml";

	private static final String SCHEMA_PATH = "Assignment.xsd";

	public static void main(String[] args) {
		try {
			Document document = getRootDocument(ASSIGNMENT_XML);

			System.out.println("Total points: "
					+ AssignmentFileXMLUtil.getTotalPoints(document));

			document = getRootDocument(ASSIGNMENT_DTD_XML);
			System.out.println("Total points: "
					+ AssignmentFileXMLUtil.getTotalPoints(document));

		} catch (Exception e) {
			System.out.println("Error in parsing: " + e.getMessage());
		}

	}

	public static Document getRootDocumentDTD(String fileName)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document document = parser.parse(fileName);

		return (document);
	}

	public static Document getRootDocument(String fileName) {

		Document document = null;

		final SchemaFactory sf = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Schema schema;
		try {
			schema = sf.newSchema(new StreamSource(new File(SCHEMA_PATH)));

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder parser = factory.newDocumentBuilder();
			document = parser.parse(fileName);

			Validator validator = schema.newValidator();
			validator.validate(new DOMSource(document));

		} catch (SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (document);
	}
}
