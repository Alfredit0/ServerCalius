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

import mx.edu.unsis.model.UsuariosTemp;

public class UsuariosTempDAOImplement implements UsuariosTempDAO{

	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImplement.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean insertUsuarioTemp(UsuariosTemp u) {
		String query = "INSERT INTO usuariostemp (usuarioId, usuarioTelefono, usuarioCodigo) VALUES (?, ?, ?);";
		try {
			jdbcTemplate.update(query, new Object[]{u.getUsuarioId(), u.getUsuarioTelefono(), u.getUsuarioCodigo()});
			logger.info("El usuariotemp fue insertado correctamente. Datos del Usuariotemp --> "+u);
			return true;
		} catch (Exception e) {
			logger.info("Error al insertar: " + e);
			return false;
		}
	}

	@Override
	public boolean updateUsuariosTemp(UsuariosTemp u) {
		String query = "update usuariostemp set usuarioTelefono = ?, usuarioCodigo = ? where usuarioId = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{u.getUsuarioTelefono(), u.getUsuarioCodigo(), u.getUsuarioId()});
			logger.info("El usuariotemp fue actualizado correctamente. Datos del Usuariotemp --> "+u);
			return true;
		} catch (Exception e) {
			logger.info("Error al actualizar: " + e);
			return false;
		}
	}

	@Override
	public boolean eliminarUsuarioTemp(String usuarioId) {
		String query = "delete from usuariostemp where usuarioId = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{usuarioId});
			logger.info("El usuariotemp con el id " + usuarioId + " fue eliminado correctamente ");
			return true;
		} catch (Exception e) {
			logger.info("Error al eliminar: " + e);
			return false;
		}
	}

	@Override
	public List<UsuariosTemp> getAllUsers() {
		String query = "select * from usuariostemp";
		try {
			List<UsuariosTemp> usuarios = this.jdbcTemplate.query(
			        query,
			        new RowMapper<UsuariosTemp>() {
			            public UsuariosTemp mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	UsuariosTemp utemp = new UsuariosTemp();
			            	utemp.setUsuarioId(rs.getString("usuarioId"));
			            	utemp.setUsuarioTelefono(rs.getString("usuarioTelefono"));
			                utemp.setUsuarioCodigo(rs.getString("usuarioCodigo"));
			                return utemp;
			            }
			        });
			logger.info("usuarios consultados exitosamente");
			return usuarios;
		} catch (Exception e) {
			logger.info("error al consultar todos los usuarios --> " + e);
			return null;
		}
	}

	@Override
	public UsuariosTemp getUsuarioTempById(String id) {
		String query = "select * from usuariostemp where usuarioId = ?";
		try {
			UsuariosTemp usuariostemps = this.jdbcTemplate.queryForObject(
			        query,
			        new Object[]{id},
			        new RowMapper<UsuariosTemp>() {
			            public UsuariosTemp mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	UsuariosTemp utemp = new UsuariosTemp();
			            	utemp.setUsuarioId(rs.getString("usuarioId"));
			            	utemp.setUsuarioTelefono(rs.getString("usuarioTelefono"));
			                utemp.setUsuarioCodigo(rs.getString("usuarioCodigo"));
			                return utemp;
			            }
			        });
			logger.info("usuario obtenido con exito --> "+ usuariostemps);
			return usuariostemps;
		} catch (Exception e) {
			logger.info("error al consultar el usuario con el ID "+id+" --> " + e);
			return null;
		}
	}

	@Override
	public boolean verificarCodigoUsuario(String usuarioId, String code) {
		String query = "select * from usuariostemp where usuarioId = ?";
		try {
			UsuariosTemp usuariostemps = this.jdbcTemplate.queryForObject(
			        query,
			        new Object[]{usuarioId},
			        new RowMapper<UsuariosTemp>() {
			            public UsuariosTemp mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	UsuariosTemp utemp = new UsuariosTemp();
			            	utemp.setUsuarioId(rs.getString("usuarioId"));
			            	utemp.setUsuarioTelefono(rs.getString("usuarioTelefono"));
			                utemp.setUsuarioCodigo(rs.getString("usuarioCodigo"));
			                return utemp;
			            }
			        });
			if(code.equals(usuariostemps.getUsuarioCodigo()))
			{
				logger.info("el código Si coincide");
				return true;
			}
			else
			{
				logger.info("el código NO coincide");
				return false;
			}
		} catch (Exception e) {
			logger.info("No se encontro el usuario --> " + e);
			return false;
		}
	}

}
