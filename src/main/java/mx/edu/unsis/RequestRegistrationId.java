package mx.edu.unsis;

public class RequestRegistrationId {
	//Llave para la conexion con el servicio
	private String passcon;
	
	//Id del usuario
	private String iduser;
	
	//Identificador del registro
	private String registrationId;

	
	public String getPasscon() {
		return passcon;
	}

	public void setPasscon(String passcon) {
		this.passcon = passcon;
	}		

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
}
