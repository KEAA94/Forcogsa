package Ejercicio;

import org.w3c.dom.Document;

public class Main {

	public static void main(String[] args) {
		PropertiesReader reader = new PropertiesReader();
		EditXML ed = new EditXML();
		ReadXML re = new ReadXML();
		SaveDocument save = new SaveDocument();
		FirmaDigital firDig = new FirmaDigital();
		String nuevoXML;
		
		Document resDoc;
		
		resDoc= re.Read(reader);
		
		if(resDoc != null) {
			//editar fecha
			resDoc = ed.Edit(resDoc,"Fecha",reader.Prop("fecha"));
			//firmar xml
			resDoc = firDig.Firma(resDoc);
			//guardar xml
			nuevoXML = save.Save(resDoc);
		}else {
			System.out.println("No se leyo el XML");
		}
		
		firDig.Firma(resDoc);

	}

}
