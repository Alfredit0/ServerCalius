package mx.edu.unsis.model;

/**	
 * Esta clase se usa para el mapeo con la tabla alumnos de la base de datos de la aplicación
 * @author: Vicente Mendoza
 * @version: 22/03/2017
 * 
 */

public class Alumnos {
	
	/** The alumno matricula. */
	private String alumnoMatricula;
	
	/** The alumno nombre. */
	private String alumnoNombre;
	
	/** The alumno ap. */
	private String alumnoAp;
	
	/** The alumno am. */
	private String alumnoAm;
	
	/** The alumno lic. */
	private String alumnoLic;
	
	/** The alumno grupo. */
	private String alumnoGrupo;
	
	/** The alumno sem. */
	private int alumnoSem;
	
	/** The alumno periodo. */
	private String alumnoPeriodo;
	
	/**
	 * Instantiates a new alumnos.
	 */
	public Alumnos(){
		
	}
	
	/**
	 * Gets the alumno matricula.
	 *
	 * @return the alumno matricula
	 */
	public String getAlumnoMatricula() {
		return alumnoMatricula;
	}
	
	/**
	 * Sets the alumno matricula.
	 *
	 * @param alumnoMatricula the new alumno matricula
	 */
	public void setAlumnoMatricula(String alumnoMatricula) {
		this.alumnoMatricula = alumnoMatricula;
	}
	
	/**
	 * Gets the alumno nombre.
	 *
	 * @return the alumno nombre
	 */
	public String getAlumnoNombre() {
		return alumnoNombre;
	}
	
	/**
	 * Sets the alumno nombre.
	 *
	 * @param alumnoNombre the new alumno nombre
	 */
	public void setAlumnoNombre(String alumnoNombre) {
		this.alumnoNombre = alumnoNombre;
	}
	
	/**
	 * Gets the alumno ap.
	 *
	 * @return the alumno ap
	 */
	public String getAlumnoAp() {
		return alumnoAp;
	}
	
	/**
	 * Sets the alumno ap.
	 *
	 * @param alumnoAp the new alumno ap
	 */
	public void setAlumnoAp(String alumnoAp) {
		this.alumnoAp = alumnoAp;
	}
	
	/**
	 * Gets the alumno am.
	 *
	 * @return the alumno am
	 */
	public String getAlumnoAm() {
		return alumnoAm;
	}
	
	/**
	 * Sets the alumno am.
	 *
	 * @param alumnoAm the new alumno am
	 */
	public void setAlumnoAm(String alumnoAm) {
		this.alumnoAm = alumnoAm;
	}
	
	/**
	 * Gets the alumno lic.
	 *
	 * @return the alumno lic
	 */
	public String getAlumnoLic() {
		return alumnoLic;
	}
	
	/**
	 * Sets the alumno lic.
	 *
	 * @param alumnoLic the new alumno lic
	 */
	public void setAlumnoLic(String alumnoLic) {
		this.alumnoLic = alumnoLic;
	}
	
	/**
	 * Gets the alumno grupo.
	 *
	 * @return the alumno grupo
	 */
	public String getAlumnoGrupo() {
		return alumnoGrupo;
	}
	
	/**
	 * Sets the alumno grupo.
	 *
	 * @param alumnoGrupo the new alumno grupo
	 */
	public void setAlumnoGrupo(String alumnoGrupo) {
		this.alumnoGrupo = alumnoGrupo;
	}
	
	/**
	 * Gets the alumno sem.
	 *
	 * @return the alumno sem
	 */
	public int getAlumnoSem() {
		return alumnoSem;
	}
	
	/**
	 * Sets the alumno sem.
	 *
	 * @param alumnoSem the new alumno sem
	 */
	public void setAlumnoSem(int alumnoSem) {
		this.alumnoSem = alumnoSem;
	}
	
	/**
	 * Gets the alumno periodo.
	 *
	 * @return the alumno periodo
	 */
	public String getAlumnoPeriodo() {
		return alumnoPeriodo;
	}
	
	/**
	 * Sets the alumno periodo.
	 *
	 * @param alumnoPeriodo the new alumno periodo
	 */
	public void setAlumnoPeriodo(String alumnoPeriodo) {
		this.alumnoPeriodo = alumnoPeriodo;
	}
	
}
