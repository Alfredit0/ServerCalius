/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.unsis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import mx.edu.unsis.model.Calificaciones;
import mx.edu.unsis.model.CalificacionesAlumno;
import mx.edu.unsis.model.MateriasAlumno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VICENTE
 */
public class CalificacionesDAOImplement implements CalificacionesDAO{

    private static final Logger logger = LoggerFactory.getLogger(AlumnosDAOImplement.class);
    private JdbcTemplate jdbcTemplate;
	
    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insertCalificaciones(Calificaciones c) {
        String query = "INSERT INTO calificaciones (cAlumnoMatricula, cMateriaId, cPeriodo, cParcial1, cParcial2, cParcial3, cOrdinario, cFinal, cExtra1, cExtra2, cEspecial) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			jdbcTemplate.update(query, new Object[]{c.getcAlumnoMatricula(), c.getcMateriaId(), c.getcPeriodo(), c.getcParcial1(), c.getcParcial2(), c.getcParcial3(), c.getcOrdinario(), c.getcFinal(), c.getcExtra1(), c.getcExtra2(), c.getcEspecial()});
			logger.info("insercción correctamente. Datos --> "+c);
			return true;
		} catch (Exception e) {
			logger.info("Error al insertar: " + e);
			return false;
		}
    }

    @Override
    public boolean updateCalificaciones(Calificaciones c) {
        String query = "update calificaciones set cParcial1 = ?, cParcial2 = ?, cParcial3 = ?, cOrdinario = ?, cFinal = ?, cExtra1 = ?, cExtra2 = ?, cEspecial = ? where cAlumnoMatricula = ?, cMateriaId = ? cPeriodo = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{c.getcParcial1(), c.getcParcial2(), c.getcParcial3(), c.getcOrdinario(), c.getcFinal(), c.getcExtra1(), c.getcExtra2(), c.getcEspecial(), c.getcAlumnoMatricula(), c.getcMateriaId(), c.getcPeriodo()});
			logger.info("actualización exitosamente. Datos --> "+c);
			return true;
		} catch (Exception e) {
			logger.info("Error al actualizar: " + e);
			return false;
		}
    }

    @Override
    public boolean eliminarCalificaciones(String cAlumnoMatricula, String cMateriaId,String cPeriodo) {
        String query = "delete from calificaciones where cAlumnoMatricula = ? and cMateriaId = ?, cPeriodo = ?;";
		try {
			jdbcTemplate.update(query, new Object[]{ cAlumnoMatricula, cMateriaId, cPeriodo});
			logger.info("eliminación exitosamente");
			return true;
		} catch (Exception e) {
			logger.info("Error al eliminar: " + e);
			return false;
		}
    }

    @Override
    public Calificaciones getCalificacionesById(String cAlumnoMatricula, String cMateriaId,String cPeriodo) {
        String query = "select * from calificaciones where cAlumnoMatricula = ? and cMateriaId = ?, cPeriodo = ?;";
		try {
			Calificaciones calificaciones = this.jdbcTemplate.queryForObject(
			        query,
			        new Object[]{cAlumnoMatricula, cMateriaId, cPeriodo},
			        new RowMapper<Calificaciones>() {
			            public Calificaciones mapRow(ResultSet rs, int rowNum) throws SQLException {
			                Calificaciones c = new Calificaciones();
                                        c.setcAlumnoMatricula(rs.getString("cAlumnoMatricula"));
                                        c.setcEspecial(rs.getFloat("cMateriaId"));
                                        c.setcExtra1(rs.getFloat("cPeriodo"));
                                        c.setcExtra2(rs.getFloat("cParcial1"));
                                        c.setcFinal(rs.getFloat("cParcial2"));
                                        c.setcMateriaId(rs.getString("cParcial3"));
                                        c.setcOrdinario(rs.getFloat("cOrdinario"));
                                        c.setcParcial1(rs.getFloat("cFinal"));
                                        c.setcParcial2(rs.getFloat("cExtra1"));
                                        c.setcParcial3(rs.getFloat("cExtra2"));
                                        c.setcPeriodo(rs.getString("cEspecial"));
			                return c;
			            }
			        });
			return calificaciones;
		} catch (Exception e) {
			logger.info("error al consultar" + e);
			return null;
		}
    }

    @Override
    public List<Calificaciones> getAllCalificaciones() {
        String query = "select * from calificaciones";
		try {
			List<Calificaciones> calificaciones = this.jdbcTemplate.query(
			        query,
			        new RowMapper<Calificaciones>() {
			            public Calificaciones mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	Calificaciones c = new Calificaciones();
                                        c.setcAlumnoMatricula(rs.getString("cAlumnoMatricula"));
                                        c.setcEspecial(rs.getFloat("cMateriaId"));
                                        c.setcExtra1(rs.getFloat("cPeriodo"));
                                        c.setcExtra2(rs.getFloat("cParcial1"));
                                        c.setcFinal(rs.getFloat("cParcial2"));
                                        c.setcMateriaId(rs.getString("cParcial3"));
                                        c.setcOrdinario(rs.getFloat("cOrdinario"));
                                        c.setcParcial1(rs.getFloat("cFinal"));
                                        c.setcParcial2(rs.getFloat("cExtra1"));
                                        c.setcParcial3(rs.getFloat("cExtra2"));
                                        c.setcPeriodo(rs.getString("cEspecial"));
			                return c;
			            }
			        });
			return calificaciones;
		} catch (Exception e) {
			logger.info("error al consultar " + e);
			return null;
		}
    }

    @Override
    public List<MateriasAlumno> getMateriasByAlumno(String alumnoMatricula, String periodo) {
        String query = "select M.materiaId, M.materiaNombre " +
            "from calificaciones C, materias M " +
            "where cAlumnoMatricula = ? and cPeriodo = ? and C.cMateriaId = M.materiaId group by cMateriaId;";
		try {
			List<MateriasAlumno> materias = this.jdbcTemplate.query(
			        query,
			        new Object[]{alumnoMatricula, periodo},
			        new RowMapper<MateriasAlumno>() {
			            public MateriasAlumno mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	MateriasAlumno materia = new MateriasAlumno();
                                        materia.setIdMateria(rs.getString("materiaId"));
                                        materia.setNombreMateria(rs.getString("materiaNombre"));
			                return materia;
			            }
			        });
			return materias;
		} catch (Exception e) {
			logger.info("error al consultar " + e);
			return null;
		}
    }

    @Override
    public List<CalificacionesAlumno> getCalificacionesByAlumno(String alumnoMatricula, String periodo) {
        String query = "select cMateriaId, cParcial1, cParcial2, cParcial3, cOrdinario " +
                        "from calificaciones " +
                        "where cAlumnoMatricula = ? and cPeriodo = ? group by cMateriaId;";
		try {
			List<CalificacionesAlumno> calificaciones = this.jdbcTemplate.query(
			        query,
			        new Object[]{alumnoMatricula, periodo},
			        new RowMapper<CalificacionesAlumno>() {
			            public CalificacionesAlumno mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	CalificacionesAlumno calificacion = new CalificacionesAlumno();
                                        calificacion.setMateriaId(rs.getString("cMateriaId"));
                                        calificacion.setOrdinario(rs.getFloat("cOrdinario"));
                                        calificacion.setParcial1(rs.getFloat("cParcial1"));
                                        calificacion.setParcial2(rs.getFloat("cParcial2"));
                                        calificacion.setParcial3(rs.getFloat("cParcial3"));
			                return calificacion;
			            }
			        });
			return calificaciones;
		} catch (Exception e) {
			logger.info("error al consultar " + e);
			return null;
		}
    }
    
}
