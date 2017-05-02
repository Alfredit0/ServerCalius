package mx.edu.unsis.model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * La clase que regresa la lista de licenciaturas existentes en la universidad
 * @author VICENTE- Mendoza
 * @version 22/04/2017
 */
public class Licenciaturas {
	
	/**
	 * Gets lista de licenciaturas
	 *
	 * @return todas las licenciaturas vigentes
	 */
	public static List<String> getAllLicenciaturas(){
		List<String> licenciaturas = new ArrayList<String>();
		licenciaturas.add("Licenciatura en Administraci�n Municipal");
		licenciaturas.add("Licenciatura en Administraci�n P�blica");
		licenciaturas.add("Licenciatura en Ciencias Empresariales");
		licenciaturas.add("Licenciatura en Inform�tica");
		licenciaturas.add("Licenciatura en Nutrici�n");
		licenciaturas.add("Licenciatura en Enfermer�a");
		return licenciaturas;
	}
}
