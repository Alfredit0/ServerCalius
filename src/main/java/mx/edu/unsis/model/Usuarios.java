package mx.edu.unsis.model;

// TODO: Auto-generated Javadoc
/**
 * 	
 * Esta clase se usa para el mapeo con la tabla usuarios de la base de datos de la aplicación.
 *
 * @author: Vicente Mendoza
 * @version: 22/03/2017
 */
public class Usuarios {
	
	/** The usuario id. */
	private String usuarioId;
	
	/** The usuario telefono. */
	private String usuarioTelefono;
	
	/** The usuario id gcm. */
	private String usuarioIdGcm;
	
	/** The usuario password. */
	private String usuarioPassword;
	
	/**
	 * Instantiates a new usuarios.
	 */
	public Usuarios(){
		
	}

	/**
	 * Gets the usuario id.
	 *
	 * @return the usuario id
	 */
	public String getUsuarioId() {
		return usuarioId;
	}

	/**
	 * Sets the usuario id.
	 *
	 * @param usuarioId the new usuario id
	 */
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * Gets the usuario telefono.
	 *
	 * @return the usuario telefono
	 */
	public String getUsuarioTelefono() {
		return usuarioTelefono;
	}

	/**
	 * Sets the usuario telefono.
	 *
	 * @param usuarioTelefono the new usuario telefono
	 */
	public void setUsuarioTelefono(String usuarioTelefono) {
		this.usuarioTelefono = usuarioTelefono;
	}

	/**
	 * Gets the usuario id gcm.
	 *
	 * @return the usuario id gcm
	 */
	public String getUsuarioIdGcm() {
		return usuarioIdGcm;
	}

	/**
	 * Sets the usuario id gcm.
	 *
	 * @param usuarioIdGcm the new usuario id gcm
	 */
	public void setUsuarioIdGcm(String usuarioIdGcm) {
		this.usuarioIdGcm = usuarioIdGcm;
	}

	/**
	 * Gets the usuario password.
	 *
	 * @return the usuario password
	 */
	public String getUsuarioPassword() {
		return usuarioPassword;
	}

	/**
	 * Sets the usuario password.
	 *
	 * @param usuarioPassword the new usuario password
	 */
	public void setUsuarioPassword(String usuarioPassword) {
		this.usuarioPassword = usuarioPassword;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "\nusuarioId: "+this.usuarioId+
				"\nusuarioPassword: "+this.usuarioPassword+
				"\nusuarioTelefono: "+this.usuarioIdGcm+
				"\nusuarioIdGcm: "+this.getUsuarioIdGcm();
	}
}
