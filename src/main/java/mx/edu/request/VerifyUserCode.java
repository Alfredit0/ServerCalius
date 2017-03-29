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
public class VerifyUserCode {
    private String passcon;
    private String iduser;
    private String code;

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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
}
