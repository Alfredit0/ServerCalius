package mx.edu.unsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.unsis.dao.MateriasDAO;
import mx.edu.unsis.model.Materias;

public class MateriasServiceImplement implements MateriasService{
	@Autowired
	private MateriasDAO a;
	
	@Override
	public void insertMateria(Materias a) {
		this.a.insertMateria(a);
	}

	@Override
	public void updateMaterias(Materias a) {
		this.a.updateMaterias(a);
	}

	@Override
	public boolean eliminarMateria(String materiaId) {
		return this.a.eliminarMateria(materiaId);
	}

	@Override
	public Materias getMateriaById(String materiaId) {
		return this.a.getMateriaById(materiaId);
	}

	@Override
	public List<Materias> getAllMaterias() {
		return this.a.getAllMaterias();
	}

}
