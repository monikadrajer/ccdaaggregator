package org.sitenv.ccdaaggregator.parsers;

import org.apache.commons.io.input.BOMInputStream;
import org.apache.log4j.Logger;
import org.sitenv.ccdaaggregator.model.CCDARefModel;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.InputStream;

@Component
public class CCDAParser {

	private static Logger log = Logger.getLogger(CCDAParser.class.getName());

	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;

	public void initDoc(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		log.info("Initializing Document ");
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		doc = builder.parse(new BOMInputStream(inputStream));
	}

	public CCDARefModel parse(InputStream inputStream) {
		try {

			initDoc(inputStream);
			CCDAConstants.getInstance();

			log.info("Creating Model");
			CCDARefModel model = new CCDARefModel();

			model.setPatient(CCDAHeaderParser.getPatient(doc));
			CCDABodyParser.parseBody(doc, model);

			log.info("Returning Parsed Model");
			model.log();

			return model;
		} catch (ParserConfigurationException e1) {
			System.out.println("Caught Parser config Excep");
			e1.printStackTrace();
		} catch (SAXException e1) {
			System.out.println("Caught SAX Excep");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Caught IO  Excep");
			e1.printStackTrace();
		} catch (XPathExpressionException e) {
			System.out.println("Caught Xpath Expression ");
			e.printStackTrace();
		}
		return null;
	}

}
