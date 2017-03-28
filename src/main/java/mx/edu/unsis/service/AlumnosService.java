package mx.edu.unsis.service;

import java.util.List;

import mx.edu.unsis.model.Alumnos;

public interface AlumnosService {
	/**
	 * Insert alumno.
	 *
	 * @param a the a
	 */
	public void insertAlumno(Alumnos a);
	
	/**
	 * Update alumno.
	 *
	 * @param a the a
	 */
	public void updateAlumno(Alumnos a);
	
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
}
