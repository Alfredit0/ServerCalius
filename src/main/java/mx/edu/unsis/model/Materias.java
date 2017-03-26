package mx.edu.unsis.model;

/**	
 * Esta clase se usa para el mapeo con la tabla materias de la base de datos de la aplicación
 * @author: Vicente Mendoza
 * @version: 22/03/2017
 * 
 */

public class Materias {

	/** The materia id. */
	private String materiaId;
	
	/** The materia nombre. */
	private String materiaNombre;
	
	/** The materia lic. */
	private String materiaLic;
	
	/** The materia sem. */
	private int materiaSem;
	
	/**
	 * Instantiates a new materias.
	 */
	public Materias(){
		
	}
	
	/**
	 * Gets the materia id.
	 *
	 * @return the materia id
	 */
	public String getMateriaId() {
		return materiaId;
	}
	
	/**
	 * Sets the materia id.
	 *
	 * @param materiaId the new materia id
	 */
	public void setMateriaId(String materiaId) {
		this.materiaId = materiaId;
	}
	
	/**
	 * Gets the materia nombre.
	 *
	 * @return the materia nombre
	 */
	public String getMateriaNombre() {
		return materiaNombre;
	}
	
	/**
	 * Sets the materia nombre.
	 *
	 * @param materiaNombre the new materia nombre
	 */
	public void setMateriaNombre(String materiaNombre) {
		this.materiaNombre = materiaNombre;
	}
	
	/**
	 * Gets the materia lic.
	 *
	 * @return the materia lic
	 */
	public String getMateriaLic() {
		return materiaLic;
	}
	
	/**
	 * Sets the materia lic.
	 *
	 * @param materiaLic the new materia lic
	 */
	public void setMateriaLic(String materiaLic) {
		this.materiaLic = materiaLic;
	}
	
	/**
	 * Gets the materia sem.
	 *
	 * @return the materia sem
	 */
	public int getMateriaSem() {
		return materiaSem;
	}
	
	/**
	 * Sets the materia sem.
	 *
	 * @param materiaSem the new materia sem
	 */
	public void setMateriaSem(int materiaSem) {
		this.materiaSem = materiaSem;
	}
	
}
