package Ejercicio;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EditXML {
	
	public Document Edit(Document doc,String attr,String newValue) {
		SaveDocument guardar = new SaveDocument();
		
		 NodeList nodeList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
         Node nodo = nodeList.item(0);
            
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                Element elemento = (Element) nodo;
                elemento.getAttributes().getNamedItem(attr).setTextContent(newValue);
                return doc;
                
            
            }else {
            	return null;
            }
	}
	
}
