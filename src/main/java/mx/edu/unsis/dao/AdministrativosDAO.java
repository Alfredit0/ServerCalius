package mx.edu.unsis.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import mx.edu.unsis.model.Administrativos;
/**
 * 	
 * Interfaz que provee los metodos CRUD para la tabla administrativos de la base de datos.
 *
 * @author: Vicente Mendoza
 * @version: 27/03/2017
 */
@Repository
public interface AdministrativosDAO {
	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	public void setDataSource(DataSource dataSource);
	
	/**
	 * Insert administrativo.
	 *
	 * @param a el objeto administrativo a insertar en la BD
	 */
	public void insertAdministrativo(Administrativos a);
	
	/**
	 * Update adminitrativo.
	 *
	 * @param a el objeto administrativos a eliminar
	 */
	public void updateAdministrativo(Administrativos a);
	
	/**
	 * Eliminar administrativo.
	 *
	 * @param adminId el Id del administrativo a eliminar
	 * @return true, si el administrativo se elimino correctamente
	 */
	public boolean eliminarAdministrativo(String adminId);
	
	/**
	 * Gets the administrativo by id.
	 *
	 * @param adminId el Id del administrativo a buscar
	 * @return el objeto adminitrativos que fue buscado, null en caso de que no fue encontrado
	 */
	public Administrativos getAdministrativoById(String adminId);
	
	/**
	 * Gets the all administrativos.
	 *
	 * @return todos los administrativos existentes en la base de datos
	 */
	public List<Administrativos> getAllAdministrativo();
}
