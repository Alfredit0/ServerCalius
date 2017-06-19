package mx.edu.unsis;

public class ResponseNotification {
	private boolean statuscon;
	private boolean procstatus;
	private int totalenviados;
	/**
	 * se obtiene el estado de la conexion 
	 * @return el estado true en caso de aber sido establecida la conexion o false en caso contrario
	 */
	public boolean getStatuscon() {
		return statuscon;
	}
	/**
	 * se le asigna el estado de la conexion a la variable statuscon
	 * @param statuscon
	 */
	public void setStatuscon(boolean statuscon) {
		this.statuscon = statuscon;
	}
	/**
	 * se obtiene el estado del proceso
	 * @return false si ocurre un error y el proseso no termida de lo cotrario regresa true 
	 */
	public boolean getProcstatus() {
		return procstatus;
	}
	/**
	 * asigna el valor a la variable procstatus
	 * @param procstatus
	 */
	public void setProcstatus(boolean procstatus) {
		this.procstatus = procstatus;
	}
	/**
	 * obtiene el número de notificaciones enviadas
	 * @return regresa el valor de totalenviados
	 */
	public int getTotalenviados() {
		return totalenviados;
	}
	/**
	 * asigan el total de notificacione senviadas a la variable totalenviados
	 * @param totalenviados
	 */
	public void setTotalenviados(int totalenviados) {
		this.totalenviados = totalenviados;
	}
	
	
}
