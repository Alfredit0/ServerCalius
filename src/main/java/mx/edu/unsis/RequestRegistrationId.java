package mx.edu.unsis;

public class RequestRegistrationId {
	//Llave para la conexion con el servicio
	private String passcon;
	
	//Id del usuario
	private String iduser;
	
	//Identificador del registro
	private String registrationId;

	/**
	 * se obtiene la llave para la conexión
	 * @return se regresa la misma
	 */
	public String getPasscon() {
		return passcon;
	}
	/**
	 * se asigna la llave para la conexión a passcon
	 * @param passcon
	 */
	public void setPasscon(String passcon) {
		this.passcon = passcon;
	}		
	/**
	 * se obtiene el identificador del usuario
	 * @return se regresa el iduser
	 */
	
	public String getIduser() {
		return iduser;
	}
	/**
	 * se asigna el identificador del usuario
	 * @param iduser
	 */

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	/**
	 * se obtiene el identificador del usuario
	 * @return se regresa registrationId
	 */

	public String getRegistrationId() {
		return registrationId;
	}
	/**
	 * se asigna el identificador del usuario a registrationId
	 * @param registrationId
	 */
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
}
