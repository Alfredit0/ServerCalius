package mx.edu.unsis.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import mx.edu.unsis.model.Materias;

/**
 * 	
 * Interfaz que provee los metodos DAO para la tabla materias de la base de datos.
 *
 * @author: Vicente Mendoza
 * @version: 28/03/2017
 */
@Repository
public interface MateriasDAO {
	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	public void setDataSource(DataSource dataSource);
	
	/**
	 * Insert Materia.
	 *
	 * @param a el objeto materia a insertar
	 */
	public boolean insertMateria(Materias a);
	
	/**
	 * Update materia.
	 *
	 * @param a el objeto materia a actualizar
	 */
	public boolean updateMaterias(Materias a);
	
	/**
	 * Eliminar Materia.
	 *
	 * @param materiaId el id de la materia a eliminar
	 * @return true, si la materia se elimino correctamente, false en caso contrario
	 */
	public boolean eliminarMateria(String materiaId);
	
	/**
	 * obtiene una materia por su Id
	 *
	 * @param materiaId el Id de la materia que se desea buscar
	 * @return el objeto materia que fue buscado, null en caso de que no se encuentra en la BD
	 */
	public Materias getMateriaById(String materiaId);
	
	/**
	 * Obtiene todas las materias dados de alta en la base de datos
	 *
	 * @return todos las materias existentes en la base de datos
	 */
	public List<Materias> getAllMaterias();
}
