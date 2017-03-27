package mx.edu.unsis.model;


/**	
 * Esta clase se usa para el mapeo con la tabla calificaciones de la base de datos de la aplicación
 * @author: Vicente Mendoza
 * @version: 22/03/2017
 * 
 */

public class Calificaciones {
	
	/** The c alumno matricula. */
	private String cAlumnoMatricula;
	
	/** The c materia id. */
	private String cMateriaId;
	
	/** The c periodo. */
	private String cPeriodo;
	
	/** The c parcia 1. */
	private float cParcial1;
	
	/** The c parcia 2. */
	private float cParcial2;
	
	/** The c parcia 3. */
	private float cParcial3;
	
	/** The c ordinario. */
	private float cOrdinario;
	
	/** The c final. */
	private float cFinal;
	
	/** The c extra 1. */
	private float cExtra1;
	
	/** The c extra 2. */
	private float cExtra2;
	
	/** The c especial. */
	private float cEspecial;
	
	/**
	 * Instantiates a new calificaciones.
	 */
	public Calificaciones(){
		
	}
	
	
	/**
	 * Gets the c alumno matricula.
	 *
	 * @return the c alumno matricula
	 */
	public String getcAlumnoMatricula() {
		return cAlumnoMatricula;
	}


	/**
	 * Sets the c alumno matricula.
	 *
	 * @param cAlumnoMatricula the new c alumno matricula
	 */
	public void setcAlumnoMatricula(String cAlumnoMatricula) {
		this.cAlumnoMatricula = cAlumnoMatricula;
	}


	/**
	 * Gets the c materia id.
	 *
	 * @return the c materia id
	 */
	public String getcMateriaId() {
		return cMateriaId;
	}


	/**
	 * Sets the c materia id.
	 *
	 * @param cMateriaId the new c materia id
	 */
	public void setcMateriaId(String cMateriaId) {
		this.cMateriaId = cMateriaId;
	}


	/**
	 * Gets the c periodo.
	 *
	 * @return the c periodo
	 */
	public String getcPeriodo() {
		return cPeriodo;
	}
	
	/**
	 * Sets the c periodo.
	 *
	 * @param cPeriodo the new c periodo
	 */
	public void setcPeriodo(String cPeriodo) {
		this.cPeriodo = cPeriodo;
	}
	
	/**
	 * Gets the c parcia 1.
	 *
	 * @return the c parcia 1
	 */
	public float getcParcial1() {
		return cParcial1;
	}
	
	/**
	 * Sets the c parcia 1.
	 *
	 * @param cParcia1 the new c parcia 1
	 */
	public void setcParcial1(float cParcial1) {
		this.cParcial1 = cParcial1;
	}
	
	/**
	 * Gets the c parcia 2.
	 *
	 * @return the c parcia 2
	 */
	public float getcParcial2() {
		return cParcial2;
	}
	
	/**
	 * Sets the c parcia 2.
	 *
	 * @param cParcia2 the new c parcia 2
	 */
	public void setcParcial2(float cParcial2) {
		this.cParcial2 = cParcial2;
	}
	
	/**
	 * Gets the c parcia 3.
	 *
	 * @return the c parcia 3
	 */
	public float getcParcial3() {
		return cParcial3;
	}
	
	/**
	 * Sets the c parcia 3.
	 *
	 * @param cParcia3 the new c parcia 3
	 */
	public void setcParcial3(float cParcial3) {
		this.cParcial3 = cParcial3;
	}
	
	/**
	 * Gets the c ordinario.
	 *
	 * @return the c ordinario
	 */
	public float getcOrdinario() {
		return cOrdinario;
	}
	
	/**
	 * Sets the c ordinario.
	 *
	 * @param cOrdinario the new c ordinario
	 */
	public void setcOrdinario(float cOrdinario) {
		this.cOrdinario = cOrdinario;
	}
	
	/**
	 * Gets the c final.
	 *
	 * @return the c final
	 */
	public float getcFinal() {
		return cFinal;
	}
	
	/**
	 * Sets the c final.
	 *
	 * @param cFinal the new c final
	 */
	public void setcFinal(float cFinal) {
		this.cFinal = cFinal;
	}
	
	/**
	 * Gets the c extra 1.
	 *
	 * @return the c extra 1
	 */
	public float getcExtra1() {
		return cExtra1;
	}
	
	/**
	 * Sets the c extra 1.
	 *
	 * @param cExtra1 the new c extra 1
	 */
	public void setcExtra1(float cExtra1) {
		this.cExtra1 = cExtra1;
	}
	
	/**
	 * Gets the c extra 2.
	 *
	 * @return the c extra 2
	 */
	public float getcExtra2() {
		return cExtra2;
	}
	
	/**
	 * Sets the c extra 2.
	 *
	 * @param cExtra2 the new c extra 2
	 */
	public void setcExtra2(float cExtra2) {
		this.cExtra2 = cExtra2;
	}
	
	/**
	 * Gets the c especial.
	 *
	 * @return the c especial
	 */
	public float getcEspecial() {
		return cEspecial;
	}
	
	/**
	 * Sets the c especial.
	 *
	 * @param cEspecial the new c especial
	 */
	public void setcEspecial(float cEspecial) {
		this.cEspecial = cEspecial;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "\n Calificaciones: "
				+ "\n cAlumnoMatricula: " +this.cAlumnoMatricula
				+ "\n cEspecial: " +this.cEspecial
				+ "\n cExtra1: " +this.cExtra1
				+ "\n cExtra2: " +this.cExtra2
				+ "\n cFinal: " +this.cFinal
				+ "\n cMateriaId: " +this.cMateriaId
				+ "\n cOrdinario: " +this.cOrdinario
				+ "\n cParcial1: " +this.cParcial1
				+ "\n cParcial2: " +this.cParcial2
				+ "\n cParcial3: " +this.cParcial3
				+ "\n cPeriodo: " +this.cPeriodo;
	}
	
}
