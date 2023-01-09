package Ejercicio;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ReadXML {
	
	public Document Read() {
		PropertiesReader reader = new PropertiesReader();
		
		try {

			DocumentBuilderFactory docBF =  DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuild = docBF.newDocumentBuilder();
			File docPath = new File(reader.Prop("ruta")+ reader.Prop("nombrearchivo"));
			Document doc = docBuild.parse(docPath);
			doc.getDocumentElement().normalize();
			
			return doc;
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("Error al leer XML: " + e);
		}
		
		return null;
	}
	
}
