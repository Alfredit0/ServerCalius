package mx.edu.unsis;

public class RequestNotification {
	private String passcon;
	private String asunto;
	private String tipo;
	private String destintario;
	private String mensaje;
	private String remitente;
	
	public String getPasscon() {
		return passcon;
	}
	public void setPasscon(String passcon) {
		this.passcon = passcon;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDestintario() {
		return destintario;
	}
	public void setDestintario(String destintario) {
		this.destintario = destintario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	

}
