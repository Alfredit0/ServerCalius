package mx.edu.unsis.model;

public class Users {
	private String usuarioId;
	private String usuarioTelefono;
	private String usuarioIdGcm;
	private String usuarioPassword;
	
	public Users(){
		
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuarioTelefono() {
		return usuarioTelefono;
	}

	public void setUsuarioTelefono(String usuarioTelefono) {
		this.usuarioTelefono = usuarioTelefono;
	}

	public String getUsuarioIdGcm() {
		return usuarioIdGcm;
	}

	public void setUsuarioIdGcm(String usuarioIdGcm) {
		this.usuarioIdGcm = usuarioIdGcm;
	}

	public String getUsuarioPassword() {
		return usuarioPassword;
	}

	public void setUsuarioPassword(String usuarioPassword) {
		this.usuarioPassword = usuarioPassword;
	}
	
}
