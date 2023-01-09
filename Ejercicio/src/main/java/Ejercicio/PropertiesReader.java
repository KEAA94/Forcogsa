package Ejercicio;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	public String Prop(String propiedad) {
		String propiedades = "/Users/kevinarellano/eclipse-workspace/Ejercicio/src/main/resources/config.properties";
		
		
		try {
			Properties proper = new Properties();
			proper.load(new FileReader(propiedades));
			
			return proper.getProperty(propiedad);
			
		} catch (IOException e) {
			System.out.println("El error obtenido al tratar de leer el archivo es: " + e);
		}
		return null;
		
	}

}
