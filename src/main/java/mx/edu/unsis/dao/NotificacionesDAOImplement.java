package mx.edu.unsis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mx.edu.unsis.model.Notificaciones;
import mx.edu.unsis.model.UsuariosTemp;

public class NotificacionesDAOImplement implements NotificacionesDAO {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImplement.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean insertNotificaciones(Notificaciones a) {
		String query = "INSERT INTO notificaciones (notifId, notifRemitente, notifDstinatario, notifMensaje, notifFecha, notifAsunto) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			jdbcTemplate.update(query, new Object[]{a.getNotifId(), a.getNotifRemitente(), a.getNotifDestinatario(), a.getNotifMensaje(), a.getNotifFecha(), a.getNotifAsunto()});
			logger.info("la notificación fue insertado correctamente. Datos de la notificación --> "+a);
			return true;
		} catch (Exception e) {
			logger.info("Error al insertar: " + e);
			return false;
		}
	}

	@Override
	public boolean updateNotificaciones(Notificaciones a) {
		String query = "update notificaciones set notifRemitente = ?, notifDstinatario = ?, notifMensaje = ?, notifFecha = ?, notifAsunto = ? where notifId = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{a.getNotifRemitente(), a.getNotifDestinatario(), a.getNotifMensaje(), a.getNotifFecha(), a.getNotifAsunto(), a.getNotifId()});
			logger.info("La notificación fue actualizado correctamente. Datos de la notificacíón --> "+a);
			return true;
		} catch (Exception e) {
			logger.info("Error al actualizar: " + e);
			return false;
		}
	}

	@Override
	public boolean eliminarNotificacion(int idNotificacion) {
		String query = "delete from notificaciónes where notifId = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{idNotificacion});
			logger.info("La notificación con el id " + idNotificacion + " fue eliminado correctamente ");
			return true;
		} catch (Exception e) {
			logger.info("Error al eliminar: " + e);
			return false;
		}
	}

	@Override
	public Notificaciones getNotificacionById(int idNotificacion) {
		String query = "select * from notificaciones where notifId = ?";
		try {
			Notificaciones notificacion = this.jdbcTemplate.queryForObject(
			        query,
			        new Object[]{idNotificacion},
			        new RowMapper<Notificaciones>() {
			            public Notificaciones mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	Notificaciones n = new Notificaciones();
			            	n.setNotifAsunto(rs.getString("notifAsunto"));
			            	n.setNotifDestinatario(rs.getString("notifDstinatario"));
			            	n.setNotifFecha(rs.getString("notifFecha"));
			            	n.setNotifId(rs.getInt("notifId"));
			            	n.setNotifMensaje(rs.getString("notifMensaje"));
			            	n.setNotifRemitente(rs.getString("notifRemitente"));
			                return n;
			            }
			        });
			logger.info("notificación obtenido con exito --> "+ notificacion);
			return notificacion;
		} catch (Exception e) {
			logger.info("error al consultar el usuario con el ID "+idNotificacion+" --> " + e);
			return null;
		}
	}

	@Override
	public List<Notificaciones> getAllNotificaciones() {
		String query = "select * from notificaciones";
		try {
			List<Notificaciones> notificaciones = this.jdbcTemplate.query(
			        query,
			        new RowMapper<Notificaciones>() {
			            public Notificaciones mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	Notificaciones n = new Notificaciones();
			            	n.setNotifAsunto(rs.getString("notifAsunto"));
			            	n.setNotifDestinatario(rs.getString("notifDstinatario"));
			            	n.setNotifFecha(rs.getString("notifFecha"));
			            	n.setNotifId(rs.getInt("notifId"));
			            	n.setNotifMensaje(rs.getString("notifMensaje"));
			            	n.setNotifRemitente(rs.getString("notifRemitente"));
			                return n;
			            }
			        });
			logger.info("notificaciónes consultados exitosamente");
			return notificaciones;
		} catch (Exception e) {
			logger.info("error al consultar todos las notificaciones --> " + e);
			return null;
		}
	}

}
