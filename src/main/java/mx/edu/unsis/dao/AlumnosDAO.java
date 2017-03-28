package mx.edu.unsis.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import mx.edu.unsis.model.Alumnos;

/**
 * 	
 * Interfaz que provee los metodos DAO para la tabla alumnos de la base de datos.
 *
 * @author: Vicente Mendoza
 * @version: 26/03/2017
 */
@Repository
public interface AlumnosDAO {

	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	public void setDataSource(DataSource dataSource);
	
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
