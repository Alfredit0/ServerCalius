package mx.edu.unsis.model;

// TODO: Auto-generated Javadoc
/**
 * 	
 * Esta clase se usa para el mapeo con la tabla notificaciones de la base de datos de la aplicación.
 *
 * @author: Vicente Mendoza
 * @version: 22/03/2017
 */

public class Notificaciones {
	
	/** The notif id. */
	private int notifId;
	
	/** The notif remitente. */
	private String notifRemitente;
	
	/** The notif destinatario. */
	private String notifDestinatario;
	
	/** The notif mensaje. */
	private String notifMensaje;
	
	/** The notif fecha. */
	private String notifFecha;
	
	/** The notif asunto. */
	private String notifAsunto;
	
	/**
	 * Instantiates a new notificaciones.
	 */
	public Notificaciones(){
		
	}
	
	/**
	 * Gets the notif id.
	 *
	 * @return the notif id
	 */
	public int getNotifId() {
		return notifId;
	}
	
	/**
	 * Sets the notif id.
	 *
	 * @param notifId the new notif id
	 */
	public void setNotifId(int notifId) {
		this.notifId = notifId;
	}
	
	/**
	 * Gets the notif remitente.
	 *
	 * @return the notif remitente
	 */
	public String getNotifRemitente() {
		return notifRemitente;
	}

	/**
	 * Sets the notif remitente.
	 *
	 * @param notifRemitente the new notif remitente
	 */
	public void setNotifRemitente(String notifRemitente) {
		this.notifRemitente = notifRemitente;
	}

	/**
	 * Gets the notif destinatario.
	 *
	 * @return the notif destinatario
	 */
	public String getNotifDestinatario() {
		return notifDestinatario;
	}
	
	/**
	 * Sets the notif destinatario.
	 *
	 * @param notifDestinatario the new notif destinatario
	 */
	public void setNotifDestinatario(String notifDestinatario) {
		this.notifDestinatario = notifDestinatario;
	}
	
	/**
	 * Gets the notif mensaje.
	 *
	 * @return the notif mensaje
	 */
	public String getNotifMensaje() {
		return notifMensaje;
	}
	
	/**
	 * Sets the notif mensaje.
	 *
	 * @param notifMensaje the new notif mensaje
	 */
	public void setNotifMensaje(String notifMensaje) {
		this.notifMensaje = notifMensaje;
	}
	
	/**
	 * Gets the notif fecha.
	 *
	 * @return the notif fecha
	 */
	public String getNotifFecha() {
		return notifFecha;
	}
	
	/**
	 * Sets the notif fecha.
	 *
	 * @param notifFecha the new notif fecha
	 */
	public void setNotifFecha(String notifFecha) {
		this.notifFecha = notifFecha;
	}
	
	/**
	 * Gets the notif asunto.
	 *
	 * @return the notif asunto
	 */
	public String getNotifAsunto() {
		return notifAsunto;
	}
	
	/**
	 * Sets the notif asunto.
	 *
	 * @param notifAsunto the new notif asunto
	 */
	public void setNotifAsunto(String notifAsunto) {
		this.notifAsunto = notifAsunto;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "\n Notificaciones:"
				+ "\n notifAsunto: " + this.notifAsunto
				+ "\n notifDestinatario: " + this.notifAsunto
				+ "\n notifFecha: " + this.notifAsunto
				+ "\n notifId: " + this.notifAsunto
				+ "\n notifMensaje: " + this.notifAsunto
				+ "\n notifRemitente: " + this.notifAsunto;
	}
}
