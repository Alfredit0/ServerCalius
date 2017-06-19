package mx.edu.unsis;
/**
 * Case para obtenere la estructura de una notificación
 * @author Mirna
 *
 */
public class RequestNotification {
	private String passcon;
	private String asunto;
	private String tipo;
	private String destintario;
	private String mensaje;
	private String remitente;
	/**
	 * Método para obtener passcon
	 * @return la contraseña de conexión
	 */
	public String getPasscon() {
		return passcon;
	}
	/**
	 * asigna valor a passcon
	 * @param se le asigna valor a passcon 
	 */
	public void setPasscon(String passcon) {
		this.passcon = passcon;
	}
	/**
	 * obtiene el valor de asunto
	 * @return el valor del asunto
	 */
	public String getAsunto() {
		return asunto;
	}
	/**
	 * asinga valor a la variable asunto
	 * @param asunto variable para el asunto
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	/**
	 * obtiene el tipo de notificación
	 * @return el valor del tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * asinga valor a la variable tipo
	 * @param tipo variable para guardar el tipo de notificación
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * obtiene el valor del destinatario
	 * @return la variable destinatario
	 */
	public String getDestintario() {
		return destintario;
	}
	/**
	 * asigna el valor a la variable destinatario
	 * @param destintario variable para guardar el destinatario
	 */
	public void setDestintario(String destintario) {
		this.destintario = destintario;
	}
	/**
	 * se obtiene el mensaje
	 * @return el valor del mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * se asigna el valor del mensaje a la variable mensaje
	 * @param mensaje variable para guardar el mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * se obtiene el valor del remitente
	 * @return se regresa el valor del remitente
	 */
	public String getRemitente() {
		return remitente;
	}
	/**
	 * se asigna el vaolor del remitente
	 * @param remitente se asigna a la variable
	 */
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	/**
	 * Método para regresar una cadena con todos los componetes de la notificación
	 */
	public String toString(){
		return "\nAlumnos: "
				+ "\n passcon: " + this.passcon
				+ "\n asunto: " + this.asunto
				+ "\n tipo: " + this.tipo
				+ "\n destintario: " + this.destintario
				+ "\n mensaje: " + this.mensaje
				+ "\n remitente: " + this.remitente;
	}

}
