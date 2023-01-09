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

public class SaveDocument {
	
	public String Save (Document doc) {
		PropertiesReader reader = new PropertiesReader();
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
            return reader.Prop("ruta")+"Copia-"+ reader.Prop("nombrearchivo");
		} catch (TransformerException | IOException e) {
			System.out.println("Error al guardar nuevo XML: " + e);
		}
		return null;

       
	}

}
