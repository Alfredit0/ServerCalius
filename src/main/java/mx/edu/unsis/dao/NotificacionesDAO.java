package mx.edu.unsis.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import mx.edu.unsis.model.Notificaciones;

/**
 * 	
 * Interfaz que provee los metodos DAO para la tabla notificaciones de la base de datos.
 *
 * @author: Vicente Mendoza
 * @version: 19/04/2017
 */
@Repository
public interface NotificacionesDAO {
	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	public void setDataSource(DataSource dataSource);
	
	/**
	 * Inserta una nueva notificacione en la tabla notificaciones en la base de datos
	 *
	 * @param a el objeto notifiaciones a insertar en la BD
	 */
	public boolean insertNotificaciones(Notificaciones a);
	
	/**
	 * Actualiza una nueva notificacion en la tabla notificaciones en la base de datos
	 *
	 * @param a el objeto notificaciones a actualizar
	 */
	public boolean updateNotificaciones(Notificaciones a);
	
	/**
	 * Elimina una notificacione de la tabla notificaciones de la base de datos
	 *
	 * @param idNotificacion el Id de la notificacion a eliminar
	 * @return true, si la notificacion se elimino correctamente
	 */
	public boolean eliminarNotificacion(int idNotificacion);
	
	/**
	 * optiene una notificacion mediante su id
	 *
	 * @param idNotificacion el Id de la notificación que se quiere obtener
	 * @return el objeto notificacion que fue buscado, null en caso de que no fue encontrado
	 */
	public Notificaciones getNotificacionById(int idNotificacion);
	
	/**
	 * obtiene todas las notificaciones existentes en la base de datos
	 *
	 * @return Arraylist con todas las notificaciones existentes en la base de datos
	 */
	public List<Notificaciones> getAllNotificaciones();
}
