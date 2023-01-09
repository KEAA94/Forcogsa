package Ejercicio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EditXML {
	
	public void Edit(Document doc) {
		PropertiesReader reader = new PropertiesReader();
		
		
		 NodeList nodeList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
		 
		 
		 System.out.println(nodeList);
		for (int i = 0; i < nodeList.getLength(); i++) {

            Node nodo = nodeList.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                Element elementoConcepto = (Element) nodo;
                System.out.println("Fecha actual: " + elementoConcepto.getAttribute("Fecha"));
                System.out.println(elementoConcepto.getElementsByTagName("Fecha"));
                elementoConcepto.getAttributes().getNamedItem("Fecha").setTextContent(reader.Prop("fecha"));
                System.out.println("Nueva fecha \t\t: " + elementoConcepto.getAttribute("Fecha"));

               
               StringWriter docWritter = new StringWriter();
               TransformerFactory transFact = TransformerFactory.newInstance();

               
               try {
            	   Transformer transf= transFact.newTransformer();
            	   transf.transform(new DOMSource(doc), new StreamResult(docWritter));
            	   String peticion = docWritter.toString();
                   File newXML = new File(reader.Prop("ruta")+"Copia-"+ reader.Prop("nombrearchivo"));
                   FileOutputStream out = new FileOutputStream(newXML);
                   out.write(peticion.getBytes());
                   out.close();
			} catch (TransformerException | IOException e) {
				System.out.println("Error al guardar nuevo XML: " + e);
			}

              
                
                
            }
        }
	}
	
}
