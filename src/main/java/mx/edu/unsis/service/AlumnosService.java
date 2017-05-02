package mx.edu.unsis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.edu.unsis.model.Alumnos;
/**
 * 	
 * clase que implementa el servicio de los métodos para la coneccion con la base de datos de la tabla alumnos.
 *
 * @author: Vicente Mendoza
 * @version: 26/03/2017
 */
@Service
public interface AlumnosService {
	/**
	 * Insert alumno.
	 *
	 * @param a the a
	 */
	public boolean insertAlumno(Alumnos a);
	
	/**
	 * Update alumno.
	 *
	 * @param a the a
	 */
	public boolean updateAlumno(Alumnos a);
	
	/**
	 * Eliminar alumno.
	 *
	 * @param matricula the matricula
	 * @return true, si el alumno se elimino correctamente
	 */
	public boolean eliminarAlumno(String matricula);
	
	/**
	 * Gets the alumno by id.
	 *
	 * @param matricula the matricula
	 * @return el objeto alumno que fue buscado
	 */
	public Alumnos getAlumnoById(String matricula);
	
	/**
	 * Gets the all alumnos.
	 *
	 * @return todos los alumnos existentes en la base de datos
	 */
	public List<Alumnos> getAllAlumnos();
	
	/**
	 * Gets los grupos actuales dependiendo del periodo
	 *
	 * @return una lista de tipo String con los grupos actuales
	 */
	public List<String> getGruposActuales();
}
