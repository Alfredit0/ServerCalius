package mx.edu.unsis.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import mx.edu.unsis.model.Usuarios;

// TODO: Auto-generated Javadoc
/**
 * 	
 * Interfaz que provee los metodos DAO para la tabla usuarios de la base de datos.
 *
 * @author: Vicente Mendoza
 * @version: 24/03/2017
 */
@Repository
public interface UsuarioDAO {
	
	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	public void setDataSource(DataSource dataSource);
	
	/**
	 * Insert usuario.
	 *
	 * @param user the user
	 */
	void insertUsuario(Usuarios u);
	
	/**
	 * Update usuario.
	 *
	 * @param user el usuario a actualizar
	 */
	void updateUsuario(Usuarios u);
	
	/**
	 * Gets the all users.
	 *
	 * @return todos los usuarios dados de alta en la base de datos
	 */
	List<Usuarios> getAllUsers();
	
	/**
	 * Gets the user by id.
	 *
	 * @param id el id del usuario que se desea buscar
	 * @return el usuario que corresponda al ID
	 */
	Usuarios getUsuarioById(String id);
	
	/**
	 * Login user.
	 *
	 * @param userName la matricula del usuario que quiere iniciar sesión
	 * @param password la contraseña del usuario
	 * @return null en caso de que no existe la cuenta, y un objeto Usuario si el usuario ya esta dado de alta
	 */
	Usuarios loginUser(String userName, String password);
}
