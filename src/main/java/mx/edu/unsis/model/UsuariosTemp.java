package mx.edu.unsis.model;

/**
 * 	
 * Esta clase se usa para el mapeo con la tabla usuariostemp de la base de datos de la aplicación.
 *
 * @author: Vicente Mendoza
 * @version: 28/03/2017
 */
public class UsuariosTemp {
	private String usuarioId;
	private String usuarioTelefono;
	private String usuarioCodigo;
	/**
	 * @return the usuarioId
	 */
	public String getUsuarioId() {
		return usuarioId;
	}
	/**
	 * @param usuarioId the usuarioId to set
	 */
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	/**
	 * @return the usuarioTelefono
	 */
	public String getUsuarioTelefono() {
		return usuarioTelefono;
	}
	/**
	 * @param usuarioTelefono the usuarioTelefono to set
	 */
	public void setUsuarioTelefono(String usuarioTelefono) {
		this.usuarioTelefono = usuarioTelefono;
	}
	/**
	 * @return the usuarioCodigo
	 */
	public String getUsuarioCodigo() {
		return usuarioCodigo;
	}
	/**
	 * @param usuarioCodigo the usuarioCodigo to set
	 */
	public void setUsuarioCodigo(String usuarioCodigo) {
		this.usuarioCodigo = usuarioCodigo;
	}
	
	public String toString(){
		return "\n usuarioId: "+this.usuarioId+
				"\n usuarioTelefono: "+this.usuarioTelefono+
				"\n usuarioCodigo: "+this.usuarioCodigo;
	}
}
