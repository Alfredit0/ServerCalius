/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.unsis.service;

import java.util.List;
import javax.sql.DataSource;
import mx.edu.unsis.model.Calificaciones;
import mx.edu.unsis.model.CalificacionesAlumno;
import mx.edu.unsis.model.MateriasAlumno;

/**
 *
 * @author VICENTE
 */
public interface CalificacionesService {
    	
	/**
	 * Insert administrativo.
	 *
	 * @param a el objeto administrativo a insertar en la BD
	 */
	public boolean insertCalificaciones(Calificaciones c);
	
	/**
	 * Update adminitrativo.
	 *
	 * @param a el objeto administrativos a eliminar
	 */
	public boolean updateCalificaciones(Calificaciones c);
	
	/**
	 * Eliminar administrativo.
	 *
	 * @param adminId el Id del administrativo a eliminar
	 * @return true, si el administrativo se elimino correctamente
	 */
	public boolean eliminarCalificaciones(String cAlumnoMatricula, String cMateriaId,String cPeriodo);
	
	/**
	 * Gets the administrativo by id.
	 *
	 * @param adminId el Id del administrativo a buscar
	 * @return el objeto adminitrativos que fue buscado, null en caso de que no fue encontrado
	 */
	public Calificaciones getCalificacionesById(String cAlumnoMatricula, String cMateriaId,String cPeriodo);
	
	/**
	 * Gets the all administrativos.
	 *
	 * @return todos los administrativos existentes en la base de datos
	 */
	public List<Calificaciones> getAllCalificaciones();
        
        public List<MateriasAlumno> getMateriasByAlumno(String alumnoMatricula, String periodo);
        
        public List<CalificacionesAlumno> getCalificacionesByAlumno(String alumnoMatricula, String periodo);
}
