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
import mx.edu.unsis.model.Materias;

public class MateriasDAOImplement implements MateriasDAO{

	private static final Logger logger = LoggerFactory.getLogger(AlumnosDAOImplement.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertMateria(Materias a) {
		String query = "INSERT INTO materias (materiaId, materiaNombre, materiaLic, materiaSem) values (?, ?, ?, ?);";
		try {
			jdbcTemplate.update(query, new Object[]{a.getMateriaId(), a.getMateriaNombre(), a.getMateriaLic(), a.getMateriaSem()});
			logger.info("La materia fue insertado correctamente. Datos de la materia --> "+a);
		} catch (Exception e) {
			logger.info("Error al insertar: " + e);
		}
	}

	@Override
	public void updateMaterias(Materias a) {
		String query = "update materias set materiaNombre = ?, materiaLic = ?, materiaSem = ? where materiaId = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{a.getMateriaNombre(), a.getMateriaLic(), a.getMateriaSem(), a.getMateriaId()});
			logger.info("la materia fue actualizado correctamente. Datos de la materia --> "+a);
		} catch (Exception e) {
			logger.info("Error al actualizar: " + e);
		}
	}

	@Override
	public boolean eliminarMateria(String materiaId) {
		String query = "delete from materias where materiaId = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{ materiaId});
			logger.info("La materia fue eliminado correctamente.");
			return true;
		} catch (Exception e) {
			logger.info("Error al eliminar: " + e);
			return false;
		}
	}

	@Override
	public Materias getMateriaById(String materiaId) {
		String query = "select * from materias where materiaId = ?";
		try {
			Materias materia = this.jdbcTemplate.queryForObject(
			        query,
			        new Object[]{materiaId},
			        new RowMapper<Materias>() {
			            public Materias mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	Materias a = new Materias();
			            	a.setMateriaId(rs.getString("materiaId"));
			            	a.setMateriaLic(rs.getString("materiaLic"));
			            	a.setMateriaNombre(rs.getString("materiaNombre"));
			            	a.setMateriaSem(rs.getInt("materiaSem"));
			                return a;
			            }
			        });
			logger.info("materia obtenido con exito --> "+ materia);
			return materia;
		} catch (Exception e) {
			logger.info("error al consultar la materia con el id "+materiaId+" --> " + e);
			return null;
		}
	}

	@Override
	public List<Materias> getAllMaterias() {
		String query = "select * from materias";
		try {
			List<Materias> materias = this.jdbcTemplate.query(
			        query,
			        new RowMapper<Materias>() {
			            public Materias mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	Materias a = new Materias();
			            	a.setMateriaId(rs.getString("materiaId"));
			            	a.setMateriaLic(rs.getString("materiaLic"));
			            	a.setMateriaNombre(rs.getString("materiaNombre"));
			            	a.setMateriaSem(rs.getInt("materiaSem"));
			                return a;
			            }
			        });
			logger.info("materias consultados exitosamente");
			return materias;
		} catch (Exception e) {
			logger.info("error al consultar todos las materias --> " + e);
			return null;
		}
	}

}
