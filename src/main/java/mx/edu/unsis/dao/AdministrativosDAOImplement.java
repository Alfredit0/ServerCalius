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

import mx.edu.unsis.model.Administrativos;

public class AdministrativosDAOImplement implements AdministrativosDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnosDAOImplement.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean insertAdministrativo(Administrativos a) {
		String query = "INSERT INTO administrativos (adminId, adminNombre, adminApePaterno, adminApeMaterno, adminPuesto) values (?, ?, ?);";
		try {
			jdbcTemplate.update(query, new Object[]{a.getAdminId(), a.getAdminNombre(), a.getAdminApePaterno(), a.getAdminApeMaterno(), a.getAdminPuesto()});
			logger.info("El administrativo fue insertado correctamente. Datos del adminitrativo --> "+a);
			return true;
		} catch (Exception e) {
			logger.info("Error al insertar: " + e);
			return false;
		}
	}

	@Override
	public boolean updateAdministrativo(Administrativos a) {
		String query = "update administrativos set adminNombre = ?, adminApePaterno= ?,adminApeMaterno = ?, adminPuesto = ? where adminId = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{ a.getAdminNombre(), a.getAdminPuesto(), a.getAdminId()});
			logger.info("El administrador fue actualizado correctamente. Datos del administrador --> "+a);
			return true;
		} catch (Exception e) {
			logger.info("Error al actualizar: " + e);
			return false;
		}
	}

	@Override
	public boolean eliminarAdministrativo(String adminId) {
		String query = "delete from administrativos where adminId = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{ adminId});
			logger.info("El administrador fue eliminado correctamente.");
			return true;
		} catch (Exception e) {
			logger.info("Error al eliminar: " + e);
			return false;
		}
	}

	@Override
	public Administrativos getAdministrativoById(String adminId) {
		String query = "select * from administrativos where adminId = ?";
		try {
			Administrativos admin = this.jdbcTemplate.queryForObject(
			        query,
			        new Object[]{adminId},
			        new RowMapper<Administrativos>() {
			            public Administrativos mapRow(ResultSet rs, int rowNum) throws SQLException {
			                Administrativos a = new Administrativos();
			                a.setAdminId(rs.getString("adminId"));
			                a.setAdminNombre(rs.getString("adminNombre"));
                                        a.setAdminApePaterno(rs.getString("adminApePaterno"));
                                        a.setAdminApeMaterno(rs.getString("adminApeMaterno"));
			                a.setAdminPuesto(rs.getString("adminPuesto"));
			                return a;
			            }
			        });
			logger.info("administrativo obtenido con exito --> "+ admin);
			return admin;
		} catch (Exception e) {
			logger.info("error al consultar el administrativo con el id "+adminId+" --> " + e);
			return null;
		}
	}

	@Override
	public List<Administrativos> getAllAdministrativo() {
		String query = "select * from administrativos";
		try {
			List<Administrativos> alumnos = this.jdbcTemplate.query(
			        query,
			        new RowMapper<Administrativos>() {
			            public Administrativos mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	Administrativos a = new Administrativos();
			                a.setAdminId(rs.getString("adminId"));
			                a.setAdminNombre(rs.getString("adminNombre"));
                                        a.setAdminApePaterno(rs.getString("adminApePaterno"));
                                        a.setAdminApeMaterno(rs.getString("adminApeMaterno"));
			                a.setAdminPuesto(rs.getString("adminPuesto"));
			                return a;
			            }
			        });
			logger.info("administrativos consultados exitosamente");
			return alumnos;
		} catch (Exception e) {
			logger.info("error al consultar todos los administrativos --> " + e);
			return null;
		}
	}

}
