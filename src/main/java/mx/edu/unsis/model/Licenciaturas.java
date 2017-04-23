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
		licenciaturas.add("Licenciatura en Administración Municipal");
		licenciaturas.add("Licenciatura en Administración Pública");
		licenciaturas.add("Licenciatura en Ciencias Empresariales");
		licenciaturas.add("Licenciatura en Informática");
		licenciaturas.add("Licenciatura en Nutrición");
		licenciaturas.add("Licenciatura en Enfermería");
		return licenciaturas;
	}
}
