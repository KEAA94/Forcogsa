package Ejercicio;

import org.w3c.dom.Document;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditXML ed = new EditXML();
		ReadXML re = new ReadXML();
		
		Document resDoc;
		
		resDoc= re.Read();
		
		if(resDoc != null) {
			ed.Edit(resDoc);
		}else {
			System.out.println("No se leyo el XML");
		}
		
		

	}

}
