package mx.edu.unsis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.edu.unsis.model.UsuariosTemp;

/**
* 	
* Interfaz que provee el servicio de los metodos para la tabla usuariostemp de la base de datos.
*
* @author: Vicente Mendoza
* @version: 28/03/2017
*/
@Service
public interface UsuariosTempService {
	/**
	 * Insert usuarioTemp.
	 *
	 * @param u el usuario a insertar
	 * @return true, si la insercción se hizo de manera correcta, false en caso contrario
	 */
	boolean insertUsuarioTemp(UsuariosTemp u);
	
	/**
	 * Update usuario.
	 *
	 * @param u el usuario a actualizar
	 * @return true, si el usuario se actualizó correctamente, false en caso contrario
	 */
	boolean updateUsuariosTemp(UsuariosTemp u);
	
	/**
	 * Eliminar usuario temp.
	 *
	 * @param usuarioId el id del usuario a eliminar
	 * @return true, si el usuario fue eliminado con exito, false en caso contrario
	 */
	boolean eliminarUsuarioTemp(String usuarioId);
	
	/**
	 * Gets the all users.
	 *
	 * @return todos los usuarios dados de alta en la base de datos en la tabla usuariostemp
	 */
	List<UsuariosTemp> getAllUsers();
	
	/**
	 * Gets the user by id.
	 *
	 * @param id el id del usuario que se desea buscar
	 * @return el usuario que corresponda al ID
	 */
	UsuariosTemp getUsuarioTempById(String id);
	
	/**
	 * Verificar codigo usuario. Verifica que el codigo del usuario coincida con el que se le envió a su telefono
	 *
	 * @param usuarioId el id del usuario del cual se va a verificar su código
	 * @param code el código que envió el usuario
	 * @return true, si el código coincide con el que está en la base de datos, false en caso contraro
	 */
	boolean verificarCodigoUsuario(String usuarioId, String code);
}
