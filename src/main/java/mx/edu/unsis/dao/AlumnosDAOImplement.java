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

import mx.edu.unsis.model.Alumnos;

public class AlumnosDAOImplement implements AlumnosDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnosDAOImplement.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean insertAlumno(Alumnos a) {
		String query = "INSERT INTO alumnos (alumnoMatricula, alumnoNombre, alumnoAp, alumnoAm, alumnoLic, alumnoGrupo, alumnoSem, alumnoPeriodo) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			jdbcTemplate.update(query, new Object[]{a.getAlumnoMatricula(), a.getAlumnoNombre(), a.getAlumnoAp(), a.getAlumnoLic(), a.getAlumnoGrupo(), a.getAlumnoSem(), a.getAlumnoPeriodo()});
			logger.info("El alumno fue insertado correctamente. Datos del alumno --> "+a);
			return true;
		} catch (Exception e) {
			logger.info("Error al insertar: " + e);
			return false;
		}
	}

	@Override
	public boolean updateAlumno(Alumnos a) {
		String query = "update alumnos set alumnoNombre = ?, alumnoAp = ?, alumnoAm = ?, alumnoLic = ?, alumnoGrupo = ?, alumnoSem = ?, alumnoPeriodo = ? where alumnoMatricula = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{ a.getAlumnoNombre(), a.getAlumnoAp(), a.getAlumnoLic(), a.getAlumnoGrupo(), a.getAlumnoSem(), a.getAlumnoPeriodo(), a.getAlumnoMatricula()});
			logger.info("El alumno fue actualizado correctamente. Datos del alumno --> "+a);
			return true;
		} catch (Exception e) {
			logger.info("Error al actualizar: " + e);
			return false;
		}
	}

	@Override
	public boolean eliminarAlumno(String matricula) {
		String query = "delete from alumnos where alumnoMatricula = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{ matricula});
			logger.info("El alumno fue eliminado correctamente.");
			return true;
		} catch (Exception e) {
			logger.info("Error al eliminar: " + e);
			return false;
		}
	}

	@Override
	public Alumnos getAlumnoById(String matricula) {
		String query = "select * from alumnos where alumnoMatricula = ?";
		try {
			Alumnos usuario = this.jdbcTemplate.queryForObject(
			        query,
			        new Object[]{matricula},
			        new RowMapper<Alumnos>() {
			            public Alumnos mapRow(ResultSet rs, int rowNum) throws SQLException {
			                Alumnos a = new Alumnos();
			                a.setAlumnoMatricula(rs.getString("alumnoMatricula"));
			                a.setAlumnoAm(rs.getString("alumnoAm"));
			                a.setAlumnoAp(rs.getString("alumnoAp"));
			                a.setAlumnoGrupo(rs.getString("alumnoGrupo"));
			                a.setAlumnoLic(rs.getString("alumnoLic"));
			                a.setAlumnoNombre(rs.getString("alumnoNombre"));
			                a.setAlumnoPeriodo(rs.getString("alumnoPeriodo"));
			                a.setAlumnoSem(rs.getInt("alumnoSem"));
			                return a;
			            }
			        });
			logger.info("alumno obtenido con exito --> "+ usuario);
			return usuario;
		} catch (Exception e) {
			logger.info("error al consultar el alumno con la matricula "+matricula+" --> " + e);
			return null;
		}
	}

	@Override
	public List<Alumnos> getAllAlumnos() {
		String query = "select * from alumnos";
		try {
			List<Alumnos> alumnos = this.jdbcTemplate.query(
			        query,
			        new RowMapper<Alumnos>() {
			            public Alumnos mapRow(ResultSet rs, int rowNum) throws SQLException {
			                Alumnos a = new Alumnos();
			                a.setAlumnoMatricula(rs.getString("alumnoMatricula"));
			                a.setAlumnoAm(rs.getString("alumnoAm"));
			                a.setAlumnoAp(rs.getString("alumnoAp"));
			                a.setAlumnoGrupo(rs.getString("alumnoGrupo"));
			                a.setAlumnoLic(rs.getString("alumnoLic"));
			                a.setAlumnoNombre(rs.getString("alumnoNombre"));
			                a.setAlumnoPeriodo(rs.getString("alumnoPeriodo"));
			                a.setAlumnoSem(rs.getInt("alumnoSem"));
			                return a;
			            }
			        });
			logger.info("alumnos consultados exitosamente");
			return alumnos;
		} catch (Exception e) {
			logger.info("error al consultar todos los alumnos --> " + e);
			return null;
		}
	}
	@Override
	public List<Alumnos> getAllAlumnos(String tipo, String parametro) {
		String query = "select * from alumnos JOIN usuarios ON alumnos.alumnoMatricula = usuarios.usuarioId where"+tipo+" = '"+parametro+"'";
		try {
			List<Alumnos> alumnos = this.jdbcTemplate.query(
			        query,
			        new RowMapper<Alumnos>() {
			            public Alumnos mapRow(ResultSet rs, int rowNum) throws SQLException {
			                Alumnos a = new Alumnos();
			                a.setAlumnoMatricula(rs.getString("alumnoMatricula"));
			                a.setAlumnoAm(rs.getString("alumnoAm"));
			                a.setAlumnoAp(rs.getString("alumnoAp"));
			                a.setAlumnoGrupo(rs.getString("alumnoGrupo"));
			                a.setAlumnoLic(rs.getString("alumnoLic"));
			                a.setAlumnoNombre(rs.getString("alumnoNombre"));
			                a.setAlumnoPeriodo(rs.getString("alumnoPeriodo"));
			                a.setAlumnoSem(rs.getInt("alumnoSem"));
			                return a;
			            }
			        });
			logger.info("alumnos consultados exitosamente");
			return alumnos;
		} catch (Exception e) {
			logger.info("error al consultar los alumnos por: "+ tipo +" y : "+parametro+" --> " + e);
			return null;
		}
	}
}
