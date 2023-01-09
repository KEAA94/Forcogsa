package Ejercicio;

import java.util.Base64;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FirmaDigital {
	
	public Document Firma(Document doc){
			EditXML ed = new EditXML();
			
			NodeList nodeList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
	         Node nodo = nodeList.item(0);
	            
	            if (nodo.getNodeType() == Node.ELEMENT_NODE) {

	                Element elemento = (Element) nodo;
		
               String toCode = Base64.getEncoder().encodeToString(elemento.getAttribute("Sello").getBytes());
               doc = ed.Edit(doc, "Sello", toCode);
	            }
              
		return doc;
	}
	
}
