package mx.edu.request;

public class RegisteridNotification {
	private String passcon;
	private String iduser;
	private String registrationId;
	
	/*regresa passcon*/
	public String getPasscon() {
		return passcon;
	}
	/*asigna valor a passcon*/
	public void setPasscon(String passcon) {
		this.passcon = passcon;
	}
	/*regresa iduser*/
	public String getIduser() {
		return iduser;
	}
	/*asigna valor a iduser*/
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	/*regresa registrationId*/
	public String getRegistrationId() {
		return registrationId;
	}
	/*asigna valor a registrationId*/ 
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
}
