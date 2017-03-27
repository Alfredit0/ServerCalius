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
import org.springframework.stereotype.Repository;

import mx.edu.unsis.model.Users;
import mx.edu.unsis.model.Usuarios;

public class UsuarioDAOImplement implements UsuarioDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImplement.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertUsuario(Usuarios u) {
		String query = "INSERT INTO usuarios (usuarioId, usuarioTelefono, usuarioIdGcm, usuarioPassword) VALUES (?, ?, ?, ?);";
		try {
			jdbcTemplate.update(query, new Object[]{u.getUsuarioId(), u.getUsuarioTelefono(), u.getUsuarioIdGcm(), u.getUsuarioPassword()});
			logger.info("El usuario fue insertado correctamente. Datos del Usuario --> "+u);
		} catch (Exception e) {
			logger.info("Error al insertar: " + e);
		}
	}

	@Override
	public void updateUsuario(Usuarios u) {
		String query = "update usuarios set usuarioTelefono = ?, usuarioPassword = ?, usuarioIdGcm = ? where usuarioId = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{u.getUsuarioTelefono(), u.getUsuarioPassword(), u.getUsuarioIdGcm(), u.getUsuarioId()});
			logger.info("El usuario fue actualizado correctamente. Datos del Usuario --> "+u);
		} catch (Exception e) {
			logger.info("Error al actualizar: " + e);
		}
	}

	@Override
	public List<Usuarios> getAllUsers() {
		String query = "select * from usuarios";
		try {
			List<Usuarios> usuarios = this.jdbcTemplate.query(
			        query,
			        new RowMapper<Usuarios>() {
			            public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
			                Usuarios usuarios = new Usuarios();
			                usuarios.setUsuarioId(rs.getString("usuarioId"));
			                usuarios.setUsuarioIdGcm(rs.getString("usuarioIdGcm"));
			                usuarios.setUsuarioPassword(rs.getString("usuarioPassword"));
			                usuarios.setUsuarioTelefono(rs.getString("usuarioTelefono"));
			                return usuarios;
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
	public Usuarios getUsuarioById(String id) {
		String query = "select * from usuarios where usuarioId = ?";
		try {
			Usuarios usuario = this.jdbcTemplate.queryForObject(
			        query,
			        new Object[]{id},
			        new RowMapper<Usuarios>() {
			            public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
			                Usuarios usuarios = new Usuarios();
			                usuarios.setUsuarioId(rs.getString("usuarioId"));
			                usuarios.setUsuarioIdGcm(rs.getString("usuarioIdGcm"));
			                usuarios.setUsuarioPassword(rs.getString("usuarioPassword"));
			                usuarios.setUsuarioTelefono(rs.getString("usuarioTelefono"));
			                return usuarios;
			            }
			        });
			logger.info("usuario obtenido con exito --> "+ usuario);
			return usuario;
		} catch (Exception e) {
			logger.info("error al consultar el usuario con el ID "+id+" --> " + e);
			return null;
		}
	}

	@Override
	public Usuarios loginUser(String userName, String password) {
		String query = "SELECT * FROM usuarios WHERE usuarioId = ? and usuarioPassword = ?;";
		try {
			Usuarios userLogin = jdbcTemplate.queryForObject(
					query, 
					new Object[] { userName, password },
					new RowMapper<Usuarios>() {
			            public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
			                Usuarios usuarios = new Usuarios();
			                usuarios.setUsuarioId(rs.getString("usuarioId"));
			                usuarios.setUsuarioIdGcm(rs.getString("usuarioIdGcm"));
			                usuarios.setUsuarioPassword(rs.getString("usuarioPassword"));
			                usuarios.setUsuarioTelefono(rs.getString("usuarioTelefono"));
			                return usuarios;
			            }
			        });
			logger.info("Regresa..." + userLogin);
			return userLogin;
		} catch (Exception e) {
			logger.info("Error en el metodo loginUser " + e);
			return null;
		}
	}

}
