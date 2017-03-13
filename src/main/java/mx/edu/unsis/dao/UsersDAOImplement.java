package mx.edu.unsis.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import mx.edu.unsis.model.Users;

public class UsersDAOImplement implements UsersDAO{
	private static final Logger logger = LoggerFactory.getLogger(UsersDAOImplement.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void insertUser(Users user) {
		String query = "INSERT INTO usuarios (id_usuario, u_password ) VALUES (?, ?);";
		try {
			jdbcTemplate.update(query, new Object[]{user.getUser_id(), user.getUser_pass()});
			logger.info("Insercion correcta de: "+user.getUser_id());
		} catch (Exception e) {
			logger.info("Error al insertar: " + e);
		}		
	}

	@Override
	public List<Users> getAllUsers() {
		logger.info("Obteniendo todos los usuarios en el dao");
		String query = "SELECT id_usuario FROM usuarios;";
		List<Users> allTokens = new ArrayList<Users>();
		try {
			allTokens = jdbcTemplate.query(query, new UserMapper());
			return allTokens;
		} catch (Exception e) {
			logger.info("Error al obtener los tokens" + e);
			return null;
		}
	}

	@Override
	public Users getUserById(String id) {
		logger.info("Obteniendo el Usuario por el id en el dao");
		String query = "SELECT * FROM usuarios WHERE id_usuario = ?;";
		
		try {
			Users usuario = jdbcTemplate.queryForObject(query, new Object[]{id}, new UserMapper());
			return usuario;
		} catch (Exception e) {
			logger.info("Error al obtener un Usuario");
			return null;
		}
	}

	@Override
	public Users loginUser(String userName, String password) {
		logger.info("entra en el dao loginUSER");
		String query = "SELECT * FROM usuarios WHERE id_usuario = ? and u_password = ?;";
		try {
			Users userLogin = jdbcTemplate.queryForObject(query, new Object[] { userName, password },
					new UserMapper());
			logger.info("Regresa..." + userLogin);
			return userLogin;
		} catch (Exception e) {
			logger.info("Error en el metodo loginUser " + e);
			return null;
		}	
	}

}
