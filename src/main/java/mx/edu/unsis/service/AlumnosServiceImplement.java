package mx.edu.unsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.unsis.dao.AlumnosDAO;
import mx.edu.unsis.model.Alumnos;

/**
 * 	
 * clase que implementa el servicio de los métodos para la coneccion con la base de datos de la tabla alumnos.
 *
 * @author: Vicente Mendoza
 * @version: 26/03/2017
 */
public class AlumnosServiceImplement implements AlumnosService{
	
	/** The u. */
	@Autowired
	private AlumnosDAO a;
	
	/* (non-Javadoc)
	 * @see mx.edu.unsis.service.AlumnosService#insertAlumno(mx.edu.unsis.model.Alumnos)
	 */
	@Override
	public boolean insertAlumno(Alumnos a) {
		return this.a.insertAlumno(a);
	}

	/* (non-Javadoc)
	 * @see mx.edu.unsis.service.AlumnosService#updateAlumno(mx.edu.unsis.model.Alumnos)
	 */
	@Override
	public boolean updateAlumno(Alumnos a) {
		return this.a.updateAlumno(a);
	}

	/* (non-Javadoc)
	 * @see mx.edu.unsis.service.AlumnosService#eliminarAlumno(java.lang.String)
	 */
	@Override
	public boolean eliminarAlumno(String matricula) {
		return this.a.eliminarAlumno(matricula);
	}

	/* (non-Javadoc)
	 * @see mx.edu.unsis.service.AlumnosService#getAlumnoById(java.lang.String)
	 */
	@Override
	public Alumnos getAlumnoById(String matricula) {
		return this.a.getAlumnoById(matricula);
	}

	/* (non-Javadoc)
	 * @see mx.edu.unsis.service.AlumnosService#getAllAlumnos()
	 */
	@Override
	public List<Alumnos> getAllAlumnos() {
		return this.a.getAllAlumnos();
	}

	@Override
	public List<String> getGruposActuales() {
		return this.a.getGruposActuales();
	}

}
