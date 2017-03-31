package mx.edu.unsis;

public class RequestRegistrationId {
	//Llave para la conexion con el servicio
	private String passcon;
	
	//Identificador del registro
	private String registrationId;

	
	public String getPasscon() {
		return passcon;
	}

	public void setPasscon(String passcon) {
		this.passcon = passcon;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
}
