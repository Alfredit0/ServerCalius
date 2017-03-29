/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.request;

/**
 *
 * @author Mirna
 */
public class LoginUser {
    private String passcon;
    private String iduser;
    private String password;

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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
