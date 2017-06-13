package mx.edu.unsis.model;


/**	
 * Esta clase se usa para el mapeo con la tabla administrativos de la base de datos de la aplicación
 * @author: Vicente Mendoza
 * @version: 22/03/2017
 * 
 */

public class Administrativos {
	
	/** The admin id. */
	private String adminId;
	
	/** The admin nombre. */
	private String adminNombre;

        /** The admin adminApePaterno. */
	private String adminApePaterno;
        
        /** The admin adminApeMaterno. */
	private String adminApeMaterno;
	/** The admin puesto. */
	private String adminPuesto;
	
	/**
	 * Instantiates a new administrativos.
	 */
	public Administrativos(){
		
	}
	
	/**
	 * Gets the admin id.
	 *
	 * @return the admin id
	 */
	public String getAdminId() {
		return adminId;
	}
	
	/**
	 * Sets the admin id.
	 *
	 * @param adminId the new admin id
	 * 
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	/**
	 * Gets the admin nombre.
	 *
	 * @return the admin nombre
	 */
	public String getAdminNombre() {
		return adminNombre;
	}
	
	/**
	 * Sets the admin nombre.
	 *
	 * @param adminNombre the new admin nombre
	 * 
	 */
	public void setAdminNombre(String adminNombre) {
		this.adminNombre = adminNombre;
	}
	
	/**
	 * Gets the admin puesto.
	 *
	 * @return the admin puesto
	 */
	public String getAdminPuesto() {
		return adminPuesto;
	}
	
	/**
	 * Sets the admin puesto.
	 *
	 * @param adminPuesto the new admin puesto
	 * 
	 */
	public void setAdminPuesto(String adminPuesto) {
		this.adminPuesto = adminPuesto;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "\n Administrativos: "
				+ "\n adminId: " +this.adminId
				+ "\n adminNombre: " +this.adminNombre
				+ "\n adminPuesto: " +this.adminPuesto;
	}

    public String getAdminApePaterno() {
        return adminApePaterno;
    }

    public void setAdminApePaterno(String adminApePaterno) {
        this.adminApePaterno = adminApePaterno;
    }

    public String getAdminApeMaterno() {
        return adminApeMaterno;
    }

    public void setAdminApeMaterno(String adminApeMaterno) {
        this.adminApeMaterno = adminApeMaterno;
    }
}
