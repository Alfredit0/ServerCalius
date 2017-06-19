/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.request;

/**
 * Clase que se mapea con los parametro enviados por el cliente al cosumir el
 * servicio de calificaciones
 * @author VICENTE
 */
public class CalificacionesRequest {
    /*indica la contraseña de conexion*/
    private String passcon;
    /*matricula del alumno a consultar su calificación*/
    private String iduser;
    /*periodo de clases actual*/
    private String periodo;

    /**
     * @return the passcon
     */
    public String getPasscon() {
        return passcon;
    }

    /**
     * @param passcon the passcon to set
     */
    public void setPasscon(String passcon) {
        this.passcon = passcon;
    }

    /**
     * @return the iduser
     */
    public String getIduser() {
        return iduser;
    }

    /**
     * @param iduser the iduser to set
     */
    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    
}
