/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.unsis.service;

import java.util.List;
import mx.edu.unsis.dao.CalificacionesDAO;
import mx.edu.unsis.model.Calificaciones;
import mx.edu.unsis.model.CalificacionesAlumno;
import mx.edu.unsis.model.MateriasAlumno;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author VICENTE
 */
public class CalificacionesServiceImplement implements CalificacionesService{
    
    @Autowired
    private CalificacionesDAO c;
    
    @Override
    public boolean insertCalificaciones(Calificaciones c) {
        return this.c.insertCalificaciones(c);
    }

    @Override
    public boolean updateCalificaciones(Calificaciones c) {
        return this.c.updateCalificaciones(c);
    }

    @Override
    public boolean eliminarCalificaciones(String cAlumnoMatricula, String cMateriaId, String cPeriodo) {
        return this.c.eliminarCalificaciones(cAlumnoMatricula, cMateriaId, cPeriodo);
    }

    @Override
    public Calificaciones getCalificacionesById(String cAlumnoMatricula, String cMateriaId, String cPeriodo) {
        return this.c.getCalificacionesById(cAlumnoMatricula, cMateriaId, cPeriodo);
    }

    @Override
    public List<Calificaciones> getAllCalificaciones() {
        return this.c.getAllCalificaciones();
    }

    @Override
    public List<MateriasAlumno> getMateriasByAlumno(String alumnoMatricula, String periodo) {
        return this.c.getMateriasByAlumno(alumnoMatricula, periodo);
    }

    @Override
    public List<CalificacionesAlumno> getCalificacionesByAlumno(String alumnoMatricula, String periodo) {
        return this.c.getCalificacionesByAlumno(alumnoMatricula, periodo);
    }
    
}
