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
public class MateriasAlumno {
            private String IdMateria;
            private String nombreMateria; 

            /**
             * @return the IdMateria
             */
            public String getIdMateria() {
                return IdMateria;
            }

            /**
             * @param IdMateria the IdMateria to set
             */
            public void setIdMateria(String IdMateria) {
                this.IdMateria = IdMateria;
            }

            /**
             * @return the nombreMateria
             */
            public String getNombreMateria() {
                return nombreMateria;
            }

            /**
             * @param nombreMateria the nombreMateria to set
             */
            public void setNombreMateria(String nombreMateria) {
                this.nombreMateria = nombreMateria;
            }
            
    public String toString(){
        return "{idMateria: "+IdMateria+", nombreMateria: "+nombreMateria+"}";
    }
}
