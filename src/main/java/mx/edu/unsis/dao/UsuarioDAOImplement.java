package mx.edu.unsis.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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
		String query = "INSERT INTO usuarios (usuarioId, usuarioTelefono, usuarioIdGcm, usuarioPassword) VALUES (?, ?);";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios getUsuarioById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios loginUser(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
