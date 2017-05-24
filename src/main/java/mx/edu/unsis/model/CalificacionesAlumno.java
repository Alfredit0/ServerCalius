/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.unsis.model;

/**
 *
 * @author VICENTE
 */
public class CalificacionesAlumno {
    private String materiaId;
    private float parcial1;
    private float parcial2;
    private float parcial3;
    private float ordinario;
    
    public CalificacionesAlumno(){
        
    }
    
    public CalificacionesAlumno(String materiaId, float parcial1, float parcial2, float parcial3, float ordinario){
        this.materiaId = materiaId;
        this.ordinario = ordinario;
        this.parcial1 = parcial1;
        this.parcial2 = parcial2;
        this.parcial3 = parcial3;
    }

    /**
     * @return the materiaId
     */
    public String getMateriaId() {
        return materiaId;
    }

    /**
     * @param materiaId the materiaId to set
     */
    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }

    /**
     * @return the parcial1
     */
    public float getParcial1() {
        return parcial1;
    }

    /**
     * @param parcial1 the parcial1 to set
     */
    public void setParcial1(float parcial1) {
        this.parcial1 = parcial1;
    }

    /**
     * @return the parcial2
     */
    public float getParcial2() {
        return parcial2;
    }

    /**
     * @param parcial2 the parcial2 to set
     */
    public void setParcial2(float parcial2) {
        this.parcial2 = parcial2;
    }

    /**
     * @return the parcial3
     */
    public float getParcial3() {
        return parcial3;
    }

    /**
     * @param parcial3 the parcial3 to set
     */
    public void setParcial3(float parcial3) {
        this.parcial3 = parcial3;
    }

    /**
     * @return the ordinario
     */
    public float getOrdinario() {
        return ordinario;
    }

    /**
     * @param ordinario the ordinario to set
     */
    public void setOrdinario(float ordinario) {
        this.ordinario = ordinario;
    }
    
    public String toString(){
		return "[materiaId: " +this.materiaId+""
                                + ", parcial1: " +this.parcial1
				+ ", parcial2: " +this.parcial2
				+ ", parcial3: " +this.parcial3
                                + ", ordinario: " +this.ordinario+"]";
    }
}
