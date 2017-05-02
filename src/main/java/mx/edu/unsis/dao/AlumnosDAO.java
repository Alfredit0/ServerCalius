package mx.edu.unsis.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import mx.edu.unsis.model.Alumnos;

// TODO: Auto-generated Javadoc
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
	 * @return true, if successful
	 */
	public boolean insertAlumno(Alumnos a);
	
	/**
	 * Update alumno.
	 *
	 * @param a the a
	 * @return true, if successful
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
